/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juanlhiciano.entidades;

import Enumeradores.EstadoCliente;
import com.juanlhiciano.database.Db;
import com.juanlhiciano.entidades.Orden;
import com.juanlhiciano.entidades.Visita;
import com.juanlhiciano.utilidades.Utilities;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
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
    
    public Cliente(Time hora_llegada){
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
            
            System.out.println("Hora llegada "+cliente.getVisita().getHora_llegada());
            System.out.println("Hora orden "+cliente.getVisita().getHora_orden());
            System.out.println("Hora entrega "+cliente.getVisita().getHora_entrega());
            System.out.println("Hora comer "+cliente.getVisita().getHora_fin_comer());
            System.out.println("Hora Salida "+cliente.getVisita().getHora_salida());
            
            System.out.println("Cantidad Ordenes -------------------->"+cliente.getOrdenes().size());
            System.out.println(cliente.getEstado());
            for(Orden or : cliente.getOrdenes()){
                System.out.println(or.getProducto().getNombre()+" status="+or.getEstado());
                System.out.println(or.getT_inicio_cola()+" - "+or.getT_fin_cola()+" "+or.getT_entrega());
            }
            
            
        }
        
        
    } 
}
