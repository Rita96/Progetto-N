/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import cliente.Cliente;
import com.toedter.calendar.JCalendar;
import funzionalita.Prenotazione;
import static gui.GuiProva.rimuoviOrarioData;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import menu.MenuCliente;
import menu.MenuCompleto;
import menu.Portata;
import menu.TipoPortata;
import struttura.Agriturismo;
import struttura.Sala;

/**
 *
 * @author luby
 */
public class GuiPrenotazione extends javax.swing.JFrame {

    private Date data = new Date();
    private Date dataOdierna = new Date();
    private String nome;
    private int numeroAdulti;
    private String pasto="Pranzo";
    private long numeroTelefono;
    private Sala sala;
    private String s = "Indifferente";
    private Portata portata;
    private String portataString = "Indifferente";
    
    MenuCompleto menuCompleto = new MenuCompleto();
    MenuCliente menuCliente = new MenuCliente();

    
    Agriturismo agriturismo = new Agriturismo();
    Prenotazione prenotazione;
    Cliente cliente;
    Object[] object = new Object[2];
    GuiProva guiProva = new GuiProva();
    
    public GuiPrenotazione() {
        initComponents();
        riempiPrimi();
        riempiSecondi();
        riempiDolci();
        

    }
    
    public void riempiPrimi(){
        for(Portata p: menuCompleto.getMenuCompleto()){
            if(p.getTipoPortata().equals(TipoPortata.Primo)){
                JPrimo1.addItem(p.getNome());
                JPrimo2.addItem(p.getNome());
                JPrimo3.addItem(p.getNome());
            }
        }
    }
    public void riempiSecondi(){
        for(Portata p: menuCompleto.getMenuCompleto()){
            if(p.getTipoPortata().equals(TipoPortata.Secondo)){
                JSecondo1.addItem(p.getNome());
                JSecondo2.addItem(p.getNome());
                JSecondo3.addItem(p.getNome());
            }
        }
    }
    public void riempiDolci(){
        for(Portata p: menuCompleto.getMenuCompleto()){
            if(p.getTipoPortata().equals(TipoPortata.Dolce)){
                JDolce.addItem(p.getNome());
            }
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JPasto = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        JNumeroPersone = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        JNome = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        JNumeroTelefono = new javax.swing.JTextField();
        JOk = new javax.swing.JButton();
        JData = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        JOra = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        JSala = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        JSecondo3 = new javax.swing.JComboBox<>();
        JPrimo1 = new javax.swing.JComboBox<>();
        JPrimo3 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        JSecondo1 = new javax.swing.JComboBox<>();
        JPrimo2 = new javax.swing.JComboBox<>();
        JSecondo2 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        JDolce = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        JNumeroTelefono3 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(220, 70));

        jLabel1.setText("Data");

        jLabel2.setText("Pasto");

        JPasto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pranzo", "Cena" }));
        JPasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JPastoActionPerformed(evt);
            }
        });

        jLabel3.setText("N. Persone");

        JNumeroPersone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JNumeroPersoneActionPerformed(evt);
            }
        });

        jLabel4.setText("Nome");

        JNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JNomeActionPerformed(evt);
            }
        });

        jLabel5.setText("N. Telefono");

        JNumeroTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JNumeroTelefonoActionPerformed(evt);
            }
        });

        JOk.setText("OK");
        JOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JOkActionPerformed(evt);
            }
        });

        JData.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                JDataPropertyChange(evt);
            }
        });

        jLabel6.setText("Ora");

        JOra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JOraActionPerformed(evt);
            }
        });

        jLabel7.setText("Sala");

        JSala.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Indifferente", "Ingresso", "Gialla", "Verde", "Rosa", "Giardino", "Corte", "Salottino", "Gelsomino", "Aia", "Balcone", "Salone" }));
        JSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JSalaActionPerformed(evt);
            }
        });

        jLabel8.setText("Primo");

        JSecondo3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Indifferente" }));
        JSecondo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JSecondo3ActionPerformed(evt);
            }
        });

        JPrimo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Indifferente" }));
        JPrimo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JPrimo1ActionPerformed(evt);
            }
        });

        JPrimo3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Indifferente" }));
        JPrimo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JPrimo3ActionPerformed(evt);
            }
        });

        jLabel9.setText("Note");

        JSecondo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Indifferente" }));
        JSecondo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JSecondo1ActionPerformed(evt);
            }
        });

        JPrimo2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Indifferente" }));
        JPrimo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JPrimo2ActionPerformed(evt);
            }
        });

        JSecondo2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Indifferente" }));
        JSecondo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JSecondo2ActionPerformed(evt);
            }
        });

        jLabel10.setText("Secondo");

        jLabel11.setText("Dolce");

        JDolce.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Indifferente" }));
        JDolce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JDolceActionPerformed(evt);
            }
        });

        jCheckBox1.setText(" Esclusiva");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jCheckBox2.setText(" Preferenza");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jCheckBox3.setText(" Esigenza");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        jLabel12.setText("Tipo di evento");

        JNumeroTelefono3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JNumeroTelefono3ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jCheckBox4.setText("In attesa");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });

        jCheckBox5.setText("Da confermare");
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 752, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 38, Short.MAX_VALUE))
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JNumeroTelefono3))
                            .addComponent(JPrimo1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JSecondo1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7))
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(JData, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                        .addComponent(JNome)
                                        .addComponent(JSala, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(JSecondo2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(JPrimo2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(JDolce, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(41, 41, 41)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(JSecondo3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(JPrimo3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jCheckBox3))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel3))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(JPasto, 0, 118, Short.MAX_VALUE)
                                                    .addComponent(JNumeroPersone))))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel6)
                                                    .addComponent(jLabel5))
                                                .addGap(31, 31, 31)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(JOra, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                                                    .addComponent(JNumeroTelefono)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(37, 37, 37)
                                                .addComponent(jCheckBox2)))))
                                .addGap(26, 26, 26))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jCheckBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(81, 81, 81))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(389, 389, 389)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(336, 336, 336)
                        .addComponent(JOk, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(396, 396, 396)
                        .addComponent(jLabel10))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(399, 399, 399)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(401, 401, 401)
                        .addComponent(jLabel11)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JPasto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(JOra, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(JNumeroPersone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(JNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(JNumeroTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JSala, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox2)
                    .addComponent(jCheckBox3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox4)
                    .addComponent(jCheckBox5))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(JNumeroTelefono3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JPrimo3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JPrimo1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JPrimo2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JSecondo1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JSecondo2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JSecondo3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(JDolce, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JOk, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JNumeroPersoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JNumeroPersoneActionPerformed
        
    }//GEN-LAST:event_JNumeroPersoneActionPerformed

    private void JOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JOkActionPerformed
        
        nome = JNome.getText();
        numeroAdulti = Integer.valueOf(JNumeroPersone.getText());
        numeroTelefono = Long.parseLong(JNumeroTelefono.getText());
        cliente = new Cliente(nome, numeroTelefono);
        prenotazione = new Prenotazione(numeroAdulti, data, pasto, cliente);
        prenotazione.setSala(new Sala(s));
        prenotazione.setMenu(menuCliente);
        agriturismo.aggiungiPrenotazione(prenotazione);
        dispose();
        
        
    }//GEN-LAST:event_JOkActionPerformed

    private void JNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JNomeActionPerformed
        
    }//GEN-LAST:event_JNomeActionPerformed

    private void JNumeroTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JNumeroTelefonoActionPerformed
        
    }//GEN-LAST:event_JNumeroTelefonoActionPerformed

    private void JPastoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JPastoActionPerformed
        pasto = (String) JPasto.getSelectedItem();
    }//GEN-LAST:event_JPastoActionPerformed

    private void JDataPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_JDataPropertyChange
       
        if(data==null){
            data = guiProva.dataOdierda();
            data = GuiProva.rimuoviOrarioData(data);
        }
        data = GuiProva.rimuoviOrarioData(data);
        GuiProva.rimuoviOrarioData(data);
        if(data.before(GuiProva.dataOdierna)){
            System.out.println("Non puoi prenotare per una data passata");
        }
         if(data!=dataOdierna){
            data = JData.getDate();
        }
    }//GEN-LAST:event_JDataPropertyChange

    private void JOraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JOraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JOraActionPerformed

    private void JPrimo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JPrimo1ActionPerformed
        String portataString = (String)JPrimo1.getSelectedItem();
        portata = new Portata(portataString, TipoPortata.Primo);
        menuCliente.getMenuCliente().add(portata);
    }//GEN-LAST:event_JPrimo1ActionPerformed

    private void JPrimo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JPrimo3ActionPerformed
        String portataString = (String)JPrimo3.getSelectedItem();
        portata = new Portata(portataString, TipoPortata.Primo);
        menuCliente.getMenuCliente().add(portata);
    }//GEN-LAST:event_JPrimo3ActionPerformed

    private void JSecondo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JSecondo3ActionPerformed
        String portataString = (String)JSecondo3.getSelectedItem();
        portata = new Portata(portataString, TipoPortata.Secondo);
        menuCliente.getMenuCliente().add(portata);
    }//GEN-LAST:event_JSecondo3ActionPerformed

    private void JSecondo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JSecondo1ActionPerformed
        String portataString = (String)JSecondo1.getSelectedItem();
        portata = new Portata(portataString, TipoPortata.Secondo);
        menuCliente.getMenuCliente().add(portata);
    }//GEN-LAST:event_JSecondo1ActionPerformed

    private void JPrimo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JPrimo2ActionPerformed
        String portataString = (String)JPrimo2.getSelectedItem();
        portata = new Portata(portataString, TipoPortata.Primo);
        menuCliente.getMenuCliente().add(portata);
    }//GEN-LAST:event_JPrimo2ActionPerformed

    private void JSecondo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JSecondo2ActionPerformed
        String portataString = (String)JSecondo2.getSelectedItem();
        portata = new Portata(portataString, TipoPortata.Secondo);
        menuCliente.getMenuCliente().add(portata);
    }//GEN-LAST:event_JSecondo2ActionPerformed

    private void JDolceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JDolceActionPerformed
        String portataString = (String)JDolce.getSelectedItem();
        portata = new Portata(portataString, TipoPortata.Dolce);
        menuCliente.getMenuCliente().add(portata);
    }//GEN-LAST:event_JDolceActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void JSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JSalaActionPerformed

        s = (String) JSala.getSelectedItem();
    }//GEN-LAST:event_JSalaActionPerformed

    private void JNumeroTelefono3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JNumeroTelefono3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JNumeroTelefono3ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser JData;
    private javax.swing.JComboBox<String> JDolce;
    private javax.swing.JTextField JNome;
    private javax.swing.JTextField JNumeroPersone;
    private javax.swing.JTextField JNumeroTelefono;
    private javax.swing.JTextField JNumeroTelefono3;
    private javax.swing.JButton JOk;
    private javax.swing.JTextField JOra;
    private javax.swing.JComboBox<String> JPasto;
    private javax.swing.JComboBox<String> JPrimo1;
    private javax.swing.JComboBox<String> JPrimo2;
    private javax.swing.JComboBox<String> JPrimo3;
    private javax.swing.JComboBox<String> JSala;
    private javax.swing.JComboBox<String> JSecondo1;
    private javax.swing.JComboBox<String> JSecondo2;
    private javax.swing.JComboBox<String> JSecondo3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
