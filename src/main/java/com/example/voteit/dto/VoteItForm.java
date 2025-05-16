package com.example.voteit.dto;

import com.example.voteit.Entity.VoteIt;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class VoteItForm {

    private String name;
    private String userid;           //
    private String password;

    public VoteIt toEntity() {
        return new VoteIt(name,userid,password);
    }

    public void logInfo() {
        log.info("name: {}, id: {}, password: {}", name,userid,password);
    }

}
