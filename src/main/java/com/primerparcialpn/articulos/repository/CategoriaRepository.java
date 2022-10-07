package com.primerparcialpn.articulos.repository;

import com.primerparcialpn.articulos.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {

}
