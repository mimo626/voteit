package com.example.voteit.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Entity
@ToString
@Slf4j
public class VoteIt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ← DB에서 자동 생성될 기본키

    private String name;
    private String userid; // 사용자가 입력하는 ID (아이디)
    private String password;

    // 생성자
    public VoteIt(String name, String userid, String password) {
        this.name = name;
        this.userid = userid;
        this.password = password;
    }

    // 기본 생성자도 필요 (JPA가 사용함)
    public VoteIt() {}

    public void logInfo() {
        log.info("name: {}, userid: {}, password: {}", name, userid, password);
    }

    // Getter들 필요 시 추가
}
