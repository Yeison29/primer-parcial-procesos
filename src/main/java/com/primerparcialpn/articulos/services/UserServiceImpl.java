package com.primerparcialpn.articulos.services;

import com.primerparcialpn.articulos.models.User;
import com.primerparcialpn.articulos.repository.UserRepository;
import com.primerparcialpn.articulos.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JWTUtil jwtUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<User> getUserById(Long id) {
        Optional<User> user= userRepository.findById(id);
        if(user.isPresent()){
            return new ResponseEntity(user, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<User> createUser(User user) {
        try{
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return new ResponseEntity(user, HttpStatus.CREATED);
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<List<User>> allUsers() {
        List<User> users =  userRepository.findAll();
        if(users.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity(users, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<User>> allUsersByName(String name) {
        List<User> users =  userRepository.findAllByName(name);
        if(users.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity(users, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<User>> allUsersByLastname(String lastname) {
        List<User> users =  userRepository.findAllByLastname(lastname);
        if(users.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity(users, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<User>> allUsersByNameAndLastname(String name, String lastname) {
        List<User> users =  userRepository.findAllByNameAndLastname(name,lastname);
        if(users.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity(users, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> editUser(Long id, User user) {
        Optional <User> userBD= userRepository.findById(id);
        if(userBD.isPresent()){
            try{
                userBD.get().setName(user.getName());
                userBD.get().setLastname(user.getLastname());
                userBD.get().setDirection(user.getDirection());
                userBD.get().setDocument(user.getDocument());
                userBD.get().setDate_Of_Birth(user.getDate_Of_Birth());
                userBD.get().setPhone(user.getPhone());
                userBD.get().setEmail(user.getEmail());
                userBD.get().setPassword(passwordEncoder.encode(user.getPassword()));
                userRepository.save(userBD.get());
                return new ResponseEntity(userBD, HttpStatus.OK);
            }catch (Exception e){
                return ResponseEntity.badRequest().build();
            }

        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<User> deleteUser(Long id) {
        Optional<User> userBD= userRepository.findById(id);
        if(userBD.isPresent()){
            userRepository.delete(userBD.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity login (String email, String password){
        try{
            User usuario = userRepository.findByEmail(email);
            if(passwordEncoder.matches(password, usuario.getPassword())){
               String  token = jwtUtil.create(String.valueOf(usuario.getId()),usuario.getEmail());
               return  ResponseEntity.ok(token);
            }
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.notFound().build();
    }

}
