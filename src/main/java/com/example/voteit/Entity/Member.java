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
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ← DB에서 자동 생성될 기본키

    private String name;
    private String userid; // 사용자가 입력하는 ID (아이디)
    private String password;

    // 생성자
    public Member(String name, String userid, String password) {
        this.name = name;
        this.userid = userid;
        this.password = password;
    }

    public void logInfo() {
        log.info("name: {}, userid: {}, password: {}", name, userid, password);
    }
}
