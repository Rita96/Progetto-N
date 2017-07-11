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
public class PersonalTableModel extends DefaultTableModel{
    
    

    @Override
    public boolean isCellEditable(int i, int i1) {       
            return false;
        
    }
       
}
