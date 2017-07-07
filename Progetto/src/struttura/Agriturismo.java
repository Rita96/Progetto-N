package struttura;

import funzionalita.FunzioniPrincipali;
import funzionalita.Prenotazione;
import java.io.IOException;
import java.util.ArrayList;
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
    public void stampaAccoglienza() {
    }

    @Override
    public void stampaCucina() {
    }

    @Override
    public void calcoloSpesa() {
    }
    
    
}
