package com.primerparcialpn.articulos.controllers;

import com.primerparcialpn.articulos.models.Articulo;
import com.primerparcialpn.articulos.repository.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RestController
public class ArticuloController {
    @Autowired
    private ArticuloRepository articuloRepository;
    @PostMapping(value = "/articulo")
    public ResponseEntity createArticulo(@RequestBody Articulo articulo){
        try{
            articuloRepository.save(articulo);
            return new ResponseEntity(articulo, HttpStatus.CREATED);
        }catch (Exception e){
            return  ResponseEntity.badRequest().build();
        }
    }
    @GetMapping(value = "/articulos")
    public ResponseEntity listArticulo(){
        List<Articulo> articulos = articuloRepository.findAll();
        if(articulos.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return new ResponseEntity(articulos, HttpStatus.OK);
        }
    }
   @GetMapping(value = "articulo/{codigo}")
    public ResponseEntity getArticulo(@PathVariable String codigo) {
        List<Articulo> articulo = articuloRepository.findAllByCodigo(codigo);
        if (articulo.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return new ResponseEntity(articulo, HttpStatus.OK);
        }
    }



}
