
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import static java.awt.Font.PLAIN;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.print.PrinterException;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author Reeve
 */
public class menu extends javax.swing.JFrame {

    /**
     * Creates new form menu
     */
    Connection con;
    PreparedStatement pst;
    Statement St;
    ResultSet Rs;
    
    public menu() {
        initComponents();
        dialog();
        dt();
        times();
        spinneredit();
        cursor();
        connect();
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 50, 50));    
        ; // disables the scroll bar

    }
//    SPINNER EDITABLE (FALSE)
    public void spinneredit(){
        JFormattedTextField adb = ((JSpinner.DefaultEditor)adobospin.getEditor()).getTextField();
        JFormattedTextField sis = ((JSpinner.DefaultEditor)sisigspin.getEditor()).getTextField();
        JFormattedTextField sinig = ((JSpinner.DefaultEditor)sinigangspin.getEditor()).getTextField();
        JFormattedTextField shang = ((JSpinner.DefaultEditor)shanghaispin.getEditor()).getTextField();
        JFormattedTextField tino = ((JSpinner.DefaultEditor)tinolaspin.getEditor()).getTextField();
        JFormattedTextField bula = ((JSpinner.DefaultEditor)bulalospin.getEditor()).getTextField();
        adb.setEditable(false);
        bula.setEditable(false);
        shang.setEditable(false);
        sinig.setEditable(false);
        sis.setEditable(false);
        tino.setEditable(false);
       
    }
//    LIVE DATE
    public void dt() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy");
        String dd = sdf.format(d);
        l_date.setText(dd);
    }
    
    Timer t;
    SimpleDateFormat st;
//      LIVE TIME
    public void times() {
        t = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                Date dt = new Date();
                st = new SimpleDateFormat("hh:mm a");

                String tt = st.format(dt);
                l_time.setText(tt);

            }
        });
        t.start();
    }
//    HAND CURSOR
    public void cursor (){
        Cursor mouse;
        mouse = new Cursor(Cursor.HAND_CURSOR);
        adobospin.setCursor(mouse);
        x.setCursor(mouse);
        sinigangspin.setCursor(mouse);
        sisigspin.setCursor(mouse);
        tinolaspin.setCursor(mouse);
        shanghaispin.setCursor(mouse);
        bulalospin.setCursor(mouse);     
    }
