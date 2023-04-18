package it.data_web.spring_data_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class RootController {
    @GetMapping
    public String root(org.springframework.ui.Model model){
        model.addAttribute("title", "Homepage");
        model.addAttribute("authorsPath", "autori");
        model.addAttribute("postsPath", "posts");
        model.addAttribute("commentsPath", "commenti");
        return "index";

    }
}
