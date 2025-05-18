package com.example.voteit.controller;

import com.example.voteit.cls.MemberService;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import com.example.voteit.Entity.Member;
import com.example.voteit.Repository.MemberRepository;
import com.example.voteit.dto.MemberForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String login(MemberForm memberForm, Model model, HttpSession session) {
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
            // 세션에 유저 정보 저장
            session.setAttribute("LOGIN_MEMBER", member.getUserid());
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

    @Autowired
    private MemberService memberService;

    // 프로필 화면
    @GetMapping("/voteit/profile")
    public String profile(HttpSession session, RedirectAttributes redirectAttributes, Model model) {
        Object loginMember = session.getAttribute("LOGIN_MEMBER");
        if (loginMember == null) {
            redirectAttributes.addFlashAttribute("loginMessage", "로그인 후 확인이 가능합니다.");
            return "redirect:/voteit/login";
        }

        // 현재 loginMember는 String (userid) 형태
        String userid = loginMember.toString();

        // DB에서 userid로 회원 정보 조회
        Member member = memberService.findByUserid(userid);
        if (member == null) {
            redirectAttributes.addFlashAttribute("loginMessage", "존재하지 않는 회원입니다.");
            return "redirect:/voteit/login";
        }

        model.addAttribute("name", member.getName());
        model.addAttribute("userid", member.getUserid());
        model.addAttribute("password", member.getPassword()); // 비밀번호 마스킹

        return "member/profile";
    }
}

