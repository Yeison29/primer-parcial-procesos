package com.primerparcialpn.articulos.repository;

import com.primerparcialpn.articulos.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
    Optional<Categoria> findById(Long id);
}
