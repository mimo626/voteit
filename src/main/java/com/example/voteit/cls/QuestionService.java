package com.example.voteit.cls;

import com.example.voteit.Entity.Question;
import com.example.voteit.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> findByUserid(String userid) {
        return questionRepository.findByUserid(userid);
    }

}
