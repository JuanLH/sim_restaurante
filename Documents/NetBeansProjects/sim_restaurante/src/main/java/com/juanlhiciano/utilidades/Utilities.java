package com.juanlhiciano.utilidades;


import com.juanlhiciano.database.Db;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;





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
        
    public static float floatRand(float leftLimit,float rightLimit) {
        Random rand = new Random();
        return leftLimit + rand.nextFloat() * (rightLimit - leftLimit);
    }

    public static Double doubleRand(float leftLimit,float rightLimit) {
        Random rand = new Random();
        return leftLimit + rand.nextDouble() * (rightLimit - leftLimit);
    }
    
    public static int intRand(int leftLimit,int rightLimit) {
        return (int)(Math.random()*((rightLimit-leftLimit)+1))+leftLimit;
    }
	


    public static String getFileExtension(String Pathfile) {
        int lastIndexOf = Pathfile.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return ""; 
        }
        return Pathfile.substring(lastIndexOf);
    }

    

    public static Double getExponencialTime(float miu){
        Double rand_llegada = Utilities.doubleRand(0, 1);
        Double tiempo_llegada = -miu * Math.log(rand_llegada);
        return tiempo_llegada;
    }
    
    public static int getNextId(String table,Db dbase) throws SQLException{
        String sql = "select id from "+table+" order by id desc limit 1;";
        ResultSet rs = dbase.execSelect(sql);
        if(rs.next())
            return rs.getInt(1)+1;
        else
            return 1;
    }

}
