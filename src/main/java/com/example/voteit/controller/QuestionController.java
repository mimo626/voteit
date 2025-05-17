package com.example.voteit.controller;

import com.example.voteit.Entity.Member;
import com.example.voteit.Entity.Question;
import com.example.voteit.Repository.QuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@Controller
public class QuestionController {

    @Autowired
    QuestionRepository questionRepository;

    //메인 페이지
    @GetMapping("/voteit/main")
    public String show(Model model) {
        List<Question> questionList = questionRepository.findAll();

        model.addAttribute("questionList", questionList);
        return "question/main";
    }
}
