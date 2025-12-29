package com.example.news.controller;

import com.example.news.model.News;
import com.example.news.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/news")
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @GetMapping
    public String getAllNews(Model model) {
        model.addAttribute("newsList", newsService.getAllNews());
        return "news-list";
    }

    @GetMapping("/view/{id}")
    public String viewNews(@PathVariable Integer id, Model model) {
        newsService.incrementVisitCount(id);
        model.addAttribute("news", newsService.getNewsById(id));
        return "news-view";
    }

    @GetMapping("/add")
    public String addNewsForm(Model model) {
        model.addAttribute("news", new News());
        return "news-add";
    }

    @PostMapping("/save")
    public String saveNews(@ModelAttribute News news) {
        newsService.saveNews(news);
        return "redirect:/news";
    }

    @GetMapping("/edit/{id}")
    public String editNewsForm(@PathVariable Integer id, Model model) {
        model.addAttribute("news", newsService.getNewsById(id));
        return "news-edit";
    }

    @GetMapping("/delete/{id}")
    public String deleteNews(@PathVariable Integer id) {
        newsService.deleteNewsById(id);
        return "redirect:/news";
    }
}