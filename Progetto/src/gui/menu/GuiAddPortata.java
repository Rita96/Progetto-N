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
public class GuiAddPortata extends javax.swing.JFrame {

    Agriturismo agri = new Agriturismo();

    
    String nome = null;
    TipoPortata tipoPortata = null;
    CreateDb createDb;
    String tp = "Pranzo";
    String query = "SELECT ` nome portata`,`tipo portata` FROM `ristorante`.`menu`";
    
    
    public GuiAddPortata() throws SQLException {
        initComponents();
        createDb = new CreateDb();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldNome = new javax.swing.JTextField();
        jLabelNome = new javax.swing.JLabel();
        jLabelTipoPortata = new javax.swing.JLabel();
        jComboBoxTipoPortata = new javax.swing.JComboBox<>();
        jButtonAdd = new javax.swing.JButton();
        jLabelSfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(430, 100));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jTextFieldNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 25, 292, -1));

        jLabelNome.setText("Nome");
        getContentPane().add(jLabelNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 5, -1, -1));

        jLabelTipoPortata.setText("Tipo");
        getContentPane().add(jLabelTipoPortata, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 5, -1, -1));

        jComboBoxTipoPortata.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Primo", "Secondo", "Dolce" }));
        jComboBoxTipoPortata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoPortataActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxTipoPortata, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 25, 83, -1));

        jButtonAdd.setText("Aggiungi");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(321, 56, 84, -1));

        jLabelSfondo.setIcon(new javax.swing.ImageIcon("C:\\Users\\luby9\\Desktop\\WKNetBeans\\Progetto-N\\Progetto\\sfondi\\sfondo chiaro.jpg")); // NOI18N
        getContentPane().add(jLabelSfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 90));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
       
        
        tp = (String) jComboBoxTipoPortata.getSelectedItem();
        nome = jTextFieldNome.getText();
        
        if(!nome.isEmpty()){
            this.tipoPortata = getTipoPortata();
            try {
                createDb.addSinglePortata(nome, tipoPortata);
                JOptionPane.showMessageDialog(rootPane, "Portata aggiunta con successo!");
                createDb.riempiTabella(GuiInputMenu.jTableMenu, query);
                ModificaMenu.addElementoMenu(new Portata(nome, TipoPortata.valueOf(tp)));
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Errore in SQL");
            }
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "Non hai inserito nulla!");
        }
        
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jComboBoxTipoPortataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoPortataActionPerformed
        

    }//GEN-LAST:event_jComboBoxTipoPortataActionPerformed
        
    public TipoPortata getTipoPortata(){
        if(tp.equals(TipoPortata.Primo.toString()))
            tipoPortata = TipoPortata.Primo;
        if(tp.equals(TipoPortata.Secondo.toString()))
            tipoPortata = TipoPortata.Secondo;
        if(tp.equals(TipoPortata.Dolce.toString()))
            tipoPortata = TipoPortata.Dolce;
        
        return tipoPortata;
    }
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private static javax.swing.JComboBox<String> jComboBoxTipoPortata;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelSfondo;
    private javax.swing.JLabel jLabelTipoPortata;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables
}
