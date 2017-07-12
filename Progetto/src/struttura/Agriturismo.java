package struttura;

import funzionalita.FunzioniPrincipali;
import funzionalita.Prenotazione;
import gui.guiPrenotazione.GestioneTabelle;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import lettura.LeggiSala;
import menu.Portata;

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
    private static ArrayList<Prenotazione> prenotazioni = new ArrayList<>();
    private int contatorePersone;
    private static ArrayList<Sala> sale = new ArrayList<>();
    private static String nome;
    public File file = new File("accoglienza.txt");
    private boolean controllo = true;
    
    public Agriturismo (String nome){
        this.nome=nome;
    }

    public static void setNome(String nome) {
        Agriturismo.nome = nome;
    }
    
    public Agriturismo(){
        
    }

   public String getNome(){
       return nome;
   }

    public static ArrayList<Prenotazione> getPrenotazioni() {
        return prenotazioni;
    }

    
    
    public void addSala(Sala s){
        sale.add(s);
    }
    
    public ArrayList<Sala> getSale() {
        return sale;
    }


    public ArrayList<Prenotazione> getPrenotazione() {
        return prenotazioni;
    }

    public int getContatorePersone() {
        return contatorePersone;
    }
    
    @Override
    public void aggiungiPrenotazione(Prenotazione p) {
        prenotazioni.add(p);
    }

    @Override
    public void rimnuoviPrenotazione() {
        
    }

    @Override
    public void modificaPrenotazione() {
    }

    @Override
    public void stampaAccoglienza(ArrayList<GestioneTabelle> g) {
        PrintStream pw=null;
        try {
            pw = new PrintStream(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Agriturismo.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(GestioneTabelle gt: g){
            if(gt.getDtm().getRowCount()!=0){ 
                pw.println("\n\n\n\n\n\n\n\n\n\n\n");
                pw.println("\n\n\n\n\n\n\n\n\n\n\n");
                pw.println(gt.getNomeSala().toString().toUpperCase());
                for(int i=0;i<gt.getDtm().getRowCount();i++){
                    String nome = (String)gt.getDtm().getValueAt(i, 0).toString();
                    pw.println(nome+"                                  "+gt.getDtm().getValueAt(i, 1).toString());
                    pw.print("\n\n");
                }
                pw.flush();
            }
        }    
    }
        
    

    @Override
    public void stampaCucina() {
    }

    @Override
    public void calcoloSpesa() {
    }
    
    
}
