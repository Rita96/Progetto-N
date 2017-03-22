package struttura;

import cibo.Menu;
import identità.Cliente;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luby9
 */
public interface Funzioni_Principali {
    
    public void aggiungiPrenotazione(Dati_Prenotazione prenotazione);
    public void modificaPrenotazione(Date date, SalaType sala, Cliente cliente, Menu menu);
    public void rimuoviPrenotazione(Date date, SalaType sala, Cliente cliente, Menu menu);

    
    
}
