package com.example.news.service;

import com.example.news.model.News;
import java.util.List;

public interface NewsService {
    List<News> getAllNews();
    News getNewsById(Integer id);
    News saveNews(News news);
    void deleteNewsById(Integer id);
    void incrementVisitCount(Integer id);
}