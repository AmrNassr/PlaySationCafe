/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Store;

import hany.*;
import java.awt.ComponentOrientation;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author amnassar
 */

public class sellreporttype extends javax.swing.JFrame {
     
     public  String LL=null;
    PreparedStatement pst ;
    Home h ;
    ResultSet rs;
    String dayyy;
    
    public sellreporttype() {
        initComponents();
        
 Calendar cal = new GregorianCalendar();
                int monthh=cal.get(Calendar.MONTH)+1;
                int yearr = cal.get(Calendar.YEAR);
                int dayy =cal.get(Calendar.DAY_OF_MONTH);
             dayyy=String.valueOf(dayy);
 if(dayy == 1 || dayy == 2 || dayy == 3 || dayy == 4
         || dayy == 5 || dayy == 6 || dayy == 7 || dayy == 8 || dayy == 9 )
 {
      dayyy=String.valueOf(dayy);
     dayyy="0"+dayyy;
 }
                  day.setText(dayyy);
                    month.setText(Integer.toString(monthh));
                year.setText(Integer.toString(yearr));
                day2.setText(dayyy);
                    month2.setText(Integer.toString(monthh));
                year2.setText(Integer.toString(yearr));
             

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cancle = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        day2 = new javax.swing.JTextField();
        s5 = new javax.swing.JLabel();
        month2 = new javax.swing.JTextField();
        s6 = new javax.swing.JLabel();
        year2 = new javax.swing.JTextField();
        save = new javax.swing.JButton();
        day = new javax.swing.JTextField();
        s3 = new javax.swing.JLabel();
        month = new javax.swing.JTextField();
        s4 = new javax.swing.JLabel();
        year = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        s1 = new javax.swing.JLabel();
        s2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setMaximumSize(new java.awt.Dimension(530, 550));
        jPanel1.setMinimumSize(new java.awt.Dimension(530, 550));
        jPanel1.setPreferredSize(new java.awt.Dimension(530, 550));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cancle.setBackground(new java.awt.Color(98, 113, 146));
        cancle.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        cancle.setForeground(new java.awt.Color(255, 255, 255));
        cancle.setText("اغلاق");
        cancle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancleActionPerformed(evt);
            }
        });
        jPanel1.add(cancle, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 80, 30));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("الي");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 50, -1));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("من");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 50, -1));

        day2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel1.add(day2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 60, 30));

        s5.setBackground(new java.awt.Color(255, 255, 255));
        s5.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        s5.setForeground(new java.awt.Color(255, 255, 255));
        s5.setText("/");
        jPanel1.add(s5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 10, -1));

        month2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel1.add(month2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 60, 30));

        s6.setBackground(new java.awt.Color(255, 255, 255));
        s6.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        s6.setForeground(new java.awt.Color(255, 255, 255));
        s6.setText("/");
        jPanel1.add(s6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 10, -1));

        year2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel1.add(year2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 60, 30));

        save.setBackground(new java.awt.Color(98, 113, 146));
        save.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        save.setForeground(new java.awt.Color(255, 255, 255));
        save.setText("تقرير");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        jPanel1.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 160, 40));

        day.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel1.add(day, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 60, 30));

        s3.setBackground(new java.awt.Color(255, 255, 255));
        s3.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        s3.setForeground(new java.awt.Color(255, 255, 255));
        s3.setText("/");
        jPanel1.add(s3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 10, -1));

        month.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel1.add(month, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 60, 30));

        s4.setBackground(new java.awt.Color(255, 255, 255));
        s4.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        s4.setForeground(new java.awt.Color(255, 255, 255));
        s4.setText("/");
        jPanel1.add(s4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 10, -1));

        year.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel1.add(year, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 60, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/64586a0ad51dc03.jpg"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(530, 550));
        jLabel1.setMinimumSize(new java.awt.Dimension(530, 550));
        jLabel1.setPreferredSize(new java.awt.Dimension(530, 550));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 260));

        s1.setBackground(new java.awt.Color(255, 255, 255));
        s1.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        s1.setForeground(new java.awt.Color(255, 255, 255));
        s1.setText("/");
        jPanel1.add(s1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 170, 10, -1));

        s2.setBackground(new java.awt.Color(255, 255, 255));
        s2.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        s2.setForeground(new java.awt.Color(255, 255, 255));
        s2.setText("/");
        jPanel1.add(s2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 170, 10, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(474, 300));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancleActionPerformed
       
        this.dispose();
    }//GEN-LAST:event_cancleActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed

    String from=year.getText()+"-"+month.getText()+"-"+day.getText();
    String to=year2.getText()+"-"+month2.getText()+"-"+day2.getText();
     InputStream in=null;
      try {
          
          in = this.getClass().getResourceAsStream("/reports/selltype.jasper");
    Map<String,Object> para = new HashMap<String,Object>();
            para.put("from",from );
            para.put("to",to );
           

            JasperPrint j = JasperFillManager.fillReport(in, para,DBConnect.con);
            JasperViewer.viewReport(j,false);
      }
     catch (JRException ex) {
        } finally {
        } 

         
        
    }//GEN-LAST:event_saveActionPerformed

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
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancle;
    public javax.swing.JTextField day;
    public javax.swing.JTextField day2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField month;
    public javax.swing.JTextField month2;
    private javax.swing.JLabel s1;
    private javax.swing.JLabel s2;
    private javax.swing.JLabel s3;
    private javax.swing.JLabel s4;
    private javax.swing.JLabel s5;
    private javax.swing.JLabel s6;
    private javax.swing.JButton save;
    public javax.swing.JTextField year;
    public javax.swing.JTextField year2;
    // End of variables declaration//GEN-END:variables

}
