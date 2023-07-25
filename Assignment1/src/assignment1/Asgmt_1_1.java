/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;
import java.sql.*;
import java.util.*;
/**
 *
 * @author au
 */
public class Asgmt_1_1 { 
    public static void main(String[] args)
    {  
      Scanner sc = new Scanner(System.in); 
      try 
      { 
          Class.forName("com.mysql.jdbc.Driver");
          String url = "jdbc:mysql://localhost:3306/stud"; 
          Connection con = DriverManager.getConnection(url,"root","");
          Statement st = con.createStatement(); 
          boolean exit = false; 
          while(!exit){ 
              System.out.println("Option are :\n1.Update\n2.Delete\n3.Fetch\n4.Exit"); 
              System.out.println("Enter your Choise : "); 
              int option = sc.nextInt(); 
              switch(option) 
              { 
                  case 1 : 
                      System.out.println("Enter your ID : "); 
                      int id = sc.nextInt(); 
                      System.out.println("Enter your Name : ");
                      String nm = sc.next(); 
                      st.executeUpdate("update info set name = '" + nm + "' where id = " + id); 
                      System.out.println("Record Update Sucessfully"); 
                      break; 
                  case 2 : 
                      System.out.println("Enter your ID : "); 
                      int delId = sc.nextInt();  
                      st.executeUpdate("delete from info where id = " + delId);
                      System.out.println("Record Delete Sucessfully"); 
                      break; 
                  case 3 : 
                      ResultSet rs = st.executeQuery("Select * from info"); 
                      System.out.println("ID\tName"); 
                      while(rs.next())
                      { 
                          int idfetch = rs.getInt("id"); 
                          String nmfetch = rs.getString("name"); 
                          System.out.println(idfetch + "\t" + nmfetch);
                      } 
                      rs.close();  
                      break;
                  case 4 : 
                      exit = true; 
                      break; 
                  default : 
                      System.out.println("Invalid Option");
              }
          } 
           con.close();
      }catch(Exception e){ 
          System.out.println(e);
      }
    }
     
}
