package com.example.asaignment_be_wed_207.controller;

import com.example.asaignment_be_wed_207.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1/questions")
public class QuestionController {

    private QuestionService questionService;
    @Autowired
    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/getQuestionsBySubject/{idSubject}")
    public ResponseEntity<?> getQuestionsBySubject(@PathVariable Integer idSubject){
        return ResponseEntity.ok().body(questionService.getQuestionsBySubject(idSubject));
    }

}
