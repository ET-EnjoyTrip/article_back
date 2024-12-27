package com.enjoytrip.article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public void saveArticle(String title, String username, String content) {
        Article article = new Article();
        article.setTitle(title);
        article.setUsername(username);
        article.setContent(content);
        articleRepository.save(article);
    }
}
