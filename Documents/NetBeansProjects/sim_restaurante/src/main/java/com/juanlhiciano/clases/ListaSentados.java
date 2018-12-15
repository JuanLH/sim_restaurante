/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juanlhiciano.clases;

import Enumeradores.EstadoCliente;
import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author JLHiciano
 */
public class ListaSentados extends Vector<Cliente>{
    
    JPanel panel;
     Rectangle rec;
    int filas;
    public ListaSentados(JPanel panel){
        this.panel = panel;
        rec = new Rectangle(666, 19, 20, 20);
        filas = 0;
    }
    
    public boolean add (Cliente btn){
        
        btn.setEstado(EstadoCliente.ESPERANDO);
        if(this.isEmpty()){
            btn.setBounds(rec);
            btn.setVisible(true);
            super.add(btn);
            panel.add(btn);
            panel.revalidate();
            panel.repaint();
            return true;
        }
        else if(this.get(this.size()-1).getBounds().x<12){
            filas++;
            btn.setBounds( new Rectangle(rec.x, rec.y + filas*25, rec.width, rec.height));
            btn.setVisible(true);
            super.add(btn);
            panel.add(btn);
            panel.revalidate();
            panel.repaint();
            return true;
        }
        else{
            Rectangle rec = this.get(this.size()-1).getBounds();
            btn.setBounds(new Rectangle(rec.x-(rec.width+2), rec.y, rec.width,rec.height));
            btn.setVisible(true);
            super.add(btn);
            panel.add(btn);
            panel.revalidate();
            panel.repaint();
            return true;
        }
        
    }
    
    public boolean remove(Cliente btn){
        if(this.isEmpty()){
            return false;
        }
        else{
            panel.remove(btn);
            panel.revalidate();
            panel.repaint();
            this.remove(btn);
            //add btn to another list
            return true;
        }
    }
    
    public void changeStatus(EstadoCliente estado,Cliente cli){
        try{
            if(estado == EstadoCliente.COMIENDO){
                cli.setEstado(estado);
               cli.setBackground(Color.ORANGE);
            }

            if(estado == EstadoCliente.REPOSANDO){
                cli.setEstado(estado);
                cli.setBackground(Color.GREEN);
            }

            panel.revalidate();
            panel.repaint();
       }
       catch(Exception ex){
           System.err.println("Cambiando el color"+ex.getMessage());
       }
    }
}
