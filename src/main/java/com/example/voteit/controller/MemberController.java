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

import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
public class MemberController {

    @Autowired
    MemberRepository memberRepository;

    //회원가입 페이지
    @GetMapping("/voteit/signup")
    public String signupForm() {
        return "member/signup";
    }

    // 회원 등록 처리
    @PostMapping("/voteit/signup")
    public String signup(MemberForm memberForm) {

        memberForm.logInfo();
        //1. DTO를 Entity로 변환
        Member member = memberForm.toEntity();
        member.logInfo();
        //2. repository를 통해 DB로 엔터티를 저장
        Member saved = memberRepository.save(member);
        saved.logInfo();
        log.info("회원가입 완료");
        return "member/login";
    }

    //로그인 페이지
    @GetMapping("/voteit/login")
    public String loginForm() {
        return "member/login";
    }

    //로그인 실행 처리
    @PostMapping("/voteit/login")
    public String login(MemberForm memberForm, Model model) {
        memberForm.logInfo();
        Optional<Member> memberId = memberRepository.findMemberByUserid(memberForm.getUserid());
        if (memberId.isEmpty()) {
            model.addAttribute("loginError", "존재하지 않는 아이디입니다.");
            log.info("로그인 에러-아이디 오류");
            return "member/login";
        }
        else {
           Member member = memberId.get();
            if (!member.getPassword().equals(memberForm.getPassword())) {
                model.addAttribute("loginError", "비밀번호가 올바르지 않습니다.");
                log.info("로그인 에러-비밀번호 오류");
                return "member/login";
            }
            log.info("로그인 성공");
            return "redirect:/voteit/main";
        }
    }

    //회원 정보 조회
    @GetMapping("/voteit/members")
    public String show(Model model) {
        List<Member> memberList = memberRepository.findAll();

        model.addAttribute("memberList", memberList);
        return "member/detail";
    }
}
