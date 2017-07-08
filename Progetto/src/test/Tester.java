/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;
import gui.nome.GuiNome;
import databse.ConnectDbMySql;
import databse.CreateDb;
import gui.GuiProva;
import gui.GuiProvaM;
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
             GuiProvaM guiProva = new GuiProvaM();
            guiProva.setVisible(true);
            
       }else
           guiNome.setVisible(true);
       
       
    }
    
}
