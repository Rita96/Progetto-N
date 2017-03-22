package struttura;

import cibo.Alimenti;
import cibo.Menu;
import identità.Cliente;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luby9
 */
public class Agriturismo implements Funzioni_Principali {
    
    private Cliente cliente;
    private Menu men;
    private Date date;
    private SalaType sala;
    private  DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.ITALY);
    private String pranzo = "Pranzo";
    private String cena = "cena";
    private ArrayList<Dati_Prenotazione> array_dati_prenotazione;
    
    public Agriturismo(){
       

    }

    public Cliente getCliente() {
        return cliente;
    }

    public Menu getMen() {
        return men;
    }

   
    public Date inserisciData(){
        System.out.println("inserire la data in formato gg/mm/aa");
        
        
        Scanner s = new Scanner(System.in);
        String myDateStr = s.next();
        try {
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ITALY);
        Date myDate = dateFormat.parse(myDateStr);
            System.out.println(dateFormat.format(myDate));
        } catch (ParseException e) {
            System.out.println("La data inserita non è valida");
        }
        return date;
    }
    
    public SalaType scegliSala(){
        System.out.println("Scegli la sala: ");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        
        SalaType sala = SalaType.valueOf(s);
        switch (sala){
            case Verde:
                sala = SalaType.Verde;
                    break;
            case Gialla:
                sala = SalaType.Gialla;
                    break;
            case Rosa:
                sala = SalaType.Rosa;
                    break;
            case Ingresso:
                sala = SalaType.Ingresso;
                    break;
            case Corte:
                sala = SalaType.Corte;
                    break;
            case Giardino:
                sala = SalaType.Giardino;
                    break;
             case Garden:
                sala = SalaType.Garden;
                    break;

            default:
                System.out.println("nessuno");
        }
        return this.sala=sala;          
    }

    
    public Cliente inserisciCliente(){
        Cliente cliente = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserire il nome del cliente: ");
        String nome = scanner.next();
        System.out.println("Inserire il numero di persone: ");
        int numero_adulti = scanner.nextInt();
        System.out.println("Inserire il numero di bambini: ");
        int numero_bambini = scanner.nextInt();
        System.out.println("Inserire il numero di telefono: ");
        long numero_telefono = scanner.nextLong();
        System.out.println("Inserire se pranzo o cena: ");
        String pranzo_cena = scanner.next();
        System.out.println("Inserire il tipo di evento: ");
        String tipo_evento = scanner.next();
        
        cliente = new Cliente(nome, tipo_evento, numero_adulti, numero_telefono, numero_bambini, pranzo_cena);
        
        return cliente;
    }
    
    public Menu scegliMenu(){
        String note = null;
        ArrayList<Alimenti> alimenti = null;
        Menu menu = new Menu();
        menu.aggiungielementoMenu();
        note = menu.setNote();
        alimenti = menu.scegli_alimenti();
        menu = new Menu(alimenti, note);
        
        return men=menu;
    }
    

    @Override
    public void aggiungiPrenotazione(Dati_Prenotazione dati_prenotazione) {
        
     
        try {
            FileWriter file = new FileWriter("prenotazioni.txt");
            BufferedWriter scrivi = new BufferedWriter(file);
            
            scrivi.write(dati_prenotazione.getCliente().getNome()+"\t"+dati_prenotazione.getCliente().getNumero_adulti()+dati_prenotazione.getCliente().getNumero_bambini()+ "\t"+sala+"\t"+dati_prenotazione.getCliente().getNumero_telefono());
            scrivi.newLine();
            for(int i =0;i<dati_prenotazione.getMenu().getAlimenti_menu_singolo().size();i++){
                                scrivi.write(dati_prenotazione.getMenu().getAlimenti_menu_singolo().get(i).getNome()+"\t");

            }
            
            
            scrivi.flush();
            
        } catch (IOException ex) {
            Logger.getLogger(Agriturismo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }

    @Override
    public void modificaPrenotazione(Date date, SalaType sala, Cliente cliente, Menu menu) {
    }

    @Override
    public void rimuoviPrenotazione(Date date, SalaType sala, Cliente cliente, Menu menu) {
    }
    
    public void printCucina(Date date, String pranzo_cena){
    
    }
    
    public void printAccoglienza(Date date, String pranzo_cena){
    
    }
    
    public void situazioneTavoli(Date date, String pranzo_cena){
    
    }
    
    
  

    
    
    
    
    
    
    
    
    
  
    
}
