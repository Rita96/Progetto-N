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
public class ExeptionNome extends Exception{
    //Messaggio che esce quando tenti di prenotare senza aver inserito un nome
    @Override
    public String getMessage() {
        return "Non hai compilato il campo 'nome' !";
    }
    
    
    
}
