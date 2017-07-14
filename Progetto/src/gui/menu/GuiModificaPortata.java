/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.menu;

import database.CreateDb;
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
import menu.Portata;
import menu.TipoPortata;
import struttura.Agriturismo;

/**
 *
 * @author luby9
 */
public class GuiModificaPortata extends javax.swing.JFrame {

    Agriturismo agri = new Agriturismo();

    
    String nome = null;
    TipoPortata tipoPortata = null;
    CreateDb createDb;
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
    String portata;
    
    
    
    public GuiModificaPortata() throws SQLException {
        initComponents();
        createDb = new CreateDb();
        initPortate();

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
    
    public void initPortate(){   
        for(Portata pt: MenuCompleto.menuCompleto){
            jComboPortate.addItem(pt.getNome());
        } 
    }
    
    public void initFields(){
        portata = (String)jComboPortate.getSelectedItem();
        for(Portata pt: MenuCompleto.menuCompleto ){
            try{
                if(pt.getNome().equals(portata)){
                    jIngrediente1.setText(pt.getIngredienti().get(0).getName());
                    jQnt1.setText(String.valueOf(pt.getIngredienti().get(0).getQuantity()));
                    jIngrediente2.setText(pt.getIngredienti().get(1).getName());
                    jQnt2.setText(String.valueOf(pt.getIngredienti().get(1).getQuantity()));
                    jIngrediente3.setText(pt.getIngredienti().get(2).getName());
                    jQnt3.setText(String.valueOf(pt.getIngredienti().get(2).getQuantity()));
                    jIngrediente4.setText(pt.getIngredienti().get(3).getName());
                    jQnt4.setText(String.valueOf(pt.getIngredienti().get(3).getQuantity()));
                    jIngrediente5.setText(pt.getIngredienti().get(4).getName());
                    jQnt5.setText(String.valueOf(pt.getIngredienti().get(4).getQuantity()));
                    jIngrediente6.setText(pt.getIngredienti().get(5).getName());
                    jQnt6.setText(String.valueOf(pt.getIngredienti().get(5).getQuantity()));
                    jIngrediente7.setText(pt.getIngredienti().get(6).getName());
                    jQnt7.setText(String.valueOf(pt.getIngredienti().get(6).getQuantity()));
                    jIngrediente8.setText(pt.getIngredienti().get(7).getName());
                    jQnt8.setText(String.valueOf(pt.getIngredienti().get(7).getQuantity()));
                    jIngrediente9.setText(pt.getIngredienti().get(8).getName());
                    jQnt9.setText(String.valueOf(pt.getIngredienti().get(8).getQuantity()));
                    jIngrediente10.setText(pt.getIngredienti().get(9).getName());
                    jQnt10.setText(String.valueOf(pt.getIngredienti().get(9).getQuantity()));
                    jIngrediente11.setText(pt.getIngredienti().get(10).getName());
                    jQnt11.setText(String.valueOf(pt.getIngredienti().get(10).getQuantity()));
                    jIngrediente12.setText(pt.getIngredienti().get(11).getName());
                    jQnt12.setText(String.valueOf(pt.getIngredienti().get(11).getQuantity()));
                    p=pt;
                }
            }catch(IndexOutOfBoundsException ex){}   
        }
    }
    public void getFields(){
        controllo = true; 
        try {
            p.getIngredienti().clear();
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
                createDb.modificaPortata(p);
                JOptionPane.showMessageDialog(rootPane, "Portata modificata con successo!");
            }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Non è possibile modificare la portata");
            }catch(NullPointerException e){}
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jQnt1 = new javax.swing.JTextField();
        jButtonModifica = new javax.swing.JButton();
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
        jComboPortate = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabelSfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(430, 100));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jQnt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jQnt1ActionPerformed(evt);
            }
        });
        getContentPane().add(jQnt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 40, -1));

        jButtonModifica.setText("Modifica");
        jButtonModifica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificaActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonModifica, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 84, -1));

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

        jComboPortate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboPortateActionPerformed(evt);
            }
        });
        getContentPane().add(jComboPortate, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 290, -1));

        jLabel4.setText("Quantità [g]");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 70, -1));

        jLabel2.setText("Ingrediente");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 70, -1));

        jLabel5.setText("Inserire gli ingredienti per dieci persone");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 300, -1));

        jLabelSfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/Texture seamless parquet rovere chiaro simo-3d.jpg"))); // NOI18N
        getContentPane().add(jLabelSfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonModificaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificaActionPerformed
        getFields();
    }//GEN-LAST:event_jButtonModificaActionPerformed

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

    private void jComboPortateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboPortateActionPerformed
       
        initFields();
    }//GEN-LAST:event_jComboPortateActionPerformed
        
  
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonModifica;
    private javax.swing.JComboBox<String> jComboPortate;
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelSfondo;
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
    // End of variables declaration//GEN-END:variables
}
