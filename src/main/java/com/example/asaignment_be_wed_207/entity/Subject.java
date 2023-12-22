package com.example.asaignment_be_wed_207.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subject")
    private Integer idSubject;

    @NotEmpty(message = "Subject name is not empty")
    @Column(name = "subject_name" , columnDefinition = "NVARCHAR(255)")
    private String  subjectName;

    @Column(name = "subject_image" , columnDefinition = "VARCHAR(MAX)")
    @NotEmpty(message = "Subject image is not empty")
    private String subjectImage;

    @OneToMany(mappedBy = "subject"
            , fetch = FetchType.LAZY
            , cascade = CascadeType.ALL
    )
    private List<Questions> listQuestion;
}
