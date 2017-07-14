/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import databse.CreateDb;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;
import struttura.Agriturismo;

/**
 *
 * @author Stefania
 */
public class TestProgetto {    
        
    //public TestProgetto() {
    //}
    
    //Test che modifica il nome del ristorante nel db
    @Test
    public void nomeTest() throws SQLException{
        Agriturismo agri = new Agriturismo();
        CreateDb cdb = new CreateDb();        

        Agriturismo.setNome("Stefania Party");  
        cdb.modificaDatiRistorante();
        assertEquals(agri.getNome(), cdb.toJavaFromDbNome());
    }
    //Test che aggiunge e toglie una sala dal db
    @Test
    public void addSalaTest() throws SQLException{
        boolean test = false;
        boolean test1 = false;
        CreateDb cdb = new CreateDb();       
        
        cdb.addSingleSala("Sala Nuova");
        cdb.selectSale();
         
            if(cdb.selectSale().contains("Sala Nuova")){
               test = true;
               assertEquals(true, test);
            }
            
        cdb.deleteSalaFromDb("Sala Nuova");
            if(!(cdb.selectSale().contains("Sala Nuova"))){
                test1 = true;
                assertEquals(true, test);
            }     
    }
    //Test di verifica di una portata
    @Test
    public void addPortataTest() throws SQLException{
        CreateDb cdb = new CreateDb();        
    }
    
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}