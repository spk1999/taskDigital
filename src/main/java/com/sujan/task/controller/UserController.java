package com.sujan.task.controller;

import com.sujan.task.model.UserModel;
import com.sujan.task.service.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Api("User APis")
public class UserController {

    private UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    @ApiOperation(value = "Employee update", notes = "This Api is used to register user.")
    public ResponseEntity<UserModel> adduser(@NonNull @RequestBody UserModel userModel) {
        return new ResponseEntity<>(userService.addUser(userModel), HttpStatus.CREATED);
    }


}
