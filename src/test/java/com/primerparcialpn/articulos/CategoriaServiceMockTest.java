package com.primerparcialpn.articulos;

import com.primerparcialpn.articulos.models.Categoria;

public class CategoriaServiceMockTest {
    public static Categoria mockCategoria() {
        Categoria modelo = new Categoria();
        modelo.setId(1L);
        modelo.setNombre("Limpiza");
        modelo.setDescripcion("Productos detergetes");

        return modelo;
    }
}
