package gui.sale;


import database.CreateDb;
import gui.FileChooser;
import gui.menu.GuiInformationMenu;
import gui.menu.GuiSetMenu;
import gui.nome.GuiNome;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lettura.LeggiSala;
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
public class GuiSetSale extends javax.swing.JFrame {

    private FileChooser fileChooser;
    private Agriturismo agri = new Agriturismo();
    private CreateDb createDb;
    private GuiInputSale guiInputSale;
    private LeggiSala leggiSala = new LeggiSala();
    private GuiInformationMenu guiInformationMenu = new GuiInformationMenu();
    
    public GuiSetSale() throws SQLException {
        initComponents();
        setLocationRelativeTo(null);
        fileChooser = new FileChooser();
        createDb = new CreateDb();
        guiInputSale = new GuiInputSale();
        createDb.createTableSale();
        imprevisto();
    }

    /**
     * Viene visualizzato quando non è stata ancora completata l'inizializzazione del db
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
    
    public void openGuiSale(){
        if(jCheckBoxSaleGui.isSelected()){
            guiInputSale.setVisible(true);
            dispose();         
        }
    }

    /**
     * Per inserire i dati delle sale tramite file nel db
     */
    public void insertFileSale(){
        if(jCheckBoxFile.isSelected()){
            jButtonFileChooser.setEnabled(true);
            try {
                leggiSala.letturaSale(fileChooser.getPercorso());

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(rootPane, "Impossibile leggere il file");
            }catch(NullPointerException ex){JOptionPane.showMessageDialog(rootPane, "File selezionato non valido!");}
                if(agri.getSale().size()>0 && agri.getSale().size()<13){
                     try {
                         createDb.addSaleFromFileToDb();
                        JOptionPane.showMessageDialog(rootPane, "Inserimento completato con successo");
                        dispose();
                        guiInformationMenu.setVisible(true);
                    }catch (SQLException ex) {
                         JOptionPane.showMessageDialog(rootPane, "La sala è già esistente");
                    } catch (NullPointerException ex) {
                         JOptionPane.showMessageDialog(rootPane, "Nessun file selezionato");
                    }
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Il numero di sale inserite non è valido");
                    System.out.println(agri.getSale().size());
                    agri.getSale().clear();     
                }    
        }
    
    } 

    /**
     * Se non viene inserita alcuna sala
     */
    public void emptySale(){
        if(!jCheckBoxFile.isSelected() && !jCheckBoxSaleGui.isSelected()){
            int choose;
            choose = JOptionPane.showConfirmDialog(rootPane, "Nessuna scelta effettuata! Continuare?");
            if(choose==JOptionPane.YES_OPTION){
                try {
                    if(createDb.verificaTabella("sale")>0 && createDb.verificaTabella("sale")<13){
                        dispose();
                        guiInformationMenu.setVisible(true);
                    }
                    else
                        JOptionPane.showMessageDialog(rootPane, "Il numero di sale inserito non è valido!");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Problemi con il Database!");
                }
                
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonAvanti = new javax.swing.JButton();
        jButtonFileChooser = new javax.swing.JButton();
        jCheckBoxSaleGui = new javax.swing.JCheckBox();
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

        jCheckBoxSaleGui.setText(" Inserisci le sale da interfaccia grafica");
        jCheckBoxSaleGui.setOpaque(false);
        jCheckBoxSaleGui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxSaleGuiActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBoxSaleGui, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jCheckBoxFile.setText(" Importa le sale da file di testo");
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

        jLabelSfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/Texture seamless parquet rovere chiaro simo-3d.jpg"))); // NOI18N
        getContentPane().add(jLabelSfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAvantiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAvantiActionPerformed
        openGuiSale();
        insertFileSale();
        emptySale();

    }//GEN-LAST:event_jButtonAvantiActionPerformed

    private void jButtonFileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFileChooserActionPerformed
        fileChooser.setVisible(true);
        
    }//GEN-LAST:event_jButtonFileChooserActionPerformed

    private void jCheckBoxSaleGuiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxSaleGuiActionPerformed
       if(jCheckBoxSaleGui.isSelected()){
           jButtonFileChooser.setEnabled(false);
           jCheckBoxFile.setSelected(false);
       }
        else{
        }
    }//GEN-LAST:event_jCheckBoxSaleGuiActionPerformed

    private void jCheckBoxFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxFileActionPerformed
         if(jCheckBoxFile.isSelected()){
           jButtonFileChooser.setEnabled(true);
           jCheckBoxSaleGui.setSelected(false);
         }
          else{
        jButtonFileChooser.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBoxFileActionPerformed

    private void jButtonIndietroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIndietroActionPerformed
        try {
            GuiInformationSale guiInformation = new GuiInformationSale();
            dispose();
            guiInformation.setVisible(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
        
    }//GEN-LAST:event_jButtonIndietroActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAvanti;
    private javax.swing.JButton jButtonFileChooser;
    private javax.swing.JButton jButtonIndietro;
    private javax.swing.JCheckBox jCheckBoxFile;
    private javax.swing.JCheckBox jCheckBoxSaleGui;
    private javax.swing.JLabel jLabelSfondo;
    // End of variables declaration//GEN-END:variables
}
