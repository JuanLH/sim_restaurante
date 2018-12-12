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
    
    Cliente(int id_visita,int id_simulacion,Time hora_llegada){
        visita = new Visita(id_visita,id_simulacion,hora_llegada);
        ordenes= new ArrayList<>();
    }
}
