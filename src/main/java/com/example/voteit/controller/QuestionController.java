package com.example.voteit.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class QuestionController {

    //메인 페이지
    @GetMapping("/voteit/main")
    public String mainPage() {
        return "question/main";
    }
}
