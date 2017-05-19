package gui.menu;


import databse.CreateDb;
import gui.FileChooser;
import gui.sale.GuiInformationSale;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lettura.LeggiPortate;
import menu.MenuCompleto;
import struttura.Agriturismo;
import struttura.Sala;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luby9
 */
public class GuiSetMenu extends javax.swing.JFrame {
//fare guiinputmenu
    
    private FileChooser fileChooser;
    CreateDb createDb;
    private GuiInputMenu guiInputMenu;
    private LeggiPortate leggiPortate = new LeggiPortate();
    
    public GuiSetMenu() throws SQLException {
        initComponents();
        fileChooser = new FileChooser();
        createDb = new CreateDb();
        guiInputMenu = new GuiInputMenu();
        createDb.createTableMenu();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonAvanti = new javax.swing.JButton();
        jButtonFileChooser = new javax.swing.JButton();
        jCheckBoxMenuGui = new javax.swing.JCheckBox();
        jCheckBoxFile = new javax.swing.JCheckBox();
        jButtonIndietro = new javax.swing.JButton();
        jLabelSfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(400, 200));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonAvanti.setText("Avanti");
        jButtonAvanti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAvantiActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAvanti, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 260, 70, -1));

        jButtonFileChooser.setText("Importa");
        jButtonFileChooser.setEnabled(false);
        jButtonFileChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFileChooserActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonFileChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, -1, -1));

        jCheckBoxMenuGui.setText(" Inserisci il menu da interfaccia grafica.");
        jCheckBoxMenuGui.setOpaque(false);
        jCheckBoxMenuGui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuGuiActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBoxMenuGui, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jCheckBoxFile.setText(" Importa menu da file di testo");
        jCheckBoxFile.setOpaque(false);
        jCheckBoxFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxFileActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBoxFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 260, -1));

        jButtonIndietro.setText("Indietro");
        jButtonIndietro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIndietroActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonIndietro, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, -1, -1));

        jLabelSfondo.setIcon(new javax.swing.ImageIcon("C:\\Users\\luby9\\Desktop\\menu_gran_mattino.png")); // NOI18N
        getContentPane().add(jLabelSfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAvantiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAvantiActionPerformed
      

        if(jCheckBoxMenuGui.isSelected()){
            guiInputMenu.setVisible(true);
            dispose();         
        }
   
        
        if(jCheckBoxFile.isSelected()){
            jButtonFileChooser.setEnabled(true);
            try {  
            leggiPortate.letturaPortate(fileChooser.getPercorso());
            createDb.addPortataFromFiletoDb();
            JOptionPane.showMessageDialog(rootPane, "Inserimento completato con successo");
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(rootPane, "Nessun file selezionato!");
            }
        }
        if(!jCheckBoxFile.isSelected() && !jCheckBoxMenuGui.isSelected()){
            int choose;
            choose = JOptionPane.showConfirmDialog(rootPane, "Nessuna scelta effettuata! Continuare?");
            if(choose==JOptionPane.YES_OPTION){
                dispose();
            }
        }
      
    }//GEN-LAST:event_jButtonAvantiActionPerformed

    private void jButtonFileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFileChooserActionPerformed
        fileChooser.setVisible(true);
        
    }//GEN-LAST:event_jButtonFileChooserActionPerformed

    private void jCheckBoxMenuGuiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuGuiActionPerformed
       if(jCheckBoxMenuGui.isSelected()){
           jButtonFileChooser.setEnabled(false);
           jCheckBoxFile.setSelected(false);
       }
        else{
        }
    }//GEN-LAST:event_jCheckBoxMenuGuiActionPerformed

    private void jCheckBoxFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxFileActionPerformed
         if(jCheckBoxFile.isSelected()){
           jButtonFileChooser.setEnabled(true);
           jCheckBoxMenuGui.setSelected(false);
         }
          else{
        jButtonFileChooser.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBoxFileActionPerformed

    private void jButtonIndietroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIndietroActionPerformed
        try {
            GuiInformationMenu guiInformationMenu = new GuiInformationMenu();
            dispose();
            guiInformationMenu.setVisible(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Errore in SQL");
        }
        
    }//GEN-LAST:event_jButtonIndietroActionPerformed

    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAvanti;
    private javax.swing.JButton jButtonFileChooser;
    private javax.swing.JButton jButtonIndietro;
    private javax.swing.JCheckBox jCheckBoxFile;
    private javax.swing.JCheckBox jCheckBoxMenuGui;
    private javax.swing.JLabel jLabelSfondo;
    // End of variables declaration//GEN-END:variables
}