package com.example.LibraryManagement.Controller;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.LibraryManagement.UserRepository;
import com.example.LibraryManagement.Entity.UserEntity;


@RestController
public class UserController {

    private final UserRepository UserRepo;
    public UserController(UserRepository UserRepo){
        this.UserRepo=UserRepo;
        
    }
    
@GetMapping()
public List<UserEntity> getUsers() {
    return UserRepo.findAll();     
}
@PostMapping("/insertUser")
public void insertUser(@RequestBody UserEntity user){
    UserRepo.save(user);
}
}
