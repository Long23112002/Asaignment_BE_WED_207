package com.example.asaignment_be_wed_207.service;

import com.example.asaignment_be_wed_207.response.QuestionResponse;

import java.util.List;

public interface QuestionService {

    List<QuestionResponse> getQuestionsBySubject(Integer idSubject);

}
