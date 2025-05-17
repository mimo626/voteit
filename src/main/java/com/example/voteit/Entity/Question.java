package com.example.voteit.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

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
    private String userId;
    private String deadLine;
    private String regDate;
    private QuestionState state;
    private int agreeCount;
    private int disagreeCount;

    public Question(String title, String content, String userId, String deadLine, String regDate, QuestionState state, int agreeCount, int disagreeCount) {
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.deadLine = deadLine;
        this.regDate = regDate;
        this.state = state;
        this.agreeCount = agreeCount;
        this.disagreeCount = disagreeCount;
    }

    public void logInfo() {
        log.info("title: {}, content: {}, userId: {}, deadLine: {}, regDate: {}, state: {}, agreeCount: {}, disagreeCount: {}", title, content, userId, deadLine, regDate, state, agreeCount, disagreeCount);
    }
}
