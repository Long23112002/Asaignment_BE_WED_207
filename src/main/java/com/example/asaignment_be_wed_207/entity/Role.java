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
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    private Integer idRole;

    @Column(name = "role_name" , columnDefinition = "VARCHAR(50)")
    @NotEmpty(message = "Role name is not empty")
    private String roleName;

    @ManyToMany(fetch = FetchType.EAGER , cascade ={
            CascadeType.DETACH, CascadeType.MERGE ,
            CascadeType.REFRESH , CascadeType.PERSIST
    })
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "id_role"),
            inverseJoinColumns = @JoinColumn(name = "id_user")
    )
    private List<Users> listUser;
}
