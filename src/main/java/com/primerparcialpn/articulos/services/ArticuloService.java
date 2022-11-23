package com.primerparcialpn.articulos.services;

import com.primerparcialpn.articulos.models.Articulo;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ArticuloService {

    ResponseEntity<Articulo> createArticulo(Articulo articulo);
    ResponseEntity<List<Articulo>>listArticulo();
    ResponseEntity<Articulo> getArticulo(String codigo);
    ResponseEntity<Articulo> updateArticulo(String codigo, Articulo articulo);
    ResponseEntity<Articulo> deleteArticulo(String codigo);

}
