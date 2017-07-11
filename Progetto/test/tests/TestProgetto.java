/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import databse.ConnectDbMySql;
import databse.CreateDb;
import java.sql.SQLException;
import menu.TipoPortata;
import org.junit.Test;
import static org.junit.Assert.*;
import struttura.Agriturismo;

/**
 *
 * @author Stefania
 */
public class TestProgetto {
    
    
    
    public TestProgetto() {
    }

    
    @Test
    public void aggiungiIngredienteTest() throws SQLException{
        ConnectDbMySql db = new ConnectDbMySql();
        Agriturismo agri = new Agriturismo();
        CreateDb cdb = new CreateDb(); 
        
        
        agri.setNome("agriturismo");
        cdb.addIngredienti("Muffin", TipoPortata.Dolce, "Uova", 4);
        
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
