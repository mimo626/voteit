package com.example.voteit.controller;

import com.example.voteit.Entity.Question;
import com.example.voteit.Repository.QuestionRepository;
import com.example.voteit.dto.QuestionForm;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Controller
public class QuestionController {

    @Autowired
    QuestionRepository questionRepository;

    // 메인 페이지
    @GetMapping("/voteit/main")
    public String show(Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        // 로그인 사용자 정보 가져오기
        Object loginMember = session.getAttribute("LOGIN_MEMBER");
        if (loginMember == null) {
            redirectAttributes.addFlashAttribute("loginMessage", "로그인 후 이용해주세요.");
            return "redirect:/voteit/login";
        }

        // 기존 로직은 그대로 유지
        List<Question> questionList = questionRepository.findAll();
        model.addAttribute("questionList", questionList);
        return "question/main";
    }


    // 질문 등록 페이지
    @GetMapping("/voteit/questionAdd")
    public String questionAdd(HttpSession session, RedirectAttributes redirectAttributes) {
        // 로그인 사용자 정보 가져오기
        Object loginMember = session.getAttribute("LOGIN_MEMBER");
        if (loginMember == null) {
            redirectAttributes.addFlashAttribute("loginMessage", "로그인 후 질문 등록이 가능합니다.");
            return "redirect:/voteit/login"; // 로그인 안되어 있을 경우 처리
        }
        return "question/add";
    }

    // 질문 등록 처리
    @PostMapping("/voteit/questionAdd")
    public String questionAddProcess(QuestionForm questionForm, Model model, HttpSession session) {
        // 입력 필드 에러 처리
        String error = validateQuestionForm(questionForm);
        if (error != null) {
            model.addAttribute("questionAddError", error);
            log.info("질문 등록 오류 - {}", error);
            return "question/add";
        }

        // 질문에 내용 저장
        questionForm.setUserid(session.getAttribute("LOGIN_MEMBER").toString());
        questionForm.setRegdate(LocalDate.now());
        questionForm.setState("진행 중");
        questionForm.setAgreecount(0);
        questionForm.setDisagreecount(0);

        // DB에 질문 데이터 저장
        Question question = questionForm.toEntity();
        question.logInfo();
        Question saved = questionRepository.save(question);
        log.info("질문 등록 성공");

        return "redirect:/voteit/detail/"+saved.getId();
    }

    // 미입력 시 에러 처리
    private String validateQuestionForm(QuestionForm form) {
        if (form.getTitle() == null || form.getTitle().trim().isEmpty()) {
            return "제목을 입력해 주세요.";
        }
        if (form.getContent() == null || form.getContent().trim().isEmpty()) {
            return "내용을 입력해 주세요.";
        }
        if (form.getDeadline() == null) {
            return "마감기한을 선택해 주세요.";
        }
        if(form.getDeadline().isBefore(LocalDate.now())){
            return "마감기한을 오늘 이후 날짜로 선택해 주세요.";
        }
        return null;
    }

    // 상세 페이지
    @GetMapping("/voteit/detail/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        Question question = questionRepository.findById(id).orElse(null);

        model.addAttribute("question", question);
        return "question/detail";
    }



}

