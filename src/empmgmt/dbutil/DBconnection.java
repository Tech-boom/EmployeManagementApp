
package empmgmt.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DBconnection {
  
   private static Connection conn = null; 
  static {
       try {
         Class.forName("oracle.jdbc.OracleDriver");
         conn = DriverManager.getConnection("jdbc:oracle:thin:@//hi:1521/Xe","tables","shubham");
         JOptionPane.showMessageDialog(null,"Connection Established","Success", JOptionPane.INFORMATION_MESSAGE);  
       }  
       catch (ClassNotFoundException ex) {
         JOptionPane.showMessageDialog(null,"Problem in Class Loading","Error", JOptionPane.INFORMATION_MESSAGE);
       } 
       catch (SQLException ex) {
         JOptionPane.showMessageDialog(null,"Problem in conn"+ex,"Error", JOptionPane.INFORMATION_MESSAGE);  
       }
    }
 public static Connection getConnection(){
     return conn;
 }
 public static void closeConnection(){
     try{
        if(conn!=null){
            conn.close();
            JOptionPane.showMessageDialog(null,"Connection Closed","Success", JOptionPane.INFORMATION_MESSAGE);
        } 
     } 
     catch (SQLException ex) {
         JOptionPane.showMessageDialog(null,"Problem in Closing Connection","Error", JOptionPane.ERROR_MESSAGE);
       }
     
    }
}
