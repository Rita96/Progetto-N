/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.calcoloSpesa;

import javax.swing.table.DefaultTableModel;
import menu.Ingredient;
import menu.Portata;
import struttura.Agriturismo;

/**
 *
 * @author luby9
 */
public class GuiOutputSpesa extends javax.swing.JFrame {
    
    Object object[];
    DefaultTableModel tabellaPortate;
    DefaultTableModel tabellaIngredienti;
    
    public GuiOutputSpesa() {
        
        initComponents();
        initTable();
        riempiTabellaPortate();
        riempiTabellaIngredienti();
    }

    public void initTable(){
        tabellaPortate = (DefaultTableModel) jTablePortate.getModel();
        tabellaIngredienti = (DefaultTableModel) jTableIngredienti.getModel();
    }
    
    public void riempiTabellaPortate(){
        for(Portata p: Agriturismo.portateSpesa){
            object = new Object[]{p.getNome(),p.getPortataNp()};
            tabellaPortate.addRow(object);
        }
    }
    public void riempiTabellaIngredienti(){
        for(Ingredient i: Agriturismo.ingSpesa){
            double qnt = ((double)i.getIngredientNp()*(double)i.getQuantity()/10);
            object = new Object[]{i.getName(),qnt};
            tabellaIngredienti.addRow(object);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableIngredienti = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePortate = new javax.swing.JTable();
        sfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(400, 200));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableIngredienti.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ingrediente", "Qnt [g]"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableIngredienti);
        if (jTableIngredienti.getColumnModel().getColumnCount() > 0) {
            jTableIngredienti.getColumnModel().getColumn(0).setPreferredWidth(170);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 29, 167, 312));

        jTablePortate.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Portata", "xNp"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTablePortate);
        if (jTablePortate.getColumnModel().getColumnCount() > 0) {
            jTablePortate.getColumnModel().getColumn(0).setPreferredWidth(220);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 31, 219, 312));

        sfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/Texture seamless parquet rovere chiaro simo-3d.jpg"))); // NOI18N
        getContentPane().add(sfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

 
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableIngredienti;
    private javax.swing.JTable jTablePortate;
    private javax.swing.JLabel sfondo;
    // End of variables declaration//GEN-END:variables
}
