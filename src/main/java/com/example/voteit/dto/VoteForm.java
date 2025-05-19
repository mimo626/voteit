package com.example.voteit.dto;
import com.example.voteit.Entity.Vote;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Getter
@Setter
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VoteForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userid;

    @Column(name = "questionid")
    private Long questionid;

    private String choice; // "찬성" or "반대"

    private LocalDate votedate;

    public Vote toEntity() {
        return new Vote(userid, questionid, choice, votedate);
    }

    public void logInfo() {
        log.info("userid: {}, questionid: {}, choice: {}, votedat: {}", userid, questionid, choice, votedate);
    }
}
