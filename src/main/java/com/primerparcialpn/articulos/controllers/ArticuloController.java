package com.primerparcialpn.articulos.controllers;

import com.primerparcialpn.articulos.models.Articulo;
import com.primerparcialpn.articulos.models.Categoria;
import com.primerparcialpn.articulos.repository.ArticuloRepository;
import com.primerparcialpn.articulos.repository.CategoriaRepository;
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
    @Autowired
    private CategoriaRepository categoriaRepository;
    @PostMapping(value = "/articulo")
    public ResponseEntity createArticulo(@RequestBody Articulo articulo){
        try{
            articuloRepository.save(articulo);
            return new ResponseEntity(articulo, HttpStatus.CREATED);
        }catch (Exception e){
            return  ResponseEntity.badRequest().build();
        }
    }
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
        Optional<Articulo> articulo = articuloRepository.findByCodigo(codigo);
        if (articulo.isPresent()) {
            return new ResponseEntity(articulo, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(value = "/update/{codigo}")
    public ResponseEntity updateArticulo(@PathVariable String codigo, @RequestBody Articulo articulo){
        Optional<Articulo> articuloBD = articuloRepository.findByCodigo(codigo);
        if(articuloBD.isPresent()){
            try {
                articuloBD.get().setNombre(articulo.getNombre());
                articuloBD.get().setFecha(articulo.getFecha());
                articuloBD.get().setCompra(articulo.getCompra());
                articuloBD.get().setVenta(articulo.getVenta());
                articuloBD.get().setCategoria(articulo.getCategoria());
                articuloBD.get().setDescricion(articulo.getDescricion());
                articuloBD.get().setStock(articulo.getStock());
                articuloRepository.save(articuloBD.get());
                return new ResponseEntity(articuloBD,HttpStatus.OK);
            }catch (Exception e){
                return ResponseEntity.badRequest().build();
            }
        }else{
            return  ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping(value = "/delete/{codigo}")
    public ResponseEntity deleteArticulo(@PathVariable String codigo) {
        Optional<Articulo> articuloBD = articuloRepository.findByCodigo(codigo);
        if (articuloBD.isPresent()) {
            articuloRepository.delete(articuloBD.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
