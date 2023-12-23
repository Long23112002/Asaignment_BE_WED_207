package com.example.asaignment_be_wed_207.service.impl;

import com.example.asaignment_be_wed_207.entity.Role;
import com.example.asaignment_be_wed_207.entity.Users;
import com.example.asaignment_be_wed_207.repository.RoleRepository;
import com.example.asaignment_be_wed_207.repository.UserReposioty;
import com.example.asaignment_be_wed_207.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private UserReposioty userReposioty;
    private RoleRepository roleRepository;
    @Autowired
    private UserServiceImpl(UserReposioty userReposioty , RoleRepository roleRepository){
        this.userReposioty = userReposioty;
        this.roleRepository = roleRepository;
    }
    @Override
    public Users findByUsersName(String userName) {
        return userReposioty.findByUserName(userName);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = findByUsersName(username);
        if(user == null){
            throw new UsernameNotFoundException("User not found");
        }
        return  new User(user.getUserName(),user.getPassWord(),rolesToAuthorities(user.getListRole()));
    }

    private Collection<? extends GrantedAuthority> rolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
    }
}
