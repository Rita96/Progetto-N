package cibo;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luby9
 */
public class Menu {
    
    public String note;
    public ArrayList<Alimenti> alimenti_menu_singolo = new ArrayList<>();
    public ArrayList<Alimenti> alimenti = new ArrayList<>();
    public int numero_portate;

    public Menu() {
    }

    public ArrayList<Alimenti> getAlimenti() {
        return alimenti;
       
    }

    public int getNumero_portate() {
        return numero_portate;
    }

    public Menu(ArrayList<Alimenti> alimenti_menu_singolo, String note) {
        this.note = note;
        this.alimenti=alimenti;
        this.alimenti_menu_singolo=alimenti_menu_singolo;
    }

    public String getNote() {
        return note;
    }

    public String setNote() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci note: ");
        note = scanner.next();
       return note;
    }
    
    
    public ArrayList<Alimenti> scegli_alimenti(){
        alimenti.add(new Alimenti("risotto trevisana e scamorza", Tipo_Alimenti.Primo));  
        int i = 0;
        System.out.println("Scegli: ");
        for(Alimenti a: alimenti){
            System.out.println(i+") "+ a.getNome());
            i++;
        }
        System.out.println("Quante portate vuoi?: ");
        Scanner scanner = new Scanner(System.in);
        int numero_portate = scanner.nextInt();
        System.out.println("Seleziona il numero di portata");
        int portata = 0;
        for(int j = 0;j<numero_portate;j++){
            portata = scanner.nextInt();
            alimenti_menu_singolo.add(alimenti.get(portata));
            System.out.println("Hai selezionato "+ alimenti.get(portata).getNome());
        }
        return alimenti_menu_singolo;
    }

    public ArrayList<Alimenti> getAlimenti_menu_singolo() {
        return alimenti_menu_singolo;
    }
    
    
    public void aggiungielementoMenu(){
        alimenti.add(new Alimenti("risotto trevisana e scamorza", Tipo_Alimenti.Primo));      
        alimenti.add(new Alimenti("risotto funghi", Tipo_Alimenti.Primo));
        alimenti.add(new Alimenti("risotto salsiccia", Tipo_Alimenti.Primo));
        alimenti.add(new Alimenti("Tagliata di scottona al pepe nero", Tipo_Alimenti.Secondo));
        alimenti.add(new Alimenti("Carpaccio di filetto con scaglie di grana", Tipo_Alimenti.Secondo));
        alimenti.add(new Alimenti("Carpaccio di filetto con scaglie di grana", Tipo_Alimenti.Secondo));
        alimenti.add(new Alimenti("Roastbeef all’inglese", Tipo_Alimenti.Secondo));
        alimenti.add(new Alimenti("crostata della casa", Tipo_Alimenti.Dolce));


    }
    
    public void rimuovielementoMenu(){
    
    }
    
}
