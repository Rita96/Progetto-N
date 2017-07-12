package funzionalita;

import gui.guiPrenotazione.GestioneTabelle;
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
public interface FunzioniPrincipali {
    public void aggiungiPrenotazione(Prenotazione p);
    public void rimnuoviPrenotazione();
    public void modificaPrenotazione();
    public void stampaAccoglienza(ArrayList<GestioneTabelle> gt);
    public void stampaCucina();
    public void calcoloSpesa();
    
    
}
