package funzionalita;

import cliente.Cliente;
import java.text.SimpleDateFormat;
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
    private int attesa;
    private int daConfermare;
    private int esclusiva;
    private int preferenza;
    private int esigenza;
    private String dateDb;

    public int getAttesa() {
        return attesa;
    }

    public void setAttesa(int attesa) {
        this.attesa = attesa;
    }

    public int getDaConfermare() {
        return daConfermare;
    }

    public void setDaConfermare(int daConfermare) {
        this.daConfermare = daConfermare;
    }

    public int getEsclusiva() {
        return esclusiva;
    }

    public void setEsclusiva(int esclusiva) {
        this.esclusiva = esclusiva;
    }

    public int getPreferenza() {
        return preferenza;
    }

    public void setPreferenza(int preferenza) {
        this.preferenza = preferenza;
    }

    public int getEsigenza() {
        return esigenza;
    }

    public void setEsigenza(int esigenza) {
        this.esigenza = esigenza;
    }


    
    public Prenotazione(int nAdulti, Date date, String pasto, Cliente cliente) {
        this.nAdulti = nAdulti;
        this.date = date;
        this.pasto = pasto;
        this.cliente = cliente;
    }

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
    
    public void setDateDb(Date d){
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyyy-MM-dd");
        dateDb = sdf.format(d);
    }
    public String getDateDb(){
        return dateDb;
    }
    
    
}
