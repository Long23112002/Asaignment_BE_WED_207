package com.example.asaignment_be_wed_207.service.impl;

import com.example.asaignment_be_wed_207.repository.QuestionRepository;
import com.example.asaignment_be_wed_207.response.QuestionResponse;
import com.example.asaignment_be_wed_207.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;

    @Autowired
    public void setQuestionRepository(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public List<QuestionResponse> getQuestionsBySubject(Integer idSubject) {
        return questionRepository.findQuestionsBySubject(idSubject);
    }
}
