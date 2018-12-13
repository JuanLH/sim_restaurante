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
public class Dia {
    int id;
    String descripcion;

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    public  static ArrayList<Dia> getDias() throws SQLException{
        ArrayList<Dia> dias = new ArrayList<>();
        Db dbase = Utilities.getConection();
        String sql ="SELECT id, descripcion\n" +
                    "  FROM public.dia;";
        ResultSet rs = dbase.execSelect(sql);
        while(rs.next()){
            Dia dia = new Dia();
            dia.setId(rs.getInt(1));
            dia.setDescripcion(rs.getString(2));
            dias.add(dia);
        }
        return dias;
    }
    
    @Override
    public String toString(){
        return descripcion;
    }
    
}
