package com.primerparcialpn.articulos.controllers;

import com.primerparcialpn.articulos.models.Categoria;
import com.primerparcialpn.articulos.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoriaController {
    @Autowired
    private CategoriaRepository categoriaRepository;
    @PostMapping(value = "/categoria")
    public ResponseEntity createCategoria(@RequestBody Categoria categoria){
        try{
            categoriaRepository.save(categoria);
            return new ResponseEntity(categoria, HttpStatus.CREATED);
        }catch (Exception e){
            System.out.println(e.fillInStackTrace());
            return  ResponseEntity.badRequest().build();
        }
    }
    @GetMapping(value = "categorias")
    public ResponseEntity listCategorias(){
        List<Categoria> categorias = categoriaRepository.findAll();
        if(categorias.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return new ResponseEntity(categorias,HttpStatus.OK);
        }
    }
}
