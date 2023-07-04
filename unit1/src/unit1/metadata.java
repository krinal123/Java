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
public class metadata {
    public static void main(String[] args) 
    { 
        try { 
            Class.forName("com.mysql.jdbc.Driver"); 
            String url = "jdbc:mysql://localhost:3306/stud"; 
            Connection con = DriverManager.getConnection(url,"root",""); 
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from info"); 
            ResultSetMetaData rsmd = rs.getMetaData(); 
            for(int i=1;i<=rsmd.getColumnCount();i++) 
            { 
                 System.out.print(rsmd.getColumnName(i)+"\t");
            } 
            System.out.println(" "); 
            while(rs.next()) 
            { 
                for (int i = 1; i<=rsmd.getColumnCount(); i++) {
                    System.out.print(rs.getString(i)+"\t");
                } 
                System.out.println("");
            }
        }catch(Exception e) 
        { 
            System.out.println(e);
        }
    }
}
