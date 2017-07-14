/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author luby9
 */
public class ExeptionNumeroAdulti extends NumberFormatException{

    //Messaggio che ti esce se non compili il campo del numero di adulti durante la prenotazione
    @Override
    public String getMessage() {
        return "Non hai compilato il campo 'Numero di adulti' !";
    }
     
    
    
}
