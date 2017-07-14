package funzionalita;

import gui.guiPrenotazione.GestioneTabelle;
import java.util.ArrayList;
import java.util.Date;

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
    public void rimnuoviPrenotazione(Prenotazione p);
    public void stampaAccoglienza(ArrayList<GestioneTabelle> gt);
    public void calcoloSpesaPortate(Date d1, Date d2);
    public void calcoloSpesaIngredienti();
    
    
}
