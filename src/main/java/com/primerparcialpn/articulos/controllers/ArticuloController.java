package com.primerparcialpn.articulos.controllers;

import com.primerparcialpn.articulos.models.Articulo;
import com.primerparcialpn.articulos.services.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ArticuloController {
    @Autowired
    private ArticuloService articuloService;
    @PostMapping(value = "/articulo")
    public ResponseEntity createArticulo(@Valid @RequestBody Articulo articulo){

            return articuloService.createArticulo(articulo);
    }
    @GetMapping(value = "/articulos")
    public ResponseEntity listArticulo(){
            return articuloService.listArticulo();
    }
   @GetMapping(value = "articulo/{codigo}")
    public ResponseEntity getArticulo(@PathVariable String codigo) {
        return articuloService.getArticulo(codigo);
    }

    @PutMapping(value = "/updateArticulo/{codigo}")
    public ResponseEntity updateArticulo(@PathVariable String codigo,@Valid @RequestBody Articulo articulo){
        return articuloService.updateArticulo(codigo,articulo);
    }
    @DeleteMapping(value = "/delete/{codigo}")
    public ResponseEntity deleteArticulo(@PathVariable String codigo) {
        return articuloService.deleteArticulo(codigo);
    }

}
