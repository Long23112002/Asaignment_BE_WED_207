package com.example.asaignment_be_wed_207.service;

import com.example.asaignment_be_wed_207.entity.Users;
import org.springframework.stereotype.Service;

public interface UsersService {
    public Users findByUserName(String username);
}
