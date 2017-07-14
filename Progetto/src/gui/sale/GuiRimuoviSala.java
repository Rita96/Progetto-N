/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.sale;

import gui.menu.*;
import database.CreateDb;
import funzionalita.Prenotazione;
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
import menu.Portata;
import menu.TipoPortata;
import struttura.Agriturismo;
import struttura.Sala;

/**
 *
 * @author luby9
 */
public class GuiRimuoviSala extends javax.swing.JFrame {

    Agriturismo agri = new Agriturismo();
    CreateDb createDb;
   
    public GuiRimuoviSala() throws SQLException {
        initComponents();
        createDb = new CreateDb();
        riempiItemSala();
    }

   public void riempiItemSala(){
       for(Sala s :agri.getSale()){
            jComboBoxSala.addItem(s.getNome());
      }
   }
   
   public void refreshSalaDeleted(String sala) throws SQLException{
       for(Prenotazione p:agri.getPrenotazione()){
           if(p.getSala().getNome().equals(sala)){
               p.setSala(new Sala("Indifferente"));
               createDb.refreshSalaDeletedDb(sala);
           }
       }
   }
   
   public void removeSala(){
       String sala = (String) jComboBoxSala.getSelectedItem();
       int choose = JOptionPane.showConfirmDialog(rootPane, "Vuoi cancellare la portata "+sala+" ?");
        if(choose==JOptionPane.YES_OPTION){
            try {
                for(int i=0;i<agri.getSale().size();i++){
                    if(sala.equals(agri.getSale().get(i).getNome()))
                    agri.removeSala(agri.getSale().get(i));
                }
                refreshSalaDeleted(sala);
                createDb.deleteSalaFromDb(sala);
                JOptionPane.showMessageDialog(rootPane, "Sala cancellata!");
                JOptionPane.showMessageDialog(rootPane, "Le modifiche saranno disponibili dopo il riavvio del programma!");
                dispose();
            
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Impossibile connettersi al Database!");
            }
        }
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonRimuovi = new javax.swing.JButton();
        jComboBoxSala = new javax.swing.JComboBox<>();
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

        jComboBoxSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSalaActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 270, -1));

        jLabelSfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/Texture seamless parquet rovere chiaro simo-3d.jpg"))); // NOI18N
        getContentPane().add(jLabelSfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 90));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRimuoviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRimuoviActionPerformed
        removeSala();
    }//GEN-LAST:event_jButtonRimuoviActionPerformed

    private void jComboBoxSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSalaActionPerformed
         
    }//GEN-LAST:event_jComboBoxSalaActionPerformed
  
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonRimuovi;
    private javax.swing.JComboBox<String> jComboBoxSala;
    private javax.swing.JLabel jLabelSfondo;
    // End of variables declaration//GEN-END:variables
}
