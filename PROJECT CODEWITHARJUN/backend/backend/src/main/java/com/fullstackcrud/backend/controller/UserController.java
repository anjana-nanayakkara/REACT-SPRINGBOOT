package com.fullstackcrud.backend.controller;

import com.fullstackcrud.backend.exception.UserNotFoundException;
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
    @GetMapping("/user/{id}")
    User getUserById(@PathVariable int id){
        return userRepo.findById(id).orElseThrow(()->new UserNotFoundException(id));
    }
    @PutMapping("/user/{id}")
    User updateUser(@RequestBody User newUser,@PathVariable int id){
        return userRepo.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    return userRepo.save(user);
                }).orElseThrow(()->new UserNotFoundException(id));
    }

    @DeleteMapping("/user/{id}")
    String deleteById(@PathVariable int id){
        if(!userRepo.existsById(id)){
            throw new UserNotFoundException(id);
        }

        userRepo.deleteById(id);
        return ("user with id "+id+" has been deleted");
    }
}
