package com.sujan.task.service;

import com.sujan.task.model.UserModel;
import com.sujan.task.repo.UserRepo;
import com.sujan.task.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class UserServiceImpl implements UserDetailsService {

    private final UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

       return new User("admin","password",new ArrayList<>());
    }

    public UserModel addUser(UserModel userModel)
    {
        return userRepo.save(userModel);
    }

    public UserModel getUsersByUsernameAndPassword(String username, String password)
    {
        return userRepo.getUserByUsernameAndPassword(username,password);
    }




}
