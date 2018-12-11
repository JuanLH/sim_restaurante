package com.juanlhiciano.utilidades;


import com.juanlhiciano.database.Db;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;





public class Utilities {
	private static Connection cnn = null;
	 
	public static Db getConection(){
        Db dbase = new Db(true,"Sim_LaRubia","postgres","letmein");
        cnn = dbase.getConnection();
        return dbase;
    }
	
	public static Db getTransConection(){
		Db dbase = new Db(true,"Sim_LaRubia","postgres","letmein");
        return dbase;
    }
	
	public static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }
	


	public static String getFileExtension(String Pathfile) {
	    int lastIndexOf = Pathfile.lastIndexOf(".");
	    if (lastIndexOf == -1) {
	        return ""; 
	    }
	    return Pathfile.substring(lastIndexOf);
	}
	
	public static int getNextId(Db dbase,String table) throws SQLException {
		String query = "SELECT id FROM public."+table+" order by id DESC limit 1;";
		ResultSet rs = dbase.execSelect(query);
		
		if(rs.next()) 
			return rs.getInt(1)+1;
		else 
			return 1;
		
				
	}


}