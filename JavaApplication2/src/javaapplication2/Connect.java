/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;  
import java.sql.*;

/**
 *
 * @author au
 */
public class Connect {
    public static void main(String[] args) {
        try {  
        Class.forName("com.mysql.jdbc.Driver"); 
        String Url = "jdbc:mysql://localhost:3306/Student"; 
        Connection con=DriverManager.getConnection(Url,"root",""); 
        Statement st = con.createStatement(); 
        st.executeUpdate("insert into inforamtion(id,name) values(1,'Miraj')");
        } 
        catch(Exception e) { 
            System.out.println(e);
        }
    }
    
}
