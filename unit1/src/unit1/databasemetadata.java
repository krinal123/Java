/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit1;
import java.sql.*;

/**
 *
 * @author Lenovo
 */
public class databasemetadata {
    public static void main(String[] args) 
    { 
        Class.forName("com.mysql.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost/stud"; 
        Connection con =DriverManager.getConnection(url,"root",""); 
        
        
    }
}