//    SQL CONNECTION
    public void connect (){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ararresto", "root", "");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    CENTER/PROPERTIES DIALOG
    public void dialog (){
        dialogreceipt.setLocationRelativeTo(null);
        dialogreceipt.setResizable(false);
        dialogreceipt.setSize(390, 630);
        area.setFont(new Font ("Monospaced", PLAIN, 15));
        getRootPane().setGlassPane(new JComponent()
                {
                    public void  paintComponent(Graphics g)
                {
                    g.setColor(new Color (0, 0, 0, 150));
                    g.fillRect(0,0,getWidth(),getHeight());
                    super.paintComponent(g);
                }
                });
    }
    public void addtable (String item, int qty, double price, double total){
        
        Vector v = new Vector ();
        DefaultTableModel dt =  (DefaultTableModel) jTable1.getModel();
        
         DecimalFormat df = new DecimalFormat("00.00");
        double totprice = price * Double.valueOf(qty);
        String totalprice = df.format(totprice);
        
        
        for(int row =0; row < jTable1.getRowCount(); row++){
            String existingItem = jTable1.getValueAt(row, 0).toString().trim();
            if (item.equals(existingItem)){
                dt.removeRow(jTable1.convertRowIndexToModel(row));
              
            }
            
        }
        
              
        v.add(item);
        v.add(qty);
        v.add(price);
        v.add(totalprice);
        dt.addRow(v);
        
    }
    public void caltotal(){
        
        int numOfRow = jTable1.getRowCount();
        double tot = 00.00;
        for(int i = 0; i <numOfRow; i++){
            double value = Double.valueOf(jTable1.getValueAt(i,3).toString());
            tot += value;
            
        }
        DecimalFormat df = new DecimalFormat("00.00");
        txttotal.setText(df.format(tot));
        
        
    }
    public void printreceipt(){
        login log = new login();
        String logname = log.username.getText();
        try {
                DefaultTableModel df = (DefaultTableModel)jTable1.getModel();

            
            java.sql.Statement st= con.createStatement();
             Rs = st.executeQuery("SELECT address, contact FROM createacc where username= '"+name.getText()+"'");
            
            
            while (Rs.next()) {
            System.out.println();
                
                 
            String dbaddress = Rs.getString(1);
            String dbcontact = Rs.getString(2);
              
            
            txtbill.append("-----------------------------------------\n");
            txtbill.append("               ArAr Resto\n");
            txtbill.append("       Dasmariñas Cavite, Philippines\n");
            txtbill.append("   www.facebook.com/ralphreevencarandang\n");
            txtbill.append("-----------------------------------------\n");
            txtbill.append("   Bill to:             Date:          \n");
            txtbill.append("   " + name.getText() +"         "+ l_date.getText() + "\n");
            txtbill.append("   "+ dbaddress + "           "+l_time.getText()+ "\n");
            txtbill.append("   +63" + dbcontact +"\n");         
            txtbill.append("-----------------------------------------\n");
            
            txtbill.append("   Item \tQty \tPrice \tTotal\n");
            txtbill.append("-----------------------------------------\n");
            for (int i = 0; i<jTable1.getRowCount(); i++ ){
                String item = df.getValueAt(i,0).toString();
                String qty = df.getValueAt(i,1).toString();
                String price = df.getValueAt(i,2).toString();
                String total = df.getValueAt(i,3).toString();
                txtbill.append("   " + item + "\t" +qty+ "\t" +price +"\t" +total+"\n");
                System.out.println();
                
            }        
            txtbill.append("-----------------------------------------\n");
            txtbill.append("-----------------------------------------\n");
            txtbill.append(" Total amount:                 " + txttotal.getText() +"\n");
            txtbill.append(" Cash:                         " + txtcash.getText() +"\n");
            txtbill.append(" Exchange:                     " + txtchange.getText() +"\n");
            txtbill.append("-----------------------------------------\n");
            txtbill.append("   Payment Method:    Cash  \n");
            txtbill.append("-----------------------------------------\n");
            txtbill.append("*****************************************\n");
            txtbill.append("        THANK YOU FOR YOUR ORDER!   \n");
            txtbill.append("*****************************************\n");
            System.out.println();
           
            
            }
              Rs.close();
           
          } catch (SQLException ex) {
            Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogreceipt = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        area = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        x = new javax.swing.JLabel();
        softedges1 = new softedges();
        jLabel6 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        adobospin = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        button4 = new Button();
        softedges2 = new softedges();
        jLabel19 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        sinigangspin = new javax.swing.JSpinner();
        button6 = new Button();
        softedges6 = new softedges();
        tinolaspin = new javax.swing.JSpinner();
        jLabel16 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        button7 = new Button();
        softedges7 = new softedges();
        jLabel4 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        sisigspin = new javax.swing.JSpinner();
        button5 = new Button();
        softedges8 = new softedges();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        shanghaispin = new javax.swing.JSpinner();
        button9 = new Button();
        softedges9 = new softedges();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        button8 = new Button();
        bulalospin = new javax.swing.JSpinner();
        softedges3 = new softedges();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        l_time = new javax.swing.JLabel();
        l_date = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        name1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        button2 = new Button();
        jLabel3 = new javax.swing.JLabel();
        button3 = new Button();
        jLabel1 = new javax.swing.JLabel();
        txtchange = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txttotal = new javax.swing.JLabel();
        txtcash = new javax.swing.JTextField();
        button10 = new Button();
        button1 = new Button();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtbill = new javax.swing.JTextArea();

        dialogreceipt.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        area.setEditable(false);
        area.setColumns(20);
        area.setRows(5);
        area.setBorder(null);
        jScrollPane2.setViewportView(area);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 660));

        dialogreceipt.getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 630));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(100, 92, 187));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        x.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        x.setForeground(new java.awt.Color(51, 51, 51));
        x.setText("X");
        x.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                xMouseClicked(evt);
            }
        });
        jPanel1.add(x, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 10, 20, 30));

        softedges1.setBackground(new java.awt.Color(160, 132, 220));
        softedges1.setRoundBottomLeft(50);
        softedges1.setRoundBottomRight(50);
        softedges1.setRoundTopLeft(50);
        softedges1.setRoundTopRight(50);
        softedges1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("MS Gothic", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Adobo");
        softedges1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        jLabel17.setFont(new java.awt.Font("MS Gothic", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("₱ 50.00");
        softedges1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        adobospin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        adobospin.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        adobospin.setBorder(null);
        adobospin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        adobospin.setFocusable(false);
        softedges1.add(adobospin, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, -1, 30));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/abobo.png"))); // NOI18N
        softedges1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 20, 150, 110));

        button4.setBackground(new java.awt.Color(100, 92, 187));
        button4.setForeground(new java.awt.Color(255, 255, 255));
        button4.setText("+");
        button4.setEffectColor(new java.awt.Color(153, 0, 153));
        button4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });
        softedges1.add(button4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 30, 30));

        jPanel1.add(softedges1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 160, 150));

        softedges2.setBackground(new java.awt.Color(160, 132, 220));
        softedges2.setRoundBottomLeft(50);
        softedges2.setRoundBottomRight(50);
        softedges2.setRoundTopLeft(50);
        softedges2.setRoundTopRight(50);
        softedges2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sinigang.png"))); // NOI18N
        softedges2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jLabel12.setFont(new java.awt.Font("MS Gothic", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Sinigang");
        softedges2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, 20));

        jLabel11.setFont(new java.awt.Font("MS Gothic", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("₱ 65.00");
        softedges2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        sinigangspin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        sinigangspin.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        sinigangspin.setBorder(null);
        softedges2.add(sinigangspin, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 40, 30));

        button6.setBackground(new java.awt.Color(100, 92, 187));
        button6.setForeground(new java.awt.Color(255, 255, 255));
        button6.setText("+");
        button6.setEffectColor(new java.awt.Color(153, 0, 153));
        button6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        button6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button6ActionPerformed(evt);
            }
        });
        softedges2.add(button6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 30, 30));

        jPanel1.add(softedges2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 160, 150));

        softedges6.setBackground(new java.awt.Color(160, 132, 220));
        softedges6.setRoundBottomLeft(50);
        softedges6.setRoundBottomRight(50);
        softedges6.setRoundTopLeft(50);
        softedges6.setRoundTopRight(50);
        softedges6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tinolaspin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tinolaspin.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        tinolaspin.setBorder(null);
        softedges6.add(tinolaspin, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 40, 30));

        jLabel16.setFont(new java.awt.Font("MS Gothic", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Tinola");
        softedges6.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tinola.png"))); // NOI18N
        softedges6.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, -1, -1));

        jLabel15.setFont(new java.awt.Font("MS Gothic", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("₱ 50.00");
        softedges6.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        button7.setBackground(new java.awt.Color(100, 92, 187));
        button7.setForeground(new java.awt.Color(255, 255, 255));
        button7.setText("+");
        button7.setEffectColor(new java.awt.Color(153, 0, 153));
        button7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        button7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button7ActionPerformed(evt);
            }
        });
        softedges6.add(button7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 30, 30));

        jPanel1.add(softedges6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, 160, 150));

        softedges7.setBackground(new java.awt.Color(160, 132, 220));
        softedges7.setRoundBottomLeft(50);
        softedges7.setRoundBottomRight(50);
        softedges7.setRoundTopLeft(50);
        softedges7.setRoundTopRight(50);
        softedges7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sisig.png"))); // NOI18N
        softedges7.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel24.setFont(new java.awt.Font("MS Gothic", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Sisig");
        softedges7.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, 20));

        jLabel25.setFont(new java.awt.Font("MS Gothic", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("₱ 60.00");
        softedges7.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        sisigspin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        sisigspin.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        sisigspin.setBorder(null);
        softedges7.add(sisigspin, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, -1, 30));

        button5.setBackground(new java.awt.Color(100, 92, 187));
        button5.setForeground(new java.awt.Color(255, 255, 255));
        button5.setText("+");
        button5.setEffectColor(new java.awt.Color(153, 0, 153));
        button5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button5ActionPerformed(evt);
            }
        });
        softedges7.add(button5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 30, 30));

        jPanel1.add(softedges7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 160, 150));

        softedges8.setBackground(new java.awt.Color(160, 132, 220));
        softedges8.setRoundBottomLeft(50);
        softedges8.setRoundBottomRight(50);
        softedges8.setRoundTopLeft(50);
        softedges8.setRoundTopRight(50);
        softedges8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/shanghai.png"))); // NOI18N
        softedges8.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 100));

        jLabel27.setFont(new java.awt.Font("MS Gothic", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Shanghai");
        softedges8.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jLabel28.setFont(new java.awt.Font("MS Gothic", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("₱ 7.00");
        softedges8.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        shanghaispin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        shanghaispin.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        shanghaispin.setBorder(null);
        softedges8.add(shanghaispin, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 40, 30));

        button9.setBackground(new java.awt.Color(100, 92, 187));
        button9.setForeground(new java.awt.Color(255, 255, 255));
        button9.setText("+");
        button9.setEffectColor(new java.awt.Color(153, 0, 153));
        button9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        button9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button9ActionPerformed(evt);
            }
        });
        softedges8.add(button9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 30, 30));

        jPanel1.add(softedges8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 160, 150));

        softedges9.setBackground(new java.awt.Color(160, 132, 220));
        softedges9.setRoundBottomLeft(50);
        softedges9.setRoundBottomRight(50);
        softedges9.setRoundTopLeft(50);
        softedges9.setRoundTopRight(50);
        softedges9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bulalo.png"))); // NOI18N
        softedges9.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jLabel30.setFont(new java.awt.Font("MS Gothic", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Bulalo");
        softedges9.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        jLabel31.setFont(new java.awt.Font("MS Gothic", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("₱ 60.00");
        softedges9.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        button8.setBackground(new java.awt.Color(100, 92, 187));
        button8.setForeground(new java.awt.Color(255, 255, 255));
        button8.setText("+");
        button8.setEffectColor(new java.awt.Color(153, 0, 153));
        button8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        button8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button8ActionPerformed(evt);
            }
        });
        softedges9.add(button8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 30, 30));

        bulalospin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bulalospin.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        bulalospin.setBorder(null);
        softedges9.add(bulalospin, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 40, 30));

        jPanel1.add(softedges9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 160, 150));

        softedges3.setBackground(new java.awt.Color(160, 132, 220));
        softedges3.setRoundBottomLeft(50);
        softedges3.setRoundBottomRight(50);
        softedges3.setRoundTopLeft(50);
        softedges3.setRoundTopRight(50);
        softedges3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setBackground(new java.awt.Color(191, 172, 226));
        jTable1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setFont(new java.awt.Font("MS Gothic", 1, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "item", "Quantity", "Price", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(0, 0, 0));
        jTable1.setSelectionBackground(new java.awt.Color(0, 255, 255));
        jTable1.setSelectionForeground(new java.awt.Color(0, 0, 255));
        jScrollPane1.setViewportView(jTable1);

        softedges3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 310, 220));

        l_time.setFont(new java.awt.Font("Palatino Linotype", 0, 14)); // NOI18N
        l_time.setForeground(new java.awt.Color(255, 255, 255));
        l_time.setText("hh:mm a");
        softedges3.add(l_time, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, -1, -1));

        l_date.setFont(new java.awt.Font("Palatino Linotype", 0, 14)); // NOI18N
        l_date.setForeground(new java.awt.Color(255, 255, 255));
        l_date.setText("mmmm-dd-yy");
        softedges3.add(l_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, -1, -1));

        name.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        name.setForeground(new java.awt.Color(255, 255, 255));
        name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name.setText("reeven");
        softedges3.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 230, 30));

        name1.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        name1.setForeground(new java.awt.Color(255, 255, 255));
        name1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name1.setText("Hi!");
        softedges3.add(name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 70, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resto images/newlg.png"))); // NOI18N
        softedges3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, -1, -1));

        jSeparator1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        softedges3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 450, 100, 10));

        button2.setBackground(new java.awt.Color(100, 92, 187));
        button2.setForeground(new java.awt.Color(255, 255, 255));
        button2.setText("Pay");
        button2.setEffectColor(new java.awt.Color(153, 51, 255));
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        softedges3.add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 480, 90, 40));

        jLabel3.setFont(new java.awt.Font("MingLiU-ExtB", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Arar Resto");
        softedges3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, -1, -1));

        button3.setBackground(new java.awt.Color(100, 92, 187));
        button3.setForeground(new java.awt.Color(255, 255, 255));
        button3.setText("Receipt");
        button3.setEffectColor(new java.awt.Color(153, 51, 255));
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });
        softedges3.add(button3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 480, 90, 40));

        jLabel1.setFont(new java.awt.Font("MS Gothic", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Change:");
        softedges3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 430, -1, -1));

        txtchange.setFont(new java.awt.Font("MS Gothic", 1, 18)); // NOI18N
        txtchange.setForeground(new java.awt.Color(255, 255, 255));
        txtchange.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtchange.setText("0.00");
        softedges3.add(txtchange, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 430, 60, -1));

        jLabel8.setFont(new java.awt.Font("MS Gothic", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Total:");
        softedges3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, -1, -1));

        jLabel9.setFont(new java.awt.Font("MS Gothic", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Cash:");
        softedges3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, -1, -1));

        txttotal.setFont(new java.awt.Font("MS Gothic", 1, 18)); // NOI18N
        txttotal.setForeground(new java.awt.Color(255, 255, 255));
        txttotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txttotal.setText("0.00");
        softedges3.add(txttotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 430, -1, -1));

        txtcash.setBackground(new java.awt.Color(160, 132, 220));
        txtcash.setFont(new java.awt.Font("MS Gothic", 1, 18)); // NOI18N
        txtcash.setForeground(new java.awt.Color(255, 255, 255));
        txtcash.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtcash.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        softedges3.add(txtcash, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, 110, 30));

        button10.setBackground(new java.awt.Color(100, 92, 187));
        button10.setForeground(new java.awt.Color(255, 255, 255));
        button10.setText("Delete");
        button10.setEffectColor(new java.awt.Color(153, 51, 255));
        button10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        button10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button10ActionPerformed(evt);
            }
        });
        softedges3.add(button10, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 380, 60, 20));

        jPanel1.add(softedges3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, 370, 540));

        button1.setBackground(new java.awt.Color(160, 132, 220));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("Reset");
        button1.setEffectColor(new java.awt.Color(153, 51, 255));
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        jPanel1.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 540, 90, 30));

        txtbill.setEditable(false);
        txtbill.setColumns(20);
        txtbill.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        txtbill.setRows(5);
        jScrollPane3.setViewportView(txtbill);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 40, 310, 530));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1066, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1066, 611));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void xMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xMouseClicked
        // TODO add your handling code here:
        int dialogresult = JOptionPane.showConfirmDialog(null, "Do you want to EXIT?", "Warning", JOptionPane.YES_NO_OPTION);
        if (dialogresult == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_xMouseClicked

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        // TODO add your handling code here:
       
       DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
       
       
   
        
        if (model.getRowCount() == 0){
            JOptionPane.showMessageDialog(null, "Make an Order first!");
        }else {
             try {
                
                double total = Double.parseDouble(txttotal.getText());
                String cash = txtcash.getText();
                double xcash = Double.parseDouble(cash);
                if (xcash < total){
                    JOptionPane.showMessageDialog(null, "You don't have enough balance!");
                }
                else {
                double change = xcash - total;
                String xchange = Double.toString(change);
                txtchange.setText(xchange);
                printreceipt();
                }
                
             }catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null,"Please Insert cash");
        }
       
        }
        
    }//GEN-LAST:event_button2ActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
        adobospin.setValue(0);
        sinigangspin.setValue(0);
        sisigspin.setValue(0);
        shanghaispin.setValue(0);
        tinolaspin.setValue(0);
        bulalospin.setValue(0);
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        txtbill.setText("");
    }//GEN-LAST:event_button1ActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        try {
            if (txtbill.getText().equals("")) JOptionPane.showMessageDialog(null,"Make an Order first");
           
            else txtbill.print();
        } catch (PrinterException ex) {
            Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        
    }//GEN-LAST:event_button3ActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        // TODO add your handling code here:
        
        
       
        int qty;                
        qty = (int)adobospin.getValue();  
        
        double price = 50.00;
        double total = price * qty;  
        
        if (qty != 0){
            addtable("Adobo", qty , price, total  );
             caltotal();
        }
      
        
        
    
            
    }//GEN-LAST:event_button4ActionPerformed

    private void button5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button5ActionPerformed
        // TODO add your handling code here:
        int qty;          
        qty = (int)sisigspin.getValue();      
        double price = 60.00;
        double total = price * qty;      

        if (qty != 0){
            addtable("Sisig", qty , price, total  );
              caltotal();
            
        }
    }//GEN-LAST:event_button5ActionPerformed

    private void button9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button9ActionPerformed
        // TODO add your handling code here:
       
        int qty;                
        qty = (int)shanghaispin.getValue();      
        double price = 7.00;
        double total = price * qty;  
        
            if (qty != 0){
            addtable("Shanghai", qty , price, total  );
              caltotal();
            
        }
    }//GEN-LAST:event_button9ActionPerformed

    private void button6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button6ActionPerformed
        // TODO add your handling code here:
       
        int qty;                
        qty = (int)sinigangspin.getValue();      
        double price = 65.00;
        double total = price * qty;  
        if (qty != 0){
            addtable("Sinigang", qty , price, total  );
               caltotal();
        }
    }//GEN-LAST:event_button6ActionPerformed

    private void button8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button8ActionPerformed
        // TODO add your handling code here:
         int qty;                
        qty = (int)bulalospin.getValue();      
        double price = 60.00;
        double total = price * qty;  
        if (qty != 0){
            addtable("Bulalo", qty , price, total  );
               caltotal();
        }
    }//GEN-LAST:event_button8ActionPerformed

    private void button7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button7ActionPerformed
        // TODO add your handling code here:
        int qty;                
        qty = (int)tinolaspin.getValue();      
        double price = 60.00;
        double total = price * qty;  
        if (qty != 0){
            addtable("Tinola", qty , price, total  );
               caltotal();
        }

    }//GEN-LAST:event_button7ActionPerformed

    private void button10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button10ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
        
        int row = jTable1.getSelectedRow();
        dt.removeRow(row);
    }//GEN-LAST:event_button10ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner adobospin;
    private javax.swing.JTextArea area;
    private javax.swing.JSpinner bulalospin;
    private Button button1;
    private Button button10;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private javax.swing.JDialog dialogreceipt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel l_date;
    private javax.swing.JLabel l_time;
    public javax.swing.JLabel name;
    private javax.swing.JLabel name1;
    private javax.swing.JSpinner shanghaispin;
    private javax.swing.JSpinner sinigangspin;
    private javax.swing.JSpinner sisigspin;
    private softedges softedges1;
    private softedges softedges2;
    private softedges softedges3;
    private softedges softedges6;
    private softedges softedges7;
    private softedges softedges8;
    private softedges softedges9;
    private javax.swing.JSpinner tinolaspin;
    private javax.swing.JTextArea txtbill;
    private javax.swing.JTextField txtcash;
    private javax.swing.JLabel txtchange;
    private javax.swing.JLabel txttotal;
    private javax.swing.JLabel x;
    // End of variables declaration//GEN-END:variables

}
