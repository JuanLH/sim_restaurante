/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juanlhiciano.clases;

import com.juanlhiciano.entidades.Orden;
import com.juanlhiciano.entidades.Producto;
import java.awt.Rectangle;
import java.sql.Time;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author JLHiciano
 */
public class ListaOrden extends ArrayList<Orden> {
    JPanel panel;
    public ListaOrden(JPanel panel){
        this.panel = panel;
    }
    
    @Override
    public boolean add (Orden btn){
        
        if(this.isEmpty()){
            btn.setBounds( new Rectangle(20, 29, 15, 15));
            btn.setVisible(true);
            super.add(btn);
            panel.add(btn);
            panel.revalidate();
            panel.repaint();
            return true;
        }
        else{
            Rectangle rec = this.get(this.size()-1).getBounds();
            btn.setBounds(new Rectangle(rec.x+(rec.width+2), rec.y, rec.width,rec.height));
            btn.setVisible(true);
            super.add(btn);
            panel.add(btn);
            panel.revalidate();
            panel.repaint();
            return true;
        }
        
    }
}
