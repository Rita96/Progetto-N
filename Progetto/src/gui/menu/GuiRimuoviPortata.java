/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.menu;

import databse.CreateDb;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import menu.MenuCompleto;
import menu.ModificaMenu;
import menu.Portata;
import menu.TipoPortata;
import struttura.Agriturismo;

/**
 *
 * @author luby9
 */
public class GuiRimuoviPortata extends javax.swing.JFrame {

    Agriturismo agri = new Agriturismo();
    CreateDb createDb;

    
    
    public GuiRimuoviPortata() throws SQLException {
        initComponents();
        createDb = new CreateDb();
        riempiItemPortate();
    }

   public void riempiItemPortate(){
       for(Portata p :MenuCompleto.menuCompleto){
            jComboBoxPortate.addItem(p.getNome());
      }
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonRimuovi = new javax.swing.JButton();
        jComboBoxPortate = new javax.swing.JComboBox<>();
        jLabelSfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(430, 100));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonRimuovi.setText("Rimuovi");
        jButtonRimuovi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRimuoviActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRimuovi, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 84, -1));

        jComboBoxPortate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPortateActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxPortate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 270, -1));

        jLabelSfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/Texture seamless parquet rovere chiaro simo-3d.jpg"))); // NOI18N
        getContentPane().add(jLabelSfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 90));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRimuoviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRimuoviActionPerformed
        String portata = (String) jComboBoxPortate.getSelectedItem();
        int choose = JOptionPane.showConfirmDialog(rootPane, "Vuoi cancellare la portata "+portata+" ?");
        if(choose==JOptionPane.YES_OPTION){
            try {
                for(int i=0;i<MenuCompleto.menuCompleto.size();i++){
                    if(portata.equals(MenuCompleto.menuCompleto.get(i).getNome()))
                    MenuCompleto.menuCompleto.remove(i);
                }
                createDb.deletePortataFromMenu(portata);
                JOptionPane.showMessageDialog(rootPane, "Portata cancellata!");
                dispose();
            
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Impossibile connettersi al Database!");
            }
        }
        
        
     
    }//GEN-LAST:event_jButtonRimuoviActionPerformed

    private void jComboBoxPortateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPortateActionPerformed
         
    }//GEN-LAST:event_jComboBoxPortateActionPerformed
  
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonRimuovi;
    private javax.swing.JComboBox<String> jComboBoxPortate;
    private javax.swing.JLabel jLabelSfondo;
    // End of variables declaration//GEN-END:variables
}
