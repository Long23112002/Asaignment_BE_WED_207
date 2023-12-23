package com.example.asaignment_be_wed_207.service;

import com.example.asaignment_be_wed_207.entity.Users;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    public Users findByUsersName(String userName);
}
