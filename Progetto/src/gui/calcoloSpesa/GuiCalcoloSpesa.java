/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.calcoloSpesa;

import gui.GuiPrincipale;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import menu.Ingredient;
import menu.Portata;
import struttura.Agriturismo;

/**
 *
 * @author luby9
 */
public class GuiCalcoloSpesa extends javax.swing.JFrame {

   private Date date1;
   private Date date2;
    
    public GuiCalcoloSpesa() {
        pack();
        setLocationRelativeTo(null);
        initComponents();
        jDateChooser1.setDate(GuiPrincipale.dataOdierna);
        jDateChooser2.setDate(GuiPrincipale.dataOdierna);
    }

    public Date intervalloDate(Date d, int giorno){
        Calendar data = Calendar.getInstance();
        data.setTime(d);
        data.add(Calendar.DAY_OF_MONTH, giorno);
        return data.getTime();
    }
    public void impostaData(){
        date1 = jDateChooser1.getDate();
        date1 = GuiPrincipale.rimuoviOrarioData(date1);
        date2 = jDateChooser2.getDate();
        date2 = GuiPrincipale.rimuoviOrarioData(date2);
    }
    public void calcolaSpesaButton(){
        if(date2.before(date1)){
            JOptionPane.showMessageDialog(rootPane, "Intervallo di date non valido!");
        }else{
            date1 = intervalloDate(date1, -1);
            date2 = intervalloDate(date2, +1);
            Agriturismo agri = new Agriturismo();
        
            for(Portata p: Agriturismo.portateSpesa){
                p.setPortataNp(0);
            }
            agri.calcoloSpesaPortate(date1, date2);  
            for(Ingredient i: Agriturismo.ingSpesa){
                i.setIngredientNp(0);
            }
            agri.calcoloSpesaIngredienti();
            GuiOutputSpesa gos = new GuiOutputSpesa();
            gos.setVisible(true);
            dispose();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jButtonCalcola = new javax.swing.JButton();
        jLabelScritta = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        sfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(400, 200));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jDateChooser1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser1PropertyChange(evt);
            }
        });
        getContentPane().add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 100, 30));

        jDateChooser2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser2PropertyChange(evt);
            }
        });
        getContentPane().add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 100, 30));

        jButtonCalcola.setText("Calcola");
        jButtonCalcola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalcolaActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCalcola, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, -1, -1));

        jLabelScritta.setText("Selezionare l'intervallo di date tra cui si vuole calcolare la spesa");
        getContentPane().add(jLabelScritta, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        jLabel1.setText("A");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, -1, -1));

        jLabel2.setText("DA");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        sfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/Texture seamless parquet rovere chiaro simo-3d.jpg"))); // NOI18N
        getContentPane().add(sfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 100));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jDateChooser1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser1PropertyChange
      
    }//GEN-LAST:event_jDateChooser1PropertyChange

    private void jDateChooser2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser2PropertyChange
        
    }//GEN-LAST:event_jDateChooser2PropertyChange

    private void jButtonCalcolaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalcolaActionPerformed
        impostaData();
        calcolaSpesaButton();
    }//GEN-LAST:event_jButtonCalcolaActionPerformed

  
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCalcola;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelScritta;
    private javax.swing.JLabel sfondo;
    // End of variables declaration//GEN-END:variables
}
