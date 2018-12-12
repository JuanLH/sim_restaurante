/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juanlhiciano.entidades;

import java.sql.Time;

/**
 *
 * @author JLHiciano
 */
public class Orden {
    int id,id_visita,id_producto;
    Time t_inicio_cola,t_fin_cola,t_entrega;

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

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
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
    
    
}
