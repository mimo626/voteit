package com.example.voteit.cls;

import com.example.voteit.Entity.Member;
import com.example.voteit.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public Member findByUserid(String userid) {
        Optional<Member> memberOptional = memberRepository.findMemberByUserid(userid);
        return memberOptional.orElse(null);
    }
    public void updatePassword(String userid, String newPassword) {
        Member member = memberRepository.findByUserid(userid).orElse(null);
        if (member != null) {
            member.setPassword(newPassword); // 보안 위해 암호화 추천
            memberRepository.save(member);
        }
    }

}
