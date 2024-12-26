package com.enjoytrip.article;

import jakarta.persistence.*;

@Entity
public class Article {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(nullable = false)
    public String title;
    @Column(nullable = false, columnDefinition = "TEXT")
    public String content;
}
