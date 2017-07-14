package lettura;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import struttura.Agriturismo;
import struttura.Sala;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luby
 */
public class LeggiSala {
   Agriturismo agri = new Agriturismo();

    /**
     * Legge da file le sale
     * @param percorso
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void letturaSale(String percorso) throws FileNotFoundException, IOException{
        String sala = null;
        FileReader file = new FileReader(percorso);
        BufferedReader buffer = new BufferedReader(file);
        while((sala=buffer.readLine())!= null){
            Sala s = new Sala(sala);
            agri.addSala(s);
        }
        file.close();
    }
        
    
}
