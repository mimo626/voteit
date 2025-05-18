package com.example.voteit.dto;

import com.example.voteit.Entity.Member;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class MemberForm {

    private String name;
    private String userid;           //
    private String password;

    public Member toEntity() {
        return new Member(name, userid,password);
    }

    public void logInfo() {
        log.info("name: {}, id: {}, password: {}", name, userid,password);
    }

}
