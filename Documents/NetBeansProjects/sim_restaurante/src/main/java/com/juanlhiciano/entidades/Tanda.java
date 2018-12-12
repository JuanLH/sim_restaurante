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
public class Tanda {
    int id,id_dia;
    private float alta,media,baja;

    public Tanda(int id_dia) {
        this.id_dia = id_dia;
        
        //Llenar las tandas float de la bdd
    }

    public float getAlta() {
        return alta;
    }

    public float getMedia() {
        return media;
    }

    public float getBaja() {
        return baja;
    }
    
    
    
    
}
