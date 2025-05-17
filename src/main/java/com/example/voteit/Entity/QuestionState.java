package com.example.voteit.Entity;

import jakarta.persistence.Embeddable;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@ToString
@Slf4j
@NoArgsConstructor
@Getter
@Setter
@Embeddable

public class QuestionState {
    private String voting;
    private String finished;

    QuestionState(String voting, String finished) {
        this.voting = voting;
        this.finished = finished;
    }
}
