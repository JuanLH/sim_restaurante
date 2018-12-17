package com.juanlhiciano.entidades;

import com.juanlhiciano.database.Db;
import com.juanlhiciano.utilidades.Utilities;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Simulacion {
	
    int id,id_dia,cant_coci_plancha,cant_coci_yaroa,cant_coci_hd,cant_coci_bbq;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_dia() {
        return id_dia;
    }

    public void setId_dia(int id_dia) {
        this.id_dia = id_dia;
    }

    public int getCant_coci_plancha() {
        return cant_coci_plancha;
    }

    public void setCant_coci_plancha(int cant_coci_plancha) {
        this.cant_coci_plancha = cant_coci_plancha;
    }

    public int getCant_coci_yaroa() {
        return cant_coci_yaroa;
    }

    public void setCant_coci_yaroa(int cant_coci_yaroa) {
        this.cant_coci_yaroa = cant_coci_yaroa;
    }

    public int getCant_coci_hd() {
        return cant_coci_hd;
    }

    public void setCant_coci_hd(int cant_coci_hd) {
        this.cant_coci_hd = cant_coci_hd;
    }

    public int getCant_coci_bbq() {
        return cant_coci_bbq;
    }

    public void setCant_coci_bbq(int cant_coci_bbq) {
        this.cant_coci_bbq = cant_coci_bbq;
    }
    
    public static Simulacion getLastSimulation(Db dbase) throws SQLException{
        String ultima_simulacion = "select id,id_dia,cant_coci_plancha,cant_coci_yaroa,"
                + "cant_coci_hd,cant_coci_bbq"
                + " from simulacion order by id desc limit 1";
        ResultSet rs = dbase.execSelect(ultima_simulacion);
        if(rs.next()){
            Simulacion sim = new Simulacion();
            sim.setId(rs.getInt(1));
            sim.setId_dia(rs.getInt(2));
            sim.setCant_coci_plancha(rs.getInt(3));
            sim.setCant_coci_yaroa(rs.getInt(4));
            sim.setCant_coci_hd(rs.getInt(5));
            sim.setCant_coci_bbq(rs.getInt(6));
            return sim;
        }
        else
            return null;
            
    }
}
