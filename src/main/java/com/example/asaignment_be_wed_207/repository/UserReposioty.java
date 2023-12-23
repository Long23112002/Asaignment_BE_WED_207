package com.example.asaignment_be_wed_207.repository;

import com.example.asaignment_be_wed_207.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReposioty  extends JpaRepository<Users,Integer> {
    public Users findByUserName(String userName);
}
