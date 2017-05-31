/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databse;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author luby9
 */
public class ConnectDbMySql {
    

    public static Connection ConnectDB(){
        try{
            String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
            String login="root";
            String password= "HarryPotter";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, login, password);
            return conn;
            
            }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Impossibile Connetersi al database!");
             return null;
            }
        }
    
    
}
