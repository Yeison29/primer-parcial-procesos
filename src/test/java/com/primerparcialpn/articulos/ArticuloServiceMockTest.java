package com.primerparcialpn.articulos;
import com.primerparcialpn.articulos.models.Articulo;

import java.util.Date;

import static com.primerparcialpn.articulos.CategoriaServiceMockTest.mockCategoria;

public class ArticuloServiceMockTest {


    public static Articulo mockArticulo() {
        Articulo modelo = new Articulo();
        modelo.setId(1L);
        modelo.setCodigo("123");
        modelo.setNombre("Limpido");
        modelo.setStock(2);
        modelo.setCategoria(mockCategoria());
        modelo.setDescripcion("HCL");
        modelo.setVenta(2000);
        modelo.setCompra(5000);
        modelo.setFecha(new Date(10,10,20));

        return modelo;
    }
    public static Articulo mockArticuloMod() {
        Articulo modelo = new Articulo();
        modelo.setId(1L);
        modelo.setCodigo("1");
        modelo.setNombre("Lejia");
        modelo.setStock(2);
        modelo.setCategoria(mockCategoria());
        modelo.setDescripcion("HCL");
        modelo.setVenta(2000);
        modelo.setCompra(5000);
        modelo.setFecha(new Date(10,10,20));

        return modelo;
    }

}
