package com.example.voteit.controller;

import org.springframework.ui.Model;
import com.example.voteit.Entity.VoteIt;
import com.example.voteit.Repository.VoteItRepository;
import com.example.voteit.dto.VoteItForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class VoteItController {

    @Autowired
    VoteItRepository voteItRepository;

    //로그인 폼
    @GetMapping("/login")
    public String login() {
        return "login/new";
    }

    // 회원 등록 처리
    @PostMapping("/join")
    public String join(VoteItForm VoteItForm) {

        VoteItForm.logInfo();
        //1. DTO를 Entity로 변환
        VoteIt voteIt = VoteItForm.toEntity();
        voteIt.logInfo();
        //2. repository를 통해 DB로 엔터티를 저장
        VoteIt saved = voteItRepository.save(voteIt);
        saved.logInfo();
        return "";
    }
    //회원 정보 조회
    @GetMapping("/VoteIt/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        log.info("id = {} ", id);
        //1. id article
        //Optional<Article> article = articleRepository.findById(id);
        VoteIt voteIt = voteItRepository.findById(id).orElse(null);
        //2.
        model.addAttribute("voteIt", voteIt);
        //3.
        return "main/main";
    }
}
