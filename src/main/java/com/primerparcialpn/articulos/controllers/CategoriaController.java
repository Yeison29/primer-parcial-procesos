package com.primerparcialpn.articulos.controllers;

import com.primerparcialpn.articulos.models.Categoria;
import com.primerparcialpn.articulos.services.CategoriaService;
import com.primerparcialpn.articulos.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;
    @Autowired
    private JWTUtil jwtUtil;
    @PostMapping(value = "/categoria")
    public ResponseEntity createCategoria(@Valid @RequestBody Categoria categoria){
        return categoriaService.createCategoria(categoria);
    }
    @GetMapping(value = "categorias")
    public ResponseEntity listCategorias(@RequestHeader(value = "Authorization") String token){
        if(jwtUtil.getKey(token)==null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("¡Token no valido!");
        }else{
            return categoriaService.allCategorias();
        }
    }
    @GetMapping(value = "categoria/{id}")
    public ResponseEntity getCategoria(@PathVariable Long id, @RequestHeader(value = "Authorization") String token) {
        if(jwtUtil.getKey(token)==null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("¡Token no valido!");
        }else{
            return categoriaService.getCategoriaById(id);
        }
    }
    @PutMapping(value = "/updateCategoria/{id}")
    public ResponseEntity updateArticulo(@PathVariable Long id, @RequestBody Categoria categoria, @RequestHeader(value = "Authorization") String token){
        if(jwtUtil.getKey(token)==null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("¡Token no valido!");
        }else{
            return categoriaService.editCategoria(id, categoria);
        }
    }
    //La categoria se puede eliminar siempre y cuando esa categoria no este relacionado con ningun articulo
    @DeleteMapping(value = "/deleteCategoria/{id}")
    public ResponseEntity deleteCategoria(@PathVariable Long id, @RequestHeader(value = "Authorization") String token) {
        if(jwtUtil.getKey(token)==null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("¡Token no valido!");
        }else{
            return categoriaService.deleteCategoria(id);
        }
    }
}
