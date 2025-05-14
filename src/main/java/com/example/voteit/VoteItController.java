package com.example.voteit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class VoteItController {

    //로그인 폼
    @GetMapping("/login")
    public String login() {
        return "login/new";
    }

}
