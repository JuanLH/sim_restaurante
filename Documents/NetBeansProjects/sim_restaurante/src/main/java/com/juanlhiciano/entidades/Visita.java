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
public class Visita {
    int id,id_simulacion;
    Time hora_llegada,hora_orden,hora_entrega,hora_salida;
    
    public Visita(Time hora_llegada){
        this.hora_llegada = hora_llegada;
        hora_orden=hora_entrega=hora_salida=null;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_simulacion() {
        return id_simulacion;
    }

    public void setId_simulacion(int id_simulacion) {
        this.id_simulacion = id_simulacion;
    }

    public Time getHora_llegada() {
        return hora_llegada;
    }

    public void setHora_llegada(Time hora_llegada) {
        this.hora_llegada = hora_llegada;
    }

    public Time getHora_orden() {
        return hora_orden;
    }

    public void setHora_orden(Time hora_orden) {
        this.hora_orden = hora_orden;
    }

    public Time getHora_entrega() {
        return hora_entrega;
    }

    public void setHora_entrega(Time hora_entrega) {
        this.hora_entrega = hora_entrega;
    }

    public Time getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(Time hora_salida) {
        this.hora_salida = hora_salida;
    }
    
    
}
