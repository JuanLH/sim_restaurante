/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juanlhiciano.clases;

import com.juanlhiciano.entidades.Orden;
import com.juanlhiciano.entidades.Visita;
import java.sql.Time;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author JLHiciano
 */
public class Cliente extends JButton{
    Visita visita;
    ArrayList<Orden> ordenes;
    int estado;
    
    Cliente(Time hora_llegada){
        visita = new Visita(hora_llegada);
        ordenes= new ArrayList<>();
    }

    public Visita getVisita() {
        return visita;
    }

    public void setVisita(Visita visita) {
        this.visita = visita;
    }

    public ArrayList<Orden> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(ArrayList<Orden> ordenes) {
        this.ordenes = ordenes;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
     
}
