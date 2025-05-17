package com.example.voteit.Repository;

import com.example.voteit.Entity.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {

    @Override
    List<Question> findAll();
}
