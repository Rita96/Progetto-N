package cibo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luby9
 */
public class Alimenti {
    
    private String nome;
    private Tipo_Alimenti tipologia;

    public Alimenti(String nome, Tipo_Alimenti tipologia) {
        this.nome = nome;
        this.tipologia = tipologia;
    }

    public String getNome() {
        return nome;
    }

    public Enum getTipologia() {
        return tipologia;
    }
    
    
    
}
