/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.sale;

import gui.menu.*;
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
import menu.Portata;
import menu.TipoPortata;
import struttura.Agriturismo;

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
    String query = "SELECT `nome` FROM `"+agri.getNome()+"`.`sale`";
    
    
    public GuiAddSala() throws SQLException {
        initComponents();
        createDb = new CreateDb();
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

        jLabelSfondo.setIcon(new javax.swing.ImageIcon("C:\\Users\\luby9\\Desktop\\WKNetBeans\\Progetto-N\\Progetto\\sfondi\\wood-background-911074_960_720.jpg")); // NOI18N
        getContentPane().add(jLabelSfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 90));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        nome = jTextFieldNome.getText();
        
        if(!nome.isEmpty()){
            try {
                createDb.addSingleSala(nome);
                JOptionPane.showMessageDialog(rootPane, "Sala aggiunta con successo!");
                createDb.riempiTabella(GuiInputSale.jTableSale, query);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Errore in SQL");
            }
        }
        else {
            JOptionPane.showMessageDialog(rootPane, "Non hai inserito nulla!");
        }
        
    }//GEN-LAST:event_jButtonAddActionPerformed
        
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelSfondo;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables
}
