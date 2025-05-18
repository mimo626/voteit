package com.example.voteit.dto;

import com.example.voteit.Entity.Question;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class QuestionForm {
    private String title;
    private String content;
    private String userid;
    private LocalDate deadline;
    private LocalDate regdate;
    private String state;
    private int agreecount;
    private int disagreecount;

    public Question toEntity() {
        return new Question(title, content, userid, deadline, regdate, state, agreecount, disagreecount);
    }

    public void logInfo() {
        log.info("title: {}, content: {}, userId: {}, deadLine: {}, regDate: {}, state: {}, agreeCount: {}, disagreeCount: {}", title, content, userid, deadline, regdate, state, agreecount, disagreecount);
    }
}
