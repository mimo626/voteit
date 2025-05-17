package com.example.voteit.dto;

import com.example.voteit.Entity.Question;
import com.example.voteit.Entity.QuestionState;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class QuestionForm {
    private String title;
    private String content;
    private String userId;
    private String deadLine;
    private String regDate;
    private QuestionState state;
    private int agreeCount;
    private int disagreeCount;

    public Question toEntity() {
        return new Question(title, content, userId, deadLine, regDate, state, agreeCount, disagreeCount);
    }

    public void logInfo() {
        log.info("title: {}, content: {}, userId: {}, deadLine: {}, regDate: {}, state: {}, agreeCount: {}, disagreeCount: {}", title, content, userId, deadLine, regDate, state, agreeCount, disagreeCount);
    }
}
