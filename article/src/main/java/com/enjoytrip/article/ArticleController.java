package com.enjoytrip.article;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArticleController {
    @GetMapping("/article")
    String article(Model model) {
        model.addAttribute("title", "제목");
        return "list.html";
    }
}
