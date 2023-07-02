package unit1;

import java.sql.*;
import java.util.Scanner;

public class crud {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/stud";
            Connection con = DriverManager.getConnection(url, "root", "");
            Statement st = con.createStatement();

            boolean exit = false;
            while (!exit) {
                System.out.println("Option are:\n1. Insert\n2. Update\n3. Delete\n4. Fetch\n5. Exit");
                System.out.println("Enter your Choice: "); 
                int option = sc.nextInt(); 

                switch (option) {
                    case 1:
                        System.out.println("Enter Your ID:");
                        int id = sc.nextInt();
                        System.out.println("Enter Your Name:");
                        String nm = sc.next();
                        st.executeUpdate("INSERT INTO info VALUES(" + id + ",'" + nm + "')");
                        System.out.println("Data inserted successfully!");
                        break;
                    case 2:
                        System.out.println("Enter the ID to update:");
                        int updateId = sc.nextInt();
                        System.out.println("Enter the new name:");
                        String newName = sc.next();
                        st.executeUpdate("UPDATE info SET name = '" + newName + "' WHERE id = " + updateId);
                        System.out.println("Data updated successfully!");
                        break;
                    case 3:
                        System.out.println("Enter the ID to delete:");
                        int deleteId = sc.nextInt();
                        st.executeUpdate("DELETE FROM info WHERE id = " + deleteId);
                        System.out.println("Data deleted successfully!");
                        break;
                    case 4:
                        ResultSet rs = st.executeQuery("SELECT * FROM info");
                        System.out.println("ID\tName");
                        while (rs.next()) {
                            int fetchedId = rs.getInt("id");
                            String fetchedName = rs.getString("name");
                            System.out.println(fetchedId + "\t" + fetchedName);
                        }
                        rs.close();
                        break;
                    case 5:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid option!");
                }
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
