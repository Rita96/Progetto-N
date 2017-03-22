package identità;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luby9
 */
public class Cliente {
    
    private String nome;
    private String tipo_evento;
    private int numero_adulti;
    private long numero_telefono;
    private int numero_bambini;
    private String pranzo_cena;

    public Cliente(String nome, String tipo_evento, int numero_adulti, long numero_telefono, int numero_bambini, String pranzo_cena) {
        this.nome = nome;
        this.tipo_evento = tipo_evento;
        this.numero_adulti = numero_adulti;
        this.numero_telefono = numero_telefono;
        this.numero_bambini = numero_bambini;
        this.pranzo_cena = pranzo_cena;
    }

    
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo_evento() {
        return tipo_evento;
    }

    public void setTipo_evento(String tipo_evento) {
        this.tipo_evento = tipo_evento;
    }

    public int getNumero_adulti() {
        return numero_adulti;
    }

    public void setNumero_adulti(int numero_adulti) {
        this.numero_adulti = numero_adulti;
    }

    public long getNumero_telefono() {
        return numero_telefono;
    }

    public void setNumero_telefono(int numero_telefono) {
        this.numero_telefono = numero_telefono;
    }

    public int getNumero_bambini() {
        return numero_bambini;
    }

    public void setNumero_bambini(int numero_bambini) {
        this.numero_bambini = numero_bambini;
    }

    public String getPranzo_cena() {
        return pranzo_cena;
    }

    public void setPranzo_cena(String pranzo_cena) {
        this.pranzo_cena = pranzo_cena;
    }
    
    
}
