/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.sale;

import gui.sale.GuiSetSale;
import databse.CreateDb;
import gui.nome.GuiNome;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author luby9
 */
public class GuiInformationSale extends javax.swing.JFrame {
    GuiSetSale guiSetSale = null;
            
    public GuiInformationSale() throws SQLException {
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButtonIndietro = new javax.swing.JButton();
        jLabelSfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(400, 200));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("\n  Nella prossima schermata ti sarà chiesto di \n  inserire le sale da cui è composto il\n  ristorante. Puoi selezionare da un minimo \n  di una ad 1 massimo di 12 sale. L'inserimento\n  delle sale potrà essere effettuato in 2 modi:\n    1) inserisci le sale da interfaccia grafica\n    2) inserisci le sale da file di testo");
        jTextArea1.setOpaque(false);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 390, 190));

        jButton1.setText("Avanti");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, 70, -1));

        jButtonIndietro.setText("Indietro");
        jButtonIndietro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIndietroActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonIndietro, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, -1, -1));

        jLabelSfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/Texture seamless parquet rovere chiaro simo-3d.jpg"))); // NOI18N
        jPanel1.add(jLabelSfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 300));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            guiSetSale = new GuiSetSale();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Errore in SQL");
        }
        dispose();
        guiSetSale.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonIndietroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIndietroActionPerformed
        dispose();
        GuiNome guiNome = new GuiNome();
        try {
            CreateDb createDb = new CreateDb();
            createDb.DropSchema();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Errore in SQL");
        }
        guiNome.setVisible(true);
        
    }//GEN-LAST:event_jButtonIndietroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonIndietro;
    private javax.swing.JLabel jLabelSfondo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
