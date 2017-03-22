/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package struttura;

import cibo.Menu;
import identità.Cliente;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;
import java.util.TimeZone;

/**
 *
 * @author luby9
 */
public class Tester_struttura {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        Agriturismo agri = new Agriturismo();
        Dati_Prenotazione prenotazione;
        Date data;
        SalaType sala;
        Cliente cliente;
        Menu menu = null;
        


        data = agri.inserisciData(); //metodo che ritorna la data inserita in formate Date
        sala = agri.scegliSala();
        cliente = agri.inserisciCliente();
        menu = agri.scegliMenu();
        prenotazione = new Dati_Prenotazione(data, sala, cliente, menu);
        
        agri.aggiungiPrenotazione(prenotazione);

    
    }
        
    
}
