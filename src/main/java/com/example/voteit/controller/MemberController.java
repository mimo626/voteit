package com.example.voteit.controller;

import org.springframework.ui.Model;
import com.example.voteit.Entity.Member;
import com.example.voteit.Repository.MemberRepository;
import com.example.voteit.dto.MemberForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class MemberController {

    @Autowired
    MemberRepository memberRepository;

    //회원가입 페이지
    @GetMapping("/voteit/signup")
    public String login() {
        return "member/signup";
    }

    // 회원 등록 처리
    @PostMapping("/voteit/join")
    public String join(MemberForm memberForm) {

        memberForm.logInfo();
        //1. DTO를 Entity로 변환
        Member voteIt = memberForm.toEntity();
        voteIt.logInfo();
        //2. repository를 통해 DB로 엔터티를 저장
        Member saved = memberRepository.save(voteIt);
        saved.logInfo();
        return "";
    }
    //회원 정보 조회
    @GetMapping("/voteit/member/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        log.info("id = {} ", id);
        //1. id article
        //Optional<Article> article = articleRepository.findById(id);
        Member member = memberRepository.findById(id).orElse(null);
        //2.
        model.addAttribute("member", member);
        //3.
        return "member/detail";
    }
}
