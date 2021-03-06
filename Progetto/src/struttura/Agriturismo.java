package struttura;

import funzionalita.FunzioniPrincipali;
import funzionalita.Prenotazione;
import gui.guiPrenotazione.GestioneTabelle;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import menu.Ingredient;
import menu.MenuCompleto;
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
    public static Set<Portata> portateSpesa = new HashSet<Portata>();
    public static LinkedHashSet<Ingredient> ingSpesa = new LinkedHashSet<>();


    
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

    /**
     * Aggiunge le sale da Sala
     * @param s
     */
    public void addSala(Sala s){
        sale.add(s);
    }

    /**
     * Rimuove le sale da Sala
     * @param s
     */
    public void removeSala(Sala s){
        sale.remove(s);
    }
    
    public ArrayList<Sala> getSale() {
        return sale;
    }

    public ArrayList<Prenotazione> getPrenotazione() {
        return prenotazioni;
    }

    /**
     * Conta le persone prenotate
     * @param d
     * @return
     */
    public int getContatorePersone(Date d) {
        for(Prenotazione p: prenotazioni)
            if(p.getDate().equals(d))
                contatorePersone += p.getnAdulti()+p.getnBambini();
        return contatorePersone;
    }
    
    @Override
    public void aggiungiPrenotazione(Prenotazione p) {
        prenotazioni.add(p);
    }

    @Override
    public void rimnuoviPrenotazione(Prenotazione p) {
        prenotazioni.remove(p);
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
    public void calcoloSpesaPortate(Date d1, Date d2) {
        portateSpesa.clear();
        for(Prenotazione p: prenotazioni){
            for(Portata pt: p.getMenu().getMenuCliente()){}
                if(((p.getDate().after(d1) && p.getDate().before(d2))))
                     for(Portata portata :p.getMenu().getMenuCliente()){
                        for(Portata mc: MenuCompleto.menuCompleto){
                            int np = mc.getPortataNp();
                            if(portata.getNome().equals(mc.getNome())){
                                mc.setPortataNp(p.getnAdulti()+np);
                                portateSpesa.add(mc); 
                            }     
                        }  
                }  
           }
    }

    @Override
    public void calcoloSpesaIngredienti() {
        ingSpesa.clear();
        for(Portata p: portateSpesa){
            for(Ingredient i: p.getIngredienti()){
                boolean controllo = true;
                i.setIngredientNp(p.getPortataNp());
                int qAllIng = i.getIngredientNp();
                if(i.getName()!=null){
                       for(Ingredient is: ingSpesa){
                           int qSingleIng= is.getIngredientNp();
                            if(is.getName().equals(i.getName())){
                               is.setIngredientNp(qSingleIng+qAllIng);
                               controllo = false;
                            }
                        }if(controllo){
                            ingSpesa.add(i);
                            controllo=true;
                        }
                }         
            }
        }

    }
    
    
 }        
        