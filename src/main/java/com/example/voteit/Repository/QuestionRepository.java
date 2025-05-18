package com.example.voteit.Repository;

import com.example.voteit.Entity.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {

    Optional<Question> findQuestionByTitle(String title);

    @Override
    List<Question> findAll();
}
