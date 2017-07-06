/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

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
    private ArrayList<GestioneTabelle> arrayJTable = new ArrayList<>();


    
    public GuiProva() {    
        initComponents();
        aggiungiTabelleArray();
        aggiornaTabelle(date);
        JDateChooser.setDate(dataOdierna);
        
       
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
        for(GestioneTabelle t: arrayJTable){
            if(a.getSala().getNome().equals(t.getNomeSala())){
                t.getDtm().addRow(object);
                if(a.getSala().getNome() != "Indifferente"){
                    arrayJTable.get(0).getDtm().addRow(object); //aggiungo i tavoli anche alla tabella principale
                }
            }
        }
    }
    public void aggiungiTabelleArray(){
        DefaultTableModel tabellaPrincipale = (DefaultTableModel) JTuttiTavoli.getModel();
        arrayJTable.add(new GestioneTabelle(tabellaPrincipale, "Indifferente"));
        DefaultTableModel tabellaVerde = (DefaultTableModel) JTavoliVerde.getModel();
        arrayJTable.add(new GestioneTabelle(tabellaVerde, "Verde"));
        DefaultTableModel tabellaGilla = (DefaultTableModel) JTavoliGialla.getModel();
        arrayJTable.add(new GestioneTabelle(tabellaGilla, "Gialla"));
        DefaultTableModel tabellaRosa = (DefaultTableModel) JTavoliRosa.getModel();
        arrayJTable.add(new GestioneTabelle(tabellaRosa, "Rosa"));
        DefaultTableModel tabellaIngresso = (DefaultTableModel) JTavoliIngresso.getModel();
        arrayJTable.add(new GestioneTabelle(tabellaIngresso, "Ingresso"));
        DefaultTableModel tabellaCorte = (DefaultTableModel) JTavoliCorte.getModel();
        arrayJTable.add(new GestioneTabelle(tabellaCorte, "Corte"));
        DefaultTableModel tabellaGiardino = (DefaultTableModel) JTavoliGiardino.getModel();
        arrayJTable.add(new GestioneTabelle(tabellaGiardino, "Giardino"));
        DefaultTableModel tabellaSalottino = (DefaultTableModel) JTavoliSalottino.getModel();
        arrayJTable.add(new GestioneTabelle(tabellaSalottino, "Salottino"));
        DefaultTableModel tabellaGarden = (DefaultTableModel) JTavoliGarden.getModel();
        arrayJTable.add(new GestioneTabelle(tabellaGarden, "Garden"));
        DefaultTableModel tabellaAia = (DefaultTableModel) JTavoliAia.getModel();
        arrayJTable.add(new GestioneTabelle(tabellaAia, "Aia"));
        DefaultTableModel tabellaSalone = (DefaultTableModel) JTavoliSalone.getModel();
        arrayJTable.add(new GestioneTabelle(tabellaSalone, "Salone"));
        DefaultTableModel tabellaGelsomino = (DefaultTableModel) JTavoliGelsomino.getModel();
        arrayJTable.add(new GestioneTabelle(tabellaGelsomino, "Gelsomino"));
        DefaultTableModel tabellaBalcone = (DefaultTableModel) JTavoliBalcone.getModel();
        arrayJTable.add(new GestioneTabelle(tabellaBalcone, "Balcone"));
        
    }
    
   
    public void rimuoviRigheTabellaSala(){
        for(GestioneTabelle t: arrayJTable){
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
        JTavoliVerde = new javax.swing.JTable();
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
        JTavoliRosa = new javax.swing.JTable();
        JVerde2 = new javax.swing.JLabel();
        JNumeroPVerde2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        JTavoliGialla = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        JTavoliIngresso = new javax.swing.JTable();
        JVerde3 = new javax.swing.JLabel();
        JNumeroPVerde3 = new javax.swing.JLabel();
        JNumeroPVerde4 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        JTavoliGiardino = new javax.swing.JTable();
        JVerde4 = new javax.swing.JLabel();
        JNumeroPVerde5 = new javax.swing.JLabel();
        JVerde5 = new javax.swing.JLabel();
        JNumeroPVerde6 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        JTavoliCorte = new javax.swing.JTable();
        JVerde6 = new javax.swing.JLabel();
        JNumeroPVerde7 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        JTavoliSalottino = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        JTavoliGarden = new javax.swing.JTable();
        JVerde7 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        JTavoliSalone = new javax.swing.JTable();
        jScrollPane10 = new javax.swing.JScrollPane();
        JTavoliBalcone = new javax.swing.JTable();
        JNumeroPVerde8 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        JTavoliGelsomino = new javax.swing.JTable();
        JNumeroPVerde9 = new javax.swing.JLabel();
        JNumeroPVerde10 = new javax.swing.JLabel();
        JNumeroPVerde11 = new javax.swing.JLabel();
        JVerde8 = new javax.swing.JLabel();
        JVerde9 = new javax.swing.JLabel();
        JVerde10 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        JTavoliAia = new javax.swing.JTable();
        JVerde11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JTavoliVerde.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(JTavoliVerde);

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
        jScrollPane14.setViewportView(JTuttiTavoli);

        JVerde1.setText("ROSA");

        JNumeroPVerde1.setText("0");

        JTavoliRosa.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(JTavoliRosa);

        JVerde2.setText("INGERESSO");

        JNumeroPVerde2.setText("0");

        JTavoliGialla.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(JTavoliGialla);

        JTavoliIngresso.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(JTavoliIngresso);

        JVerde3.setText("GIALLA");

        JNumeroPVerde3.setText("0");

        JNumeroPVerde4.setText("0");

        JTavoliGiardino.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(JTavoliGiardino);

        JVerde4.setText("GIARDINO");

        JNumeroPVerde5.setText("0");

        JVerde5.setText("CORTE");

        JNumeroPVerde6.setText("0");

        JTavoliCorte.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(JTavoliCorte);

        JVerde6.setText("GARDEN");

        JNumeroPVerde7.setText("0");

        JTavoliSalottino.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane7.setViewportView(JTavoliSalottino);

        JTavoliGarden.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane8.setViewportView(JTavoliGarden);

        JVerde7.setText("SALOTTINO");

        JTavoliSalone.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane9.setViewportView(JTavoliSalone);

        JTavoliBalcone.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane10.setViewportView(JTavoliBalcone);

        JNumeroPVerde8.setText("0");

        JTavoliGelsomino.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane11.setViewportView(JTavoliGelsomino);

        JNumeroPVerde9.setText("0");

        JNumeroPVerde10.setText("0");

        JNumeroPVerde11.setText("0");

        JVerde8.setText("BALCONE");

        JVerde9.setText("SALONE");

        JVerde10.setText("GELSOMINO");

        JTavoliAia.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane12.setViewportView(JTavoliAia);

        JVerde11.setText("AIA");

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
                                        .addComponent(JNumeroPVerde)))
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
                .addContainerGap(335, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JDateChooser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JPasto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
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
       aggiornaTabelle(date);
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
    public javax.swing.JTable JTavoliAia;
    public javax.swing.JTable JTavoliBalcone;
    public javax.swing.JTable JTavoliCorte;
    public javax.swing.JTable JTavoliGarden;
    public javax.swing.JTable JTavoliGelsomino;
    public javax.swing.JTable JTavoliGialla;
    public javax.swing.JTable JTavoliGiardino;
    public javax.swing.JTable JTavoliIngresso;
    public javax.swing.JTable JTavoliRosa;
    public javax.swing.JTable JTavoliSalone;
    public javax.swing.JTable JTavoliSalottino;
    public javax.swing.JTable JTavoliVerde;
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

