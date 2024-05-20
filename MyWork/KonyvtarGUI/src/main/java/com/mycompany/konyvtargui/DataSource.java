/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.konyvtargui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author peter
 */
public class DataSource {
    
    Connection conn = null;

    String user = "peter";
    String pass = "almafa12";
    String url = "jdbc:mariadb://localhost:3306/Konyvtar";
    
    public void getKolcsonzok(){
        
        try{
           conn = DriverManager.getConnection(url, user, pass);
           
           String sql = """
                        select nev, szulido
                        from Kolcsonzok                                    
                        """;
           
        } catch(Exception e){
            System.err.println("Hiba, az adatbazis eleres sikertelen");
            System.err.println(e.getMessage());
        }
        
        
        
    }
}
