

import java.awt.Color;

import java.awt.geom.RoundRectangle2D;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Reeve
 */
public class otp extends javax.swing.JFrame {

    Connection con;
    PreparedStatement pst;
    Statement St;
    ResultSet Rs;
    
    public otp() {
        initComponents();
        

        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 50, 50));
    }

     public void connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ararresto","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(otp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(otp.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
     
     public void ll (){
         loading load = new loading();
        
         add(load);
         pack();   
         load.setBounds(70, 60, 200, 200);  
         load.setBackground(new Color(0, 0, 0, 128));
         load.setVisible(true);
         load.setOpaque(false);
         
         
         
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        softedges1 = new softedges();
        button4 = new Button();
        jLabel3 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        button5 = new Button();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(100, 92, 187));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        softedges1.add(button4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 80, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resto images/verotp.png"))); // NOI18N
        softedges1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        username.setBackground(new java.awt.Color(100, 92, 187));
        username.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        username.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        username.setBorder(null);
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        softedges1.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 130, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("ralphreeven@carandang.com");
        softedges1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("We have sent verification to ");
        softedges1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        button5.setBackground(new java.awt.Color(204, 255, 204));
        button5.setText("OK");
        button5.setEffectColor(new java.awt.Color(0, 255, 102));
        button5.setFont(new java.awt.Font("Serif", 1, 15)); // NOI18N
        button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button5ActionPerformed(evt);
            }
        });
        softedges1.add(button5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 80, 30));

        jPanel1.add(softedges1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 260, 190));

        jLabel6.setFont(new java.awt.Font("MingLiU-ExtB", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Arar Retso");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 280));

        setSize(new java.awt.Dimension(344, 278));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        // TODO add your handling code here:
        
        dispose();
        
    }//GEN-LAST:event_button4ActionPerformed

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void button5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button5ActionPerformed
        // TODO add your handling code here:
        ll();
       
        
        

    }//GEN-LAST:event_button5ActionPerformed

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
            java.util.logging.Logger.getLogger(otp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(otp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(otp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(otp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new otp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Button button4;
    private Button button5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private softedges softedges1;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
