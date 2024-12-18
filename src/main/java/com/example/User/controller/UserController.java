package com.example.User.controller;

import com.example.User.models.User;
import com.example.User.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    public UserService service;
    @GetMapping
    public List<User> getAllUser(){
        return service.getAllUser();

    }
    @PostMapping
    public String save(@Valid @RequestBody User user){
       return service.insertUser(user);
    }

    @PostMapping("/login")
    public String logIn(@RequestBody User user  ){

       return service.logIn(user);

    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id){
        return  service.deleteUser(id);
    }
}
