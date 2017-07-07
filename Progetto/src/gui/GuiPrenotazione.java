/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import cliente.Cliente;
import com.toedter.calendar.JCalendar;
import databse.CreateDb;
import exception.ExeptionData;
import exception.ExeptionNome;
import exception.ExeptionNumeroAdulti;
import funzionalita.Prenotazione;
import static gui.GuiProva.rimuoviOrarioData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
    private int numeroBambini;
    private String pasto="Pranzo";
    private long numeroTelefono;
    private Sala sala;
    String tipoEvento=null;
    private String s = "Indifferente";
    private Portata portata= null;
    private Portata primo2= null;
    private Portata primo1= null;
    private Portata primo3= null;
    private Portata secondo2= null;
    private Portata secondo3=  null;
    private Portata dolce= null;
    private String note;
    private Portata secondo1= null;
    private String portataString = "Indifferente";
    private int attesa = 0;
    private int daConfermare = 0;
    private int esclusiva = 0;
    private int preferenza = 0;
    private int esigenza = 0;
    CreateDb createDb;
    
    
    
    
    MenuCompleto menuCompleto = new MenuCompleto();
    MenuCliente menuCliente = new MenuCliente();

    
    Agriturismo agriturismo = new Agriturismo();
    Prenotazione prenotazione;
    Cliente cliente;
    Object[] object = new Object[2];
    GuiProva guiProva = new GuiProva();
    
    public GuiPrenotazione() throws SQLException {
        createDb = new CreateDb();
        initComponents();
        riempiItemPrimi();
        riempiItemSecondi();
        riempItemiDolci();
        riempiItemSale();
       

    }
    
    public void riempiItemSale(){
        for(Sala s: agriturismo.getSale())
            JSala.addItem(s.getNome());
    }
    
    public void riempiItemPrimi(){
        for(Portata p: MenuCompleto.menuCompleto){
            if(p.getTipoPortata().equals(TipoPortata.Primo)){
                JPrimo1.addItem(p.getNome());
                JPrimo2.addItem(p.getNome());
                JPrimo3.addItem(p.getNome());
            }
        }
    }
    
    
    public void riempiItemSecondi(){
        for(Portata p: MenuCompleto.menuCompleto){
            if(p.getTipoPortata().equals(TipoPortata.Secondo)){
                JSecondo1.addItem(p.getNome());
                JSecondo2.addItem(p.getNome());
                JSecondo3.addItem(p.getNome());
            }
        }
    }
    public void riempItemiDolci(){
        for(Portata p: MenuCompleto.menuCompleto){
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
        JNumeroAdulti = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        JNome = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        JNumeroTelefono = new javax.swing.JTextField();
        JOk = new javax.swing.JButton();
        JData = new com.toedter.calendar.JDateChooser();
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
        jCheckBoxEsclusiva = new javax.swing.JCheckBox();
        jCheckBoxPreferenza = new javax.swing.JCheckBox();
        jCheckBoxEsigenza = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        JNumeroTelefono3 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jNote = new javax.swing.JTextArea();
        jCheckBoxAttesa = new javax.swing.JCheckBox();
        jCheckBoxDaConfermare = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();
        JNumeroBambini = new javax.swing.JTextField();

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

        jLabel3.setText("N. Adulti");

        JNumeroAdulti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JNumeroAdultiActionPerformed(evt);
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

        jLabel7.setText("Sala");

        JSala.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Indifferente" }));
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

        jCheckBoxEsclusiva.setText(" Esclusiva");
        jCheckBoxEsclusiva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxEsclusivaActionPerformed(evt);
            }
        });

        jCheckBoxPreferenza.setText(" Preferenza");
        jCheckBoxPreferenza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxPreferenzaActionPerformed(evt);
            }
        });

        jCheckBoxEsigenza.setText(" Esigenza");
        jCheckBoxEsigenza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxEsigenzaActionPerformed(evt);
            }
        });

        jLabel12.setText("Tipo di evento");

        JNumeroTelefono3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JNumeroTelefono3ActionPerformed(evt);
            }
        });

        jNote.setColumns(20);
        jNote.setRows(5);
        jScrollPane1.setViewportView(jNote);

        jCheckBoxAttesa.setText("In attesa");
        jCheckBoxAttesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxAttesaActionPerformed(evt);
            }
        });

        jCheckBoxDaConfermare.setText("Da confermare");
        jCheckBoxDaConfermare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxDaConfermareActionPerformed(evt);
            }
        });

        jLabel13.setText("N. Bambini");

        JNumeroBambini.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JNumeroBambiniActionPerformed(evt);
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
                                    .addComponent(jCheckBoxEsclusiva, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(JData, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                        .addComponent(JNome)
                                        .addComponent(JSala, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(31, 31, 31)
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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel13))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(JPasto, 0, 118, Short.MAX_VALUE)
                                            .addComponent(JNumeroAdulti)
                                            .addComponent(JNumeroBambini, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(37, 37, 37))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jCheckBoxPreferenza)
                                        .addGap(46, 46, 46)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(31, 31, 31)
                                        .addComponent(JNumeroTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jCheckBoxAttesa, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(43, 43, 43)
                                        .addComponent(jCheckBoxDaConfermare, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(26, 26, 26)))
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
                        .addGap(401, 401, 401)
                        .addComponent(jLabel11))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(293, 293, 293)
                        .addComponent(jCheckBoxEsigenza)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel8)))
                .addContainerGap(456, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JPasto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(JNumeroAdulti, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(JNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(JNumeroTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(JNumeroBambini, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JSala, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxAttesa)
                    .addComponent(jCheckBoxDaConfermare)
                    .addComponent(jCheckBoxPreferenza)
                    .addComponent(jCheckBoxEsigenza)
                    .addComponent(jCheckBoxEsclusiva))
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

    private void JNumeroAdultiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JNumeroAdultiActionPerformed
        
    }//GEN-LAST:event_JNumeroAdultiActionPerformed

    private void JOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JOkActionPerformed
          
        try{            
            nome = JNome.getText();
            if(nome.isEmpty())
                throw new ExeptionNome();
            numeroAdulti = Integer.valueOf(JNumeroAdulti.getText());
            if(JNumeroAdulti.getText().isEmpty()){
                throw new ExeptionNumeroAdulti();
            }if(data.before(GuiProva.dataOdierna))
                throw new ExeptionData();
            String line;
            line = JNumeroBambini.getText();
            if(line.isEmpty())
                numeroBambini=0;
            else
                numeroBambini = Integer.parseInt(JNumeroBambini.getText());
            numeroTelefono = Long.parseLong(JNumeroTelefono.getText());
            tipoEvento = JNumeroTelefono3.getText();
        
            primo1 = new Portata((String) JPrimo1.getSelectedItem(), TipoPortata.Primo);
            primo2 = new Portata((String) JPrimo2.getSelectedItem(), TipoPortata.Primo);
            primo3 = new Portata((String) JPrimo3.getSelectedItem(), TipoPortata.Primo);
            secondo1 = new Portata((String) JSecondo1.getSelectedItem(), TipoPortata.Secondo);
            secondo2 = new Portata((String) JSecondo2.getSelectedItem(), TipoPortata.Secondo);
            secondo3 = new Portata((String) JSecondo3.getSelectedItem(), TipoPortata.Secondo);
            dolce = new Portata((String) JDolce.getSelectedItem(), TipoPortata.Dolce);
            note = jNote.getText();
            cliente = new Cliente(nome, numeroTelefono);
        
            menuCliente.getMenuCliente().add(primo1);
            menuCliente.getMenuCliente().add(primo2);
            menuCliente.getMenuCliente().add(primo3);
            menuCliente.getMenuCliente().add(secondo1);
            menuCliente.getMenuCliente().add(secondo2);
            menuCliente.getMenuCliente().add(secondo3);
            menuCliente.getMenuCliente().add(dolce);
            prenotazione = new Prenotazione(numeroAdulti, data, pasto, cliente);
            prenotazione.setDateDb(data);
            prenotazione.setNote(note);
            prenotazione.setMenu(menuCliente);
            prenotazione.setTipoEvento(tipoEvento);
            prenotazione.setnBambini(numeroBambini);
       
            prenotazione.setSala(new Sala(s));
            prenotazione.setMenu(menuCliente);
            prenotazione.setAttesa(attesa);
            prenotazione.setDaConfermare(daConfermare);
            prenotazione.setEsclusiva(esclusiva);
            prenotazione.setEsigenza(esigenza);
            prenotazione.setPreferenza(preferenza);
            prenotazione.setDate(data);

            agriturismo.aggiungiPrenotazione(prenotazione);
            createDb.addSinglePrenotazione(prenotazione);
            dispose();
            
        }catch(ExeptionNome ex){
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }catch(NullPointerException ex){
            JOptionPane.showMessageDialog(rootPane, "Non hai inserito la data!");
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "La prenotazione non è stata salvata!");
        }catch(ExeptionNumeroAdulti ex){
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(rootPane, "Possibile errore nei campi: n.Adulti / numero di telefono /numero di bambini !");
        }catch(ExeptionData ex){
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
        
        
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
      
         if(data!=dataOdierna){
            data = JData.getDate();
        }
    }//GEN-LAST:event_JDataPropertyChange

    private void JPrimo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JPrimo1ActionPerformed
       
    }//GEN-LAST:event_JPrimo1ActionPerformed

    private void JPrimo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JPrimo3ActionPerformed
        
    }//GEN-LAST:event_JPrimo3ActionPerformed

    private void JSecondo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JSecondo3ActionPerformed
        
    }//GEN-LAST:event_JSecondo3ActionPerformed

    private void JSecondo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JSecondo1ActionPerformed
       
    }//GEN-LAST:event_JSecondo1ActionPerformed

    private void JPrimo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JPrimo2ActionPerformed
       
    }//GEN-LAST:event_JPrimo2ActionPerformed

    private void JSecondo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JSecondo2ActionPerformed
        
    }//GEN-LAST:event_JSecondo2ActionPerformed

    private void JDolceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JDolceActionPerformed
      
    }//GEN-LAST:event_JDolceActionPerformed

    private void jCheckBoxEsclusivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxEsclusivaActionPerformed
        if(jCheckBoxEsclusiva.isSelected())
            esclusiva=1;
    }//GEN-LAST:event_jCheckBoxEsclusivaActionPerformed

    private void jCheckBoxPreferenzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxPreferenzaActionPerformed
        if(jCheckBoxPreferenza.isSelected())
            preferenza=1;
    }//GEN-LAST:event_jCheckBoxPreferenzaActionPerformed

    private void jCheckBoxEsigenzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxEsigenzaActionPerformed
        if(jCheckBoxEsigenza.isSelected())
            esigenza=1;
    }//GEN-LAST:event_jCheckBoxEsigenzaActionPerformed

    private void JSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JSalaActionPerformed
        s = (String) JSala.getSelectedItem();
    }//GEN-LAST:event_JSalaActionPerformed

    private void JNumeroTelefono3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JNumeroTelefono3ActionPerformed
        
    }//GEN-LAST:event_JNumeroTelefono3ActionPerformed

    private void jCheckBoxAttesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxAttesaActionPerformed
        if(jCheckBoxAttesa.isSelected())
            attesa=1;
    }//GEN-LAST:event_jCheckBoxAttesaActionPerformed

    private void jCheckBoxDaConfermareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxDaConfermareActionPerformed
         if(jCheckBoxDaConfermare.isSelected())
            daConfermare=1;
    }//GEN-LAST:event_jCheckBoxDaConfermareActionPerformed

    private void JNumeroBambiniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JNumeroBambiniActionPerformed
        
    }//GEN-LAST:event_JNumeroBambiniActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser JData;
    private javax.swing.JComboBox<String> JDolce;
    private javax.swing.JTextField JNome;
    private javax.swing.JTextField JNumeroAdulti;
    private javax.swing.JTextField JNumeroBambini;
    private javax.swing.JTextField JNumeroTelefono;
    private javax.swing.JTextField JNumeroTelefono3;
    private javax.swing.JButton JOk;
    private javax.swing.JComboBox<String> JPasto;
    private javax.swing.JComboBox<String> JPrimo1;
    private javax.swing.JComboBox<String> JPrimo2;
    private javax.swing.JComboBox<String> JPrimo3;
    private javax.swing.JComboBox<String> JSala;
    private javax.swing.JComboBox<String> JSecondo1;
    private javax.swing.JComboBox<String> JSecondo2;
    private javax.swing.JComboBox<String> JSecondo3;
    private javax.swing.JCheckBox jCheckBoxAttesa;
    private javax.swing.JCheckBox jCheckBoxDaConfermare;
    private javax.swing.JCheckBox jCheckBoxEsclusiva;
    private javax.swing.JCheckBox jCheckBoxEsigenza;
    private javax.swing.JCheckBox jCheckBoxPreferenza;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextArea jNote;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
