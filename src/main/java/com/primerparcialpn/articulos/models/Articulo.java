package com.primerparcialpn.articulos.models;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "articulos")

public class Articulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, unique = true)
    private String codigo;
    @Column(length = 100, nullable = false)
    private String nombre;
    @Column(length = 500)
    private String descricion;
    @Column(nullable = false)
    private Date fechaRegistro;
    @Column(length = 50, nullable = false)
    private int stock;
    @Column(length = 100, nullable = false)
    private double precioVenta;
    @Column(length = 100, nullable = false)
    private int precioCompra;
    @ManyToOne
    private  Categoria categoria;

    /*código, nombre, descripción, fecha de registro,
    categoria( tiene un nombre y una descripción), stock,
    precio de venta y precio de compra
     */

}
