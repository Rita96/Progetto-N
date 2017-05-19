package lettura;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.xml.bind.ParseConversionEvent;
import menu.MenuCompleto;
import menu.Portata;
import menu.TipoPortata;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luby
 */
public class LeggiPortate {
    
    MenuCompleto menu = new MenuCompleto();

    public void letturaPortate(String percorso) throws FileNotFoundException, IOException {
        String s[];
        String line=null;
        String portata=null;
        FileReader file = new FileReader(percorso);
        BufferedReader buffer = new BufferedReader(file);
        while((line=buffer.readLine())!=null){
            s = line.split(", ");
            portata = s[0];
            TipoPortata tipoPortata = TipoPortata.valueOf(s[1]);
            Portata p = new Portata(portata, tipoPortata);
            menu.addPortata(p);
        }
        file.close();
        
    }
    

}
