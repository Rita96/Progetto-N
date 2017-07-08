/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import databse.CreateDb;
import funzionalita.Prenotazione;
import gui.menu.NewJFrame;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import struttura.Agriturismo;
import struttura.Sala;

/**
 *
 * @author luby
 */
public class GuiProva extends javax.swing.JFrame {
    
    private Agriturismo agri = new Agriturismo();
    protected Date date = new Date();
    protected static Date dataOdierna = new Date();
    private String pasto="Pranzo";
    private Object[] object;
    private ArrayList<GestioneTabelle> arrayGestioneTabelle = new ArrayList<>();
    private CreateDb createDb;
    private int numeroSale;

    
    public GuiProva() throws SQLException {  
        createDb = new CreateDb();
        initComponents();
        aggiungiTabelleArray();
        JDateChooser.setDate(dataOdierna);
        numeroSale = createDb.getNumeroSale();
    }
    
    //operazioni tabelle
    public void aggiornaTabelle(Date d){ 
        rimuoviRigheTabellaSala();
        for(Prenotazione p: agri.getPrenotazione()){ 
            if((d.equals(p.getDate())) && pasto.equals(p.getPasto())){
                object = new Object[]{p.getCliente().getNome(),p.getnAdulti()};
                aggiornaTabelleSale(p);

            }
        } 
    }
    public void aggiornaTabelleSale(Prenotazione a){
        for(GestioneTabelle t: arrayGestioneTabelle){
            if(a.getSala().getNome().equals(t.getNomeSala())){
                t.getDtm().addRow(object);
                if(!a.getSala().getNome().equalsIgnoreCase("Indifferente")){
                    arrayGestioneTabelle.get(0).getDtm().addRow(object); //aggiungo i tavoli anche alla tabella principale
                }
            }
        }
    }
    
    public void aggiungiTabelleArray(){
                
        try{
            
            DefaultTableModel tabellaPrincipale = (DefaultTableModel) JTuttiTavoli.getModel();
            arrayGestioneTabelle.add(new GestioneTabelle(tabellaPrincipale, "Indifferente"));
            DefaultTableModel tabellaVerde = (DefaultTableModel) JTable1.getModel();
            arrayGestioneTabelle.add(new GestioneTabelle(tabellaVerde, agri.getSale().get(0).getNome()));
            DefaultTableModel tabellaGilla = (DefaultTableModel) JTable2.getModel();
            arrayGestioneTabelle.add(new GestioneTabelle(tabellaGilla, agri.getSale().get(1).getNome()));
            DefaultTableModel tabellaRosa = (DefaultTableModel) JTable3.getModel();
            arrayGestioneTabelle.add(new GestioneTabelle(tabellaRosa, agri.getSale().get(2).getNome()));
            DefaultTableModel tabellaIngresso = (DefaultTableModel) JTable4.getModel();
            arrayGestioneTabelle.add(new GestioneTabelle(tabellaIngresso, agri.getSale().get(3).getNome()));
            DefaultTableModel tabellaCorte = (DefaultTableModel) JTable5.getModel();
            arrayGestioneTabelle.add(new GestioneTabelle(tabellaCorte, agri.getSale().get(4).getNome()));
            DefaultTableModel tabellaGiardino = (DefaultTableModel) JTable6.getModel();
            arrayGestioneTabelle.add(new GestioneTabelle(tabellaGiardino, agri.getSale().get(5).getNome()));
            DefaultTableModel tabellaSalottino = (DefaultTableModel) JTable7.getModel();
            arrayGestioneTabelle.add(new GestioneTabelle(tabellaSalottino, agri.getSale().get(6).getNome()));
            DefaultTableModel tabellaGarden = (DefaultTableModel) JTable8.getModel();
            arrayGestioneTabelle.add(new GestioneTabelle(tabellaGarden, agri.getSale().get(7).getNome()));
            DefaultTableModel tabellaAia = (DefaultTableModel) JTable9.getModel();
            arrayGestioneTabelle.add(new GestioneTabelle(tabellaAia, agri.getSale().get(8).getNome()));
            DefaultTableModel tabellaSalone = (DefaultTableModel) JTable10.getModel();
            arrayGestioneTabelle.add(new GestioneTabelle(tabellaSalone, agri.getSale().get(9).getNome()));
            DefaultTableModel tabellaGelsomino = (DefaultTableModel) JTable11.getModel();
            arrayGestioneTabelle.add(new GestioneTabelle(tabellaGelsomino, agri.getSale().get(10).getNome()));
            DefaultTableModel tabellaBalcone = (DefaultTableModel) JTable12.getModel();
            arrayGestioneTabelle.add(new GestioneTabelle(tabellaBalcone, agri.getSale().get(11).getNome()));
        }catch(IndexOutOfBoundsException ex){
        }

        
    }
    
   
    public void rimuoviRigheTabellaSala(){
        for(GestioneTabelle t: arrayGestioneTabelle){
            while(t.getDtm().getRowCount()>0){
                t.getDtm().removeRow(0);
            }
        }
    }
 
