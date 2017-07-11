package gui;

import com.toedter.calendar.JDateChooser;
import databse.CreateDb;
import funzionalita.Prenotazione;
import gui.GestioneTabelle;
import java.awt.AWTEventMulticaster;
import java.awt.ComponentOrientation;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputAdapter;
import javax.swing.table.DefaultTableModel;
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
 * @author Marcello
 */
public class GuiProvaM extends javax.swing.JFrame {
    private Agriturismo agri = new Agriturismo();
    protected Date date = new Date();
    protected static Date dataOdierna = new Date();
    private String pasto="Pranzo";
    private Object[] object;
    private CreateDb createDb;
    private ArrayList<GestioneTabelle> arrayJTable = new ArrayList<>();
    private int numeroSale;
    private int[] numPplPerRoom = new int[12];
    private ArrayList<JMenuItem> arrayItem = new ArrayList<>();
    private int id;
    private String nomePrenotazione;
    
    
    /**
     * Creates new form GUI
     */
    public GuiProvaM() throws SQLException {
        createDb = new CreateDb();
        initComponents();
        setLocationRelativeTo(null);
        inizializzo();
        aggiungiTabelleArray();
        jDateChooser.setDate(dataOdierna);
        numeroSale = createDb.getNumeroSale();
        inserisciSale(numeroSale);
        
        impostaJModifica();
        impostaRimuovi();
        
    }
     public ArrayList<GestioneTabelle> getArrayJTable() {
        return arrayJTable;
    }
    public void inizializzo(){
        jScrollPane13.setVisible(false);
        jScrollPane3.setVisible(false);
        jScrollPane4.setVisible(false);
        jScrollPane5.setVisible(false);
        jScrollPane6.setVisible(false);
        jScrollPane7.setVisible(false);
        jScrollPane8.setVisible(false);
        jScrollPane9.setVisible(false);
        jScrollPane10.setVisible(false);
        jScrollPane11.setVisible(false);
        jScrollPane12.setVisible(false);
        label2sala.setVisible(false);
        label3sala.setVisible(false);
        label4sala.setVisible(false);
        label5sala.setVisible(false);
        label6sala.setVisible(false);
        label7sala.setVisible(false);
        label8sala.setVisible(false);
        label9sala.setVisible(false);
        label10sala.setVisible(false);
        label11sala.setVisible(false);
        label12sala.setVisible(false);
        labelnp2.setVisible(false);
        labelnp3.setVisible(false);
        labelnp4.setVisible(false);
        labelnp5.setVisible(false);
        labelnp6.setVisible(false);
        labelnp7.setVisible(false);
        labelnp8.setVisible(false);
        labelnp9.setVisible(false);
        labelnp10.setVisible(false);
        labelnp11.setVisible(false);
        labelnp12.setVisible(false);
        
        
        
        
    }
    public void aggiornaTabelle(Date d){  
        rimuoviRigheTabellaSala();
        for(Prenotazione p: agri.getPrenotazione()){ 
            if((d.equals(p.getDate())) && pasto.equals(p.getPasto())){
                object = new Object[]{p.getCliente().getNome(),p.getnAdulti()+p.getnBambini(),p.getId()};
                aggiornaTabelleSale(p);
            }
        }  
    }
    public void aggiornaTabelleSale(Prenotazione a){
         int i = 0;
         for(GestioneTabelle t: arrayJTable){
            if(a.getSala().getNome().equals(t.getNomeSala())){
                t.getDtm().addRow(object);
                if(!a.getSala().getNome().equalsIgnoreCase("Indifferente")){
                    arrayJTable.get(0).getDtm().addRow(object); //aggiungo i tavoli anche alla tabella principale
                    i = arrayJTable.get(0).getDtm().getRowCount();
                }
            if(a.getAttesa()==1){
                    arrayJTable.get(1).getDtm().addRow(object); 
                    arrayJTable.get(0).getDtm().removeRow(i-1);
                    t.getDtm().removeRow(i-1);
            }
        }
            try{
                refreshNumber();
            }catch(NullPointerException e){}
        }

    }
    public void aggiungiTabelleArray(){    
        try{
            DefaultTableModel tabellaPrincipale = (DefaultTableModel) jTable1.getModel();
            arrayJTable.add(new GestioneTabelle(tabellaPrincipale, "Indifferente"));
            DefaultTableModel tabellaSala13 = (DefaultTableModel) tabellaAttesa.getModel();
            arrayJTable.add(new GestioneTabelle(tabellaSala13, "tabellaAttesa"));
            DefaultTableModel tabellaSala1 = (DefaultTableModel) tavolo1.getModel();
            arrayJTable.add(new GestioneTabelle(tabellaSala1, agri.getSale().get(0).getNome()));
            DefaultTableModel tabellaSala2 = (DefaultTableModel) tavolo2.getModel();
            arrayJTable.add(new GestioneTabelle(tabellaSala2, agri.getSale().get(1).getNome()));
            DefaultTableModel tabellaSala3 = (DefaultTableModel) tavolo3.getModel();
            arrayJTable.add(new GestioneTabelle(tabellaSala3, agri.getSale().get(2).getNome()));
            DefaultTableModel tabellaSala4 = (DefaultTableModel) tavolo4.getModel();
            arrayJTable.add(new GestioneTabelle(tabellaSala4, agri.getSale().get(3).getNome()));
            DefaultTableModel tabellaSala5 = (DefaultTableModel) tavolo5.getModel();
            arrayJTable.add(new GestioneTabelle(tabellaSala5, agri.getSale().get(4).getNome()));
            DefaultTableModel tabellaSala6 = (DefaultTableModel) tavolo6.getModel();
            arrayJTable.add(new GestioneTabelle(tabellaSala6, agri.getSale().get(5).getNome()));
            DefaultTableModel tabellaSala7 = (DefaultTableModel) tavolo7.getModel();
            arrayJTable.add(new GestioneTabelle(tabellaSala7, agri.getSale().get(6).getNome()));
            DefaultTableModel tabellaSala8 = (DefaultTableModel) tavolo8.getModel();
            arrayJTable.add(new GestioneTabelle(tabellaSala8, agri.getSale().get(7).getNome()));
            DefaultTableModel tabellaSala9 = (DefaultTableModel) tavolo9.getModel();
            arrayJTable.add(new GestioneTabelle(tabellaSala9, agri.getSale().get(8).getNome()));
            DefaultTableModel tabellaSala10 = (DefaultTableModel) tavolo10.getModel();
            arrayJTable.add(new GestioneTabelle(tabellaSala10, agri.getSale().get(9).getNome()));
            DefaultTableModel tabellaSala11 = (DefaultTableModel) tavolo11.getModel();
            arrayJTable.add(new GestioneTabelle(tabellaSala11, agri.getSale().get(10).getNome()));
            DefaultTableModel tabellaSala12 = (DefaultTableModel) tavolo12.getModel();
            arrayJTable.add(new GestioneTabelle(tabellaSala12, agri.getSale().get(11).getNome()));
         
        }catch(IndexOutOfBoundsException ex){
        }
        
    }
    public void rimuoviRigheTabellaSala(){
        for(GestioneTabelle t: arrayJTable){
            while(t.getDtm().getRowCount()>0){
                t.getDtm().removeRow(0);
            }
        }
    }
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
    public void impostaMenu() throws SQLException{
        
        jModifica.setText("Modifica");
        jSposta.setText("Sposta");
        jRimuovi.setText("Rimuovi");
        jMenuPrincipale.add(jModifica);
        jMenuPrincipale.add(jRimuovi);
//        int i = 0;
//        jMenuSale.removeAll();
//        for(Sala s: agri.getSale()){
//            JMenuItem itemSala = new JMenuItem(s.getNome());
//            arrayItem.add(itemSala);
//            jMenuSale.add(arrayItem.get(i));
//            i++;
//        }
        
       
    }
    public void impostaJSposta(){
         jSposta.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                try{
                    jMenuSale.show(me.getComponent(), me.getX(), me.getY());
                }catch(java.awt.IllegalComponentStateException e){}
            }
        });
        for(JMenuItem jmi: arrayItem){
            jmi.addMouseListener(new MouseInputAdapter() {
                @Override
                public void mouseExited(MouseEvent me) {
                }
   
            });
        }
    }
    public void impostaJModifica() throws SQLException{
        jModifica.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                ModificaPrenotazione mp;
                try {
                    mp = new ModificaPrenotazione();
                    mp.setDataField(id);
                    mp.setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(GuiProvaM.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
        });
    }
    public void inserisciSale(int n){

        switch(n){
            case 1:
                jScrollPane2.setVisible(true);
                jScrollPane2.setSize(860,550);
                labelnp1.setLocation(1080, 120);
                label1sala.setVisible(true);
                labelnp1.setVisible(true);
                label1sala.setText(agri.getSale().get(0).getNome());
                break;
            case 2:
                jScrollPane3.setVisible(true);
                jScrollPane3.setLocation(700,140);
                jScrollPane2.setSize(400,500);
                jScrollPane3.setSize(400,500);
                label2sala.setVisible(true);
                labelnp1.setLocation(620, 120);
                label2sala.setLocation(700,120);
                labelnp2.setLocation(1080, 120);
                labelnp2.setVisible(true);
                label1sala.setText(agri.getSale().get(0).getNome());
                label2sala.setText(agri.getSale().get(1).getNome());
                break;
            case 3:
                jScrollPane2.setSize(250,500);
                jScrollPane3.setSize(250,500);
                jScrollPane5.setSize(250,500);
                jScrollPane2.setVisible(true);
                jScrollPane3.setLocation(550,140);
                jScrollPane3.setVisible(true);
                jScrollPane5.setVisible(true);
                jScrollPane5.setLocation(850,140);
                label3sala.setVisible(true);
                labelnp3.setVisible(true);
                label3sala.setLocation(850, 120);
                labelnp3.setLocation(1080, 120);
                label2sala.setVisible(true);
                label2sala.setLocation(550,120);
                labelnp2.setVisible(true);
                labelnp2.setLocation(780, 120);
                labelnp1.setLocation(470,120);
                label1sala.setText(agri.getSale().get(0).getNome());
                label2sala.setText(agri.getSale().get(1).getNome());
                label3sala.setText(agri.getSale().get(2).getNome());    
                break;
            case 4:
                jScrollPane2.setSize(200,500);
                jScrollPane3.setSize(200,500);
                jScrollPane5.setSize(200,500);
                jScrollPane4.setSize(200,500);
                jScrollPane2.setVisible(true);
                jScrollPane3.setVisible(true);
                jScrollPane5.setVisible(true);
                jScrollPane4.setVisible(true);
                label2sala.setVisible(true);
                labelnp2.setVisible(true);
                label3sala.setVisible(true);
                labelnp3.setVisible(true);
                label4sala.setVisible(true);
                labelnp4.setVisible(true);
                label1sala.setText(agri.getSale().get(0).getNome());
                label2sala.setText(agri.getSale().get(1).getNome());
                label3sala.setText(agri.getSale().get(2).getNome());
                label4sala.setText(agri.getSale().get(3).getNome());
                break;
            case 5:
                jScrollPane2.setSize(250,200);
                jScrollPane3.setSize(250,200);
                jScrollPane5.setSize(250,200);
                jScrollPane2.setVisible(true);
                jScrollPane3.setLocation(545,140);
                jScrollPane3.setVisible(true);
                jScrollPane5.setVisible(true);
                jScrollPane5.setLocation(850,140);
                jScrollPane4.setLocation(400,400);
                jScrollPane6.setLocation(700,400);
                jScrollPane6.setVisible(true);
                jScrollPane4.setVisible(true);
                jScrollPane6.setSize(250,200);
                jScrollPane4.setSize(250,200);
                label3sala.setVisible(true);
                labelnp3.setVisible(true);
                label3sala.setLocation(850, 120);
                labelnp3.setLocation(1080, 120);
                label2sala.setVisible(true);
                label2sala.setLocation(545,120);
                labelnp2.setVisible(true);
                labelnp2.setLocation(775, 120);
                label4sala.setLocation(400,380);
                labelnp4.setLocation(630,380);
                labelnp4.setVisible(true);
                label4sala.setVisible(true);
                label5sala.setLocation(700,380);
                label5sala.setVisible(true);
                labelnp5.setVisible(true);
                labelnp5.setLocation(930,380);
                labelnp1.setLocation(470,120);
                label1sala.setText(agri.getSale().get(0).getNome());
                label2sala.setText(agri.getSale().get(1).getNome());
                label3sala.setText(agri.getSale().get(2).getNome());
                label4sala.setText(agri.getSale().get(3).getNome());
                label5sala.setText(agri.getSale().get(4).getNome());
                break;
            case 6: 
                jScrollPane2.setSize(250,250);
                jScrollPane3.setSize(250,250);
                jScrollPane5.setSize(250,250);
                jScrollPane2.setVisible(true);
                jScrollPane3.setLocation(550,140);
                jScrollPane3.setVisible(true);
                jScrollPane5.setVisible(true);
                jScrollPane5.setLocation(850,140);
                label3sala.setVisible(true);
                labelnp3.setVisible(true);
                label3sala.setLocation(850, 120);
                labelnp3.setLocation(1080, 120);
                label2sala.setVisible(true);
                label2sala.setLocation(550,120);
                labelnp2.setVisible(true);
                labelnp2.setLocation(780, 120);
                labelnp1.setLocation(470,120);
                jScrollPane4.setVisible(true);
                jScrollPane4.setLocation(240,420);
                jScrollPane4.setSize(250,250);
                jScrollPane6.setVisible(true);
                jScrollPane6.setLocation(550,420);
                jScrollPane6.setSize(250,250);
                jScrollPane7.setVisible(true);
                jScrollPane7.setSize(250,250);
                jScrollPane7.setLocation(850,420);
                label4sala.setVisible(true);
                label4sala.setLocation(240,400);
                labelnp4.setVisible(true);
                labelnp4.setLocation(470, 400);
                label5sala.setVisible(true);
                label5sala.setLocation(550,400);
                labelnp5.setVisible(true);
                labelnp5.setLocation(780,400);
                label6sala.setVisible(true);
                label6sala.setLocation(850,400);
                labelnp6.setVisible(true);
                labelnp6.setLocation(1080,400);
                label1sala.setText(agri.getSale().get(0).getNome());
                label2sala.setText(agri.getSale().get(1).getNome());
                label3sala.setText(agri.getSale().get(2).getNome());
                label4sala.setText(agri.getSale().get(3).getNome());
                label5sala.setText(agri.getSale().get(4).getNome());
                label6sala.setText(agri.getSale().get(5).getNome());
                break;
            case 7:
                jScrollPane2.setSize(200,250);
                jScrollPane3.setSize(200,250);
                jScrollPane5.setSize(200,250);
                jScrollPane4.setSize(200,250);
                jScrollPane2.setVisible(true);
                jScrollPane3.setVisible(true);
                jScrollPane5.setVisible(true);
                jScrollPane4.setVisible(true);
                jScrollPane6.setVisible(true);
                jScrollPane6.setLocation(350,420);
                jScrollPane6.setSize(200,250);
                jScrollPane7.setVisible(true);
                jScrollPane7.setSize(200,250);
                jScrollPane7.setLocation(580,420);
                jScrollPane8.setVisible(true);
                jScrollPane8.setLocation(810,420);
                jScrollPane8.setSize(200,250);
                label5sala.setVisible(true);
                label5sala.setLocation(350, 400);
                labelnp5.setVisible(true);
                labelnp5.setLocation(530,400);
                label6sala.setVisible(true);
                label6sala.setLocation(580,400);
                labelnp6.setVisible(true);
                labelnp6.setLocation(760,400);
                label7sala.setVisible(true);
                label7sala.setLocation(810,400);
                labelnp7.setVisible(true);
                labelnp7.setLocation(990,400);
                label2sala.setVisible(true);
                labelnp2.setVisible(true);
                label3sala.setVisible(true);
                labelnp3.setVisible(true);
                label4sala.setVisible(true);
                labelnp4.setVisible(true);
                label1sala.setText(agri.getSale().get(0).getNome());
                label2sala.setText(agri.getSale().get(1).getNome());
                label3sala.setText(agri.getSale().get(2).getNome());
                label4sala.setText(agri.getSale().get(3).getNome());
                label5sala.setText(agri.getSale().get(4).getNome());
                label6sala.setText(agri.getSale().get(5).getNome());
                label7sala.setText(agri.getSale().get(6).getNome());
                break;
            case 8: 
                jScrollPane2.setSize(200,250);
                jScrollPane3.setSize(200,250);
                jScrollPane5.setSize(200,250);
                jScrollPane4.setSize(200,250);
                jScrollPane6.setSize(200,250);
                jScrollPane7.setSize(200,250);
                jScrollPane8.setSize(200,250);
                jScrollPane9.setSize(200,250);
                jScrollPane6.setLocation(240,420);
                jScrollPane7.setLocation(460,420);
                jScrollPane8.setLocation(680,420);
                jScrollPane9.setLocation(900,420);
                label5sala.setLocation(240,400);
                label5sala.setVisible(true);
                labelnp5.setVisible(true);
                labelnp5.setLocation(420,400);
                label6sala.setLocation(460,400);
                label6sala.setVisible(true);
                labelnp6.setLocation(640,400);
                label7sala.setLocation(680,400);
                label7sala.setVisible(true);
                labelnp7.setVisible(true);
                labelnp7.setLocation(860, 400);
                label8sala.setVisible(true);
                label8sala.setLocation(900, 400);
                labelnp8.setVisible(true);
                labelnp8.setLocation(1080, 400);
                labelnp6.setVisible(true);
                jScrollPane6.setVisible(true);
                jScrollPane7.setVisible(true);
                jScrollPane8.setVisible(true);
                jScrollPane9.setVisible(true);
                jScrollPane2.setVisible(true);
                jScrollPane3.setVisible(true);
                jScrollPane5.setVisible(true);
                jScrollPane4.setVisible(true);
                label2sala.setVisible(true);
                labelnp2.setVisible(true);
                label3sala.setVisible(true);
                labelnp3.setVisible(true);
                label4sala.setVisible(true);
                labelnp4.setVisible(true);
                label1sala.setText(agri.getSale().get(0).getNome());
                label2sala.setText(agri.getSale().get(1).getNome());
                label3sala.setText(agri.getSale().get(2).getNome());
                label4sala.setText(agri.getSale().get(3).getNome());
                label5sala.setText(agri.getSale().get(4).getNome());
                label6sala.setText(agri.getSale().get(5).getNome());
                label7sala.setText(agri.getSale().get(6).getNome());
                label8sala.setText(agri.getSale().get(7).getNome());
                break;
            case 9:
                jScrollPane2.setSize(250,200);
                jScrollPane3.setSize(250,200);
                jScrollPane5.setSize(250,200);
                jScrollPane2.setVisible(true);
                jScrollPane3.setLocation(550,140);
                jScrollPane3.setVisible(true);
                jScrollPane5.setVisible(true);
                jScrollPane5.setLocation(850,140);
                label3sala.setVisible(true);
                labelnp3.setVisible(true);
                label3sala.setLocation(850, 120);
                labelnp3.setLocation(1080, 120);
                label2sala.setVisible(true);
                label2sala.setLocation(550,120);
                labelnp2.setVisible(true);
                labelnp2.setLocation(780, 120);
                labelnp1.setLocation(470,120);
                jScrollPane4.setVisible(true);
                jScrollPane4.setLocation(240,370);
                jScrollPane4.setSize(250,200);
                jScrollPane6.setVisible(true);
                jScrollPane6.setLocation(550,370);
                jScrollPane6.setSize(250,200);
                jScrollPane7.setVisible(true);
                jScrollPane7.setSize(250,200);
                jScrollPane7.setLocation(850,370);
                label4sala.setVisible(true);
                label4sala.setLocation(240,350);
                labelnp4.setVisible(true);
                labelnp4.setLocation(470, 350);
                label5sala.setVisible(true);
                label5sala.setLocation(550,350);
                labelnp5.setVisible(true);
                labelnp5.setLocation(780,350);
                label6sala.setVisible(true);
                label6sala.setLocation(850,350);
                labelnp6.setVisible(true);
                labelnp6.setLocation(1080,350);
                
                jScrollPane8.setSize(250,200);
                jScrollPane9.setSize(250,200);
                jScrollPane8.setLocation(250,600);
                jScrollPane9.setVisible(true);
                jScrollPane9.setLocation(550,600);
                jScrollPane8.setVisible(true);
                jScrollPane10.setVisible(true);
                jScrollPane10.setLocation(850,600);
                jScrollPane10.setSize(250, 200);
                label7sala.setLocation(250,580);
                label7sala.setVisible(true);
                labelnp7.setVisible(true);
                labelnp7.setLocation(480, 580);
                label8sala.setVisible(true);
                label8sala.setLocation(550,580);
                labelnp8.setVisible(true);
                labelnp8.setLocation(780, 580);
                label9sala.setVisible(true);
                label9sala.setLocation(850,580);
                labelnp9.setLocation(1080,580);
                labelnp9.setVisible(true);
                label1sala.setText(agri.getSale().get(0).getNome());
                label2sala.setText(agri.getSale().get(1).getNome());
                label3sala.setText(agri.getSale().get(2).getNome());
                label4sala.setText(agri.getSale().get(3).getNome());
                label5sala.setText(agri.getSale().get(4).getNome());
                label6sala.setText(agri.getSale().get(5).getNome());
                label7sala.setText(agri.getSale().get(6).getNome());
                label8sala.setText(agri.getSale().get(7).getNome());
                label9sala.setText(agri.getSale().get(8).getNome());
                break;
            case 10:
                jScrollPane2.setVisible(true);
                label2sala.setVisible(true);
                labelnp2.setVisible(true);
                jScrollPane5.setVisible(true);
                label5sala.setVisible(true);
                labelnp5.setVisible(true);
                jScrollPane6.setVisible(true);
                label6sala.setVisible(true);
                labelnp6.setVisible(true);
                jScrollPane9.setVisible(true);
                jScrollPane10.setLocation(460,580);
                label9sala.setVisible(true);
                labelnp9.setVisible(true);
                jScrollPane10.setVisible(true);
                jScrollPane11.setLocation(680,580);
                jScrollPane11.setVisible(true);
                jScrollPane3.setVisible(true);
                label3sala.setVisible(true);
                labelnp3.setVisible(true);
                jScrollPane7.setVisible(true);
                label7sala.setVisible(true);
                labelnp7.setVisible(true);
                jScrollPane4.setVisible(true);
                label4sala.setVisible(true);
                labelnp4.setVisible(true);
                jScrollPane8.setVisible(true);
                label8sala.setVisible(true);
                labelnp8.setVisible(true);
                label9sala.setLocation(460,560);
                labelnp9.setLocation(650,560);
                label10sala.setVisible(true);
                label10sala.setLocation(680,560);
                labelnp10.setLocation(860,560);
                labelnp10.setVisible(true);
                label1sala.setText(agri.getSale().get(0).getNome());
                label2sala.setText(agri.getSale().get(1).getNome());
                label3sala.setText(agri.getSale().get(2).getNome());
                label4sala.setText(agri.getSale().get(3).getNome());
                label5sala.setText(agri.getSale().get(4).getNome());
                label6sala.setText(agri.getSale().get(5).getNome());
                label7sala.setText(agri.getSale().get(6).getNome());
                label8sala.setText(agri.getSale().get(7).getNome());
                label9sala.setText(agri.getSale().get(8).getNome());
                label10sala.setText(agri.getSale().get(9).getNome());
                break;
            case 11:
                jScrollPane2.setVisible(true);
                label2sala.setVisible(true);
                labelnp2.setVisible(true);
                jScrollPane5.setVisible(true);
                label5sala.setVisible(true);
                labelnp5.setVisible(true);
                jScrollPane6.setVisible(true);
                label6sala.setVisible(true);
                labelnp6.setVisible(true);
                jScrollPane9.setVisible(true);
                label9sala.setVisible(true);
                labelnp9.setVisible(true);
                jScrollPane10.setVisible(true);
                jScrollPane10.setLocation(300,580);
                label9sala.setLocation(300,560);
                labelnp9.setLocation(480,560);
                label10sala.setVisible(true);
                label10sala.setLocation(580,560);
                labelnp10.setVisible(true);
                labelnp10.setLocation(760,560);
                label11sala.setVisible(true);
                label11sala.setLocation(850,560);
                labelnp11.setVisible(true);
                labelnp11.setLocation(1030, 560);
                jScrollPane11.setVisible(true);
                jScrollPane11.setLocation(580, 580);
                jScrollPane12.setVisible(true);
                jScrollPane12.setLocation(850,580);
                jScrollPane3.setVisible(true);
                label3sala.setVisible(true);
                labelnp3.setVisible(true);
                jScrollPane7.setVisible(true);
                label7sala.setVisible(true);
                labelnp7.setVisible(true);
                jScrollPane4.setVisible(true);
                label4sala.setVisible(true);
                labelnp4.setVisible(true);
                jScrollPane8.setVisible(true);
                label8sala.setVisible(true);
                labelnp8.setVisible(true);
                label1sala.setText(agri.getSale().get(0).getNome());
                label2sala.setText(agri.getSale().get(1).getNome());
                label3sala.setText(agri.getSale().get(2).getNome());
                label4sala.setText(agri.getSale().get(3).getNome());
                label5sala.setText(agri.getSale().get(4).getNome());
                label6sala.setText(agri.getSale().get(5).getNome());
                label7sala.setText(agri.getSale().get(6).getNome());
                label8sala.setText(agri.getSale().get(7).getNome());
                label9sala.setText(agri.getSale().get(8).getNome());
                label10sala.setText(agri.getSale().get(9).getNome());
                label11sala.setText(agri.getSale().get(10).getNome());
                break;
            case 12:
                jScrollPane2.setVisible(true);
                label2sala.setVisible(true);
                labelnp2.setVisible(true);
                jScrollPane5.setVisible(true);
                label5sala.setVisible(true);
                labelnp5.setVisible(true);
                jScrollPane6.setVisible(true);
                label6sala.setVisible(true);
                labelnp6.setVisible(true);
                jScrollPane9.setVisible(true);
                label9sala.setVisible(true);
                labelnp9.setVisible(true);
                jScrollPane10.setVisible(true);
                label10sala.setVisible(true);
                labelnp10.setVisible(true);
                jScrollPane3.setVisible(true);
                label3sala.setVisible(true);
                labelnp3.setVisible(true);
                jScrollPane7.setVisible(true);
                label7sala.setVisible(true);
                labelnp7.setVisible(true);
                jScrollPane12.setVisible(true);
                label11sala.setVisible(true);
                labelnp11.setVisible(true);
                jScrollPane4.setVisible(true);
                label4sala.setVisible(true);
                labelnp4.setVisible(true);
                jScrollPane8.setVisible(true);
                label8sala.setVisible(true);
                labelnp8.setVisible(true);
                jScrollPane11.setVisible(true);
                label12sala.setVisible(true);
                labelnp12.setVisible(true);
                jScrollPane13.setVisible(true);
                label1sala.setText(agri.getSale().get(0).getNome());
                label2sala.setText(agri.getSale().get(1).getNome());
                label3sala.setText(agri.getSale().get(2).getNome());
                label4sala.setText(agri.getSale().get(3).getNome());
                label5sala.setText(agri.getSale().get(4).getNome());
                label6sala.setText(agri.getSale().get(5).getNome());
                label7sala.setText(agri.getSale().get(6).getNome());
                label8sala.setText(agri.getSale().get(7).getNome());
                label9sala.setText(agri.getSale().get(8).getNome());
                label10sala.setText(agri.getSale().get(9).getNome());
                label11sala.setText(agri.getSale().get(10).getNome());
                label12sala.setText(agri.getSale().get(11).getNome());
            default:
                jScrollPane2.setVisible(true);
                label2sala.setVisible(true);
                labelnp2.setVisible(true);
                jScrollPane5.setVisible(true);
                label5sala.setVisible(true);
                labelnp5.setVisible(true);
                jScrollPane6.setVisible(true);
                label6sala.setVisible(true);
                labelnp6.setVisible(true);
                jScrollPane9.setVisible(true);
                label9sala.setVisible(true);
                labelnp9.setVisible(true);
                jScrollPane10.setVisible(true);
                label10sala.setVisible(true);
                labelnp10.setVisible(true);
                jScrollPane3.setVisible(true);
                label3sala.setVisible(true);
                labelnp3.setVisible(true);
                jScrollPane7.setVisible(true);
                label7sala.setVisible(true);
                labelnp7.setVisible(true);
                jScrollPane12.setVisible(true);
                label11sala.setVisible(true);
                labelnp11.setVisible(true);
                jScrollPane4.setVisible(true);
                label4sala.setVisible(true);
                labelnp4.setVisible(true);
                jScrollPane8.setVisible(true);
                label8sala.setVisible(true);
                labelnp8.setVisible(true);
                jScrollPane11.setVisible(true);
                label12sala.setVisible(true);
                labelnp12.setVisible(true);
                jScrollPane13.setVisible(true);
                label1sala.setText(agri.getSale().get(0).getNome());
                label2sala.setText(agri.getSale().get(1).getNome());
                label3sala.setText(agri.getSale().get(2).getNome());
                label4sala.setText(agri.getSale().get(3).getNome());
                label5sala.setText(agri.getSale().get(4).getNome());
                label6sala.setText(agri.getSale().get(5).getNome());
                label7sala.setText(agri.getSale().get(6).getNome());
                label8sala.setText(agri.getSale().get(7).getNome());
                label9sala.setText(agri.getSale().get(8).getNome());
                label10sala.setText(agri.getSale().get(9).getNome());
                label11sala.setText(agri.getSale().get(10).getNome());
                label12sala.setText(agri.getSale().get(11).getNome());
                break;
        }
        
            
    }
    public void rightClick(JTable jtable, java.awt.event.MouseEvent evt ){
        try {
            impostaMenu();
        } catch (SQLException ex) {
            Logger.getLogger(GuiProvaM.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(SwingUtilities.isRightMouseButton(evt)){
           jMenuPrincipale.show(this, evt.getXOnScreen(), evt.getYOnScreen());
        }
        try{
            int i = jtable.getSelectedRow();        
            id = Integer.parseInt(jtable.getValueAt(i, 2).toString());
            nomePrenotazione = (String) jtable.getValueAt(i, 0);
        }catch(ArrayIndexOutOfBoundsException s){}
    }
    public void impostaRimuovi(){
        jRimuovi.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                for(int j=0;j<agri.getPrenotazione().size(); j++){
                    if(agri.getPrenotazione().get(j).getId()==id){ 
                        int choose = JOptionPane.showConfirmDialog(rootPane, "Sei sicuro di voler "
                                + "eliminare la prenotazione a nome di '"+nomePrenotazione+"' ?");
                        if(choose==JOptionPane.YES_OPTION){  
                            try {
                                createDb.deletePrenotazione(id, nomePrenotazione);
                                agri.getPrenotazione().remove(j);
                            } catch (SQLException ex) {
                                Logger.getLogger(GuiProvaM.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }  
                    }
                } 
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuPrincipale = new javax.swing.JPopupMenu();
        jModifica = new javax.swing.JMenuItem();
        jRimuovi = new javax.swing.JMenuItem();
        jSposta = new javax.swing.JMenuItem();
        jMenuSale = new javax.swing.JPopupMenu();
        jItemSala2 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        labelnp3 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tavolo9 = new javax.swing.JTable();
        labelnp8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        labelnp12 = new javax.swing.JLabel();
        labelnp11 = new javax.swing.JLabel();
        label12sala = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tavolo10 = new javax.swing.JTable();
        jScrollPane12 = new javax.swing.JScrollPane();
        tavolo11 = new javax.swing.JTable();
        label9sala = new javax.swing.JLabel();
        labelnp1 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tavolo7 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tavolo3 = new javax.swing.JTable();
        labelnp9 = new javax.swing.JLabel();
        label7sala = new javax.swing.JLabel();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        label4sala = new javax.swing.JLabel();
        labelnp5 = new javax.swing.JLabel();
        labelnp10 = new javax.swing.JLabel();
        JPasto = new javax.swing.JComboBox<>();
        label8sala = new javax.swing.JLabel();
        label1sala = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        labelnp7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tavolo1 = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        tavolo6 = new javax.swing.JTable();
        labelAttesa = new javax.swing.JLabel();
        labelnp4 = new javax.swing.JLabel();
        label5sala = new javax.swing.JLabel();
        label11sala = new javax.swing.JLabel();
        label3sala = new javax.swing.JLabel();
        label2sala = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tavolo12 = new javax.swing.JTable();
        labelnp6 = new javax.swing.JLabel();
        labelnp2 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tavolo5 = new javax.swing.JTable();
        label6sala = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tavolo4 = new javax.swing.JTable();
        Prenota = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tavolo2 = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        tavolo8 = new javax.swing.JTable();
        label10sala = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        tabellaAttesa = new javax.swing.JTable();
        jButtonRefresh = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jModifica.setText("jMenuItem2");
        jMenuPrincipale.add(jModifica);

        jRimuovi.setText("jMenuItem1");
        jMenuPrincipale.add(jRimuovi);

        jSposta.setText("jMenuItem3");
        jMenuPrincipale.add(jSposta);

        jItemSala2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setMinimumSize(new java.awt.Dimension(1344, 850));
        setSize(new java.awt.Dimension(1344, 850));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setMaximumSize(new java.awt.Dimension(1440, 1080));
        jPanel1.setPreferredSize(new java.awt.Dimension(1344, 850));
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setLayout(null);

        labelnp3.setText("0");
        labelnp3.setPreferredSize(new java.awt.Dimension(25, 16));
        jPanel1.add(labelnp3);
        labelnp3.setBounds(855, 120, 30, 16);

        tavolo9.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tavoli", "N.Persone", "id"
            }
        ));
        tavolo9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tavolo9MouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tavolo9);
        if (tavolo9.getColumnModel().getColumnCount() > 0) {
            tavolo9.getColumnModel().getColumn(0).setPreferredWidth(100);
            tavolo9.getColumnModel().getColumn(2).setPreferredWidth(40);
        }

        jPanel1.add(jScrollPane10);
        jScrollPane10.setBounds(240, 580, 199, 180);

        labelnp8.setText("0");
        labelnp8.setPreferredSize(new java.awt.Dimension(25, 16));
        jPanel1.add(labelnp8);
        labelnp8.setBounds(1075, 340, 30, 16);

        jLabel1.setText("Prenotazioni");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 120, 80, 14);

        labelnp12.setText("0");
        labelnp12.setPreferredSize(new java.awt.Dimension(25, 16));
        jPanel1.add(labelnp12);
        labelnp12.setBounds(1075, 560, 30, 16);

        labelnp11.setText("0");
        labelnp11.setPreferredSize(new java.awt.Dimension(25, 16));
        jPanel1.add(labelnp11);
        labelnp11.setBounds(855, 560, 30, 16);

        label12sala.setText("Sala 12");
        label12sala.setPreferredSize(new java.awt.Dimension(75, 16));
        jPanel1.add(label12sala);
        label12sala.setBounds(900, 560, 75, 16);

        tavolo10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tavoli", "N.Persone", "id"
            }
        ));
        tavolo10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tavolo10MouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tavolo10);
        if (tavolo10.getColumnModel().getColumnCount() > 0) {
            tavolo10.getColumnModel().getColumn(0).setPreferredWidth(100);
            tavolo10.getColumnModel().getColumn(2).setPreferredWidth(40);
        }

        jPanel1.add(jScrollPane11);
        jScrollPane11.setBounds(460, 580, 199, 180);

        tavolo11.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tavoli", "N.Persone", "id"
            }
        ));
        tavolo11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tavolo11MouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(tavolo11);
        if (tavolo11.getColumnModel().getColumnCount() > 0) {
            tavolo11.getColumnModel().getColumn(0).setPreferredWidth(100);
            tavolo11.getColumnModel().getColumn(2).setPreferredWidth(40);
        }

        jPanel1.add(jScrollPane12);
        jScrollPane12.setBounds(680, 580, 199, 180);

        label9sala.setText("Sala 9");
        label9sala.setPreferredSize(new java.awt.Dimension(75, 16));
        jPanel1.add(label9sala);
        label9sala.setBounds(240, 560, 75, 16);

        labelnp1.setText("0");
        labelnp1.setMaximumSize(new java.awt.Dimension(30, 16));
        labelnp1.setMinimumSize(new java.awt.Dimension(30, 16));
        labelnp1.setPreferredSize(new java.awt.Dimension(30, 16));
        jPanel1.add(labelnp1);
        labelnp1.setBounds(410, 120, 30, 16);

        tavolo7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tavoli", "N.Persone", "id"
            }
        ));
        tavolo7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tavolo7MouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tavolo7);
        if (tavolo7.getColumnModel().getColumnCount() > 0) {
            tavolo7.getColumnModel().getColumn(0).setPreferredWidth(100);
            tavolo7.getColumnModel().getColumn(2).setPreferredWidth(40);
        }

        jPanel1.add(jScrollPane8);
        jScrollPane8.setBounds(680, 360, 199, 180);

        tavolo3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tavoli", "N.Persone", "id"
            }
        ));
        tavolo3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tavolo3MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tavolo3);

        jPanel1.add(jScrollPane5);
        jScrollPane5.setBounds(680, 140, 199, 180);

        labelnp9.setText("0");
        labelnp9.setPreferredSize(new java.awt.Dimension(25, 16));
        jPanel1.add(labelnp9);
        labelnp9.setBounds(415, 560, 30, 16);

        label7sala.setText("Sala 7");
        label7sala.setPreferredSize(new java.awt.Dimension(75, 16));
        jPanel1.add(label7sala);
        label7sala.setBounds(680, 340, 75, 16);

        jDateChooser.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooserPropertyChange(evt);
            }
        });
        jPanel1.add(jDateChooser);
        jDateChooser.setBounds(20, 50, 170, 20);

        label4sala.setText("Sala 4");
        label4sala.setPreferredSize(new java.awt.Dimension(75, 16));
        jPanel1.add(label4sala);
        label4sala.setBounds(900, 120, 75, 16);

        labelnp5.setText("0");
        labelnp5.setPreferredSize(new java.awt.Dimension(25, 16));
        jPanel1.add(labelnp5);
        labelnp5.setBounds(415, 340, 30, 16);

        labelnp10.setText("0");
        labelnp10.setPreferredSize(new java.awt.Dimension(25, 16));
        jPanel1.add(labelnp10);
        labelnp10.setBounds(635, 560, 30, 16);

        JPasto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pranzo", "Cena" }));
        JPasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JPastoActionPerformed(evt);
            }
        });
        jPanel1.add(JPasto);
        JPasto.setBounds(250, 50, 135, 20);

        label8sala.setText("Sala 8");
        label8sala.setPreferredSize(new java.awt.Dimension(75, 16));
        jPanel1.add(label8sala);
        label8sala.setBounds(900, 340, 75, 16);

        label1sala.setText("Sala 1");
        label1sala.setMaximumSize(new java.awt.Dimension(75, 16));
        label1sala.setMinimumSize(new java.awt.Dimension(75, 16));
        label1sala.setPreferredSize(new java.awt.Dimension(75, 16));
        jPanel1.add(label1sala);
        label1sala.setBounds(240, 120, 75, 16);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tavoli", "N.Persone", "id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(40);
        }

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 140, 199, 564);

        labelnp7.setText("0");
        labelnp7.setPreferredSize(new java.awt.Dimension(25, 16));
        jPanel1.add(labelnp7);
        labelnp7.setBounds(855, 340, 30, 16);

        tavolo1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tavoli", "N.Persone", "id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tavolo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tavolo1MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tavolo1MouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tavolo1);
        if (tavolo1.getColumnModel().getColumnCount() > 0) {
            tavolo1.getColumnModel().getColumn(0).setPreferredWidth(100);
            tavolo1.getColumnModel().getColumn(2).setPreferredWidth(40);
        }

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(240, 140, 199, 180);

        tavolo6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tavoli", "N.Persone", "id"
            }
        ));
        tavolo6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tavolo6MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tavolo6);
        if (tavolo6.getColumnModel().getColumnCount() > 0) {
            tavolo6.getColumnModel().getColumn(0).setPreferredWidth(100);
            tavolo6.getColumnModel().getColumn(2).setPreferredWidth(40);
        }

        jPanel1.add(jScrollPane7);
        jScrollPane7.setBounds(460, 360, 199, 180);

        labelAttesa.setText("Attesa");
        jPanel1.add(labelAttesa);
        labelAttesa.setBounds(1120, 120, 60, 14);

        labelnp4.setText("0");
        labelnp4.setPreferredSize(new java.awt.Dimension(25, 16));
        jPanel1.add(labelnp4);
        labelnp4.setBounds(1075, 120, 30, 16);

        label5sala.setText("Sala 5");
        label5sala.setPreferredSize(new java.awt.Dimension(75, 16));
        jPanel1.add(label5sala);
        label5sala.setBounds(240, 340, 75, 16);

        label11sala.setText("Sala 11");
        label11sala.setPreferredSize(new java.awt.Dimension(75, 16));
        jPanel1.add(label11sala);
        label11sala.setBounds(680, 560, 75, 16);

        label3sala.setText("Sala 3");
        label3sala.setPreferredSize(new java.awt.Dimension(75, 16));
        jPanel1.add(label3sala);
        label3sala.setBounds(680, 120, 75, 16);

        label2sala.setText("Sala 2");
        label2sala.setPreferredSize(new java.awt.Dimension(75, 16));
        jPanel1.add(label2sala);
        label2sala.setBounds(460, 120, 75, 16);

        tavolo12.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tavoli", "N.Persone", "id"
            }
        ));
        tavolo12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tavolo12MouseClicked(evt);
            }
        });
        jScrollPane13.setViewportView(tavolo12);
        if (tavolo12.getColumnModel().getColumnCount() > 0) {
            tavolo12.getColumnModel().getColumn(0).setPreferredWidth(100);
            tavolo12.getColumnModel().getColumn(2).setPreferredWidth(40);
        }

        jPanel1.add(jScrollPane13);
        jScrollPane13.setBounds(900, 580, 199, 180);

        labelnp6.setText("0");
        labelnp6.setPreferredSize(new java.awt.Dimension(25, 16));
        jPanel1.add(labelnp6);
        labelnp6.setBounds(640, 340, 25, 16);

        labelnp2.setText("0");
        labelnp2.setMaximumSize(new java.awt.Dimension(40, 16));
        labelnp2.setPreferredSize(new java.awt.Dimension(25, 16));
        jPanel1.add(labelnp2);
        labelnp2.setBounds(635, 120, 25, 16);

        tavolo5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tavoli", "N.Persone", "id"
            }
        ));
        tavolo5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tavolo5MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tavolo5);
        if (tavolo5.getColumnModel().getColumnCount() > 0) {
            tavolo5.getColumnModel().getColumn(0).setPreferredWidth(100);
        }

        jPanel1.add(jScrollPane6);
        jScrollPane6.setBounds(240, 360, 199, 180);

        label6sala.setText("Sala 6");
        label6sala.setPreferredSize(new java.awt.Dimension(75, 16));
        jPanel1.add(label6sala);
        label6sala.setBounds(460, 340, 75, 16);

        tavolo4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tavoli", "N.Persone", "id"
            }
        ));
        tavolo4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tavolo4MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tavolo4);
        if (tavolo4.getColumnModel().getColumnCount() > 0) {
            tavolo4.getColumnModel().getColumn(0).setPreferredWidth(100);
            tavolo4.getColumnModel().getColumn(2).setPreferredWidth(40);
        }

        jPanel1.add(jScrollPane4);
        jScrollPane4.setBounds(900, 140, 199, 180);

        Prenota.setText("Prenota");
        Prenota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrenotaActionPerformed(evt);
            }
        });
        jPanel1.add(Prenota);
        Prenota.setBounds(420, 50, 100, 23);

        tavolo2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tavoli", "N.Persone", "id"
            }
        ));
        tavolo2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tavolo2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tavolo2);
        if (tavolo2.getColumnModel().getColumnCount() > 0) {
            tavolo2.getColumnModel().getColumn(0).setPreferredWidth(100);
            tavolo2.getColumnModel().getColumn(2).setPreferredWidth(40);
        }

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(460, 140, 199, 180);

        tavolo8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tavoli", "N.Persone", "id"
            }
        ));
        tavolo8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tavolo8MouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tavolo8);
        if (tavolo8.getColumnModel().getColumnCount() > 0) {
            tavolo8.getColumnModel().getColumn(0).setPreferredWidth(100);
            tavolo8.getColumnModel().getColumn(2).setPreferredWidth(40);
        }

        jPanel1.add(jScrollPane9);
        jScrollPane9.setBounds(900, 360, 199, 180);

        label10sala.setText("Sala 10");
        label10sala.setPreferredSize(new java.awt.Dimension(75, 16));
        jPanel1.add(label10sala);
        label10sala.setBounds(460, 560, 75, 16);

        tabellaAttesa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tavoli", "N.Persone", "id"
            }
        ));
        tabellaAttesa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabellaAttesaMouseClicked(evt);
            }
        });
        jScrollPane14.setViewportView(tabellaAttesa);
        if (tabellaAttesa.getColumnModel().getColumnCount() > 0) {
            tabellaAttesa.getColumnModel().getColumn(0).setPreferredWidth(100);
            tabellaAttesa.getColumnModel().getColumn(2).setPreferredWidth(40);
        }

        jPanel1.add(jScrollPane14);
        jScrollPane14.setBounds(1120, 140, 199, 564);

        jButtonRefresh.setText("Aggiorna");
        jButtonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonRefresh);
        jButtonRefresh.setBounds(550, 50, 110, 23);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/Texture seamless parquet rovere chiaro simo-3d.jpg"))); // NOI18N
        jLabel3.setToolTipText("");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(0, 0, 1410, 1080);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1344, 850);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JDateChooserPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_JDateChooserPropertyChange
         if(date!=dataOdierna){
            date = jDateChooser.getDate();
        }
        if(date==null){
            date = dataOdierda();
        }
        date = rimuoviOrarioData(date);
        aggiornaTabelle(date);
    }//GEN-LAST:event_JDateChooserPropertyChange

    private void PrenotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrenotaActionPerformed
        GuiPrenotazione guiPrenotazione = null;
        try {
            guiPrenotazione = new GuiPrenotazione();
        } catch (SQLException ex) {
            Logger.getLogger(GuiProvaM.class.getName()).log(Level.SEVERE, null, ex);
        }
        guiPrenotazione.setVisible(true);
    }//GEN-LAST:event_PrenotaActionPerformed

    private void JPastoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JPastoActionPerformed
        pasto = (String) JPasto.getSelectedItem();
        aggiornaTabelle(date);
    }//GEN-LAST:event_JPastoActionPerformed

    public void refreshNumber(){
        updateNumPeople(jScrollPane2,tavolo1,labelnp1,0);
        updateNumPeople(jScrollPane3,tavolo2,labelnp2,1);
        updateNumPeople(jScrollPane5,tavolo3,labelnp3,2);
        updateNumPeople(jScrollPane4,tavolo4,labelnp4,3);
        updateNumPeople(jScrollPane6,tavolo5,labelnp5,4);
        updateNumPeople(jScrollPane7,tavolo6,labelnp6,5);
        updateNumPeople(jScrollPane8,tavolo7,labelnp7,6);
        updateNumPeople(jScrollPane9,tavolo8,labelnp8,7);
        updateNumPeople(jScrollPane10,tavolo9,labelnp9,8);
        updateNumPeople(jScrollPane11,tavolo10,labelnp10,9);
        updateNumPeople(jScrollPane12,tavolo11,labelnp11,10);
        updateNumPeople(jScrollPane13,tavolo12,labelnp12,11);
    }
    
    private void jButtonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshActionPerformed
        date = rimuoviOrarioData(date);
        aggiornaTabelle(date);
        refreshNumber();
        
    }//GEN-LAST:event_jButtonRefreshActionPerformed

    public void updateNumPeople(JScrollPane j,JTable t,JLabel l,int index){
        for(int k = 0 ; k<numPplPerRoom.length ; k++){
            numPplPerRoom[k]=0;
        }
        if(j.isVisible()){
            for(int i = 0; i < t.getRowCount();i++){
                numPplPerRoom[index] += Integer.parseInt(t.getModel().getValueAt(i, 1).toString());
            }
            l.setText((String.valueOf(numPplPerRoom[index])));
        }
    }
    
    private void jDateChooserPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooserPropertyChange
        if(date!=dataOdierna){
            date = jDateChooser.getDate();
        }
        if(date==null){
            date = dataOdierda();
        }
        date = rimuoviOrarioData(date);
        aggiornaTabelle(date);
        
    }//GEN-LAST:event_jDateChooserPropertyChange

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        rightClick(jTable1, evt);
    }//GEN-LAST:event_jTable1MouseClicked

    private void tavolo1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tavolo1MouseReleased
        rightClick(tavolo1, evt);
    }//GEN-LAST:event_tavolo1MouseReleased

    private void tavolo1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tavolo1MouseClicked
        
    }//GEN-LAST:event_tavolo1MouseClicked

    private void tavolo2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tavolo2MouseClicked
        rightClick(tavolo2, evt);
    }//GEN-LAST:event_tavolo2MouseClicked

    private void tavolo3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tavolo3MouseClicked
        rightClick(tavolo3, evt);
    }//GEN-LAST:event_tavolo3MouseClicked

    private void tavolo4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tavolo4MouseClicked
        rightClick(tavolo4, evt);
    }//GEN-LAST:event_tavolo4MouseClicked

    private void tavolo5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tavolo5MouseClicked
        rightClick(tavolo5, evt);
    }//GEN-LAST:event_tavolo5MouseClicked

    private void tavolo6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tavolo6MouseClicked
        rightClick(tavolo6, evt);
    }//GEN-LAST:event_tavolo6MouseClicked

    private void tavolo7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tavolo7MouseClicked
         rightClick(tavolo7, evt);
    }//GEN-LAST:event_tavolo7MouseClicked

    private void tavolo8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tavolo8MouseClicked
        rightClick(tavolo8, evt);
    }//GEN-LAST:event_tavolo8MouseClicked

    private void tavolo9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tavolo9MouseClicked
         rightClick(tavolo9, evt);
    }//GEN-LAST:event_tavolo9MouseClicked

    private void tavolo10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tavolo10MouseClicked
         rightClick(tavolo10, evt);
    }//GEN-LAST:event_tavolo10MouseClicked

    private void tavolo11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tavolo11MouseClicked
         rightClick(tavolo11, evt);
    }//GEN-LAST:event_tavolo11MouseClicked

    private void tavolo12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tavolo12MouseClicked
        rightClick(tavolo12, evt);
    }//GEN-LAST:event_tavolo12MouseClicked

    private void tabellaAttesaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabellaAttesaMouseClicked
        rightClick(tabellaAttesa, evt);
    }//GEN-LAST:event_tabellaAttesaMouseClicked

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JPasto;
    private javax.swing.JButton Prenota;
    private javax.swing.JButton jButtonRefresh;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JMenuItem jItemSala2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPopupMenu jMenuPrincipale;
    private javax.swing.JPopupMenu jMenuSale;
    private javax.swing.JMenuItem jModifica;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem jRimuovi;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JMenuItem jSposta;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel label10sala;
    private javax.swing.JLabel label11sala;
    private javax.swing.JLabel label12sala;
    private javax.swing.JLabel label1sala;
    private javax.swing.JLabel label2sala;
    private javax.swing.JLabel label3sala;
    private javax.swing.JLabel label4sala;
    private javax.swing.JLabel label5sala;
    private javax.swing.JLabel label6sala;
    private javax.swing.JLabel label7sala;
    private javax.swing.JLabel label8sala;
    private javax.swing.JLabel label9sala;
    private javax.swing.JLabel labelAttesa;
    private javax.swing.JLabel labelnp1;
    private javax.swing.JLabel labelnp10;
    private javax.swing.JLabel labelnp11;
    private javax.swing.JLabel labelnp12;
    private javax.swing.JLabel labelnp2;
    private javax.swing.JLabel labelnp3;
    private javax.swing.JLabel labelnp4;
    private javax.swing.JLabel labelnp5;
    private javax.swing.JLabel labelnp6;
    private javax.swing.JLabel labelnp7;
    private javax.swing.JLabel labelnp8;
    private javax.swing.JLabel labelnp9;
    private javax.swing.JTable tabellaAttesa;
    private javax.swing.JTable tavolo1;
    private javax.swing.JTable tavolo10;
    private javax.swing.JTable tavolo11;
    private javax.swing.JTable tavolo12;
    private javax.swing.JTable tavolo2;
    private javax.swing.JTable tavolo3;
    private javax.swing.JTable tavolo4;
    private javax.swing.JTable tavolo5;
    private javax.swing.JTable tavolo6;
    private javax.swing.JTable tavolo7;
    private javax.swing.JTable tavolo8;
    private javax.swing.JTable tavolo9;
    // End of variables declaration//GEN-END:variables
}
