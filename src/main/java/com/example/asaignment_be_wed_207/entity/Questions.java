package com.example.asaignment_be_wed_207.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "questions")
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_question")
    private Integer idQuestion;

    @Column(name = "content_question" , columnDefinition = "NVARCHAR(255)")
    @NotEmpty(message = "Content question is not empty")
    private String contentQuestion;

    @Column(name = "answer_a" , columnDefinition = "NVARCHAR(255)")
    @NotEmpty(message = "Answer A is not empty")
    private String answerA;

    @Column(name = "answer_b" , columnDefinition = "NVARCHAR(255)")
    @NotEmpty(message = "Answer B is not empty")
    private String answerB;

    @Column(name = "answer_c" , columnDefinition = "NVARCHAR(255)")
    @NotEmpty(message = "Answer C is not empty")
    private String answerC;

    @Column(name = "answer_d" , columnDefinition = "NVARCHAR(255)")
    @NotEmpty(message = "Answer D is not empty")
    private String answerD;

    @Column(name = "answer_correct" , columnDefinition = "NVARCHAR(255)")
    @NotEmpty(message = "Answer correct is not empty")
    private String answerCorrect;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_subject")
    private Subject subject;


}
