package com.sidshiv.love.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class LoveController {

    @GetMapping("/")
    public String home(HttpSession session, Model model) {

        Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");

        if (loggedIn == null || !loggedIn) {
            return "redirect:/login";
        }

        List<String> reasons = List.of(
                "You stayed with me for more than a year.",
                "You were always there for me. In bad times and good times.",
                "You make my bad and sad days better and lively.",
                "With you I always feel young and jolly",
                "You love me and forgive even when I mess up."
        );

        model.addAttribute("reasons", reasons);

        return "index";
    }
}