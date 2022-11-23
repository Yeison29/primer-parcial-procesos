package com.primerparcialpn.articulos.services;

import com.primerparcialpn.articulos.models.Articulo;
import com.primerparcialpn.articulos.repository.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticuloServiceImpl implements ArticuloService{
    @Autowired
    private ArticuloRepository articuloRepository;

    @Override
    public ResponseEntity<Articulo> createArticulo(Articulo articulo){
        try{
            articuloRepository.save(articulo);
            return new ResponseEntity(articulo, HttpStatus.CREATED);
        }catch (Exception e){
            return  ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<List<Articulo>> listArticulo(){
        List<Articulo> articulos = articuloRepository.findAll();
        if(articulos.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return new ResponseEntity(articulos, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<Articulo> getArticulo(String codigo) {
        Optional<Articulo> articulo = articuloRepository.findByCodigo(codigo);
        if (articulo.isPresent()) {
            return new ResponseEntity(articulo, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Articulo> updateArticulo(String codigo, Articulo articulo){
        Optional<Articulo> articuloBD = articuloRepository.findByCodigo(codigo);
        if(articuloBD.isPresent()){
            try {
                articuloBD.get().setNombre(articulo.getNombre());
                articuloBD.get().setFecha(articulo.getFecha());
                articuloBD.get().setCompra(articulo.getCompra());
                articuloBD.get().setVenta(articulo.getVenta());
                articuloBD.get().setCategoria(articulo.getCategoria());
                articuloBD.get().setDescripcion(articulo.getDescripcion());
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

    @Override
    public ResponseEntity<Articulo> deleteArticulo(String codigo) {
        Optional<Articulo> articuloBD = articuloRepository.findByCodigo(codigo);
        if (articuloBD.isPresent()) {
            articuloRepository.delete(articuloBD.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
