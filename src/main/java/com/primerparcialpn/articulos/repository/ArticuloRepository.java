package com.primerparcialpn.articulos.repository;

import com.primerparcialpn.articulos.models.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArticuloRepository extends JpaRepository<Articulo,Long> {
    Optional<Articulo> findByCodigo(String codigo);
}
