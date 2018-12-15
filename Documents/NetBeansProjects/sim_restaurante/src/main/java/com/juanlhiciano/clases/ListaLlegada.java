/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juanlhiciano.clases;


import java.awt.Rectangle;
import java.sql.Time;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author JLHiciano
 */
public class ListaLlegada extends ArrayList<Cliente>{
    
    JPanel panel;
    public ListaLlegada(JPanel panel){
        this.panel = panel;
    }
    
    
    
    public boolean add (Time hora_llegada){
        
        Cliente btn = new Cliente(hora_llegada);
        
        if(this.isEmpty()){
            btn.setBounds( new Rectangle(1275, 20, 25, 25));
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
    
    public boolean remove(){
        if(this.isEmpty()){
            return false;
        }
        else{
            Cliente btn = this.get(this.size()-1);
            panel.remove(btn);
            panel.revalidate();
            panel.repaint();
            this.remove(btn);
            //Add btn to another list
            return true;
        }
    }
    
}
