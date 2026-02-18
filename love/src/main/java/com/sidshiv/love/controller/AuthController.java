package com.sidshiv.love.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    private final String SECRET_PASSWORD = "23052025"; // example: your anniversary date

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String password, HttpSession session) {

        if (SECRET_PASSWORD.equals(password)) {
            session.setAttribute("loggedIn", true);
            return "redirect:/";
        }

        return "redirect:/login?error";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
