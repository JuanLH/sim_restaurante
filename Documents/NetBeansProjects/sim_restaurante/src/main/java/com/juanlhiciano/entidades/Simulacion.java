package com.juanlhiciano.entidades;

import com.juanlhiciano.database.Db;
import com.juanlhiciano.utilidades.Utilities;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class Simulacion {
	
	int id,id_dia,cant_coci_p1,cant_coci_p2,cant_coci_p3;

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

	public int getCant_coci_p1() {
		return cant_coci_p1;
	}

	public void setCant_coci_p1(int cant_coci_p1) {
		this.cant_coci_p1 = cant_coci_p1;
	}

	public int getCant_coci_p2() {
		return cant_coci_p2;
	}

	public void setCant_coci_p2(int cant_coci_p2) {
		this.cant_coci_p2 = cant_coci_p2;
	}

	public int getCant_coci_p3() {
		return cant_coci_p3;
	}

	public void setCant_coci_p3(int cant_coci_p3) {
		this.cant_coci_p3 = cant_coci_p3;
	}
	
	public void insert(Db dbase) throws SQLException {
		int nextId = Utilities.getNextId(dbase, "simulacion");
		String sql = "INSERT INTO public.simulacion(id, id_dia, cant_coci_p1, cant_coci_p2, cant_coci_p3)"
				+ " VALUES (?, ?, ?, ?, ?);";
		PreparedStatement ps = dbase.getConnection().prepareStatement(sql);
		ps.setInt(1, nextId);
		ps.setInt(1, id_dia);
		ps.setInt(3, cant_coci_p1);
		ps.setInt(4, cant_coci_p2);
		ps.setInt(5, cant_coci_p3);
		ps.executeUpdate();
		
	}
}
