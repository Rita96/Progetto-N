/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import database.CreateDb;
import gui.GuiPrincipale;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import menu.Ingredient;
import menu.MenuCompleto;
import menu.Portata;
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
    //Test di verifica della funzione Calcola portata
    @Test
    public void testGestioneSpesa() throws SQLException, ParseException{
        CreateDb cdb = new CreateDb();  
        Agriturismo agri = new Agriturismo();
        Portata por = null;
        Ingredient ing = null;
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date data1 = formatter.parse("17-07-2017");
        Date data2 = formatter.parse("19-07-2017");
        
        
        cdb.toJavaFromDbSale();
        cdb.toJavaFromDbPortate();
        cdb.toJavaFromDbNome();
        cdb.toJavaFromDbPrenotazioni();
        agri.calcoloSpesaPortate(data1, data2);
        agri.calcoloSpesaIngredienti();
        for(Portata p: Agriturismo.portateSpesa){
            if(p.getNome().equalsIgnoreCase("Ravioli gratinati")){
                por = p;
            }
        }
        
        for(Ingredient ingr: Agriturismo.ingSpesa){
            if(ingr.getName().equalsIgnoreCase("brasato")){
                ing = ingr;
            }
        }
        
        assertEquals("4", String.valueOf(por.getPortataNp())); 
        assertEquals("40.0",String.valueOf((double)ing.getIngredientNp()*(double)ing.getQuantity()/10));
            
    }
    

    
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}