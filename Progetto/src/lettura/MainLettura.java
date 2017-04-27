/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lettura;

import java.io.IOException;
import menu.MenuCompleto;
import menu.Portata;
import struttura.Agriturismo;
import struttura.Sala;

/**
 *
 * @author luby
 */
public class MainLettura {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        Agriturismo agri = new Agriturismo();   //istanza di Agriturismo
        
        //lettura sala
        LeggiSala leggiSala = new LeggiSala();  // istanza di LeggiSala
        leggiSala.letturaSale();    // lettura da file delle sale
        for(Sala s: agri.getSale()){    //verifica dell array sale in Agriturismo con ciclo for
            System.out.println(s.getNome());
        }
        
        //lettura portate
        LeggiPortate leggiPortata = new LeggiPortate();     //istanza di LeggiPortata  
        MenuCompleto menuC = new MenuCompleto();        //istanza di MenuCompleto
        leggiPortata.letturaPortate();      //lettura da file delle portate
        for(Portata p: menuC.getMenuCompleto()){    // verifica dell'array menuCompleto in MenuCompleto co ciclo for
            System.out.println(p.getNome()+" "+p.getTipoPortata());
        }
        
        
        
        
        
    }
    
}
