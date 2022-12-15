package com.primerparcialpn.articulos.controllers;

import com.primerparcialpn.articulos.models.Articulo;
import com.primerparcialpn.articulos.services.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import com.primerparcialpn.articulos.utils.JWTUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@CrossOrigin(maxAge = 3600)
@RestController
public class ArticuloController {
    @Autowired
    private ArticuloService articuloService;

    @Autowired
    private JWTUtil jwtUtil;
    @PostMapping(value = "/articulo")
    public ResponseEntity createArticulo(@Valid @RequestBody Articulo articulo){
            return articuloService.createArticulo(articulo);
    }
    @GetMapping(value = "/articulos")
    public ResponseEntity listArticulo(@RequestHeader(value = "Authorization") String token){
        if(jwtUtil.getKey(token)==null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("¡Token no valido!");
        }
            return articuloService.listArticulo();
    }
   @GetMapping(value = "articulo/{codigo}")
    public ResponseEntity getArticulo(@PathVariable String codigo, @RequestHeader(value = "Authorization") String token) {
       if(jwtUtil.getKey(token)==null){
           return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("¡Token no valido!");
       }
        return articuloService.getArticulo(codigo);
    }

    @PutMapping(value = "/articulo/{codigo}")
    public ResponseEntity updateArticulo(@PathVariable String codigo,@Valid @RequestBody Articulo articulo, @RequestHeader(value = "Authorization") String token){
        if(jwtUtil.getKey(token)==null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("¡Token no valido!");
        }
        return articuloService.updateArticulo(codigo,articulo);
    }
    @DeleteMapping(value = "/articulo/{codigo}")
    public ResponseEntity deleteArticulo(@PathVariable String codigo, @RequestHeader(value = "Authorization") String token) {
        if(jwtUtil.getKey(token)==null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("¡Token no valido!");
        }
        return articuloService.deleteArticulo(codigo);
    }

}
