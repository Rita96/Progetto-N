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
import menu.Ingredient;
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
    Portata p;
    
    String ing1;
    int qnt1;
    String ing2;
    int qnt2;
    String ing3;
    int qnt3;
    String ing4;
    int qnt4;
    String ing5;
    int qnt5;
    String ing6;
    int qnt6;
    String ing7;
    int qnt7;
    String ing8;
    int qnt8;
    String ing9;
    int qnt9;
    String ing10;
    int qnt10;
    String ing11;
    int qnt11;
    String ing12;
    int qnt12;
    private boolean controllo = true;
    
    
    
    public GuiAddPortata() throws SQLException {
        initComponents();
        createDb = new CreateDb();
    }

    public void setQntIng(JTextField jIng, JTextField jQnt, String ing, int qnt){
         try{
             if(jIng.getText().isEmpty() || jQnt.getText().isEmpty()){
                ing=null;
                qnt=0;
            }else{
                ing = jIng.getText();
                qnt = Integer.valueOf(jQnt.getText());
                p.getIngredienti().add(new Ingredient(ing, qnt));
            }

         }catch(NumberFormatException ex){
             JOptionPane.showMessageDialog(rootPane,"Quantità non valida!");
             controllo = false;
         }
    }
    public void initFild(){
       jTextFieldNome.setText("");
       jIngrediente1.setText("");
       jQnt1.setText("");
       jIngrediente2.setText("");
       jQnt2.setText("");
       jIngrediente3.setText("");
       jQnt3.setText("");
       jIngrediente4.setText("");
       jQnt4.setText("");
       jIngrediente5.setText("");
       jQnt5.setText("");
       jIngrediente6.setText("");
       jQnt6.setText("");
       jIngrediente7.setText("");
       jQnt7.setText("");
       jIngrediente8.setText("");
       jQnt8.setText("");
       jIngrediente9.setText("");
       jQnt9.setText("");
       jIngrediente10.setText("");
       jQnt10.setText("");
       jIngrediente11.setText("");
       jQnt11.setText("");
       jIngrediente12.setText("");
       jQnt12.setText("");
    }
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldNome = new javax.swing.JTextField();
        jLabelNome = new javax.swing.JLabel();
        jLabelTipoPortata = new javax.swing.JLabel();
        jComboBoxTipoPortata = new javax.swing.JComboBox<>();
        jQnt1 = new javax.swing.JTextField();
        jButtonAdd = new javax.swing.JButton();
        jIngrediente2 = new javax.swing.JTextField();
        jQnt2 = new javax.swing.JTextField();
        jIngrediente3 = new javax.swing.JTextField();
        jQnt3 = new javax.swing.JTextField();
        jIngrediente4 = new javax.swing.JTextField();
        jQnt4 = new javax.swing.JTextField();
        jIngrediente5 = new javax.swing.JTextField();
        jQnt5 = new javax.swing.JTextField();
        jIngrediente6 = new javax.swing.JTextField();
        jQnt6 = new javax.swing.JTextField();
        jIngrediente1 = new javax.swing.JTextField();
        jQnt7 = new javax.swing.JTextField();
        jIngrediente8 = new javax.swing.JTextField();
        jQnt8 = new javax.swing.JTextField();
        jIngrediente9 = new javax.swing.JTextField();
        jQnt9 = new javax.swing.JTextField();
        jIngrediente10 = new javax.swing.JTextField();
        jQnt10 = new javax.swing.JTextField();
        jIngrediente11 = new javax.swing.JTextField();
        jQnt11 = new javax.swing.JTextField();
        jIngrediente12 = new javax.swing.JTextField();
        jQnt12 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jIngrediente7 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelNome1 = new javax.swing.JLabel();
        jLabelSfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(430, 100));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jTextFieldNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 25, 292, -1));

        jLabelNome.setText("Inserire gli ingredienti per dieci persone");
        getContentPane().add(jLabelNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, -1));

        jLabelTipoPortata.setText("Tipo");
        getContentPane().add(jLabelTipoPortata, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 5, -1, -1));

        jComboBoxTipoPortata.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Primo", "Secondo", "Dolce" }));
        jComboBoxTipoPortata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoPortataActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxTipoPortata, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 25, 83, -1));

        jQnt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jQnt1ActionPerformed(evt);
            }
        });
        getContentPane().add(jQnt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 40, -1));

        jButtonAdd.setText("Aggiungi");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 84, -1));

        jIngrediente2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jIngrediente2ActionPerformed(evt);
            }
        });
        getContentPane().add(jIngrediente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 90, -1));

        jQnt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jQnt2ActionPerformed(evt);
            }
        });
        getContentPane().add(jQnt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 40, -1));
        getContentPane().add(jIngrediente3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 90, 20));

        jQnt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jQnt3ActionPerformed(evt);
            }
        });
        getContentPane().add(jQnt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 40, 20));
        getContentPane().add(jIngrediente4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 90, -1));
        getContentPane().add(jQnt4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 40, -1));

        jIngrediente5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jIngrediente5ActionPerformed(evt);
            }
        });
        getContentPane().add(jIngrediente5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 90, -1));

        jQnt5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jQnt5ActionPerformed(evt);
            }
        });
        getContentPane().add(jQnt5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 40, -1));
        getContentPane().add(jIngrediente6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 90, -1));
        getContentPane().add(jQnt6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 40, -1));

        jIngrediente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jIngrediente1ActionPerformed(evt);
            }
        });
        getContentPane().add(jIngrediente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 90, -1));

        jQnt7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jQnt7ActionPerformed(evt);
            }
        });
        getContentPane().add(jQnt7, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, 40, -1));
        getContentPane().add(jIngrediente8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 90, -1));
        getContentPane().add(jQnt8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, 40, -1));
        getContentPane().add(jIngrediente9, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 90, 20));
        getContentPane().add(jQnt9, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, 40, 20));
        getContentPane().add(jIngrediente10, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 90, -1));

        jQnt10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jQnt10ActionPerformed(evt);
            }
        });
        getContentPane().add(jQnt10, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, 40, -1));
        getContentPane().add(jIngrediente11, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 90, -1));

        jQnt11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jQnt11ActionPerformed(evt);
            }
        });
        getContentPane().add(jQnt11, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, 40, -1));
        getContentPane().add(jIngrediente12, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, 90, -1));
        getContentPane().add(jQnt12, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, 40, -1));

        jLabel1.setText("Quantità [g]");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 70, -1));
        getContentPane().add(jIngrediente7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 90, -1));

        jLabel3.setText("Ingrediente");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 70, -1));

        jLabel4.setText("Quantità [g]");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 70, -1));

        jLabel2.setText("Ingrediente");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 70, -1));

        jLabelNome1.setText("Nome");
        getContentPane().add(jLabelNome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabelSfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/Texture seamless parquet rovere chiaro simo-3d.jpg"))); // NOI18N
        getContentPane().add(jLabelSfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        controllo = true;
        tp = (String) jComboBoxTipoPortata.getSelectedItem();
        nome = jTextFieldNome.getText();
        
        if(!nome.isEmpty()){
            this.tipoPortata = getTipoPortata();
            try {
                p= new Portata(nome, tipoPortata);
                setQntIng(jIngrediente1, jQnt1, ing1, qnt1);
                setQntIng(jIngrediente2, jQnt2, ing2, qnt2);
                setQntIng(jIngrediente3, jQnt3, ing3, qnt3);
                setQntIng(jIngrediente4, jQnt4, ing4, qnt4);
                setQntIng(jIngrediente5, jQnt5, ing5, qnt5);
                setQntIng(jIngrediente6, jQnt6, ing6, qnt6);
                setQntIng(jIngrediente7, jQnt7, ing7, qnt7);
                setQntIng(jIngrediente8, jQnt8, ing8, qnt8);
                setQntIng(jIngrediente9, jQnt9, ing9, qnt9);
                setQntIng(jIngrediente10, jQnt10, ing10, qnt10);
                setQntIng(jIngrediente11, jQnt11, ing11, qnt11);
                setQntIng(jIngrediente12, jQnt12, ing12, qnt12);
                if(controllo){
                    createDb.addSinglePortata(p);
                    JOptionPane.showMessageDialog(rootPane, "Portata aggiunta con successo!");
                    createDb.riempiTabella(GuiInputMenu.jTableMenu, query);
                    MenuCompleto.menuCompleto.add(p);
                    initFild();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "La portata esiste già!");
            }catch(NullPointerException e){}
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "Non hai inserito nulla!");
        }
        if(controllo)
            initFild();
        
        
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jComboBoxTipoPortataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoPortataActionPerformed
        

    }//GEN-LAST:event_jComboBoxTipoPortataActionPerformed

    private void jIngrediente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jIngrediente1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jIngrediente1ActionPerformed

    private void jIngrediente2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jIngrediente2ActionPerformed
       
    }//GEN-LAST:event_jIngrediente2ActionPerformed

    private void jIngrediente5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jIngrediente5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jIngrediente5ActionPerformed

    private void jQnt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jQnt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jQnt1ActionPerformed

    private void jQnt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jQnt3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jQnt3ActionPerformed

    private void jQnt5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jQnt5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jQnt5ActionPerformed

    private void jQnt7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jQnt7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jQnt7ActionPerformed

    private void jQnt10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jQnt10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jQnt10ActionPerformed

    private void jQnt11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jQnt11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jQnt11ActionPerformed

    private void jQnt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jQnt2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jQnt2ActionPerformed
        
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
    private javax.swing.JTextField jIngrediente1;
    private javax.swing.JTextField jIngrediente10;
    private javax.swing.JTextField jIngrediente11;
    private javax.swing.JTextField jIngrediente12;
    private javax.swing.JTextField jIngrediente2;
    private javax.swing.JTextField jIngrediente3;
    private javax.swing.JTextField jIngrediente4;
    private javax.swing.JTextField jIngrediente5;
    private javax.swing.JTextField jIngrediente6;
    private javax.swing.JTextField jIngrediente7;
    private javax.swing.JTextField jIngrediente8;
    private javax.swing.JTextField jIngrediente9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelNome1;
    private javax.swing.JLabel jLabelSfondo;
    private javax.swing.JLabel jLabelTipoPortata;
    private javax.swing.JTextField jQnt1;
    private javax.swing.JTextField jQnt10;
    private javax.swing.JTextField jQnt11;
    private javax.swing.JTextField jQnt12;
    private javax.swing.JTextField jQnt2;
    private javax.swing.JTextField jQnt3;
    private javax.swing.JTextField jQnt4;
    private javax.swing.JTextField jQnt5;
    private javax.swing.JTextField jQnt6;
    private javax.swing.JTextField jQnt7;
    private javax.swing.JTextField jQnt8;
    private javax.swing.JTextField jQnt9;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables
}
