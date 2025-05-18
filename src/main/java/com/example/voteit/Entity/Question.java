package com.example.voteit.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Entity
@ToString
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String userid;
    private LocalDate deadline;
    private LocalDate regdate;
    private String state;
    private int agreecount;
    private int disagreecount;

    public Question(String title, String content, String userid, LocalDate deadline, LocalDate regdate, String state, int agreecount, int disagreecount) {
        this.title = title;
        this.content = content;
        this.userid = userid;
        this.deadline = deadline;
        this.regdate = regdate;
        this.state = state;
        this.agreecount = agreecount;
        this.disagreecount = disagreecount;
    }

    public void logInfo() {
        log.info("title: {}, content: {}, userId: {}, deadLine: {}, regDate: {}, state: {}, agreeCount: {}, disagreeCount: {}", title, content, userid, deadline, regdate, state, agreecount, disagreecount);
    }
}
