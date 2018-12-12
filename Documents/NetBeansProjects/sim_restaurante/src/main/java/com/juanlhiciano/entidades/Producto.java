/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juanlhiciano.entidades;

/**
 *
 * @author JLHiciano
 */
public class Producto {
    int id,precio,id_tipo_producto,tiempo_max_prep,tiempo_min_prep;
    String nombre;     
    float porc_elec;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getId_tipo_producto() {
        return id_tipo_producto;
    }

    public void setId_tipo_producto(int id_tipo_producto) {
        this.id_tipo_producto = id_tipo_producto;
    }

    public int getTiempo_max_prep() {
        return tiempo_max_prep;
    }

    public void setTiempo_max_prep(int tiempo_max_prep) {
        this.tiempo_max_prep = tiempo_max_prep;
    }

    public int getTiempo_min_prep() {
        return tiempo_min_prep;
    }

    public void setTiempo_min_prep(int tiempo_min_prep) {
        this.tiempo_min_prep = tiempo_min_prep;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPorc_elec() {
        return porc_elec;
    }

    public void setPorc_elec(float porc_elec) {
        this.porc_elec = porc_elec;
    }
    
    
    
}
