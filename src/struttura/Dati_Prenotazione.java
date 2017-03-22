/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package struttura;

import cibo.Menu;
import identità.Cliente;
import java.util.Date;

/**
 *
 * @author luby9
 */
public class Dati_Prenotazione {

    public Dati_Prenotazione(Date date, SalaType sala, Cliente cliente, Menu menu) {
        this.date = date;
        this.sala = sala;
        this.cliente = cliente;
        this.menu = menu;
    }

    public Date getDate() {
        return date;
    }

    public SalaType getSala() {
        return sala;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Menu getMenu() {
        return menu;
    }

   Date date;
   SalaType sala;
   Cliente cliente;
   Menu menu;
   
    
    
    
    
}
