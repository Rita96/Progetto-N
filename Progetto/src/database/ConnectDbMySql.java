/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import menu.MenuCompleto;
import menu.Portata;

/**
 *
 * @author luby9
 */
public class ConnectDbMySql {
   public static Connection connection = null;


    public static Connection ConnectDB(){
        if(connection==null){
        try{
            String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
            String login="root";
            String password= "HarryPotter";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, login, password);
            connection=conn;
            return connection;
            
            }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Impossibile Connetersi al database!");
             return null;
            }
        }
        else return connection;
        }
    
   
}
