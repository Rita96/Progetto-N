/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import gui.nome.GuiNome;
import databse.ConnectDbMySql;
import databse.CreateDb;
import gui.GuiProva;
import java.io.IOException;
import java.sql.SQLException;
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
    public static void main(String[] args) throws IOException, SQLException {
       GuiNome guiNome = new GuiNome();
       CreateDb createDb = new CreateDb();
       
     
       GuiProva guiProva = new GuiProva();
       
        if(true) //controllo se il ristorante è gia stato creato da fare
            guiNome.setVisible(true);
    }
    
}
