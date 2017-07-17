/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import cliente.Cliente;
import database.CreateDb;
import funzionalita.Prenotazione;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import menu.Ingredient;
import menu.MenuCliente;
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
        Prenotazione pre = null;
        MenuCliente menuCliente = new MenuCliente();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date data1 = formatter.parse("17-07-2017");
        Date data2 = formatter.parse("19-07-2017");
        Cliente c = new Cliente("Giuseppe", 254669874);
        
        
        cdb.toJavaFromDbSale();
        cdb.toJavaFromDbPortate();
        cdb.toJavaFromDbNome();
       
        for(Portata p: MenuCompleto.menuCompleto){
            if(p.getNome().equalsIgnoreCase("Ravioli gratinati")){
                por = p;
            }
        }
        pre= new Prenotazione(4, formatter.parse("18-07-2017"), "Pranzo", c);
        agri.aggiungiPrenotazione(pre);
        menuCliente.getMenuCliente().add(por);
        pre.setMenu(menuCliente);
        agri.calcoloSpesaPortate(data1, data2);
        agri.calcoloSpesaIngredienti();
        
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