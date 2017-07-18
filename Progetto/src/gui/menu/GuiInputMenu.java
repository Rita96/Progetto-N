/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.menu;

import database.CreateDb;
import gui.GuiPrincipale;
import gui.nome.GuiNome;
import gui.sale.GuiInputSale;
import gui.sale.GuiSetSale;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
public class GuiInputMenu extends javax.swing.JFrame {

//     public DefaultTableModel jtm = null;
     GuiAddPortata guiAddPortata;
     CreateDb createDb;
     
    
    public GuiInputMenu() throws SQLException {
        initComponents();
        setLocationRelativeTo(null);
        guiAddPortata = new GuiAddPortata();
        createDb = new CreateDb();
        imprevisto();
    }
    
    /**
     * Interviene quando si esce prematuramente dal programma o ci sono problemi di connessione col db
     */
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
    
    /**
     * Ti permette di tornare alla pagina precedente
     */
    public void indietroButton(){
        dispose();
        GuiSetMenu guiSetMenu;
         try {
             guiSetMenu = new GuiSetMenu();
             guiSetMenu.setVisible(true);
         } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Errore in SQL");
         }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMenu = new javax.swing.JTable();
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
        getContentPane().add(jButtonAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, 30));

        jTableMenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableMenu.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTableMenuPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(jTableMenu);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 300, 232));

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
        guiAddPortata.setVisible(true);
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jTableMenuPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTableMenuPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableMenuPropertyChange

    private void jButtonIndietroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIndietroActionPerformed
        indietroButton();  
    }//GEN-LAST:event_jButtonIndietroActionPerformed

    private void jButtonAvantiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAvantiActionPerformed
         try {
                dispose();
                guiAddPortata.dispose();
                createDb.createTablePrenotazioni();
                GuiPrincipale guiProva = new GuiPrincipale();
                guiProva.setVisible(true);
         } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Problemi con il Database");
         }
        
        
    }//GEN-LAST:event_jButtonAvantiActionPerformed

    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonAvanti;
    private javax.swing.JButton jButtonIndietro;
    private javax.swing.JLabel jLabelSfondo;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTableMenu;
    // End of variables declaration//GEN-END:variables
}
