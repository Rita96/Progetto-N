/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.nome;

import gui.sale.GuiInformationSale;
import databse.CreateDb;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import struttura.Agriturismo;
import exception.ExeptionNome;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author luby9
 */
public class GuiNome extends javax.swing.JFrame {

    private String warning = "Non hai inserito il nome del ristorante";
    
    /**
     * Creates new form GuiNome
     */
    public GuiNome() {
        initComponents();
        imprevisto();
    }

    public void imprevisto(){
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                int i = JOptionPane.showConfirmDialog(rootPane, "Sei sicuro di voler uscire?");
                if(i==JOptionPane.YES_OPTION){
                    try {
                        CreateDb createDb = new CreateDb();
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
    public void avantiButton(){
         String nome = jTextNome.getText();
        if(nome.isEmpty())
            JOptionPane.showMessageDialog(rootPane, warning);
        else{ 
         Agriturismo agri = new Agriturismo();
         agri.setNome(nome);
            try {
                CreateDb createDb = new CreateDb();
                createDb.CreateSchema();
                createDb.createTableDatiRistorante();
                createDb.insertDatiRistorante();
                dispose();
            } catch (SQLException ex) {
                JOptionPane.showConfirmDialog(rootPane, "Errore nel database !");
            }
         GuiInformationSale guiInformation;
            try {
                guiInformation = new GuiInformationSale();
                guiInformation.setVisible(true);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Errore in SQL !");
            }
        } 
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jTextNome = new javax.swing.JTextField();
        jButtonAvanti = new javax.swing.JButton();
        jLabelSfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(400, 200));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Gill Sans MT", 1, 24)); // NOI18N
        jLabel2.setText("NOME DEL RISTORANTE");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 310, 28));

        jTextNome.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jTextNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNomeActionPerformed(evt);
            }
        });
        getContentPane().add(jTextNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 114, 279, 41));

        jButtonAvanti.setText("Avanti");
        jButtonAvanti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAvantiActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAvanti, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, -1, -1));

        jLabelSfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/Texture seamless parquet rovere chiaro simo-3d.jpg"))); // NOI18N
        getContentPane().add(jLabelSfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNomeActionPerformed

    private void jButtonAvantiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAvantiActionPerformed
        avantiButton();
    }//GEN-LAST:event_jButtonAvantiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAvanti;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelSfondo;
    private javax.swing.JTextField jTextNome;
    // End of variables declaration//GEN-END:variables
}
