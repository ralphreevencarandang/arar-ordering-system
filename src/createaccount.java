
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import java.util.Random;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author Reeve
 */
public class createaccount extends javax.swing.JFrame {

    /**
     * Creates new form createaccount
     */
    Connection con;
    PreparedStatement pst;
    Statement St;
    ResultSet Rs;
    API_OTP api = new API_OTP();
    Random rand = new Random ();
    int OTP;

    public createaccount() {
        initComponents();
        cursor();
        connect();
        check.setVisible(false);        
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 50, 50));
        dialog();
        centermess();       
       
    }
    public void dialog (){
        
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
    public void centermess(){    
        jDialog1.setLocationRelativeTo(null);
        jDialog1.setSize(330,270);       
        jDialog1.setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        jDialog1.setLocation(dim.width/2-jDialog1.getSize().width/2, dim.height/2-jDialog1.getSize().height/2);
        jDialog1.setShape(new RoundRectangle2D.Double(0, 0, jDialog1.getWidth(), jDialog1.getHeight(), 50, 50));  
        
        otp.setLocationRelativeTo(null);
        otp.setSize(390,250);       
        otp.setResizable(false);
        otp.setLocation(dim.width/2-otp.getSize().width/2, dim.height/2-otp.getSize().height/2);
        otp.setShape(new RoundRectangle2D.Double(0, 0, otp.getWidth(), otp.getHeight(), 50, 50));  
    }
    public void cursor (){
      
        Cursor mouse = new Cursor (Cursor.HAND_CURSOR);
        x.setCursor(mouse);
        signin.setCursor(mouse);
        question.setCursor(mouse);   
    }
    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ararresto", "root", "");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(createaccount.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(createaccount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void confirm (){
        
        if (password.getText().equals(confirmpass.getText())){
            check.setVisible(true);
        } else {
            check.setVisible(false);
        }
    }
    public void foregroundtext(){
        password.setEchoChar('\u0000');
        confirmpass.setEchoChar('\u0000');
        username.setForeground(new Color(204, 204, 204));
        password.setForeground(new Color(204, 204, 204));
        confirmpass.setForeground(new Color(204, 204, 204));
        answer.setForeground(new Color(204, 204, 204));
        location.setForeground(new Color(204, 204, 204));
        to.setForeground(new Color(204, 204, 204));
    }
    
    
  

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        confirm = new Button();
        jLabel10 = new javax.swing.JLabel();
        otp = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        softedges1 = new softedges();
        button4 = new Button();
        jLabel12 = new javax.swing.JLabel();
        txtotp = new javax.swing.JTextField();
        txtsentemail = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        button5 = new Button();
        jLabel17 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        signin = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        username = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        answer = new javax.swing.JTextField();
        question = new javax.swing.JComboBox<>();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        password = new javax.swing.JPasswordField();
        x = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        confirmpass = new javax.swing.JPasswordField();
        to = new javax.swing.JTextField();
        location = new javax.swing.JTextField();
        button1 = new Button();
        check = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        email = new javax.swing.JTextField();

        jDialog1.setUndecorated(true);
        jDialog1.setSize(new java.awt.Dimension(320, 260));
        jDialog1.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(160, 132, 220));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com-resize-unscreen.gif"))); // NOI18N
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, -1));

        confirm.setBackground(new java.awt.Color(100, 92, 187));
        confirm.setForeground(new java.awt.Color(255, 255, 255));
        confirm.setText("Confirm");
        confirm.setEffectColor(new java.awt.Color(102, 0, 153));
        confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmActionPerformed(evt);
            }
        });
        jPanel2.add(confirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 120, 40));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Your Account has been successfully created.");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, 40));

        jDialog1.getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 310));

        otp.setUndecorated(true);
        otp.setResizable(false);
        otp.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(100, 92, 187));

        softedges1.setBackground(new java.awt.Color(160, 132, 220));
        softedges1.setRoundBottomLeft(50);
        softedges1.setRoundBottomRight(50);
        softedges1.setRoundTopLeft(50);
        softedges1.setRoundTopRight(50);
        softedges1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        button4.setBackground(new java.awt.Color(255, 102, 102));
        button4.setText("Cancel");
        button4.setEffectColor(new java.awt.Color(255, 0, 0));
        button4.setFont(new java.awt.Font("Serif", 1, 15)); // NOI18N
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });
        softedges1.add(button4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 80, 30));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resto images/verotp.png"))); // NOI18N
        softedges1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        txtotp.setBackground(new java.awt.Color(100, 92, 187));
        txtotp.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtotp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtotp.setBorder(null);
        txtotp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtotpActionPerformed(evt);
            }
        });
        softedges1.add(txtotp, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 130, 30));

        txtsentemail.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtsentemail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtsentemail.setText("09638722067");
        softedges1.add(txtsentemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("We have sent verification to ");
        softedges1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        button5.setBackground(new java.awt.Color(204, 255, 204));
        button5.setText("OK");
        button5.setEffectColor(new java.awt.Color(0, 255, 102));
        button5.setFont(new java.awt.Font("Serif", 1, 15)); // NOI18N
        button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button5ActionPerformed(evt);
            }
        });
        softedges1.add(button5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 80, 30));

        jLabel17.setFont(new java.awt.Font("MingLiU-ExtB", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Arar Retso");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jLabel17))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(softedges1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel17)
                .addGap(7, 7, 7)
                .addComponent(softedges1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        otp.getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 250));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(100, 92, 187));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Lucida Fax", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Create Account");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, 60));

        jLabel3.setFont(new java.awt.Font("MingLiU-ExtB", 0, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Arar Resto");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resto images/newlg.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resto images/user37.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resto images/passlock.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resto images/confirmpass.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resto images/sq.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resto images/sa.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Already have an account?");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 670, -1, -1));

        signin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        signin.setForeground(new java.awt.Color(160, 132, 220));
        signin.setText("Sign in ");
        signin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signinMouseClicked(evt);
            }
        });
        jPanel1.add(signin, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 670, -1, -1));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 270, 10));

        username.setBackground(new java.awt.Color(100, 92, 187));
        username.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        username.setForeground(new java.awt.Color(204, 204, 204));
        username.setText("Enter Username");
        username.setBorder(null);
        username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                usernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                usernameFocusLost(evt);
            }
        });
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        jPanel1.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 250, 40));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 490, 270, 10));

        answer.setBackground(new java.awt.Color(100, 92, 187));
        answer.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        answer.setForeground(new java.awt.Color(204, 204, 204));
        answer.setText("Enter Answer");
        answer.setBorder(null);
        answer.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                answerFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                answerFocusLost(evt);
            }
        });
        answer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answerActionPerformed(evt);
            }
        });
        jPanel1.add(answer, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 460, 250, 40));

        question.setBackground(new java.awt.Color(100, 92, 187));
        question.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        question.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "What is your favorite song?", "What is the name of your mother?", "What is the name of your favorite pet?", "What is your favorite TV Show?" }));
        question.setBorder(null);
        question.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionActionPerformed(evt);
            }
        });
        jPanel1.add(question, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 410, 270, 40));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 540, 270, 10));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 270, 10));

        password.setBackground(new java.awt.Color(100, 92, 187));
        password.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        password.setForeground(new java.awt.Color(204, 204, 204));
        password.setText("Enter Password");
        password.setBorder(null);
        password.setEchoChar('\u0000');
        password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordFocusLost(evt);
            }
        });
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        jPanel1.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, 260, 40));

        x.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        x.setForeground(new java.awt.Color(51, 51, 51));
        x.setText("X");
        x.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                xMouseClicked(evt);
            }
        });
        jPanel1.add(x, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 20, 30));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/house47.png"))); // NOI18N
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, -1, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/contact.png"))); // NOI18N
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 560, -1, -1));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, 270, 10));
        jPanel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 590, 270, 10));

        confirmpass.setBackground(new java.awt.Color(100, 92, 187));
        confirmpass.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        confirmpass.setForeground(new java.awt.Color(204, 204, 204));
        confirmpass.setText("Confirm Password");
        confirmpass.setBorder(null);
        confirmpass.setEchoChar('\u0000');
        confirmpass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                confirmpassFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                confirmpassFocusLost(evt);
            }
        });
        confirmpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmpassActionPerformed(evt);
            }
        });
        jPanel1.add(confirmpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, 260, 40));

        to.setBackground(new java.awt.Color(100, 92, 187));
        to.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        to.setForeground(new java.awt.Color(204, 204, 204));
        to.setText("Enter Contact Number");
        to.setBorder(null);
        to.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                toFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                toFocusLost(evt);
            }
        });
        to.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toActionPerformed(evt);
            }
        });
        jPanel1.add(to, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 560, 250, 40));

        location.setBackground(new java.awt.Color(100, 92, 187));
        location.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        location.setForeground(new java.awt.Color(204, 204, 204));
        location.setText("Enter Address");
        location.setBorder(null);
        location.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                locationFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                locationFocusLost(evt);
            }
        });
        location.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locationActionPerformed(evt);
            }
        });
        jPanel1.add(location, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 510, 250, 40));

        button1.setBackground(new java.awt.Color(160, 132, 220));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("Sign Up");
        button1.setEffectColor(new java.awt.Color(153, 51, 255));
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        jPanel1.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 620, 100, 40));

        check.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resto images/check.png"))); // NOI18N
        jPanel1.add(check, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 350, -1, -1));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/email.png"))); // NOI18N
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));
        jPanel1.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 270, 10));

        email.setBackground(new java.awt.Color(100, 92, 187));
        email.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        email.setForeground(new java.awt.Color(204, 204, 204));
        email.setText("Enter Email");
        email.setBorder(null);
        email.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailFocusLost(evt);
            }
        });
        jPanel1.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 280, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 716, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(430, 716));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void signinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signinMouseClicked
        // TODO add your handling code here:
        login log = new login();
        log.show();
        dispose();
    }//GEN-LAST:event_signinMouseClicked

    private void usernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameFocusGained
        // TODO add your handling code here:
        if (username.getText().equals("Enter Username")) {
            username.setText("");
            username.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_usernameFocusGained

    private void usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameFocusLost
        // TODO add your handling code here:
        if (username.getText().equals("")) {
            username.setText("Enter Username");
            username.setForeground(new Color(204, 204, 204));
            
        }
        
    }//GEN-LAST:event_usernameFocusLost

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void answerFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_answerFocusGained
        // TODO add your handling code here:
        if (answer.getText().equals("Enter Answer")) {
            answer.setText("");
            answer.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_answerFocusGained

    private void answerFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_answerFocusLost
        // TODO add your handling code here:
        if (answer.getText().equals("")) {
            answer.setText("Enter Answer");
            answer.setForeground(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_answerFocusLost

    private void answerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_answerActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    private void questionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_questionActionPerformed

    private void xMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xMouseClicked
        // TODO add your handling code here:
        int dialogresult = JOptionPane.showConfirmDialog(null, "Do you want to EXIT?", "Warning", JOptionPane.YES_NO_OPTION);
        if (dialogresult == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_xMouseClicked

    private void confirmpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmpassActionPerformed

    private void toFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_toFocusGained
        // TODO add your handling code here:
        if (to.getText().equals("Enter Contact Number")) {
            to.setText("");
            to.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_toFocusGained

    private void toFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_toFocusLost
        // TODO add your handling code here:
        if (to.getText().equals("")) {
            to.setText("Enter Contact Number");
            to.setForeground(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_toFocusLost

    private void toActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_toActionPerformed

    private void locationFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_locationFocusGained
        // TODO add your handling code here:
        if (location.getText().equals("Enter Address")) {
            location.setText("");
            location.setForeground(new Color(0, 0, 0));
        }

    }//GEN-LAST:event_locationFocusGained

    private void locationFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_locationFocusLost
        // TODO add your handling code here:
        if (location.getText().equals("")) {
            location.setText("Enter Address");
            location.setForeground(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_locationFocusLost

    private void locationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_locationActionPerformed

    private void passwordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFocusGained
        // TODO add your handling code here:
        if (password.getText().equals("Enter Password")) {
            password.setText(null);

            password.setForeground(new Color(0, 0, 0));
            password.setEchoChar('*');
        }
    }//GEN-LAST:event_passwordFocusGained

    private void passwordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFocusLost
        // TODO add your handling code here:
        if (password.getText().equals("")) {
            password.setText("Enter Password");
            password.setForeground(new Color(204, 204, 204));
            password.setEchoChar('\u0000');
        }
    }//GEN-LAST:event_passwordFocusLost

    private void confirmpassFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_confirmpassFocusGained
        // TODO add your handling code here:
        if (confirmpass.getText().equals("Confirm Password")) {
            confirmpass.setText(null);
            confirmpass.setForeground(new Color(0, 0, 0));
            confirmpass.setEchoChar('*');
        }
    }//GEN-LAST:event_confirmpassFocusGained

    private void confirmpassFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_confirmpassFocusLost
        // TODO add your handling code here:
        if (confirmpass.getText().equals("")) {
            confirmpass.setText("Confirm Password");
            confirmpass.setForeground(new Color(204, 204, 204));
            confirmpass.setEchoChar('\u0000');
            
        }
        confirm();
        
    }//GEN-LAST:event_confirmpassFocusLost

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
        String user = username.getText();
        String pass = password.getText();
        String cpass = confirmpass.getText(); 
        String ques = question.getSelectedItem().toString();
        String ans = answer.getText();
        String address = location.getText();
        String phone = to.getText();
        String Email = email.getText();
        
       
        
        if (Email.equalsIgnoreCase("Enter Email")){
            JOptionPane.showMessageDialog(this, "Please Enter your Email");
        }
        else if (user.equalsIgnoreCase("Enter Username") | user.equalsIgnoreCase(" ")){
            JOptionPane.showMessageDialog(this, "Please Enter USERNAME");
        }
        else if (pass.equals("Enter Password")){
            JOptionPane.showMessageDialog(this, "Please Enter PASSWORD");
        }
        else if (cpass.equalsIgnoreCase("Confirm Password")){
            JOptionPane.showMessageDialog(this, "Please Confirm your PASSWORD");
        }
        else if (ans.equalsIgnoreCase("Enter Answer")){
            JOptionPane.showMessageDialog(this, "Please Enter your ANSWER");
        }
        else if (address.equalsIgnoreCase("Enter Address")){
            JOptionPane.showMessageDialog(this,"Please Enter your ADDRESS");
        }
        else if (!cpass.equals(pass)){
            JOptionPane.showMessageDialog(this,"Please Check your password");
         }
        
        
      
        else {           
              txtsentemail.setText(to.getText());
                getRootPane().getGlassPane().setVisible(true);
                otp.setVisible(true);     
              api.sms("ralphcarandang","Rvn09185741665",to.getText(),"Your One-Time PIN is " + OTP +". For your protection, do not share this code with anyone. Enter this code to validate your registration.");
                

        }
        
        
      
       
        
        
        
        
    }//GEN-LAST:event_button1ActionPerformed

    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmActionPerformed
        // TODO add your handling code here:
        jDialog1.setVisible(false   );
        getRootPane().getGlassPane().setVisible(false);

        
    }//GEN-LAST:event_confirmActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        // TODO add your handling code here:
    getRootPane().getGlassPane().setVisible(false);
        otp.setVisible(false);
        

    }//GEN-LAST:event_button4ActionPerformed

    private void txtotpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtotpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtotpActionPerformed

    private void button5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button5ActionPerformed
        
        String user = username.getText();
        String pass = password.getText();
        String cpass = confirmpass.getText(); 
        String ques = question.getSelectedItem().toString();
        String ans = answer.getText();
        String address = location.getText();
        String phone = to.getText();
        String Email = email.getText();
      
        if (txtotp.getText().equals(OTP)){
            try {               
                pst = con.prepareStatement ("insert into createacc (username,password,question,answer,address,contact, email) values (?,?,?,?,?,?,?)");
                pst.setString(1, user);
                pst.setString(2, pass);
                pst.setString(3, ques);
                pst.setString(4, ans);
                pst.setString(5, address);
                pst.setString(6, phone);
                pst.setString(7, Email);
                pst.executeUpdate();
                
                Thread.sleep(1000);
                 getRootPane().getGlassPane().setVisible(true);
                  jDialog1.setVisible(true);
                  otp.setVisible(false);
                foregroundtext();
                username.setText("Enter Username");
                password.setText("Enter Password");
                confirmpass.setText("Confirm Password");
                question.setSelectedIndex(0);
                answer.setText("Enter Answer");
                location.setText("Enter Address");
                to.setText("Enter Contact Number");
                email.setText("Enter Email");
                
                
            }catch (SQLException ex) {
                Logger.getLogger(createaccount.class.getName()).log(Level.SEVERE, "Something went wrong", ex);
                JOptionPane.showMessageDialog(this, "Please Enter Correct Contact Number");
            } catch (InterruptedException ex) {
                Logger.getLogger(createaccount.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (txtotp.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Enter OTP!");
        }
        else {
            JOptionPane.showMessageDialog(null,"Incorrect OTP");
        }
     
     

    }//GEN-LAST:event_button5ActionPerformed

    private void emailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFocusGained
        // TODO add your handling code here:
        if (email.getText().equals("Enter Email")){
            email.setText(null);
            email.setForeground(new Color (0, 0, 0 ));
        }
    }//GEN-LAST:event_emailFocusGained

    private void emailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFocusLost
        // TODO add your handling code here:
        if (email.getText().equals("")){
            email.setText("Enter Email");
            email.setForeground(new Color (204, 204, 204));
        }
    }//GEN-LAST:event_emailFocusLost

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
            java.util.logging.Logger.getLogger(createaccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(createaccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(createaccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(createaccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new createaccount().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField answer;
    private Button button1;
    private Button button4;
    private Button button5;
    private javax.swing.JLabel check;
    private Button confirm;
    private javax.swing.JPasswordField confirmpass;
    private javax.swing.JTextField email;
    public javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    public javax.swing.JTextField location;
    private javax.swing.JDialog otp;
    private javax.swing.JPasswordField password;
    private javax.swing.JComboBox<String> question;
    private javax.swing.JLabel signin;
    private softedges softedges1;
    public javax.swing.JTextField to;
    private javax.swing.JTextField txtotp;
    public javax.swing.JLabel txtsentemail;
    public javax.swing.JTextField username;
    private javax.swing.JLabel x;
    // End of variables declaration//GEN-END:variables
}
