package com.primerparcialpn.articulos.models;

public class Categoria {
    private String nombreCategoria;
    private String descripcionCategoria;
    public Categoria(){
        
    }
    public Categoria(String nombreCategoria,String descripcionCategoria){
        this.nombreCategoria=nombreCategoria;
        this.descripcionCategoria=descripcionCategoria;
    }

    public String getNombreCategoria(){
        return nombreCategoria;
    }
    public String getDescripcionCategoria(){
        return descripcionCategoria;
    }
    public void setNombreCategoria(String nombreCategoria){
        this.nombreCategoria=nombreCategoria;
    }
    public void setDescripcionCategoria(String descripcionCategoria){
        this.descripcionCategoria=descripcionCategoria;
    }
}
