package com.primerparcialpn.articulos.controllers;

import com.primerparcialpn.articulos.models.Articulo;
import com.primerparcialpn.articulos.models.Categoria;
import com.primerparcialpn.articulos.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @GetMapping(value = "categoria/{id}")
    public ResponseEntity getCategoria(@PathVariable Long id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if (categoria.isPresent()) {
            return new ResponseEntity(categoria, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping(value = "/updateCategoria/{id}")
    public ResponseEntity updateArticulo(@PathVariable Long id, @RequestBody Articulo categoria){
        Optional<Categoria> categoriaBD = categoriaRepository.findById(id);
        if(categoriaBD.isPresent()){
            try {
                categoriaBD.get().setNombre(categoria.getNombre());
                categoriaBD.get().setDescripcion(categoria.getDescripcion());
                categoriaRepository.save(categoriaBD.get());
                return new ResponseEntity(categoriaBD,HttpStatus.OK);
            }catch (Exception e){
                return ResponseEntity.badRequest().build();
            }
        }else{
            return  ResponseEntity.notFound().build();
        }
    }
}
