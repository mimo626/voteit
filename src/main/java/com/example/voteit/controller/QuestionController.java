package com.example.voteit.controller;

import com.example.voteit.Entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@Controller
public class QuestionController {

    //메인 페이지
    @GetMapping("/voteit/main")
    public String mainPage() {
        return "question/main";
    }

    @GetMapping("/voteit/main")
    public String show(Model model) {
        List<Member> questionList = questionRepository.findAll();

        model.addAttribute("questionList", questionList);
        return "question/main";
    }
}
