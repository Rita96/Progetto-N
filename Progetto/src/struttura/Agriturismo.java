package struttura;

import funzionalita.FunzioniPrincipali;
import funzionalita.Prenotazione;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luby
 */
public class Agriturismo implements FunzioniPrincipali{
    private ArrayList<Prenotazione> prenotazione = new ArrayList<>();
    private int contatorePersone;

    public ArrayList<Prenotazione> getPrenotazione() {
        return prenotazione;
    }

    public int getContatorePersone() {
        return contatorePersone;
    }
    
    @Override
    public void aggiungiPrenotazione() {
    }

    @Override
    public void rimnuoviPrenotazione() {
    }

    @Override
    public void modificaPrenotazione() {
    }

    @Override
    public void stampaAccoglienza() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void stampaCucina() {
    }

    @Override
    public void calcoloSpesa() {
    }
    
    
}
