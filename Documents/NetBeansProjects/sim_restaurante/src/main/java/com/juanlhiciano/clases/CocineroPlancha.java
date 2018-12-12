/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juanlhiciano.clases;

import com.juanlhiciano.entidades.Orden;
import java.util.ArrayList;

/**
 *
 * @author JLHiciano
 */
public class CocineroPlancha implements Runnable{

    ArrayList<Orden> ordenes_pendientes;
    ArrayList<Orden> ordenes_entregadas;
    
    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<Orden> getOrdenes_pendientes() {
        return ordenes_pendientes;
    }

    public void setOrdenes_pendientes(ArrayList<Orden> ordenes_pendientes) {
        this.ordenes_pendientes = ordenes_pendientes;
    }

    public ArrayList<Orden> getOrdenes_entregadas() {
        return ordenes_entregadas;
    }

    public void setOrdenes_entregadas(ArrayList<Orden> ordenes_entregadas) {
        this.ordenes_entregadas = ordenes_entregadas;
    }
    
    
}
