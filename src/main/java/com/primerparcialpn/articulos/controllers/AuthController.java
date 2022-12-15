package com.primerparcialpn.articulos.controllers;

import com.primerparcialpn.articulos.models.User;
import com.primerparcialpn.articulos.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(maxAge = 3600)
@RestController
public class AuthController {
    @Autowired
    private UserService userService;
    @PostMapping(value = "auth/login")
    public ResponseEntity login (@RequestBody User user){
        return userService.login(user.getEmail(), user.getPassword());
    }
}
