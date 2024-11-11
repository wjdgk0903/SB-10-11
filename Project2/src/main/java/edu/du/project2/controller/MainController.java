package edu.du.project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    @GetMapping("/main")
    public String main() {

        return "main/main";
    }

    @GetMapping("/login")
    public String login() {
        return "login/login"; // 로그인 폼 페이지
    }

}