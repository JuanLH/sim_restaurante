/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juanlhiciano.entidades;

import com.juanlhiciano.database.Db;
import com.juanlhiciano.utilidades.Utilities;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author JLHiciano
 */
public class Producto {
    int id,precio,id_tipo_producto,tiempo_min_prep,tiempo_max_prep;
    float rango_inicial,rango_final;
    String nombre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getId_tipo_producto() {
        return id_tipo_producto;
    }

    public void setId_tipo_producto(int id_tipo_producto) {
        this.id_tipo_producto = id_tipo_producto;
    }

    public int getTiempo_min_prep() {
        return tiempo_min_prep;
    }

    public void setTiempo_min_prep(int tiempo_min_prep) {
        this.tiempo_min_prep = tiempo_min_prep;
    }

    public int getTiempo_max_prep() {
        return tiempo_max_prep;
    }

    public void setTiempo_max_prep(int tiempo_max_prep) {
        this.tiempo_max_prep = tiempo_max_prep;
    }

    public float getRango_inicial() {
        return rango_inicial;
    }

    public void setRango_inicial(float rango_inicial) {
        this.rango_inicial = rango_inicial;
    }

    public float getRango_final() {
        return rango_final;
    }

    public void setRango_final(float rango_final) {
        this.rango_final = rango_final;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Producto> getListado() throws SQLException{
        ArrayList<Producto> list = new ArrayList<>();
        String sql = "SELECT id, nombre, precio, id_tipo_producto, "
                + "tiempo_min_prep, tiempo_max_prep, rango_inicial, rango_final\n"
                + "  FROM public.producto;";
        Db dbase = Utilities.getConection();
        ResultSet rs = dbase.execSelect(sql);
        while(rs.next()){
            Producto pro = new Producto();
            pro.setId(rs.getInt(1));
            pro.setNombre(rs.getString(2));
            pro.setPrecio(rs.getInt(3));
            pro.setId_tipo_producto(4);
            pro.setTiempo_min_prep(rs.getInt(5));
            pro.setTiempo_max_prep(rs.getInt(6));
            pro.setRango_inicial(rs.getFloat(7));
            pro.setRango_final(rs.getFloat(8));
            list.add(pro);
        }
        
        return list;
    }
    
    public Producto findProducto(ArrayList<Producto> lista, float rand){
        for(Producto p:lista){
            if(p.getRango_inicial()<=rand && p.getRango_final()>=rand)
                return p;
        }
        return null;
    }
    
    
    
}
