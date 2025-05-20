package com.example.voteit.Repository;

import com.example.voteit.Entity.Vote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository extends CrudRepository<Vote, Long> {
    Vote findByUseridAndQuestionid(String loginUserId, Long id);

    List<Vote> findByUserid(String userid);
}
