/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.guiPrenotazione;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luby9
 */
public class GestioneTabelle {
    DefaultTableModel dtm = new DefaultTableModel();
    String nomeSala;
    
    public GestioneTabelle(DefaultTableModel dtm, String nomeSala){
        this.dtm=dtm;
        this.nomeSala = nomeSala;
                
    }

    public DefaultTableModel getDtm() {
        return dtm;
    }
    
    public String getNomeSala(){
        return nomeSala;
    }
    
}
