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
    Agriturismo agri = new Agriturismo();
    GuiProvaM guiProva = new GuiProvaM();
    
    public GuiPrenotazione() throws SQLException {
        createDb = new CreateDb();
        initComponents();
        JData.setDate(dataOdierna);
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
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(220, 70));
        setMaximumSize(new java.awt.Dimension(920, 720));
        setMinimumSize(new java.awt.Dimension(920, 720));
        setPreferredSize(new java.awt.Dimension(920, 720));
        getContentPane().setLayout(null);

        jLabel1.setText("Data");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(49, 35, 75, 30);

        jLabel2.setText("Pasto");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(312, 43, 71, 14);

        JPasto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pranzo", "Cena" }));
        JPasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JPastoActionPerformed(evt);
            }
        });
        getContentPane().add(JPasto);
        JPasto.setBounds(387, 35, 118, 30);

        jLabel3.setText("N. Adulti");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(312, 79, 70, 14);

        JNumeroAdulti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JNumeroAdultiActionPerformed(evt);
            }
        });
        getContentPane().add(JNumeroAdulti);
        JNumeroAdulti.setBounds(387, 71, 118, 30);

        jLabel4.setText("Nome");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(49, 79, 70, 14);

        JNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JNomeActionPerformed(evt);
            }
        });
        getContentPane().add(JNome);
        JNome.setBounds(139, 71, 142, 30);

        jLabel5.setText("N. Telefono");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(542, 79, 90, 14);

        JNumeroTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JNumeroTelefonoActionPerformed(evt);
            }
        });
        getContentPane().add(JNumeroTelefono);
        JNumeroTelefono.setBounds(629, 71, 118, 30);

        JOk.setText("OK");
        JOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JOkActionPerformed(evt);
            }
        });
        getContentPane().add(JOk);
        JOk.setBounds(360, 620, 128, 35);

        JData.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                JDataPropertyChange(evt);
            }
        });
        getContentPane().add(JData);
        JData.setBounds(139, 35, 142, 30);

        jLabel7.setText("Sala");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(49, 115, 70, 14);

        JSala.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Indifferente" }));
        JSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JSalaActionPerformed(evt);
            }
        });
        getContentPane().add(JSala);
        JSala.setBounds(139, 107, 142, 30);

        jLabel8.setText("Primo");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(399, 226, 80, 14);

        JSecondo3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Indifferente" }));
        JSecondo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JSecondo3ActionPerformed(evt);
            }
        });
        getContentPane().add(JSecondo3);
        JSecondo3.setBounds(570, 335, 243, 30);

        JPrimo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Indifferente" }));
        JPrimo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JPrimo1ActionPerformed(evt);
            }
        });
        getContentPane().add(JPrimo1);
        JPrimo1.setBounds(49, 246, 232, 30);

        JPrimo3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Indifferente" }));
        JPrimo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JPrimo3ActionPerformed(evt);
            }
        });
        getContentPane().add(JPrimo3);
        JPrimo3.setBounds(570, 246, 243, 30);

        jLabel9.setText("Note");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(410, 500, 90, 14);

        JSecondo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Indifferente" }));
        JSecondo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JSecondo1ActionPerformed(evt);
            }
        });
        getContentPane().add(JSecondo1);
        JSecondo1.setBounds(49, 335, 232, 30);

        JPrimo2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Indifferente" }));
        JPrimo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JPrimo2ActionPerformed(evt);
            }
        });
        getContentPane().add(JPrimo2);
        JPrimo2.setBounds(312, 246, 217, 30);

        JSecondo2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Indifferente" }));
        JSecondo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JSecondo2ActionPerformed(evt);
            }
        });
        getContentPane().add(JSecondo2);
        JSecondo2.setBounds(312, 335, 217, 30);

        jLabel10.setText("Secondo");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(396, 310, 100, 14);

        jLabel11.setText("Dolce");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(401, 404, 100, 14);

        JDolce.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Indifferente" }));
        JDolce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JDolceActionPerformed(evt);
            }
        });
        getContentPane().add(JDolce);
        JDolce.setBounds(312, 436, 217, 30);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(49, 472, 790, 2);

        jCheckBoxEsclusiva.setText(" Esclusiva");
        jCheckBoxEsclusiva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxEsclusivaActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBoxEsclusiva);
        jCheckBoxEsclusiva.setBounds(139, 144, 128, 23);

        jCheckBoxPreferenza.setText(" Preferenza");
        jCheckBoxPreferenza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxPreferenzaActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBoxPreferenza);
        jCheckBoxPreferenza.setBounds(415, 144, 110, 23);

        jCheckBoxEsigenza.setText(" Esigenza");
        jCheckBoxEsigenza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxEsigenzaActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBoxEsigenza);
        jCheckBoxEsigenza.setBounds(293, 144, 100, 23);

        jLabel12.setText("Tipo di evento");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(49, 185, 130, 14);

        JNumeroTelefono3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JNumeroTelefono3ActionPerformed(evt);
            }
        });
        getContentPane().add(JNumeroTelefono3);
        JNumeroTelefono3.setBounds(180, 180, 154, 30);

        jNote.setColumns(20);
        jNote.setRows(5);
        jScrollPane1.setViewportView(jNote);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(50, 540, 752, 58);

        jCheckBoxAttesa.setText("In attesa");
        jCheckBoxAttesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxAttesaActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBoxAttesa);
        jCheckBoxAttesa.setBounds(542, 144, 100, 23);

        jCheckBoxDaConfermare.setText("Da confermare");
        jCheckBoxDaConfermare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxDaConfermareActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBoxDaConfermare);
        jCheckBoxDaConfermare.setBounds(674, 144, 128, 23);

        jLabel13.setText("N. Bambini");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(312, 115, 80, 14);

        JNumeroBambini.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JNumeroBambiniActionPerformed(evt);
            }
        });
        getContentPane().add(JNumeroBambini);
        JNumeroBambini.setBounds(387, 107, 118, 30);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/Texture seamless parquet rovere chiaro simo-3d.jpg"))); // NOI18N
        jLabel6.setMaximumSize(new java.awt.Dimension(920, 720));
        jLabel6.setMinimumSize(new java.awt.Dimension(920, 720));
        jLabel6.setPreferredSize(new java.awt.Dimension(920, 627));
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 980, 720);

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
            }if(data.before(GuiProvaM.dataOdierna))
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
            int id = createDb.selectMaxId();
            prenotazione.setId(id);
            
        }catch(ExeptionNome ex){
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }catch(NullPointerException ex){
            JOptionPane.showMessageDialog(rootPane, "Non hai inserito la data!");
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
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
            data = GuiProvaM.rimuoviOrarioData(data);
        }
        data = GuiProvaM.rimuoviOrarioData(data);
        GuiProvaM.rimuoviOrarioData(data);
      
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextArea jNote;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
