package com.fullstackcrud.backend.controller;

import com.fullstackcrud.backend.model.User;
import com.fullstackcrud.backend.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/user")
    User saveUser(@RequestBody User newUser){
        return userRepo.save(newUser);
    }

    @GetMapping("/user")
    List<User> getAllUsers(){
        return userRepo.findAll();
    }
}
