/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juanlhiciano.clases;

import Enumeradores.EstadoOrden;
import com.juanlhiciano.entidades.Orden;
import com.juanlhiciano.entidades.Producto;
import java.awt.Rectangle;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author JLHiciano
 */
public class ListaOrden extends CopyOnWriteArrayList<Orden> {
    JPanel panel;
    //private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public ListaOrden(JPanel panel){
        this.panel = panel;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }
    
    @Override
    public synchronized boolean add (Orden btn){
            
            btn.setEstado(EstadoOrden.COLA);
            if(this.isEmpty()){
                btn.setBounds( new Rectangle(20, 29, 20, 20));
                btn.setVisible(true);
                super.add(btn);
                panel.add(btn);
                panel.revalidate();
                panel.repaint();
                //lock.writeLock().unlock();
                //this.notify();
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
            
        //}
    }
    
    
    public synchronized boolean remove(){
       
        if(this.isEmpty()){
            return true;
        }
        else{

            Orden btn = this.get(0);

            Rectangle rec_actual;
            Rectangle rec_proximo;
            Rectangle tmp = this.get(0).getBounds();
            for(int x=0;x<this.size()-1;x++){
                rec_proximo = this.get(x+1).getBounds();
                this.get(x+1).setBounds(tmp);
                tmp =rec_proximo;

            }
            this.remove(btn);
            panel.remove(btn);
            panel.revalidate();
            panel.repaint();


            //Add btn to another list
            return true;
        }
        
    }
    
    /*@Override
    public synchronized Orden get(int index){
        try {
            wait(10);
        } catch (InterruptedException ex) {
            Logger.getLogger(ListaOrden.class.getName()).log(Level.SEVERE, null, ex);
        }
        return super.get(index);
    }*/
}
