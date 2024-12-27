package com.enjoytrip.article;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleRepository articleRepository;
    private final ArticleService articleService;

    @GetMapping("/article")
    String article(Model model) {
        List<Article> result = articleRepository.findAll();    // findAll : 테이블의 모든 데이터를 List에 담아서 가져옴
//        System.out.println(result.get(0).content);
        model.addAttribute("articles", result);
        var a = new Article();
        System.out.println(a.toString());
        return "list.html";
    }

    @GetMapping("/article/create")
    String create() {
        return "create.html";
    }

    @PostMapping("/create")
    String createArticle(String title, String username, String content) {
        articleService.saveArticle(title, username, content);
        return "redirect:/article";
    }

    @GetMapping("/article/detail/{id}")
    String detail(@PathVariable Long id, Model model) {
        Optional<Article> result = articleRepository.findById(id);
        if (result.isPresent()) {
            model.addAttribute("detail", result.get());
            System.out.println(result.get());
            return "detail.html";
        } else {
            return "redirect:/article";
        }
    }

    @DeleteMapping("/article")
    ResponseEntity<String> deleteArticle(@RequestParam Long id) {
        articleRepository.deleteById(id);
        return ResponseEntity.status(200).body("삭제완료");
    }

    @GetMapping("/article/update/{id}")
    String update(@PathVariable Long id, Model model) {
        Optional<Article> result = articleRepository.findById(id);
        if (result.isPresent()) {
            model.addAttribute("data", result.get());
            return "update.html";
        } else {
            return "redirect:/article";
        }
    }

    @PostMapping("/update")
    String updateArticle(String title, String username, String content, Long id) {
        Article article = new Article();
        article.setId(id);
        article.setTitle(title);
        article.setUsername(username);
        article.setContent(content);
        articleRepository.save(article);
        return "redirect:/article";
    }

}
