package com.example.voteit.Entity;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"userid", "questionid"})
        }
)
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userid;

    private Long questionid;

    private String choice; // "찬성" or "반대"

    private LocalDate votedate;

    public Vote(String userid, Long questionid, String choice, LocalDate votedate) {
        this.userid = userid;
        this.questionid = questionid;
        this.choice = choice;
        this.votedate = this.votedate;
    }

    public void logInfo() {
        log.info("userid: {}, questionid: {}, choice: {}, votedat: {}", userid, questionid, choice, votedate);
    }
}
