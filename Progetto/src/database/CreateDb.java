/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import cliente.Cliente;
import funzionalita.Prenotazione;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JTable;
import menu.Ingredient;
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
   
    /**
     * Metodo per la connessione con il db
     * @throws SQLException
     */
    public CreateDb() throws SQLException{
        conn = ConnectDbMySql.ConnectDB();
        stm = conn.createStatement();
    }
    
    public Statement getStm() {
        return stm;
    } 
    
    /**
     * Controllo del primo accesso
     * @return controllo: a true non è il primo accesso, a false bisogna creare il db
     * @throws SQLException
     */
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
    
    /**
     * Inizializza lo schema al primo accesso
     * @throws SQLException
     */
    public void CreateSchema() throws SQLException{
        String query = "CREATE SCHEMA IF NOT EXISTS `ristorante`";
        stm.execute(query);
    }

    /**
     * Cancella lo schema dal db 
     * @throws SQLException
     */
    public void DropSchema() throws SQLException{
        String query = "DROP SCHEMA IF EXISTS `ristorante`";
        stm.execute(query);
    }

    /**
     * Chiude la connessione
     * @throws SQLException
     */
    public void closeConnection() throws SQLException{
            stm.close(); // rilascio le risorse
            pstmt.close(); // rilascio le risorse
            conn.close(); // termino la connessione
    }

    /**
     * Crea la tabella delle sale del ristorante nel db
     * @throws SQLException
     */
    public void createTableSale() throws SQLException{
        String query = "CREATE TABLE IF NOT EXISTS `ristorante`.`sale` (\n" +
                "  `idsale` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `nome` VARCHAR(100) NOT NULL,\n" +
                "  PRIMARY KEY (`idsale`),\n" +
                "  UNIQUE INDEX `nomi_UNIQUE` (`nome` ASC));";
        stm.executeUpdate(query);
    }   

    /**
     * Crea la tabella con i dati del ristorante nel db
     * @throws SQLException
     */
    public void createTableDatiRistorante() throws SQLException{
        String query = "CREATE TABLE IF NOT EXISTS `ristorante`.`dati` (\n" +
                "  `iddati` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `nome` VARCHAR(100) NOT NULL,\n" +
                "  PRIMARY KEY (`iddati`, `nome`),\n" +
                "  UNIQUE INDEX `nomi_UNIQUE` (`nome` ASC));";
        stm.executeUpdate(query);
    }

    /**
     * Inizializza la tabella dei dati del ristorante al primo accesso
     * @throws SQLException
     */
    public void insertDatiRistorante() throws SQLException{
        String query = "INSERT INTO `ristorante`.`dati` (`nome`) VALUES ('"+agri.getNome().replace("'", "''")+"')";;
        stm.executeUpdate(query);
    } 
    
    /**
     * Metodo che inserisce le sale nel db tramita lettura da file
     * @throws SQLException
     */
    public void addSaleFromFileToDb() throws SQLException{
        for(Sala s: agri.getSale()){
        String query = "INSERT INTO `ristorante`.`sale` (`nome`) VALUES ('"+s.getNome().replace("'", "''")+"')";
            stm.executeUpdate(query);
        }
    }

    /**
     * Popola la tabella delle sale da interfaccia grafica
     * @param nomeSala
     * @throws SQLException
     */
    public void addSingleSala(String nomeSala) throws SQLException{
        String query = "INSERT INTO `ristorante`.`sale` (`nome`) VALUES ('"+nomeSala.replace("'", "''")+"');";
        stm.execute(query);
    }   

    /**
     * Elimina la tabella delle sale dal db
     * @throws SQLException
     */
    
    public void DropTableSale() throws SQLException{
        String query = "DROP TABLE IF EXISTS `ristorante`.`sale`";
        stm.executeUpdate(query);
    
    } 

    /**
     * Crea la tabella menu
     * @throws SQLException
     */
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

    /**
     * Popola la tabella menu da file
     * @throws SQLException
     */
    public void addPortataFromFiletoDb() throws SQLException{
          for(Portata p: MenuCompleto.menuCompleto){
            String query = "INSERT INTO `ristorante`.`menu` (` nome portata`,"
                    + " `tipo portata`) VALUES "
                    + "('"+p.getNome().replace("'", "''")+"', '"+p.getTipoPortata()+"');";
            stm.executeUpdate(query);
        }
    }

    /**
     * Popola la tabella menu tramite interfaccia
     * @param p è la classe portata
     * @throws SQLException
     */
    public void addSinglePortata(Portata p) throws SQLException{
        String query = "INSERT INTO `ristorante`.`menu` (` nome portata`, `tipo portata`) VALUES "
                + "('"+p.getNome().replace("'", "''")+"', '"+p.getTipoPortata().toString()+"');";;
        stm.execute(query);
        for(int i=1;i<=p.getIngredienti().size();i++){
                String query1 = "UPDATE `ristorante`.`menu` SET "
                        + "`ingrediente"+i+"`='"+p.getIngredienti().get(i-1).getName().replace("'", "''")+"', "
                        + "`qnt"+i+"`='"+p.getIngredienti().get(i-1).getQuantity()+"' "
                        + "WHERE ` nome portata`='"+p.getNome().replace("'", "''")+"';";
                stm.executeUpdate(query1);
            }
        
        
    }  

    /**
     * Aggiunge gli ingredienti alle portate
     * @throws SQLException
     */
    public void addIngredienti() throws SQLException{
         for(Portata p: MenuCompleto.menuCompleto){
        
            for(int i=1;i<=p.getIngredienti().size();i++){
                String query = "UPDATE `ristorante`.`menu` SET "
                        + "`ingrediente"+i+"`='"+p.getIngredienti().get(i-1).getName().replace("'", "''")+"', "
                        + "`qnt"+i+"`='"+p.getIngredienti().get(i-1).getQuantity()+"' "
                        + "WHERE ` nome portata`='"+p.getNome().replace("'", "''")+"';";
                stm.executeUpdate(query);
            }
        }
    }    

    /**
     * Metodo generico che permette di aggiungere campi alla tabella
     * @param table a cui vuoi aggiungere dati
     * @param query che devi fare per poter aggiungere i dati alla tabella
     * @throws SQLException
     */
    public void riempiTabella(JTable table, String query) throws SQLException{
         pstmt = conn.prepareStatement(query);
         rs = pstmt.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
     }  

    /**
     * Conteggia i dati in una determinata tabella
     * @param tabella di cui si vogliono conteggiare i dati
     * @return
     * @throws SQLException
     */
    public int verificaTabella(String tabella) throws SQLException{
        String query = "SELECT COUNT(*) AS 'Numero' FROM `ristorante`.`"+tabella+"`;";
        rs=stm.executeQuery(query);
        rs.last();
        int i = rs.getInt("Numero");
       return i;
    }  

    /**
     * Crea la tabella delle prenotazioni
     * @throws SQLException
     */
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

    /**
     * Aggiunge una prenotazione nella relativa tabella del db
     * @param p è la classe prenotazione
     * @throws SQLException
     */
    public void addSinglePrenotazione(Prenotazione p) throws SQLException{
        String query = "INSERT INTO `ristorante`.`prenotazioni` (`pasto`, "
                + "`nome`, `numero di adulti`, `sala`, `numero di bambini`"
                + ", `primo1`, `primo2`, `primo3`"
                + ", `secondo1`, `secondo2`, `secondo3`, `dolce`, `note`"
                + ", `lista attesa`, `esigenza sala`, `preferenza sala`"
                + ", `esclusiva sala`, `da confermare`, `tipo di evento`, `data`, `numero di telefono`) VALUES "
                + "('"+p.getPasto()+"', "
                + "'"+p.getCliente().getNome().replace("'", "''")+"', "
                + "'"+p.getnAdulti()+"', "
                + "'"+p.getSala().getNome().replace("'", "''")+"', "
                + "'"+p.getnBambini()+"', "
                + "'"+p.getMenu().getMenuCliente().get(0).getNome().replace("'", "''")+"', "
                + "'"+p.getMenu().getMenuCliente().get(1).getNome().replace("'", "''")+"', "
                + "'"+p.getMenu().getMenuCliente().get(2).getNome().replace("'", "''")+"', "
                + "'"+p.getMenu().getMenuCliente().get(3).getNome().replace("'", "''")+"', "
                + "'"+p.getMenu().getMenuCliente().get(4).getNome().replace("'", "''")+"', "
                + "'"+p.getMenu().getMenuCliente().get(5).getNome().replace("'", "''")+"', "
                + "'"+p.getMenu().getMenuCliente().get(6).getNome().replace("'", "''")+"' ,"
                + "'"+p.getNote().replace("'", "''")+"' ,"
                + "'"+p.getAttesa()+"' ,"
                + "'"+p.getEsigenza()+"' ,"
                + "'"+p.getPreferenza()+"' ,"
                + "'"+p.getEsclusiva()+"' ,"
                + "'"+p.getDaConfermare()+"' ,"
                + "'"+p.getTipoEvento().replace("'", "''")+"' ,"
                + "'"+p.getDateDb()+"' ,"
                + "'"+p.getCliente().getNumTelefono()+"');";
        stm.execute(query);
    
    }   

    /**
     * Metodo che prende i dati dalla tabella sale del db per popolare l'interfaccia
     * @throws SQLException
     */
    public void toJavaFromDbSale() throws SQLException{
        String query = "SELECT * FROM `ristorante`.`sale` ORDER BY `sale`.`idsale`";
        rs = stm.executeQuery(query);
        while(rs.next()){
           String nomeSala =rs.getString("nome");
           agri.addSala(new Sala(nomeSala));
        }
    }

    /**
     * Prende le portate dalla tabella menu e le mostra nell'interfaccia
     * @throws SQLException
     */
    public void toJavaFromDbPortate() throws SQLException{
        String query = "SELECT * FROM `ristorante`.`menu`";
        rs = stm.executeQuery(query);
        while(rs.next()){
           String nomePortata = rs.getString(" nome portata");
           String tipoPortata = rs.getString("tipo portata");
           Portata portata = new Portata(nomePortata, TipoPortata.valueOf(tipoPortata));

           for(int i=1;i<=12;i++){
               String ing = rs.getString("ingrediente"+i);
               int qnt = rs.getInt("qnt"+i);
               portata.getIngredienti().add(new Ingredient(ing, qnt));
           }
           MenuCompleto.menuCompleto.add(portata);
        }
    }    
    
    /**
     * Prende i dati del ristorante dal db
     * @return nomeRistorante che serve per testare che il nome scritto nel db sia corretto
     * @throws SQLException
     */
    public String toJavaFromDbNome() throws SQLException{
       String nomeRistorante = null;
        String query = "SELECT * FROM `ristorante`.`dati`";
        rs = stm.executeQuery(query);
        while(rs.next()){
           nomeRistorante = rs.getString("nome");
           agri.setNome(nomeRistorante);
        }
        return nomeRistorante;
    }    

    /**
     * Prende i dati della tabella prenotazioni e li carica nell'interfaccia
     * @throws SQLException
     */
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
            menuCliente.getMenuCliente().add(primoDue);
            Portata primoTre= new Portata(primo3, TipoPortata.Primo);
            menuCliente.getMenuCliente().add(primoTre);
            Portata secondoUno= new Portata(secondo1, TipoPortata.Secondo);
            menuCliente.getMenuCliente().add(secondoUno);
            Portata secondoDue= new Portata(secondo2, TipoPortata.Secondo);
            menuCliente.getMenuCliente().add(secondoDue);
            Portata secondoTre= new Portata(secondo3, TipoPortata.Secondo);
            menuCliente.getMenuCliente().add(secondoTre);
            Portata dolcE= new Portata(dolce, TipoPortata.Dolce);
            menuCliente.getMenuCliente().add(dolcE);
            
            prenotazione.setMenu(menuCliente);
            agri.aggiungiPrenotazione(prenotazione);
            
            }    
        }
    
    /**
     * Query che permette di sapere quante sale ci sono salvate nel db
     * @return numeroSale per relativo controllo e modifica dell'interfaccia
     * @throws SQLException
     */
    public int getNumeroSale() throws SQLException{
            String query = "SELECT COUNT(*) AS 'Numero' FROM `ristorante`.`sale`;";
            rs=stm.executeQuery(query);
            rs.last();
            int numeroSale = rs.getInt("Numero");
            return numeroSale;
        }  

    /**
     * Permette di modificare una prenotazione effettuata
     * @param p classe prenotazione
     * @throws SQLException
     */
    public void modificaPrenotazione(Prenotazione p) throws SQLException{
            String query = "UPDATE `ristorante`.`prenotazioni` SET "
                    + "`note`='"+p.getNote().replace("'", "''")+"', "
                    + "`nome`='"+p.getCliente().getNome().replace("'", "''")+"' ,"
                    + "`numero di telefono`='"+p.getCliente().getNumTelefono()+"', "
                    + "`pasto`='"+p.getPasto()+"' ,`data`='"+p.getDateDb()+"' ,"
                    + "`numero di adulti`='"+p.getnAdulti()+"' ,`numero di bambini`='"+p.getnBambini()+"' ,"
                    + " `sala`='"+p.getSala().getNome().replace("'", "''")+"' ,"
                    + "`tipo di evento`='"+p.getTipoEvento().replace("'", "''")+"' ,"
                    + "`esigenza sala`='"+p.getEsigenza()+"' ,"
                    + "`lista attesa`='"+p.getAttesa()+"' ,"
                    + "`preferenza sala`='"+p.getPreferenza()+"' ,"
                    + "`esclusiva sala`='"+p.getEsclusiva()+"' ,"
                    + "`primo1`='"+p.getMenu().getMenuCliente().get(0).getNome().replace("'", "''")+"' ,"
                    + "`primo2`='"+p.getMenu().getMenuCliente().get(1).getNome().replace("'", "''")+"' ,"
                    + "`primo3`='"+p.getMenu().getMenuCliente().get(2).getNome().replace("'", "''")+"' ,"
                    + "`secondo1`='"+p.getMenu().getMenuCliente().get(3).getNome().replace("'", "''")+"' ,"
                    + "`secondo2`='"+p.getMenu().getMenuCliente().get(4).getNome().replace("'", "''")+"' ,"
                    + "`secondo3`='"+p.getMenu().getMenuCliente().get(5).getNome().replace("'", "''")+"' ,"
                    + "`dolce`='"+p.getMenu().getMenuCliente().get(6).getNome().replace("'", "''")+"' ,"
                    + "`da confermare`='"+p.getDaConfermare()+"'"
                    + " WHERE `idprenotazioni`='"+p.getId()+"'";
           
                stm.executeUpdate(query);
    }

    /**
     * Cancella una prenotazione dato il suo id e nome
     * @param id della prenotazione al momento della conferma
     * @param nomePrenotazione dato dal Cliente al momento della prenotazione
     * @throws SQLException
     */
    public void deletePrenotazione(int id, String nomePrenotazione) throws SQLException{
            String query = "DELETE FROM `ristorante`.`prenotazioni` WHERE `idprenotazioni`='"+id+"' "
                    + "and`nome`='"+nomePrenotazione.replace("'", "''")+"'";
            stm.execute(query);
        }

    /**
     * Prende l'id dell'ultima prenotazione effettuata
     * @return l'id della prenotazione
     * @throws SQLException
     */
    public int selectMaxId() throws SQLException{
        int max;
        String query = "SELECT MAX(idprenotazioni) AS 'max' FROM ristorante.prenotazioni";
        rs = stm.executeQuery(query);
        rs.next();
        max = rs.getInt("max");
        return max;
    }

    /**
     * Cancella le portate dalla tabella menu dato il nome
     * @param nome della portata che si vuole cancellare
     * @throws SQLException
     */
    public void deletePortataFromMenu(String nome) throws SQLException{
         String query = "DELETE FROM `ristorante`.`menu` WHERE ` nome portata`='"+nome.replace("'", "''")+"'";
            stm.execute(query);
    }

    /**
     * Cancella una sala dalla relativa tabella
     * @param nome
     * @throws SQLException
     */
    public void deleteSalaFromDb(String nome) throws SQLException{
         String query = "DELETE FROM `ristorante`.`sale` WHERE `nome`='"+nome.replace("'", "''")+"'";
            stm.execute(query);
    }

    /**
     * Metodo per modificare un piatto
     * @param p classe portata
     * @throws SQLException
     */
    public void modificaPortata(Portata p) throws SQLException{
      
        for(int i=1;i<=p.getIngredienti().size();i++){
            String query = "UPDATE `ristorante`.`menu` SET "
            + "`ingrediente"+i+"`='"+p.getIngredienti().get(i-1).getName().replace("'", "''")+"', "
            + "`qnt"+i+"`='"+p.getIngredienti().get(i-1).getQuantity()+"' "
                + "WHERE ` nome portata`='"+p.getNome().replace("'", "''")+"';";
                stm.executeUpdate(query);
            }
        for(int i=p.getIngredienti().size();i<=12;i++){
            String query = "UPDATE `ristorante`.`menu` SET "
            + "`ingrediente"+i+"`='', "
            + "`qnt"+i+"`='"+0+"' "
                + "WHERE ` nome portata`='"+p.getNome().replace("'", "''")+"';";
                stm.executeUpdate(query);
            }
    }

    /**
     * Dopo aver cancellato una sala, aggiorna le prenotazioni
     * @param sala
     * @throws SQLException
     */
    public void refreshSalaDeletedDb(String sala) throws SQLException{
         String query = "UPDATE `ristorante`.`prenotazioni` SET "
                        + "`sala`='Indifferente' "
                        + "WHERE `sala`='"+sala+"';";
         stm.executeUpdate(query);
    }

    /**
     * Dopo aver cancellato una portata, aggiorna le prenotazioni
     * @param p
     * @throws SQLException
     */
    public void refreshPortataDeletedDb(Portata p) throws SQLException{
         if(p.getTipoPortata().equals(TipoPortata.Primo)){
             for(int i=1;i<=3;i++){
                 String query = "UPDATE `ristorante`.`prenotazioni` SET "
                        + "`primo"+i+"`='Indifferente' "
                        + "WHERE `primo"+i+"`='"+p.getNome()+"';";
                stm.executeUpdate(query);
             }
         }
         if(p.getTipoPortata().equals(TipoPortata.Secondo)){
             for(int i=1;i<=3;i++){
                 String query = "UPDATE `ristorante`.`prenotazioni` SET "
                        + "`secondo"+i+"`='Indifferente' "
                        + "WHERE `secondo"+i+"`='"+p.getNome()+"';";
                stm.executeUpdate(query);
             }
         }
         if(p.getTipoPortata().equals(TipoPortata.Dolce)){
                 String query = "UPDATE `ristorante`.`prenotazioni` SET "
                        + "`dolce`='Indifferente' "
                        + "WHERE `dolce`='"+p.getNome()+"';";
                stm.executeUpdate(query);
        }
                
    }
     
    /**
     * Metodo che ci è servito per controllare che scrivesse effettivamente nel db una sala aggiunta dal junit test
     * @return
     * @throws SQLException
     */
    public ArrayList selectSale() throws SQLException{
        ArrayList sl = new ArrayList();
        String query = "SELECT * FROM `ristorante`.`sale` ORDER BY `sale`.`idsale`";
        rs = stm.executeQuery(query);
        while(rs.next()){
           String nomeSala =rs.getString("nome");
           sl.add(nomeSala);
        }
        return sl;
    }
        
    /**
     * Modifica i dati del ristorante nella relativa tabella
     * @throws SQLException
     */
        public void modificaDatiRistorante() throws SQLException{
        String query = "UPDATE `ristorante`.`dati` SET `nome` = '"+agri.getNome()+"';";
        stm.executeUpdate(query);
    }    
    
    
 }
        
        
    
  
    
    
    
    
    

