/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import menu.MenuCompleto;
import menu.Portata;
import menu.TipoPortata;
import net.proteanit.sql.DbUtils;
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
   private MenuCompleto menuCompleto = new MenuCompleto();
   

    
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
        String query = "CREATE SCHEMA IF NOT EXISTS `"+agri.getNome()+"`";
        stm.execute(query);
    }
    public void DropSchema() throws SQLException{
        String query = "DROP SCHEMA IF EXISTS `"+agri.getNome()+"`";
        stm.execute(query);
    }
    
    public void closeConnection() throws SQLException{
            stm.close(); // rilascio le risorse
            pstmt.close(); // rilascio le risorse
            conn.close(); // termino la connessione
    }
    
    public void createTableSale() throws SQLException{
            String query = "CREATE TABLE IF NOT EXISTS `"+agri.getNome()+"`.`sale` (\n" +
                        "  `idsale` INT NOT NULL AUTO_INCREMENT,\n" +
                        "  `nome` VARCHAR(45) NOT NULL,\n" +
                        "  PRIMARY KEY (`idsale`),\n" +
                        "  UNIQUE INDEX `nomi_UNIQUE` (`nome` ASC));";
        stm.executeUpdate(query);
    }   
    
    
    public void addSaleFromFileToDb() throws SQLException{
        for(Sala s: agri.getSale()){
        String query = "INSERT INTO `"+agri.getNome()+"`.`sale` (`nome`) VALUES ('"+s.getNome()+"')";
            stm.executeUpdate(query);
        }
    }
    
    public void addSingleSala(String nomeSala) throws SQLException{
        String query = "INSERT INTO `"+agri.getNome()+"`.`sale` (`nome`) VALUES ('"+nomeSala+"');";
        stm.execute(query);
    }
    
    public void removeSchema() throws SQLException{
        String query = "DROP SCHEMA IF EXISTS  `"+agri.getNome()+"`";
        stm.execute(query);
    }
    
    public void DropTableSale() throws SQLException{
        String query = "DROP TABLE IF EXISTS `"+agri.getNome()+"`.`sale`";
        stm.executeUpdate(query);
    
    }
    
    public void createTableMenu() throws SQLException{
       
        String query = "CREATE TABLE IF NOT EXISTS `"+agri.getNome()+"`.`menu` (\n" +
                    "  `idmenu` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  ` nome portata` VARCHAR(100) NOT NULL,\n" +
                    "  `tipo portata` VARCHAR(100) NOT NULL,\n" +
                    "  PRIMARY KEY (`idmenu`, ` nome portata`),\n" +
                    "  UNIQUE INDEX ` nome portata_UNIQUE` (` nome portata` ASC));";
        stm.executeUpdate(query);
    }
    
    public void addPortataFromFiletoDb() throws SQLException{
          for(Portata p: MenuCompleto.menuCompleto){
            String query = "INSERT INTO `"+agri.getNome()+"`.`menu` (` nome portata`, `tipo portata`) VALUES ('"+p.getNome()+"', '"+p.getTipoPortata()+"');";
            stm.executeUpdate(query);
        }
    }

    public void addSinglePortata(String nomePortata, TipoPortata tipoPortata) throws SQLException{
        String query = "INSERT INTO `"+agri.getNome()+"`.`menu` (` nome portata`, `tipo portata`) VALUES ('"+nomePortata+"', '"+tipoPortata+"');";;
        stm.execute(query);
    }
    
    
    public void createTablePrenotazione() throws SQLException{
            String query = "CREATE TABLE IF NOT EXISTS `"+agri.getNome()+"`.`prenotazioni` (\n" +
                        "  `IdPrenotazione` INT NOT NULL AUTO_INCREMENT,\n" +
                        "  `Cliente` VARCHAR(45) NOT NULL,\n" +
                        "  `Pasto` VARCHAR(45) NOT NULL,\n" + 
                        "  `Ora` VARCHAR(45) NOT NULL,\n" +
                        "  `Data` DATE NOT NULL,\n" +
                        "  `NPersone` INT NOT NULL,\n" +
                        "  `NTelefono` VARCHAR(45) NOT NULL,\n" +
                        "  `Sala` VARCHAR(45) NULL,\n" +
                        "  `PreferenzaSala` VARCHAR(45) NULL,\n" +
                        "  `TipoEvento` VARCHAR(45) NULL,\n" +
                        "  `Primo1` VARCHAR(45) NULL,\n" +
                        "  `Primo2` VARCHAR(45) NULL,\n" +
                        "  `Primo3` VARCHAR(45) NULL,\n" +
                        "  `Secondo1` VARCHAR(45) NULL,\n" +
                        "  `Secondo2` VARCHAR(45) NULL,\n" +
                        "  `Secondo3` VARCHAR(45) NULL,\n" +
                        "  `Dolce` VARCHAR(45) NULL,\n" +
                        "  `Note` VARCHAR(1000) NULL,\n"                    
                    + "PRIMARY KEY (`idPrenotazione`, `Cliente`,`Ora`,`Data` ),\n";
        stm.executeUpdate(query);
    } 
    
    public void addPrenotazione(String cliente, String tipoPortata, 
            String ora, Date data, int nPersone, String nTel, String sala, 
            String prefSala, String tipoEvento,String primo1,
            String primo2,String primo3,String secondo1,
            String secondo2,String secondo3, String dolce, String note)
            throws SQLException{
            String query = "INSERT INTO `"+agri.getNome()+"`.`prenotazioni` "
                + "(`Cliente`, `Pasto`, `Ora`, `Data`, `NPersone`,"
                + " `NTelefono`, `Sala`, `PreferenzaSala`, `Stato`, `TipoEvento`,"
                + "`Primo1`,`Primo2`,`Primo3`,`Secondo1`,`Secondo2`,`Secondo3`,"
                + " `Dolce`,`Note`) "
                + "VALUES ('"+cliente+"', '"+tipoPortata+"',"
                + " '"+ora+"', '"+data+"', '"+nPersone+"',"
                + " '"+nTel+"', '"+sala+"', '"+prefSala+"',"
                + " '"+tipoEvento+"', '"+primo1+"', '"+primo2+"', "
                + "'"+primo3+"', '"+secondo1+"', '"+secondo2+"', '"+secondo3+"',"
                + " '"+dolce+"', '"+note+"');";
        stm.execute(query);
    }
    
     public void riempiTabella(JTable table, String query) throws SQLException{
         pstmt = conn.prepareStatement(query);
         rs = pstmt.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
     }
    
    
}
