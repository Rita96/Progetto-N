/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import lettura.LeggiPortate;
import lettura.LeggiSala;

/**
 *
 * @author luby9
 */
public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        LeggiPortate leggiPortate = new LeggiPortate();
        LeggiSala leggiSala = new LeggiSala();
        GuiProva guiProva = new GuiProva();
        
        leggiPortate.letturaPortate();
        leggiSala.letturaSale();
        
        guiProva.setVisible(true);
        
    }
    
}
