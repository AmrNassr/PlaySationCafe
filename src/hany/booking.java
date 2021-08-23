/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hany;

import Store.*;
import hany.DBConnect;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author amnassar
 */
public final class booking extends javax.swing.JInternalFrame {

    /**
     * Creates new form book
     */
    PreparedStatement pst;
    ResultSet rs;
    public String y;
   public Calendar cal;
    public int day;
    public int month;
    public int year;
    String dayyy;
    public String datee;
    public String fulldatee;

    public booking() {
        initComponents();
        tablelord();
        clear();
        TableCellRenderer rendererFromHeader = tdetails.getTableHeader().getDefaultRenderer();
JLabel headerLabel = (JLabel) rendererFromHeader;
headerLabel.setHorizontalAlignment(JLabel.CENTER);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        tdetails.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
         tdetails.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
         tdetails.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
         tdetails.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
         tdetails.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
         tdetails.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
        tdetails.getTableHeader().setFont(new Font("Arial", Font.BOLD, 20));
        tdetails.getTableHeader().setOpaque(false);
        tdetails.getTableHeader().setBackground(new Color(28,57,81));
        tdetails.getTableHeader().setForeground(new Color(255, 255, 255));
        tdetails.getTableHeader().setPreferredSize(new Dimension(40, 40));
        tdetails.setRowHeight(40);
        Calendar cal = new GregorianCalendar();
        day = cal.get(Calendar.DAY_OF_MONTH);
        month = cal.get(Calendar.MONTH) + 1;
        year = cal.get(Calendar.YEAR);
        name.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        Font bigFont = new Font("Arial", Font.BOLD, 30); // or whatever
        tdetails.getTableHeader().setFont(bigFont);
          cal = new GregorianCalendar();
            int dayy = cal.get(Calendar.DAY_OF_MONTH);
            dayyy = String.valueOf(dayy);
            if (dayy == 1 || dayy == 2 || dayy == 3 || dayy == 4
                    || dayy == 5 || dayy == 6 || dayy == 7 || dayy == 8 || dayy == 9) {
                dayyy = String.valueOf(dayy);
                dayyy = "0" + dayyy;
            }
            int month = cal.get(Calendar.MONTH) + 1;
            int year = cal.get(Calendar.YEAR);
            date1.setText(year + "-" + month + "-" + dayyy);
            datee = date1.getText().toString();
            TimeZone tz = TimeZone.getTimeZone("GMT+02");
            Calendar c = Calendar.getInstance(tz);
            String time = String.format("%02d", c.get(Calendar.HOUR_OF_DAY)) + ":"
                    + String.format("%02d", c.get(Calendar.MINUTE));
            fulldatee = datee + " " + time;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel14 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tdetails = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        cmday = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        cmroom = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        comment = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        cmtype = new javax.swing.JComboBox();
        jLabel37 = new javax.swing.JLabel();
        delete4 = new javax.swing.JButton();
        name = new javax.swing.JTextField();
        save4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        serialid4 = new javax.swing.JLabel();
        date4 = new javax.swing.JLabel();
        date1 = new javax.swing.JLabel();
        numberrr = new javax.swing.JLabel();
        nameee = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1060, 660));
        setMinimumSize(new java.awt.Dimension(1060, 660));
        setPreferredSize(new java.awt.Dimension(1060, 660));

        jPanel14.setBackground(new java.awt.Color(0, 0, 0));
        jPanel14.setForeground(new java.awt.Color(255, 255, 255));
        jPanel14.setMaximumSize(new java.awt.Dimension(1060, 660));
        jPanel14.setMinimumSize(new java.awt.Dimension(1060, 660));
        jPanel14.setPreferredSize(new java.awt.Dimension(1060, 660));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tdetails.setBackground(new java.awt.Color(102, 152, 205));
        tdetails.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        tdetails.setForeground(new java.awt.Color(255, 255, 255));
        tdetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "تفاصيل", "تاريخ", "النوع", "الغرفة", "اسم العميل", "id"
            }
        ));
        tdetails.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tdetails.setRowHeight(25);
        tdetails.setRowMargin(2);
        tdetails.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tdetails.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tdetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tdetailsMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tdetails);
        if (tdetails.getColumnModel().getColumnCount() > 0) {
            tdetails.getColumnModel().getColumn(3).setMinWidth(100);
            tdetails.getColumnModel().getColumn(3).setPreferredWidth(100);
            tdetails.getColumnModel().getColumn(3).setMaxWidth(100);
            tdetails.getColumnModel().getColumn(5).setMinWidth(1);
            tdetails.getColumnModel().getColumn(5).setPreferredWidth(1);
            tdetails.getColumnModel().getColumn(5).setMaxWidth(1);
        }

        jPanel14.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 880, 270));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel13.setText("تاريخ");
        jPanel14.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 160, 110, -1));

        cmday.setDateFormatString("yyyy-MM-dd");
        cmday.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanel14.add(cmday, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 160, 230, 30));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        jLabel8.setText("الغرفة");
        jPanel14.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 110, 80, -1));

        cmroom.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "Room1", "Room2", "Room3", "Room4", "Room5", "Room6" }));
        jPanel14.add(cmroom, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, 230, 30));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        jLabel9.setText("نوع ");
        jPanel14.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, 90, -1));

        comment.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        comment.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel14.add(comment, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 230, -1));

        jLabel38.setBackground(new java.awt.Color(255, 255, 255));
        jLabel38.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        jLabel38.setText("تفاصيل");
        jPanel14.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 160, 90, 30));

        cmtype.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "PlayStation 4", "PlayStation 5" }));
        jPanel14.add(cmtype, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 230, 30));

        jLabel37.setBackground(new java.awt.Color(255, 255, 255));
        jLabel37.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        jLabel37.setText("اسم العميل");
        jPanel14.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 50, 130, 40));

        delete4.setBackground(new java.awt.Color(102, 152, 205));
        delete4.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        delete4.setForeground(new java.awt.Color(255, 255, 255));
        delete4.setText("مسح");
        delete4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete4ActionPerformed(evt);
            }
        });
        jPanel14.add(delete4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 560, 110, 50));

        name.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel14.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 50, 230, 40));

        save4.setBackground(new java.awt.Color(102, 152, 205));
        save4.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        save4.setForeground(new java.awt.Color(255, 255, 255));
        save4.setText("حفظ");
        save4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save4ActionPerformed(evt);
            }
        });
        jPanel14.add(save4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 100, 50));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/nYwGq3.jpg"))); // NOI18N
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0), 2));
        jPanel14.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 730));

        serialid4.setText("jLabel1");
        jPanel14.add(serialid4, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 650, -1, -1));

        date4.setText("jLabel1");
        jPanel14.add(date4, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 170, -1, -1));

        date1.setText("jLabel1");
        jPanel14.add(date1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 180, -1, -1));

        numberrr.setText("jLabel1");
        jPanel14.add(numberrr, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 690, -1, -1));

        nameee.setText("jLabel2");
        jPanel14.add(nameee, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 660, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1060, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tdetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tdetailsMouseClicked
        DefaultTableModel tmodel = (DefaultTableModel) tdetails.getModel();
        int selectrowindex = tdetails.getSelectedRow();
        serialid4.setText(tmodel.getValueAt(selectrowindex, 5).toString());
    }//GEN-LAST:event_tdetailsMouseClicked

    private void delete4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete4ActionPerformed
        if (serialid4.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "اختر الحجز المراد مسحة");

        } else {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this, "حفظ العملية ؟", "رسالة تاكيد ", dialogButton);
            if (dialogResult == 0) {
                try {
                    String sql = "DELETE FROM cafe.booking WHERE id='" + serialid4.getText() + "'";
                    pst = (PreparedStatement) DBConnect.con.prepareStatement(sql);
                    pst.execute();
                    JOptionPane.showMessageDialog(rootPane, " تم مسح العملية بنجاح");
                    tablelord();
                    clear();
                } catch (SQLException ex) {

                }
                clear();
            } else {

                JOptionPane.showMessageDialog(this, "الغاء العملية ");
            }
        }
    }//GEN-LAST:event_delete4ActionPerformed

    private void save4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save4ActionPerformed
        
            
            if (serialid4.getText().trim().isEmpty()) {

                if (cmtype.getSelectedItem().toString().equals("-") || cmroom.getSelectedItem().toString().equals("-") || name.getText().trim().isEmpty() || 
                        ((JTextField)cmday.getDateEditor().getUiComponent()).getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, " من فضلك اكمل البيانات ");
                } else {
                    String namee= name.getText();
                    String remark = comment.getText();
                    String type=cmtype.getSelectedItem().toString();
                    String room=cmroom.getSelectedItem().toString();
                    String day=((JTextField)cmday.getDateEditor().getUiComponent()).getText();
                    int dialogButton = JOptionPane.YES_NO_OPTION;
                    int dialogResult = JOptionPane.showConfirmDialog(this, "حفظ العملية ؟", "رسالة تاكيد ", dialogButton);
                    if (dialogResult == 0) {
                        try {
                            String sql = "INSERT INTO  cafe.booking (name,type,room,day,date,fulldatee,remark) VALUES"
                                    + " ('" + namee + "','"+type+"','"+room+"','"+day+"','"+datee+"','"+fulldatee+"','"+remark+"')";
                            pst = (PreparedStatement) DBConnect.con.prepareStatement(sql);
                            pst.execute();
                            
                            JOptionPane.showMessageDialog(null, "تم الحجز بنجاح");
                            tablelord();
                            clear();
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e);
                        }

                    } else {
                        JOptionPane.showMessageDialog(this, "الغاء العملية");

                    }
                }
                   
                }
          
    }//GEN-LAST:event_save4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser cmday;
    private javax.swing.JComboBox cmroom;
    private javax.swing.JComboBox cmtype;
    private javax.swing.JTextField comment;
    private javax.swing.JLabel date1;
    private javax.swing.JLabel date4;
    private javax.swing.JButton delete4;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField name;
    private javax.swing.JLabel nameee;
    private javax.swing.JLabel numberrr;
    private javax.swing.JButton save4;
    private javax.swing.JLabel serialid4;
    private javax.swing.JTable tdetails;
    // End of variables declaration//GEN-END:variables

    public void tablelord() {
        try {
            String sqll = "SELECT * FROM cafe.booking where date= '"+datee+"'";
            pst = (PreparedStatement) DBConnect.con.prepareStatement(sqll);
            rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) tdetails.getModel();
            model.setRowCount(0);
            int x = 1;
            while (rs.next()) {
                Object row[] = {
                   rs.getString("remark"),
                   rs.getString("day"),
                   rs.getString("type"),
                   rs.getString("room"),
                   rs.getString("name"),
                   rs.getString("id"),
                };
                model.addRow(row);
                x++;

            }
            if (x >= 11) {
            } else {
                for (int z = x; z < 13; z++) {
                    Object rowData[] = {
                        "", "", "", "", "",};
                    model.addRow(rowData);
                }
            }
        } catch (SQLException ex) {

        }
    }
   

    public void clear() {
        name.setText("");
        comment.setText("");
        cmtype.setSelectedIndex(0);
        cmroom.setSelectedIndex(0);
        serialid4.setText("");
    }

}