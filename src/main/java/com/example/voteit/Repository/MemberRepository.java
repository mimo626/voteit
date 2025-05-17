package com.example.voteit.Repository;

import com.example.voteit.Entity.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long>{

    Optional<Member> findMemberByUserid(String userid);

    @Override
    List<Member> findAll();
}

