/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.sale;

import database.CreateDb;
import gui.menu.*;
import gui.nome.GuiNome;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author luby9
 */
public class GuiInputSale extends javax.swing.JFrame {

     GuiAddSala guiAddSala;
     CreateDb createDb;
     
     
    
    public GuiInputSale() throws SQLException {
        initComponents();
        guiAddSala = new GuiAddSala();
        createDb = new CreateDb();
        imprevisto();
    }
    public void imprevisto(){
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                int i = JOptionPane.showConfirmDialog(rootPane, "Sei sicuro di voler uscire?");
                if(i==JOptionPane.YES_OPTION){
                    try {
                        createDb.DropSchema();
                        dispose();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(rootPane, "Impossibile raggiungere il Database!");
                    }  
                }else
                    setDefaultCloseOperation(GuiNome.DO_NOTHING_ON_CLOSE);
            }
        });
    }
    public void indietroButton(){
        dispose();
        GuiSetSale guiSetSale;
        try {
            guiSetSale = new GuiSetSale();
            guiSetSale.setVisible(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Errore in SQL");
        }

    }
    public void avantiButton(){
        try {
             if(createDb.verificaTabella("sale")>0 && createDb.verificaTabella("sale")<13){
                 try {
                     GuiInformationMenu guiInformationMenu = new GuiInformationMenu();
                     dispose();
                     guiInformationMenu.setVisible(true);
                     guiAddSala.dispose();
                 } catch (SQLException ex) {
                     JOptionPane.showMessageDialog(rootPane, "Sala già esistente");
                 }
             }
             else
                JOptionPane.showMessageDialog(rootPane, "Il numero di sale inserito non è valido!");
                 } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Problemi con il Database");
            }
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

        jLabelSfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/Texture seamless parquet rovere chiaro simo-3d.jpg"))); // NOI18N
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
         avantiButton();
    }//GEN-LAST:event_jButtonAvantiActionPerformed

    private void jButtonIndietroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIndietroActionPerformed
       indietroButton();
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
