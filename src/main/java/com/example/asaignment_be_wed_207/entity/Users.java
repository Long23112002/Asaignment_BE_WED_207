package com.example.asaignment_be_wed_207.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer idUser;

    @Column(name = "user_name" , columnDefinition = "NVARCHAR(255)")
    @NotEmpty(message = "User name is not empty")
    private String userName;

    @Column(name = "pass_word" , columnDefinition = "VARCHAR(MAX)")
    @NotEmpty(message = "Pass word is not empty")
    private String passWord;

    @Column(name = "full_name" , columnDefinition = "NVARCHAR(255)")
    @NotEmpty(message = "Full name is not empty")
    private String fullName;

    @Column(name = "email" , columnDefinition = "VARCHAR(100)")
    @Pattern(regexp = "^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+\\.[A-Z]{2,4}$" , message = "Invalid email format")
    @NotEmpty(message = "Email is not empty")
    private String email;

    @ManyToMany(fetch = FetchType.EAGER , cascade ={
       CascadeType.DETACH, CascadeType.MERGE ,
       CascadeType.REFRESH , CascadeType.PERSIST
    })
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_role")
    )
    private List<Role> listRole;

    @ManyToMany(fetch = FetchType.EAGER , cascade ={
            CascadeType.DETACH, CascadeType.MERGE ,
            CascadeType.REFRESH , CascadeType.PERSIST
    })
    @JoinTable(
            name = "user_subject",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_subject")
    )
    private List<Subject> listQuestion;

}
