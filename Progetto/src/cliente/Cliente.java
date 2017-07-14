package cliente;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luby
 */
public class Cliente {
    private String nome;
    private long numTelefono;

    public Cliente(String nome, long numTelefono) {
        this.nome = nome;
        this.numTelefono = numTelefono;
    }

    /**
     * Ritorna il nome del cliente
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     * Setta il nome del cliente
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Ritorna il numero di telefono del cliente
     * @return
     */
    public long getNumTelefono() {
        return numTelefono;
    }

    /**
     * Setta il numero di telefono del cliente
     * @param numTelefono
     */
    public void setNumTelefono(long numTelefono) {
        this.numTelefono = numTelefono;
    }
    
}