    //operazioni date
    public static Date rimuoviOrarioData(Date d){
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND,0);
        return cal.getTime();
    }
    public Date dataOdierda(){
        Calendar cal = Calendar.getInstance();
        dataOdierna= cal.getTime();
        dataOdierna = rimuoviOrarioData(dataOdierna);
        return dataOdierna;
    }
   
    
   
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        JTable1 = new javax.swing.JTable();
        JVerde = new javax.swing.JLabel();
        JNumeroPVerde = new javax.swing.JLabel();
        JPasto = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        JDateChooser = new com.toedter.calendar.JDateChooser();
        jScrollPane14 = new javax.swing.JScrollPane();
        JTuttiTavoli = new javax.swing.JTable();
        JVerde1 = new javax.swing.JLabel();
        JNumeroPVerde1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTable3 = new javax.swing.JTable();
        JVerde2 = new javax.swing.JLabel();
        JNumeroPVerde2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        JTable2 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        JTable4 = new javax.swing.JTable();
        JVerde3 = new javax.swing.JLabel();
        JNumeroPVerde3 = new javax.swing.JLabel();
        JNumeroPVerde4 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        JTable6 = new javax.swing.JTable();
        JVerde4 = new javax.swing.JLabel();
        JNumeroPVerde5 = new javax.swing.JLabel();
        JVerde5 = new javax.swing.JLabel();
        JNumeroPVerde6 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        JTable5 = new javax.swing.JTable();
        JVerde6 = new javax.swing.JLabel();
        JNumeroPVerde7 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        JTable7 = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        JTable8 = new javax.swing.JTable();
        JVerde7 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        JTable10 = new javax.swing.JTable();
        jScrollPane10 = new javax.swing.JScrollPane();
        JTable12 = new javax.swing.JTable();
        JNumeroPVerde8 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        JTable11 = new javax.swing.JTable();
        JNumeroPVerde9 = new javax.swing.JLabel();
        JNumeroPVerde10 = new javax.swing.JLabel();
        JNumeroPVerde11 = new javax.swing.JLabel();
        JVerde8 = new javax.swing.JLabel();
        JVerde9 = new javax.swing.JLabel();
        JVerde10 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        JTable9 = new javax.swing.JTable();
        JVerde11 = new javax.swing.JLabel();
        jButtonAggiorna = new javax.swing.JButton();
        jButtonModifica = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tavoli", "N.Persone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(JTable1);

        JVerde.setText("VERDE");

        JNumeroPVerde.setText("0");

        JPasto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pranzo", "Cena" }));
        JPasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JPastoActionPerformed(evt);
            }
        });

        jButton1.setText("PRENOTA");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        JDateChooser.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                JDateChooserPropertyChange(evt);
            }
        });

        JTuttiTavoli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tavoli", "N.Persone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        JTuttiTavoli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTuttiTavoliMouseClicked(evt);
            }
        });
        jScrollPane14.setViewportView(JTuttiTavoli);

        JVerde1.setText("ROSA");

        JNumeroPVerde1.setText("0");

        JTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tavoli", "N.Persone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(JTable3);

        JVerde2.setText("INGERESSO");

        JNumeroPVerde2.setText("0");

        JTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tavoli", "N.Persone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(JTable2);

        JTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tavoli", "N.Persone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(JTable4);

        JVerde3.setText("GIALLA");

        JNumeroPVerde3.setText("0");

        JNumeroPVerde4.setText("0");

        JTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tavoli", "N.Persone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane5.setViewportView(JTable6);

        JVerde4.setText("GIARDINO");

        JNumeroPVerde5.setText("0");

        JVerde5.setText("CORTE");

        JNumeroPVerde6.setText("0");

        JTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tavoli", "N.Persone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane6.setViewportView(JTable5);

        JVerde6.setText("GARDEN");

        JNumeroPVerde7.setText("0");

        JTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tavoli", "N.Persone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane7.setViewportView(JTable7);

        JTable8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tavoli", "N.Persone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane8.setViewportView(JTable8);

        JVerde7.setText("SALOTTINO");

        JTable10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tavoli", "N.Persone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane9.setViewportView(JTable10);

        JTable12.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tavoli", "N.Persone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane10.setViewportView(JTable12);

        JNumeroPVerde8.setText("0");

        JTable11.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tavoli", "N.Persone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane11.setViewportView(JTable11);

        JNumeroPVerde9.setText("0");

        JNumeroPVerde10.setText("0");

        JNumeroPVerde11.setText("0");

        JVerde8.setText("BALCONE");

        JVerde9.setText("SALONE");

        JVerde10.setText("GELSOMINO");

        JTable9.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tavoli", "N.Persone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane12.setViewportView(JTable9);

        JVerde11.setText("AIA");

        jButtonAggiorna.setText("Aggiorna");
        jButtonAggiorna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAggiornaActionPerformed(evt);
            }
        });

        jButtonModifica.setText("Modifica");
        jButtonModifica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(JVerde)
                                        .addGap(61, 61, 61)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButtonAggiorna)
                                            .addComponent(JNumeroPVerde))))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(35, 35, 35)
                                                .addComponent(JVerde1)
                                                .addGap(61, 61, 61)
                                                .addComponent(JNumeroPVerde1)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(35, 35, 35)
                                                .addComponent(JVerde3)
                                                .addGap(61, 61, 61)
                                                .addComponent(JNumeroPVerde3)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(35, 35, 35)
                                                .addComponent(JVerde2)
                                                .addGap(61, 61, 61)
                                                .addComponent(JNumeroPVerde2))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(jButtonModifica))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(JVerde4)
                                        .addGap(61, 61, 61)
                                        .addComponent(JNumeroPVerde5)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(JVerde5)
                                        .addGap(61, 61, 61)
                                        .addComponent(JNumeroPVerde6)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(JVerde7)
                                        .addGap(61, 61, 61)
                                        .addComponent(JNumeroPVerde4)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(JVerde6)
                                        .addGap(61, 61, 61)
                                        .addComponent(JNumeroPVerde7))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(JVerde9)
                                        .addGap(61, 61, 61)
                                        .addComponent(JNumeroPVerde11)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(JVerde8)
                                        .addGap(61, 61, 61)
                                        .addComponent(JNumeroPVerde10)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(JVerde11)
                                        .addGap(61, 61, 61)
                                        .addComponent(JNumeroPVerde9)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(JVerde10)
                                        .addGap(61, 61, 61)
                                        .addComponent(JNumeroPVerde8))))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JPasto, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(264, 264, 264)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(229, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JDateChooser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(JPasto, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonAggiorna)
                                        .addComponent(jButtonModifica))))
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addComponent(jScrollPane14))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(JVerde1)
                                    .addComponent(JNumeroPVerde1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(JVerde)
                                    .addComponent(JNumeroPVerde))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(JVerde2)
                                    .addComponent(JNumeroPVerde2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(JVerde3)
                                    .addComponent(JNumeroPVerde3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(JVerde5)
                                    .addComponent(JNumeroPVerde6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(JVerde4)
                                    .addComponent(JNumeroPVerde5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(JVerde6)
                                    .addComponent(JNumeroPVerde7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(JVerde7)
                                    .addComponent(JNumeroPVerde4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(JVerde8)
                                    .addComponent(JNumeroPVerde10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(JVerde9)
                                    .addComponent(JNumeroPVerde11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(JVerde10)
                                    .addComponent(JNumeroPVerde8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(JVerde11)
                                    .addComponent(JNumeroPVerde9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(206, 206, 206))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JDateChooserPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_JDateChooserPropertyChange
        if(date!=dataOdierna){
            date = JDateChooser.getDate();
        }
        if(date==null){
            date = dataOdierda();
        }
        date = rimuoviOrarioData(date);
        aggiornaTabelle(date);
    }//GEN-LAST:event_JDateChooserPropertyChange

    private void JPastoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JPastoActionPerformed
       pasto = (String) JPasto.getSelectedItem();
    }//GEN-LAST:event_JPastoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        GuiPrenotazione guiPrenotazione = null;
        try {
            guiPrenotazione = new GuiPrenotazione();
        } catch (SQLException ex) {
            Logger.getLogger(GuiProva.class.getName()).log(Level.SEVERE, null, ex);
        }
        guiPrenotazione.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonAggiornaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAggiornaActionPerformed
        date = rimuoviOrarioData(date);
        aggiornaTabelle(date);
     
        
        
    }//GEN-LAST:event_jButtonAggiornaActionPerformed

    private void JTuttiTavoliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTuttiTavoliMouseClicked
       
    }//GEN-LAST:event_JTuttiTavoliMouseClicked

    private void jButtonModificaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificaActionPerformed
        
    }//GEN-LAST:event_jButtonModificaActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser JDateChooser;
    private javax.swing.JLabel JNumeroPVerde;
    private javax.swing.JLabel JNumeroPVerde1;
    private javax.swing.JLabel JNumeroPVerde10;
    private javax.swing.JLabel JNumeroPVerde11;
    private javax.swing.JLabel JNumeroPVerde2;
    private javax.swing.JLabel JNumeroPVerde3;
    private javax.swing.JLabel JNumeroPVerde4;
    private javax.swing.JLabel JNumeroPVerde5;
    private javax.swing.JLabel JNumeroPVerde6;
    private javax.swing.JLabel JNumeroPVerde7;
    private javax.swing.JLabel JNumeroPVerde8;
    private javax.swing.JLabel JNumeroPVerde9;
    private javax.swing.JComboBox<String> JPasto;
    public javax.swing.JTable JTable1;
    public javax.swing.JTable JTable10;
    public javax.swing.JTable JTable11;
    public javax.swing.JTable JTable12;
    public javax.swing.JTable JTable2;
    public javax.swing.JTable JTable3;
    public javax.swing.JTable JTable4;
    public javax.swing.JTable JTable5;
    public javax.swing.JTable JTable6;
    public javax.swing.JTable JTable7;
    public javax.swing.JTable JTable8;
    public javax.swing.JTable JTable9;
    private javax.swing.JTable JTuttiTavoli;
    private javax.swing.JLabel JVerde;
    private javax.swing.JLabel JVerde1;
    private javax.swing.JLabel JVerde10;
    private javax.swing.JLabel JVerde11;
    private javax.swing.JLabel JVerde2;
    private javax.swing.JLabel JVerde3;
    private javax.swing.JLabel JVerde4;
    private javax.swing.JLabel JVerde5;
    private javax.swing.JLabel JVerde6;
    private javax.swing.JLabel JVerde7;
    private javax.swing.JLabel JVerde8;
    private javax.swing.JLabel JVerde9;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAggiorna;
    private javax.swing.JButton jButtonModifica;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    // End of variables declaration//GEN-END:variables

    
}

