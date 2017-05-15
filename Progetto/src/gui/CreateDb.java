/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import struttura.Agriturismo;
import struttura.Sala;

/**
 *
 * @author luby9
 */
public class CreateDb {
    
   private Connection conn = null;
   private Statement stm = null;
   private ResultSet rs = null;
   private PreparedStatement pstmt = null;
   private Agriturismo agri = new Agriturismo();
   

    
    public CreateDb() throws SQLException{
        conn = ConnectDbMySql.ConnectDB();
        stm = conn.createStatement();
    }
    
    public void FirstAccess() throws SQLException{
        String query = "SHOW SCHEMAS IF NOT EXISTS";
        rs = stm.executeQuery(query);
        String agriturismo = "agriturismo";
        if(rs.getString("SELECT *").equals(agriturismo)){
             System.out.println("bravo");
        }
    }

    public void CreateSchema() throws SQLException{
        String query = "CREATE SCHEMA IF NOT EXISTS `agriturismo`";
        stm.execute(query);
    }
    public void closeConnection() throws SQLException{
            stm.close(); // rilascio le risorse
            pstmt.close(); // rilascio le risorse
            conn.close(); // termino la connessione
    }
    
    public void createTableSale() throws SQLException{
        String query = "CREATE TABLE IF NOT EXISTS `agriturismo`.`sale` (\n" +
                        "  `idsale` INT NOT NULL AUTO_INCREMENT,\n" +
                        "  `nomi` VARCHAR(45) NOT NULL,\n" +
                        "  PRIMARY KEY (`idsale`, `nomi`))";
        stm.executeUpdate(query);
    }   
    
    
    public void addSaleFromFileToDb() throws SQLException{
        for(Sala s: agri.getSale()){
            String query = "INSERT INTO `agriturismo`.`sale` (`nomi`) VALUES ('"+s.getNome()+"')";
            stm.executeUpdate(query);
        }
    }
    
    public void addSingleSala(String nomeSala) throws SQLException{
        String query = "INSERT INTO `agriturismo`.`sale` (`nomi`) VALUES ('"+nomeSala+"');";
        stm.execute(query);
    }

    
    
}
