package com.example.asaignment_be_wed_207.repository;

import com.example.asaignment_be_wed_207.entity.Questions;
import com.example.asaignment_be_wed_207.response.QuestionResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Questions,Integer> {

    @Query(value = "SELECT new com.example.asaignment_be_wed_207.response.QuestionResponse(" +
            "q.idQuestion, q.contentQuestion, q.answerA, q.answerB, q.answerC, q.answerD, q.answerCorrect) " +
            "FROM Questions q " +
            "join q.subject sb " +
            "where sb.idSubject = :idsubject")
    List<QuestionResponse> findQuestionsBySubject(@Param("idsubject") Integer idSubject);
}
