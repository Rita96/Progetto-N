/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databse;

import cliente.Cliente;
import funzionalita.Prenotazione;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import menu.MenuCliente;
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
    public Statement getStm() {
        return stm;
    }   
    public boolean FirstAccess() throws SQLException{
        boolean controllo = false;
        String query = "SELECT * FROM `ristorante`.`dati`";
        rs = stm.executeQuery(query);
        ResultSetMetaData rsmd = rs.getMetaData();
        if(rsmd.getCatalogName(1).equals("ristorante")){
            controllo = true;
        }
        return controllo;
    }
    public void CreateSchema() throws SQLException{
        String query = "CREATE SCHEMA IF NOT EXISTS `ristorante`";
        stm.execute(query);
    }
    public void DropSchema() throws SQLException{
        String query = "DROP SCHEMA IF EXISTS `ristorante`";
        stm.execute(query);
    }
    public void closeConnection() throws SQLException{
            stm.close(); // rilascio le risorse
            pstmt.close(); // rilascio le risorse
            conn.close(); // termino la connessione
    }
    public void createTableSale() throws SQLException{
        String query = "CREATE TABLE IF NOT EXISTS `ristorante`.`sale` (\n" +
                "  `idsale` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `nome` VARCHAR(100) NOT NULL,\n" +
                "  PRIMARY KEY (`idsale`),\n" +
                "  UNIQUE INDEX `nomi_UNIQUE` (`nome` ASC));";
        stm.executeUpdate(query);
    }   
    public void createTableDatiRistorante() throws SQLException{
        String query = "CREATE TABLE IF NOT EXISTS `ristorante`.`dati` (\n" +
                "  `iddati` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `nome` VARCHAR(100) NOT NULL,\n" +
                "  PRIMARY KEY (`iddati`, `nome`),\n" +
                "  UNIQUE INDEX `nomi_UNIQUE` (`nome` ASC));";
        stm.executeUpdate(query);
    }
    public void insertDatiRistorante() throws SQLException{
        String query = "INSERT INTO `ristorante`.`dati` (`nome`) VALUES ('"+agri.getNome()+"')";;
        stm.executeUpdate(query);
    } 
    public void addSaleFromFileToDb() throws SQLException{
        for(Sala s: agri.getSale()){
        String query = "INSERT INTO `ristorante`.`sale` (`nome`) VALUES ('"+s.getNome()+"')";
            stm.executeUpdate(query);
        }
    }
    public void addSingleSala(String nomeSala) throws SQLException{
        String query = "INSERT INTO `ristorante`.`sale` (`nome`) VALUES ('"+nomeSala+"');";
        stm.execute(query);
    }   
    public void removeSchema() throws SQLException{
        String query = "DROP SCHEMA IF EXISTS  `ristorante`";
        stm.execute(query);
    }
    public void DropTableSale() throws SQLException{
        String query = "DROP TABLE IF EXISTS `ristorante`.`sale`";
        stm.executeUpdate(query);
    
    } 
    public void createTableMenu() throws SQLException{
       
        String query = "CREATE TABLE IF NOT EXISTS `ristorante`.`menu` (\n" +
                    "  `idmenu` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  ` nome portata` VARCHAR(100) NOT NULL,\n" +
                    "  `tipo portata` VARCHAR(100) NOT NULL,\n" +
                    "  `ingrediente1` VARCHAR(100) NULL,\n" +
                    "  `qnt1` INT NULL,\n"  +
                    "  `ingrediente2` VARCHAR(100) NULL,\n" +
                    "  `qnt2` INT NULL,\n"  +
                    "  `ingrediente3` VARCHAR(100) NULL,\n" +
                    "  `qnt3` INT NULL,\n"  +
                    "  `ingrediente4` VARCHAR(100) NULL,\n" +
                    "  `qnt4` INT NULL,\n"  +
                    "  `ingrediente5` VARCHAR(100) NULL,\n" +
                    "  `qnt5` INT NULL,\n"  +
                    "  `ingrediente6` VARCHAR(100) NULL,\n" +
                    "  `qnt6` INT NULL,\n"  +
                    "  `ingrediente7` VARCHAR(100) NULL,\n" +
                    "  `qnt7` INT NULL,\n"  +
                    "  `ingrediente8` VARCHAR(100) NULL,\n" +
                    "  `qnt8` INT NULL,\n"  +
                    "  `ingrediente9` VARCHAR(100) NULL,\n" +
                    "  `qnt9` INT NULL,\n"  +
                    "  `ingrediente10` VARCHAR(100) NULL,\n" +
                    "  `qnt10` INT NULL,\n" +
                    "  `ingrediente11` VARCHAR(100) NULL,\n" +
                    "  `qnt11` INT NULL,\n" +
                    "  `ingrediente12` VARCHAR(100) NULL,\n" +
                    "  `qnt12` INT NULL,\n" +
                    "  PRIMARY KEY (`idmenu`, ` nome portata`),\n" +
                    "  UNIQUE INDEX ` nome portata_UNIQUE` (` nome portata` ASC));";
        stm.executeUpdate(query);
    }
    public void addPortataFromFiletoDb() throws SQLException{
          for(Portata p: MenuCompleto.menuCompleto){
            String query = "INSERT INTO `ristorante`.`menu` (` nome portata`, `tipo portata`) VALUES ('"+p.getNome()+"', '"+p.getTipoPortata()+"');";
            stm.executeUpdate(query);
        }
    }
    public void addSinglePortata(String nomePortata, TipoPortata tipoPortata) throws SQLException{
        String query = "INSERT INTO `ristorante`.`menu` (` nome portata`, `tipo portata`) VALUES ('"+nomePortata+"', '"+tipoPortata+"');";;
        stm.execute(query);
    }  
    public void modificaIngrediente(String nomePortata, TipoPortata tipoPortata, String newIngrediente, String oldIngrediente) throws SQLException{
        
        for(int i=1;i<11;i++){
            String query = "SELECT `ingrediente"+i+"`,`idmenu` from `"+agri.getNome()+"`.`menu` WHERE `nomeportata`= "+nomePortata+" AND `ingrediente"+i+"`= "+oldIngrediente+";";
            ResultSet rs = stm.executeQuery(query);
            if(rs.next()){
                String id = rs.getString(2);            
                System.out.println(id);
                query = "UPDATE `"+agri.getNome()+"`.`menu` SET `ingrediente"+i+"` = "+newIngrediente+" WHERE `idmenu` = "+id+" AND `ingrediente"+i+"`='"+oldIngrediente+"';";
                stm.execute(query);
            }else{
                continue;  
            }  
        }
    }  
    public void addIngredienti() throws SQLException{
        
//        for(int i=1;i<13;i++){
//            String query = "SELECT `ingrediente"+i+"`, `idmenu` from `"+agri.getNome()+"`.`menu` WHERE`nomeportata`= "+nomePortata+" "
//                    + "AND `tipo portata`="+tipoPortata+";";
//            ResultSet rs = stm.executeQuery(query);
//            if(rs.next()){
//                String ingr = rs.getString(1);            
//                System.out.println(ingr);
//            }else{
//                int id = rs.getInt(2);
//                query = "UPDATE `"+agri.getNome()+"`.`menu` SET `ingrediente"+i+"` = '"+ingrediente+"',`qnt"+i+"` = "+qnt+" WHERE `idmenu` = "+id+";";
//                stm.execute(query);
//            }
//        }
         for(Portata p: MenuCompleto.menuCompleto){
        
            for(int i=1;i<=p.getIngredienti().size();i++){
                String query = "UPDATE `ristorante`.`menu` SET `ingrediente"+i+"`='"+p.getIngredienti().get(i-1).getName()+"', `qnt"+i+"`='"+p.getIngredienti().get(i-1).getQuantity()+"' WHERE ` nome portata`='"+p.getNome()+"';";
//                String qery = "INSERT INTO `ristorante`.`menu` (`ingrediente"+i+"`, `qnt"+i+"`) "
//                        + "VALUES ('"+p.getIngredienti().get(i-1).getName()+"', "
//                        + "'"+p.getIngredienti().get(i-1).getQuantity()+"');";  
                
                stm.executeUpdate(query);
            }
            
        }


    }    
    public void riempiTabella(JTable table, String query) throws SQLException{
         pstmt = conn.prepareStatement(query);
         rs = pstmt.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
     }  
    public int verificaTabella(String tabella) throws SQLException{
        String query = "SELECT COUNT(*) AS 'Numero' FROM `ristorante`.`"+tabella+"`;";
        rs=stm.executeQuery(query);
        rs.last();
        int i = rs.getInt("Numero");
       return i;
    }  
    public void createTablePrenotazioni() throws SQLException{
        String query = "CREATE TABLE IF NOT EXISTS `ristorante`.`prenotazioni` (\n" +
                        "  `idprenotazioni` INT NOT NULL AUTO_INCREMENT,\n" +
                        "  `data` DATE NOT NULL,\n" +
                        "  `pasto` VARCHAR(50) NOT NULL,\n" +
                        "  `nome` VARCHAR(100) NOT NULL,\n" +
                        "  `numero di adulti` INT NOT NULL,\n" +
                        "  `numero di telefono` BIGINT NOT NULL,\n" +
                        "  `numero di bambini` INT NULL,\n" +
                        "  `sala` VARCHAR(100) NULL,\n" +
                        "  `esigenza sala` INT NULL,\n" +
                        "  `lista attesa` INT NULL,\n" +
                        "  `preferenza sala` INT NULL,\n" +
                        "  `esclusiva sala` INT NULL,\n" +
                        "  `da confermare` INT NULL,\n" +
                        "  `tipo di evento` VARCHAR(100) NULL,\n" +
                        "  `primo1` VARCHAR(200) NULL,\n" +
                        "  `primo2` VARCHAR(200) NULL,\n" +
                        "  `primo3` VARCHAR(200) NULL,\n" +
                        "  `secondo1` VARCHAR(200) NULL,\n" +
                        "  `secondo2` VARCHAR(200) NULL,\n" +
                        "  `secondo3` VARCHAR(200) NULL,\n" +
                        "  `dolce` VARCHAR(200) NULL,\n" +
                        "  `note` VARCHAR(2000) NULL,\n" +
                        "  PRIMARY KEY (`idprenotazioni`, `data`, `nome`, `numero di adulti`, `numero di telefono`, `pasto`),\n" +
                        "  UNIQUE INDEX `idprenotazioni_UNIQUE` (`idprenotazioni` ASC));";
        
        stm.executeUpdate(query);
    }    
    public void addSinglePrenotazione(Prenotazione p) throws SQLException{
        String query = "INSERT INTO `ristorante`.`prenotazioni` (`pasto`, "
                + "`nome`, `numero di adulti`, `sala`, `numero di bambini`"
                + ", `primo1`, `primo2`, `primo3`"
                + ", `secondo1`, `secondo2`, `secondo3`, `dolce`, `note`"
                + ", `lista attesa`, `esigenza sala`, `preferenza sala`"
                + ", `esclusiva sala`, `da confermare`, `tipo di evento`, `data`, `numero di telefono`) VALUES "
                + "('"+p.getPasto()+"', "
                + "'"+p.getCliente().getNome()+"', "
                + "'"+p.getnAdulti()+"', "
                + "'"+p.getSala().getNome()+"', "
                + "'"+p.getnBambini()+"', "
                + "'"+p.getMenu().getMenuCliente().get(0).getNome()+"', "
                + "'"+p.getMenu().getMenuCliente().get(1).getNome()+"', "
                + "'"+p.getMenu().getMenuCliente().get(2).getNome()+"', "
                + "'"+p.getMenu().getMenuCliente().get(3).getNome()+"', "
                + "'"+p.getMenu().getMenuCliente().get(4).getNome()+"', "
                + "'"+p.getMenu().getMenuCliente().get(5).getNome()+"', "
                + "'"+p.getMenu().getMenuCliente().get(6).getNome()+"' ,"
                + "'"+p.getNote()+"' ,"
                + "'"+p.getAttesa()+"' ,"
                + "'"+p.getEsigenza()+"' ,"
                + "'"+p.getPreferenza()+"' ,"
                + "'"+p.getEsclusiva()+"' ,"
                + "'"+p.getDaConfermare()+"' ,"
                + "'"+p.getTipoEvento()+"' ,"
                + "'"+p.getDateDb()+"' ,"
                + "'"+p.getCliente().getNumTelefono()+"');";
        stm.execute(query);
    
    }   
    public void toJavaFromDbSale() throws SQLException{
        String query = "SELECT * FROM `ristorante`.`sale` ORDER BY `sale`.`idsale`";
        rs = stm.executeQuery(query);
        while(rs.next()){
           String nomeSala =rs.getString("nome");
           agri.addSala(new Sala(nomeSala));
        }
        
    }
    public void toJavaFromDbPortate() throws SQLException{
        String query = "SELECT * FROM `ristorante`.`menu`";
        rs = stm.executeQuery(query);
        while(rs.next()){
           String nomePortata = rs.getString(" nome portata");
           String tipoPortata = rs.getString("tipo portata");
           Portata portata = new Portata(nomePortata, TipoPortata.valueOf(tipoPortata));
           MenuCompleto.menuCompleto.add(portata);
        }
    }    
    public void toJavaFromDbNome() throws SQLException{
        String query = "SELECT * FROM `ristorante`.`dati`";
        rs = stm.executeQuery(query);
        while(rs.next()){
           String nomeRistorante = rs.getString("nome");
           agri.setNome(nomeRistorante);
        }
    }    
    public void toJavaFromDbPrenotazioni() throws SQLException{
        int i = 0;
        String query = "SELECT * FROM `ristorante`.`prenotazioni` ORDER BY `idprenotazioni`";
        rs = stm.executeQuery(query);
        while(rs.next()){
            MenuCliente menuCliente = new MenuCliente();
            int id = rs.getInt("idprenotazioni");
            Date date = rs.getDate("data");
            String nome = rs.getString("nome");
            String pasto = rs.getString("pasto");
            int numeroAdulti = rs.getInt("numero di adulti");
            long numeroTelefono = rs.getLong("numero di telefono");
            int numeroBambini = rs.getInt("numero di bambini");
            String nomeSala = rs.getString("sala");
            Sala sala = new Sala(nomeSala);
            int esigenzaSala = rs.getInt("esigenza sala");
            int preferenzaSala = rs.getInt("preferenza sala");
            int listaAttesa = rs.getInt("lista attesa");
            int esclusivaSala = rs.getInt("esclusiva sala");
            int daConfermare = rs.getInt("da confermare");
            String tipoEvento = rs.getString("tipo di evento");
            String primo1 = rs.getString("primo1");
            String primo2 = rs.getString("primo2");
            String primo3 = rs.getString("primo3");
            String secondo1 = rs.getString("secondo1");
            String secondo2 = rs.getString("secondo2");
            String secondo3 = rs.getString("secondo3");
            String dolce = rs.getString("dolce");
            String note = rs.getString("note");
            Cliente cliente = new Cliente(nome, numeroTelefono);
            Prenotazione prenotazione = new Prenotazione(numeroAdulti, date, pasto, cliente);

            prenotazione.setnBambini(numeroBambini);
            prenotazione.setSala(sala);
            prenotazione.setPreferenza(preferenzaSala);
            prenotazione.setAttesa(listaAttesa);
            prenotazione.setDaConfermare(daConfermare);
            prenotazione.setEsclusiva(esclusivaSala);
            prenotazione.setEsigenza(esigenzaSala);
            prenotazione.setId(id);
            prenotazione.setTipoEvento(tipoEvento);
            prenotazione.setNote(note);
 
            Portata primoUno= new Portata(primo1, TipoPortata.Primo);
            menuCliente.getMenuCliente().add(primoUno);
            Portata primoDue= new Portata(primo2, TipoPortata.Primo);
            menuCliente.getMenuCliente().add(primoUno);
            Portata primoTre= new Portata(primo3, TipoPortata.Primo);
            menuCliente.getMenuCliente().add(primoUno);
            Portata secondoUno= new Portata(secondo1, TipoPortata.Secondo);
            menuCliente.getMenuCliente().add(primoUno);
            Portata secondoDue= new Portata(secondo2, TipoPortata.Secondo);
            menuCliente.getMenuCliente().add(primoUno);
            Portata SecondoTre= new Portata(secondo3, TipoPortata.Secondo);
            menuCliente.getMenuCliente().add(primoUno);
            Portata dolcE= new Portata(dolce, TipoPortata.Dolce);
            menuCliente.getMenuCliente().add(primoUno);
            
            prenotazione.setMenu(menuCliente);
            agri.aggiungiPrenotazione(prenotazione);
            
            }    
        }
    public int getNumeroSale() throws SQLException{
            String query = "SELECT COUNT(*) AS 'Numero' FROM `ristorante`.`sale`;";
            rs=stm.executeQuery(query);
            rs.last();
            int numeroSale = rs.getInt("Numero");
            return numeroSale;
        }  
    public void modificaPrenotazione(Prenotazione p) throws SQLException{
            String query = "UPDATE `ristorante`.`prenotazioni` SET "
                    + "`note`='"+p.getNote()+"', `nome`='"+p.getCliente().getNome()+"' ,"
                    + "`numero di telefono`='"+p.getCliente().getNumTelefono()+"', "
                    + "`pasto`='"+p.getPasto()+"' ,`data`='"+p.getDateDb()+"' ,"
                    + "`numero di adulti`='"+p.getnAdulti()+"' ,`numero di bambini`='"+p.getnBambini()+"' ,"
                    + " `sala`='"+p.getSala().getNome()+"' ,"
                    + "`tipo di evento`='"+p.getTipoEvento()+"' ,"
                    + "`esigenza sala`='"+p.getEsigenza()+"' ,"
                    + "`lista attesa`='"+p.getAttesa()+"' ,"
                    + "`preferenza sala`='"+p.getPreferenza()+"' ,"
                    + "`esclusiva sala`='"+p.getEsclusiva()+"' ,"
                    + "`primo1`='"+p.getMenu().getMenuCliente().get(0).getNome()+"' ,"
                    + "`primo2`='"+p.getMenu().getMenuCliente().get(1).getNome()+"' ,"
                    + "`primo3`='"+p.getMenu().getMenuCliente().get(2).getNome()+"' ,"
                    + "`secondo1`='"+p.getMenu().getMenuCliente().get(3).getNome()+"' ,"
                    + "`secondo2`='"+p.getMenu().getMenuCliente().get(4).getNome()+"' ,"
                    + "`secondo3`='"+p.getMenu().getMenuCliente().get(5).getNome()+"' ,"
                    + "`dolce`='"+p.getMenu().getMenuCliente().get(6).getNome()+"' ,"
                    + "`da confermare`='"+p.getDaConfermare()+"'"
                    + " WHERE `idprenotazioni`='"+p.getId()+"'";
           
                stm.executeUpdate(query);
    }
    public void deletePrenotazione(int id, String nomePrenotazione) throws SQLException{
            String query = "DELETE FROM `ristorante`.`prenotazioni` WHERE `idprenotazioni`='"+id+"' "
                    + "and`nome`='"+nomePrenotazione+"'";
            stm.execute(query);
        }
    public int selectMaxId() throws SQLException{
        int max;
        String query = "SELECT MAX(idprenotazioni) AS 'max' FROM ristorante.prenotazioni";
        rs = stm.executeQuery(query);
        rs.next();
        max = rs.getInt("max");
        return max;
    }
    public void deletePortataFromMenu(String nome) throws SQLException{
         String query = "DELETE FROM `ristorante`.`menu` WHERE ` nome portata`='"+nome+"'";
            stm.execute(query);
    }
    public void deleteSalaFromMenu(String nome) throws SQLException{
         String query = "DELETE FROM `ristorante`.`sale` WHERE `nome`='"+nome+"'";
            stm.execute(query);
    }
 }
        
        
    
  
    
    
    
    
    

