/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juanlhiciano.sim_restaurante;

import java.sql.Time;
import org.joda.time.LocalTime;
import org.joda.time.Minutes;

/**
 *
 * @author JLHiciano
 */
public class DiferenciaDeTiempos {
    
    public static void main(String [] args){
        LocalTime lt1 = new LocalTime(6,30,0);
        LocalTime lt2 = new LocalTime(5,0,0);
        
        long diferencia = lt1.getMillisOfDay() - lt2.getMillisOfDay();
        long diffSec = diferencia / 1000;
        long min = diffSec / 60;
        long sec = diffSec % 60;
        System.out.println("The difference is "+min+" minutes and "+sec+" seconds.");
        
        Minutes minutes = Minutes.minutesBetween(lt1, lt2);
        System.out.println("Joda Time minutes = "+minutes.getMinutes());
        
        
        Time t1 = new Time(5,0,0);
        Time t2 = new Time(6,30,0);
        LocalTime lt11 = new LocalTime(t1.getTime());
        LocalTime lt22 = new LocalTime(t2.getTime());
        Minutes min_time = Minutes.minutesBetween(lt11, lt22);
        System.out.println("Joda Time minutes desde sql.Time = "+min_time.getMinutes());
        LocalTime tiempo = new LocalTime(diferencia);
        System.out.println(tiempo);
    }
}
