package com.example.news.service.impl;

import com.example.news.model.News;
import com.example.news.repository.NewsRepository;
import com.example.news.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;

    @Override
    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    @Override
    public News getNewsById(Integer id) {
        return newsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("News not found with id: " + id));
    }

    @Override
    public News saveNews(News news) {
        return newsRepository.save(news);
    }

    @Override
    public void deleteNewsById(Integer id) {
        newsRepository.deleteById(id);
    }

    @Override
    public void incrementVisitCount(Integer id) {
        News news = getNewsById(id);
        news.setVisitCount(news.getVisitCount() + 1);
        newsRepository.save(news);
    }
}