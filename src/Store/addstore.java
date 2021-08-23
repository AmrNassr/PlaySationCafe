/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Store;

import hany.*;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
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

public class addstore extends javax.swing.JFrame {
 
    PreparedStatement pst ;
    ResultSet rs;
    Home h ;
  
    
    
    public addstore() throws ParseException {
        initComponents();
        
       
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
        jLabel17 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        save = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        date1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setMaximumSize(new java.awt.Dimension(530, 550));
        jPanel1.setMinimumSize(new java.awt.Dimension(530, 550));
        jPanel1.setPreferredSize(new java.awt.Dimension(530, 550));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("اسم المخزن");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 120, 30));

        name.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jPanel1.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 260, 40));

        save.setBackground(new java.awt.Color(98, 113, 146));
        save.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        save.setForeground(new java.awt.Color(255, 255, 255));
        save.setText("اضافة");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        jPanel1.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 120, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/64586a0ad51dc03.jpg"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(530, 550));
        jLabel1.setMinimumSize(new java.awt.Dimension(530, 550));
        jLabel1.setPreferredSize(new java.awt.Dimension(530, 550));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 260));

        date1.setText("jLabel2");
        jPanel1.add(date1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 200, -1, -1));

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

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed

         String namee = name.getText();

        
            if( name.getText().trim().isEmpty() )
            {
                JOptionPane.showMessageDialog(this, " من فضلك ادخل اسم المخزن");
            }
            else
            {
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(this, "هل تريد حفظ العمليه", "تاكيد العمليه", dialogButton);
                if(dialogResult == 0) {
                    try{
                        String sql = "INSERT INTO cafe.storecategory (name) VALUES"
                        + " ('"+namee+"')";
                        pst = (PreparedStatement)DBConnect.con.prepareStatement(sql);
                        pst.execute();
                        JOptionPane.showMessageDialog(null, "تم اضافه المخزن بنجاح");
                        name.setText("");
                        
                    }
                    catch(Exception e ){
                        JOptionPane.showMessageDialog(null,"المخزن موجود من قبل");
                    }

                }
                else
                {JOptionPane.showMessageDialog(this, " تم الغاء العمليه");

                }

            }
        
        
    }//GEN-LAST:event_saveActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel date1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField name;
    private javax.swing.JButton save;
    // End of variables declaration//GEN-END:variables
 
}