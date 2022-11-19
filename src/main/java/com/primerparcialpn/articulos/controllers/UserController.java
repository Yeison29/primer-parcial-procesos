package com.primerparcialpn.articulos.controllers;


import com.primerparcialpn.articulos.models.User;
import com.primerparcialpn.articulos.services.UserService;
import com.primerparcialpn.articulos.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private JWTUtil jwtUtil;
    @GetMapping(value = "/user/{id}")
    public ResponseEntity getUsuario(@PathVariable Long id, @RequestHeader(value = "Authorization") String token){
       if(jwtUtil.getKey(token)==null){
           return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("¡Token no valido!");
       }
        return userService.getUserById(id);
    }
    @PostMapping("/user")
    public ResponseEntity CreateUser(@Valid @RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("/listusers")
    public ResponseEntity listUsers(@RequestHeader(value = "Authorization") String token){
        if(jwtUtil.getKey(token)==null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("¡Token no valido!");
        }
        return userService.allUsers();
    }
    @GetMapping("/user/name/{name}")
    public ResponseEntity listByName(@PathVariable String name, @RequestHeader(value = "Authorization") String token){
        if(jwtUtil.getKey(token)==null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("¡Token no valido!");
        }
        return userService.allUsersByName(name);
    }
    @GetMapping("/user/lastname/{lastname}")
    public ResponseEntity listByLastname(@PathVariable String lastname, @RequestHeader(value = "Authorization") String token){
        if(jwtUtil.getKey(token)==null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("¡Token no valido!");
        }
        return userService.allUsersByLastname(lastname);
    }
    @GetMapping("/user/{name}/{lastname}")
    public ResponseEntity listByNameAndLastname(@PathVariable String name, @PathVariable String lastname, @RequestHeader(value = "Authorization") String token){
        if(jwtUtil.getKey(token)==null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("¡Token no valido!");
        }
        return userService.allUsersByNameAndLastname(name, lastname);
    }
    @PutMapping("/user/{id}")
    public ResponseEntity editUser(@PathVariable Long id,@Valid @RequestBody  User user, @RequestHeader(value = "Authorization") String token){
        if(jwtUtil.getKey(token)==null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("¡Token no valido!");
        }
        return userService.editUser(id, user);
    }
    @DeleteMapping("/user/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id, @RequestHeader(value = "Authorization") String token){
        if(jwtUtil.getKey(token)==null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("¡Token no valido!");
        }
        return userService.deleteUser(id);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
