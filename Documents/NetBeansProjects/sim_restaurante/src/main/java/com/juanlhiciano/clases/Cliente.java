/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juanlhiciano.clases;

import Enumeradores.EstadoCliente;
import com.juanlhiciano.entidades.Orden;
import com.juanlhiciano.entidades.Visita;
import java.awt.event.ActionEvent;
import java.sql.Time;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.JButton;

/**
 *
 * @author JLHiciano
 */
public class Cliente extends JButton{
    Visita visita;
    ArrayList<Orden> ordenes;
    EstadoCliente estado;
    
    Cliente(Time hora_llegada){
        this.addActionListener(new SomeAction(this));
        visita = new Visita(hora_llegada);
        ordenes= new ArrayList<>();
        estado = EstadoCliente.LLEGANDO;
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

    public EstadoCliente getEstado() {
        return estado;
    }

    public void setEstado(EstadoCliente estado) {
        this.estado = estado;
    }
    
    class SomeAction extends AbstractAction{
        Cliente cliente;
        
        public SomeAction( Cliente cli)
        {
            super();
            cliente = cli;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(cliente.getOrdenes().size());
            System.out.println(cliente.getEstado());
            for(Orden or : cliente.getOrdenes())
                System.out.println(or.getProducto().getNombre()+" status="+or.getEstado());
        }
        
        
    } 
}
