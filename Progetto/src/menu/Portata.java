package menu;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luby
 */
public class Portata {
    private String nome;
    private TipoPortata tipoPortata;
    private ArrayList<Ingredient> ingredienti;
    private int portataNp = 0;

    public int getPortataNp() {
        return portataNp;
    }

    public void setPortataNp(int portataNp) {
        this.portataNp = portataNp;
    }

    public ArrayList<Ingredient> getIngredienti() {
        return ingredienti;
    }

    public void setIngredienti(ArrayList<Ingredient> ingredienti) {
        this.ingredienti = ingredienti;
    }

    public Portata(String nome, TipoPortata tipoPortata) {
        this.nome = nome;
        this.tipoPortata = tipoPortata;
        ingredienti = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoPortata getTipoPortata() {
        return tipoPortata;
    }

    public void setTipoPortata(TipoPortata tipoPortata) {
        this.tipoPortata = tipoPortata;
    }

    
    
}
