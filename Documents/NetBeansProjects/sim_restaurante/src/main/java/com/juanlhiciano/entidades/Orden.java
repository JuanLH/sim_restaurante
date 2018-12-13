/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juanlhiciano.entidades;

import java.sql.Time;
import javax.swing.JButton;

/**
 *
 * @author JLHiciano
 */
public class Orden extends JButton {
    int id,id_visita;
    Producto producto;
    Time t_inicio_cola,t_fin_cola,t_entrega;
    int estado;//para marcar el proceso
    public Orden(){}
    public Orden(Producto p,Time t_inicio_cola){
        this.producto = p;
        this.t_inicio_cola = t_inicio_cola;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_visita() {
        return id_visita;
    }

    public void setId_visita(int id_visita) {
        this.id_visita = id_visita;
    }

    public Time getT_inicio_cola() {
        return t_inicio_cola;
    }

    public void setT_inicio_cola(Time t_inicio_cola) {
        this.t_inicio_cola = t_inicio_cola;
    }

    public Time getT_fin_cola() {
        return t_fin_cola;
    }

    public void setT_fin_cola(Time t_fin_cola) {
        this.t_fin_cola = t_fin_cola;
    }

    public Time getT_entrega() {
        return t_entrega;
    }

    public void setT_entrega(Time t_entrega) {
        this.t_entrega = t_entrega;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
}
