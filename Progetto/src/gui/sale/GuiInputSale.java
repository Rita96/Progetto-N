/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.sale;

import gui.menu.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import menu.MenuCompleto;
import menu.Portata;

/**
 *
 * @author luby9
 */
public class GuiInputSale extends javax.swing.JFrame {

//     public DefaultTableModel jtm = null;
     GuiAddSala guiAddSala;
     
     
    
    public GuiInputSale() throws SQLException {
        initComponents();
        guiAddSala = new GuiAddSala();
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSale = new javax.swing.JTable();
        jButtonAvanti = new javax.swing.JButton();
        jButtonIndietro = new javax.swing.JButton();
        jLabelSfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(400, 200));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonAdd.setText("+");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 22, -1, -1));

        jTableSale.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableSale.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTableSalePropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(jTableSale);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 310, 232));

        jButtonAvanti.setText("Avanti");
        jButtonAvanti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAvantiActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAvanti, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, 70, -1));

        jButtonIndietro.setText("Indietro");
        jButtonIndietro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIndietroActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonIndietro, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, -1, -1));

        jLabelSfondo.setIcon(new javax.swing.ImageIcon("C:\\Users\\luby9\\Desktop\\wood-background-911074_960_720.jpg")); // NOI18N
        getContentPane().add(jLabelSfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        guiAddSala.setVisible(true);
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jTableSalePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTableSalePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableSalePropertyChange

    private void jButtonAvantiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAvantiActionPerformed
         try {
             GuiInformationMenu guiInformationMenu = new GuiInformationMenu();
             dispose();
             guiInformationMenu.setVisible(true);
         } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Errore in SQL");
         }
        
       
    }//GEN-LAST:event_jButtonAvantiActionPerformed

    private void jButtonIndietroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIndietroActionPerformed
        dispose();
        GuiSetSale guiSetSale;
         try {
             guiSetSale = new GuiSetSale();
             guiSetSale.setVisible(true);
         } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Errore in SQL");
         }
        
    }//GEN-LAST:event_jButtonIndietroActionPerformed

    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonAvanti;
    private javax.swing.JButton jButtonIndietro;
    private javax.swing.JLabel jLabelSfondo;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTableSale;
    // End of variables declaration//GEN-END:variables
}
