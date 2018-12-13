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

/**
 *
 * @author JLHiciano
 */
public class Tanda {
    int id,id_dia;
    private float alta,media,baja;

    public Tanda(int id_dia) throws SQLException {
        this.id_dia = id_dia;
        String sql = "SELECT id, id_dia, porc_alta, porc_media, porc_baja\n" +
                        "  FROM public.tanda where id_dia = "+id_dia+";";
        Db dbase = Utilities.getConection();
        ResultSet rs = dbase.execSelect(sql);
        
        if(rs.next()){
            id = rs.getInt(1);
            alta = rs.getFloat(3);
            media = rs.getFloat(4);
            baja = rs.getFloat(5);
        }
        
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
