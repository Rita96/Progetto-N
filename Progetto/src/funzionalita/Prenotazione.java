package funzionalita;

import cliente.Cliente;
import java.util.Date;
import menu.MenuCliente;
import struttura.Sala;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luby
 */
public class Prenotazione {
    private Sala sala;
    private int nAdulti;
    private int nBambini;
    private Date date;
    private String tipoEvento;
    private String note;
    private MenuCliente menu;
    private String pasto;
    private Cliente cliente;

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public int getnAdulti() {
        return nAdulti;
    }

    public void setnAdulti(int nAdulti) {
        this.nAdulti = nAdulti;
    }

    public int getnBambini() {
        return nBambini;
    }

    public void setnBambini(int nBambini) {
        this.nBambini = nBambini;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public MenuCliente getMenu() {
        return menu;
    }

    public void setMenu(MenuCliente menu) {
        this.menu = menu;
    }

    public String getPasto() {
        return pasto;
    }

    public void setPasto(String pasto) {
        this.pasto = pasto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
}
