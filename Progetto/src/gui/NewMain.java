/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author luby9
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        createTable();
        
        
    }
    
    public static void createTable() throws SQLException    {
        try{
            Connection conn = getConnection();
            PreparedStatement create = conn.prepareStatement("CREATE SCHEMA `agriturismo`");
            create.executeUpdate();
//            create = conn.prepareStatement("INSERT INTO prenotaaaa (id, cani,gatti) values (?,?,?)");
//            create.setString(1, "3");
//            create.setString(2, "MARIO");
//            create.setString(3, "ROSSI");
//            create.execute();
            
           
            

        }
         catch(Exception e){
              JOptionPane.showMessageDialog(null, e);
        }
    
    }
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        Connection conn = null;
        try{
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost";
            String login="root";
            String password= "HarryPotter";
            Class.forName(driver);
            conn = DriverManager.getConnection(url, login, password);
            JOptionPane.showMessageDialog(null, "Connesso");

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return conn;
    }
    
}
