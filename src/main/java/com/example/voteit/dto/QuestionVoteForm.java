package com.example.voteit.dto;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class QuestionVoteForm {
    private Long questionid;
    private String title;
    private String choice;
    private String state;
}
