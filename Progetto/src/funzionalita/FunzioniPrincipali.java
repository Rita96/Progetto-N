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
    /**
     * Funzione che aggiunge una prenotazione
     * @param p
     */
        public void aggiungiPrenotazione(Prenotazione p);

    /**
     * Funzione rimuovi una prenotazione effettuata
     * @param p
     */
    public void rimnuoviPrenotazione(Prenotazione p);

    /**
     * Funzione di stampa per l'accoglienza dei clienti in base alle prenotazioni
     * @param gt
     */
    public void stampaAccoglienza(ArrayList<GestioneTabelle> gt);

    /**
     * Calcola le portate in base alle persone prenotate
     * @param d1
     * @param d2
     */
    public void calcoloSpesaPortate(Date d1, Date d2);

    /**
     * Calcola le quantità degli ingredienti in base alle portate prenotate
     */
    public void calcoloSpesaIngredienti();
    
    
}
