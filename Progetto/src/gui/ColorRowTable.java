/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import funzionalita.Prenotazione;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import struttura.Agriturismo;

/**
 *
 * @author luby9
 */
public class ColorRowTable extends DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
        setBackground(Color.WHITE);
       for(Prenotazione p: Agriturismo.getPrenotazioni()){
           if(o.equals(p.getCliente().getNome()) && p.getEsclusiva()==1){
               setBackground(Color.RED);
           }
           if(o.equals(p.getCliente().getNome()) && p.getDaConfermare()==1){
               setBackground(Color.YELLOW);
           }
           if(o.equals(p.getCliente().getNome()) && p.getEsigenza()==1){
               setBackground(Color.CYAN);
           }
           if(o.equals(p.getCliente().getNome()) && p.getPreferenza()==1){
               setBackground(Color.GREEN);
           }
          
       }
        
        return super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
