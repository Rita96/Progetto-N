package menu;

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

    public Portata(String nome, TipoPortata tipoPortata) {
        this.nome = nome;
        this.tipoPortata = tipoPortata;
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
