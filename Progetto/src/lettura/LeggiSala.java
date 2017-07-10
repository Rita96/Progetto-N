package lettura;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
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
   Scanner x ;
   
    
    public void letturaSale(String percorso) throws FileNotFoundException, IOException{
        String sala = null;
        Scanner inputStream = null;
        x = new Scanner(new File(percorso));
        while(x.hasNext()){
            String riga = x.nextLine();
            String parts[] = riga.split("\n");
            String genericSala = parts[0];
            Sala s = new Sala(genericSala);
            agri.addSala(s);
        }
        x.close();
        
//        String[] array = riga.split("\n");
//        FileReader file = new FileReader(percorso);
//        BufferedReader buffer = new BufferedReader(file);
//        while((sala=buffer.readLine())!= null){
//            Sala s = new Sala(sala);
//            agri.addSala(s);
//        }
//        file.close();
    }

    
  
    
    
    
}
