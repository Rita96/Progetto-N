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
public class ExeptionData extends Exception{

    //Errore che viene mostrato quando tenti di prenotare per un giorno passato
    @Override
    public String getMessage() {
        return "La data inserita non è valida !";
    }
     
}
