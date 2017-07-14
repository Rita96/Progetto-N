/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

import java.sql.SQLException;

/**
 *
 * @author luby9
 */
public class ExeptionDatabase extends SQLException{

    //Messaggio che ti esce quando non c'è connessione col db
    @Override
    public String getMessage() {
        return "Problemi con il database !";
    }
    
    
    
}
