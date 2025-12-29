package com.example.news.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "newsTitle")
    private String newsTitle;

    @Column(name = "newsContent")
    private String newsContent;

    @Column(name = "visitCount")
    private Integer visitCount = 0;

    @Column(name = "author")
    private String author;
}