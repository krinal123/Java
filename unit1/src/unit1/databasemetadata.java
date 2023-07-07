
package unit1;
import java.sql.*;

public class databasemetadata {
     public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql:///bca", "root", "");
            Statement st = con.createStatement();
            DatabaseMetaData dmd = con.getMetaData();
            ResultSet tablesResultSet = dmd.getTables(null, null, null, null);
            
            while (tablesResultSet.next()) {
                System.out.println(tablesResultSet.getString("TABLE_NAME"));
                
                String tableName = tablesResultSet.getString("TABLE_NAME");
                ResultSet rs = st.executeQuery("SELECT * FROM " + tableName);
                ResultSetMetaData rsmd = rs.getMetaData();
                
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    System.out.print(rsmd.getColumnName(i) + " ");
                }
                System.out.println("");
                
                while (rs.next()) {
                    for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                        System.out.print(rs.getString(i) + " ");
                    }
                    System.out.println("");
                }
            }
            
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
