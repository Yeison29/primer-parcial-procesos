package com.primerparcialpn.articulos.services;

import com.primerparcialpn.articulos.models.Categoria;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoriaService {
    ResponseEntity<Categoria> createCategoria(Categoria categoria);
    ResponseEntity<List<Categoria>> allCategorias();
    ResponseEntity<Categoria> getCategoriaById(Long id);
    ResponseEntity<Categoria> editCategoria(Long id, Categoria categoria);
    ResponseEntity<Categoria> deleteCategoria(Long id);
}
