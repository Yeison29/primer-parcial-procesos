package com.primerparcialpn.articulos.services;

import com.primerparcialpn.articulos.models.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    ResponseEntity<User> getUserById(Long id);
    ResponseEntity<User> createUser(User user);
    ResponseEntity<List<User>> allUsers();
    ResponseEntity<List<User>> allUsersByName(String name);

    ResponseEntity<List<User>> allUsersByLastname(String lastname);
    ResponseEntity<List<User>> allUsersByNameAndLastname(String name, String lastname);
    ResponseEntity<User> editUser(Long id, User user);
    ResponseEntity<User> deleteUser(Long id);
    ResponseEntity login(String email, String password);
}
