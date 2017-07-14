/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;
import gui.nome.GuiNome;
import databse.ConnectDbMySql;
import databse.CreateDb;
import gui.GuiPrincipale;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import lettura.LeggiSala;

/**
 *
 * @author luby9
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, SQLException {
     
       GuiNome guiNome = new GuiNome();
       CreateDb createDb = new CreateDb();
        boolean controllo = false;
       

       try{
           controllo = createDb.FirstAccess();
       }catch(MySQLSyntaxErrorException ex){
       }
       
       if(controllo){
            createDb.toJavaFromDbSale();
            createDb.toJavaFromDbPortate();
            createDb.toJavaFromDbNome();
            createDb.toJavaFromDbPrenotazioni();
            GuiPrincipale guiProva = new GuiPrincipale();
            guiProva.refreshNumber();
            guiProva.setLocationRelativeTo(null);
            guiProva.setVisible(true);
            
       }else
           guiNome.setVisible(true);
       
       
    }
    
}
