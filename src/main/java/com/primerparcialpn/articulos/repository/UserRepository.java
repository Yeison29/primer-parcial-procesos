package com.primerparcialpn.articulos.repository;

import com.primerparcialpn.articulos.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository <User, Long> {
    List<User> findAllByName(String name);
    List<User> findAllByLastname(String lastname);
    List<User> findAllByNameAndLastname(String name, String lastname);
    User findByEmail(String email);

}
