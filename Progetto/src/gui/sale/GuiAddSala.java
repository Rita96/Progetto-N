/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.sale;

import database.CreateDb;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import menu.TipoPortata;
import struttura.Agriturismo;
import struttura.Sala;

/**
 *
 * @author luby9
 */
public class GuiAddSala extends javax.swing.JFrame {

    Agriturismo agri = new Agriturismo();

    
    String nome = null;
    TipoPortata tipoPortata = null;
    CreateDb createDb;
    String tp = "Pranzo";
    String query = "SELECT `nome` FROM `ristorante`.`sale`";
    
    
    public GuiAddSala() throws SQLException {
        initComponents();
        setLocationRelativeTo(null);
        createDb = new CreateDb();
    }

    /**
     * Per poter aggiungere una sala
     */
    public void addButton(){
        nome = jTextFieldNome.getText(); 
        if(!nome.isEmpty()){
            if(agri.getSale().size()>=0 && agri.getSale().size()<12){
                 try {
                    createDb.addSingleSala(nome);
                    JOptionPane.showMessageDialog(rootPane, "Sala aggiunta con successo!");
                    createDb.riempiTabella(GuiInputSale.jTableSale, query);
                    agri.addSala(new Sala(nome));
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(rootPane, "La sala è già esistente");
            }
            catch(NullPointerException e){}
            }else{
                JOptionPane.showMessageDialog(rootPane, "Il numero massimo di sale è stato raggiunto!");
                agri.getSale().clear();
            }
        }else 
            JOptionPane.showMessageDialog(rootPane, "Non hai inserito nulla!");
        jTextFieldNome.setText("");
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldNome = new javax.swing.JTextField();
        jLabelNome = new javax.swing.JLabel();
        jButtonAdd = new javax.swing.JButton();
        jLabelSfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(430, 100));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 25, 292, -1));

        jLabelNome.setText("Nome");
        getContentPane().add(jLabelNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 5, -1, -1));

        jButtonAdd.setText("Aggiungi");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 56, 84, -1));

        jLabelSfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/Texture seamless parquet rovere chiaro simo-3d.jpg"))); // NOI18N
        getContentPane().add(jLabelSfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 90));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        addButton();
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jTextFieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeActionPerformed
        
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelSfondo;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables
}
