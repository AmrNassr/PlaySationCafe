/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Store;

import hany.DBConnect;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author amnassar
 */
public final class storeitems extends javax.swing.JInternalFrame {

    /**
     * Creates new form book
     */
    PreparedStatement pst;
    ResultSet rs;
    public String y;
    public String datee;
    public Calendar cal;
    String dayyy;
    String smokerr;
    String sugarr;
    String pressurr;

    public storeitems(String x) throws IOException, ParseException {
        initComponents();
        category();
        clear();
        tablelord();
        TableCellRenderer rendererFromHeader = tdetails.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tdetails.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tdetails.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tdetails.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tdetails.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tdetails.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        
        tdetails.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        tdetails.getTableHeader().setFont(new Font("Arial", Font.BOLD, 20));
        tdetails.getTableHeader().setOpaque(false);
        tdetails.getTableHeader().setBackground(new Color(28,57,81));
        tdetails.getTableHeader().setForeground(new Color(255, 255, 255));
        tdetails.getTableHeader().setPreferredSize(new Dimension(40, 40));
        tdetails.setRowHeight(40);
        cal = new GregorianCalendar();

        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
        int dayy = cal.get(Calendar.DAY_OF_MONTH);
        dayyy = String.valueOf(dayy);
        if (dayy == 1 || dayy == 2 || dayy == 3 || dayy == 4
                || dayy == 5 || dayy == 6 || dayy == 7 || dayy == 8 || dayy == 9) {
            dayyy = String.valueOf(dayy);
            dayyy = "0" + dayyy;
        }
        date1.setText(year + "-" + month + "-" + dayyy);
        datee = date1.getText().toString();
        if (x.equals("admin")) {

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

        jPanel10 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        cmtype = new javax.swing.JComboBox();
        delete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tdetails = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        cmcategory = new javax.swing.JComboBox();
        save3 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        save4 = new javax.swing.JButton();
        save5 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        serialid = new javax.swing.JLabel();
        date1 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1060, 750));
        setMinimumSize(new java.awt.Dimension(1060, 750));
        setPreferredSize(new java.awt.Dimension(1060, 750));

        jPanel10.setBackground(new java.awt.Color(0, 0, 0));
        jPanel10.setForeground(new java.awt.Color(255, 255, 255));
        jPanel10.setMaximumSize(new java.awt.Dimension(1060, 660));
        jPanel10.setMinimumSize(new java.awt.Dimension(1060, 660));
        jPanel10.setPreferredSize(new java.awt.Dimension(1060, 660));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Arial", 1, 28)); // NOI18N
        jLabel10.setText("??????????");
        jPanel10.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 160, 120, -1));

        cmtype.setEditable(true);
        cmtype.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        cmtype.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "??????", "??????????????", "??????????????" }));
        jPanel10.add(cmtype, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 160, 220, 30));

        delete.setBackground(new java.awt.Color(102, 152, 205));
        delete.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setText("?????? ????????????");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel10.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 570, 190, 50));

        tdetails.setBackground(new java.awt.Color(102, 152, 205));
        tdetails.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
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
                "??????", "??????????", "????????????", "?????? ????????????", "?????? ????????????", "id"
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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tdetailsMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tdetails);
        if (tdetails.getColumnModel().getColumnCount() > 0) {
            tdetails.getColumnModel().getColumn(1).setMinWidth(150);
            tdetails.getColumnModel().getColumn(1).setPreferredWidth(150);
            tdetails.getColumnModel().getColumn(1).setMaxWidth(150);
            tdetails.getColumnModel().getColumn(3).setMinWidth(150);
            tdetails.getColumnModel().getColumn(3).setPreferredWidth(150);
            tdetails.getColumnModel().getColumn(3).setMaxWidth(150);
            tdetails.getColumnModel().getColumn(5).setMinWidth(1);
            tdetails.getColumnModel().getColumn(5).setPreferredWidth(1);
            tdetails.getColumnModel().getColumn(5).setMaxWidth(1);
        }

        jPanel10.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 930, 250));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Arial", 1, 28)); // NOI18N
        jLabel9.setText("????????????");
        jPanel10.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, 120, -1));

        cmcategory.setEditable(true);
        cmcategory.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        cmcategory.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        jPanel10.add(cmcategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 220, 30));

        save3.setBackground(new java.awt.Color(102, 152, 205));
        save3.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        save3.setForeground(new java.awt.Color(255, 255, 255));
        save3.setText("??????");
        save3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save3ActionPerformed(evt);
            }
        });
        jPanel10.add(save3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 210, 100, 50));

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Arial", 1, 28)); // NOI18N
        jLabel19.setText("??????????");
        jPanel10.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 100, 90, 30));

        price.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        price.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        price.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                priceKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                priceKeyTyped(evt);
            }
        });
        jPanel10.add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 100, 100, 30));

        save4.setBackground(new java.awt.Color(102, 152, 205));
        save4.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        save4.setForeground(new java.awt.Color(255, 255, 255));
        save4.setText("??????????");
        save4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save4ActionPerformed(evt);
            }
        });
        jPanel10.add(save4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, 110, 50));

        save5.setBackground(new java.awt.Color(102, 152, 205));
        save5.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        save5.setForeground(new java.awt.Color(255, 255, 255));
        save5.setText("??????");
        save5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save5ActionPerformed(evt);
            }
        });
        jPanel10.add(save5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 210, 110, 50));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Arial", 1, 28)); // NOI18N
        jLabel15.setText("?????? ????????????");
        jPanel10.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 40, 120, -1));

        name.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jPanel10.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 40, 220, 30));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/nYwGq3.jpg"))); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0), 2));
        jPanel10.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 720));

        serialid.setText("jLabel1");
        jPanel10.add(serialid, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 650, -1, -1));

        date1.setText("jLabel1");
        jPanel10.add(date1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 80, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tdetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tdetailsMouseClicked
        DefaultTableModel tmodel = (DefaultTableModel) tdetails.getModel();
        //bid,name, price, publisher, book_type, b_code, date, category
        int selectrowindex = tdetails.getSelectedRow();
        serialid.setText(tmodel.getValueAt(selectrowindex, 5).toString());
        name.setText(tmodel.getValueAt(selectrowindex, 4).toString());
        price.setText(tmodel.getValueAt(selectrowindex, 3).toString());
        cmcategory.setSelectedItem(tmodel.getValueAt(selectrowindex, 2).toString());
        cmtype.setSelectedItem(tmodel.getValueAt(selectrowindex, 0).toString());

    }//GEN-LAST:event_tdetailsMouseClicked

    private void save4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save4ActionPerformed
        clear();
        cmtype.setSelectedIndex(0);
        tablelord();
    }//GEN-LAST:event_save4ActionPerformed

    private void save5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save5ActionPerformed
        try {
            String namee = name.getText();
            String pricee = price.getText();
            String categoryy = cmcategory.getSelectedItem().toString();

            String sqll = "SELECT * FROM cafe.storeitemlist WHERE  1=1 ";
            if (!name.getText().trim().isEmpty()) {
                sqll = sqll + " AND name LIKE '%" + namee + "%'";
            }
            if (!price.getText().trim().isEmpty()) {
                sqll = sqll + " AND price LIKE '%" + pricee + "%'";
            }
         if (!cmcategory.getSelectedItem().toString().trim().isEmpty()) {
                sqll = sqll + " AND category LIKE '%" + categoryy + "%'";
            }
          if (!cmtype.getSelectedItem().toString().trim().isEmpty()) {
                sqll = sqll + " AND type LIKE '%" + cmtype.getSelectedItem() + "%'";
            }
            pst = (PreparedStatement) DBConnect.con.prepareStatement(sqll);
            rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) tdetails.getModel();
            model.setRowCount(0);
            int k = 0;
            while (rs.next()) {
                Object row[] = {
                    rs.getString("type"),
                    rs.getString("number"),
                    rs.getString("category"),
                    rs.getString("price"),
                    rs.getString("name"),
                    rs.getString("id"),};
                model.addRow(row);
                k++;
            }
            for (int i = k; i < 11; i++) {
                Object rowData[] = {
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",};
                model.addRow(rowData);
            }
        } catch (SQLException ex) {
            Logger.getLogger(storeitems.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_save5ActionPerformed

    private void save3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save3ActionPerformed
        try {
            String namee = name.getText();
            float pricee = Float.parseFloat(price.getText());
            String categoryy = cmcategory.getSelectedItem().toString();
            if (serialid.getText().trim().isEmpty()) {

                if (name.getText().trim().isEmpty() || price.getText().trim().isEmpty() || cmtype.getSelectedItem().toString().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "  ???? ???????? ???????? ?????? ???????????? ?????????? ?? ???????????? ??????????????");
                } else {
                    int dialogButton = JOptionPane.YES_NO_OPTION;
                    int dialogResult = JOptionPane.showConfirmDialog(this, "???? ???????? ?????? ??????????????", "?????????? ??????????????", dialogButton);
                    if (dialogResult == 0) {
                        try {
                            String sql = "INSERT INTO cafe.storeitemlist (price,name,category,type) VALUES"
                                    + " ('" + pricee + "','" + namee + "','" + categoryy + "','"+cmtype.getSelectedItem()+"')";
                            pst = (PreparedStatement) DBConnect.con.prepareStatement(sql);
                            pst.execute();
                            JOptionPane.showMessageDialog(null, "???? ?????????? ???????????? ??????????");
                            clear();
                            tablelord();

                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "???????????? ?????????? ???? ??????");
                        }

                    } else {
                        JOptionPane.showMessageDialog(this, " ???? ?????????? ??????????????");

                    }

                }
            } else {
                try {
                    String sqla = "UPDATE cafe.storeitemlist SET name='" + namee + "',price='" + pricee + "' , category='" + categoryy + "',type='"+cmtype.getSelectedItem()+"'"
                            + " where  id='" + serialid.getText() + "'";
                    pst = (PreparedStatement) DBConnect.con.prepareStatement(sqla);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(this, "???? ?????????? ???????????? ??????????");
                    clear();
                    tablelord();
                } catch (SQLException ex) {

                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "???????????? ?????? ????????");
        }
    }//GEN-LAST:event_save3ActionPerformed

    private void priceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_priceKeyTyped

    }//GEN-LAST:event_priceKeyTyped

    private void priceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_priceKeyReleased
       
    }//GEN-LAST:event_priceKeyReleased

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        if (serialid.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "???? ???????? ???????? ???????????? ");

        } else {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this, "???? ???????? ?????? ??????????????", "?????????? ?????????? ?? ", dialogButton);
            if (dialogResult == 0) {
                try {
                    String sql = "DELETE FROM cafe.storeitemlist WHERE id='" + serialid.getText() + "'";
                    pst = (PreparedStatement) DBConnect.con.prepareStatement(sql);
                    pst.execute();
                    serialid.setText("");
                    tablelord();
                } catch (SQLException ex) {

                }
            } else {

                JOptionPane.showMessageDialog(this, " ??????????");
            }
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void tdetailsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tdetailsMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tdetailsMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmcategory;
    private javax.swing.JComboBox cmtype;
    private javax.swing.JLabel date1;
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField name;
    private javax.swing.JTextField price;
    private javax.swing.JButton save3;
    private javax.swing.JButton save4;
    private javax.swing.JButton save5;
    private javax.swing.JLabel serialid;
    private javax.swing.JTable tdetails;
    // End of variables declaration//GEN-END:variables
public void clear() {
        name.setText("");
        serialid.setText("");
        cmcategory.setSelectedIndex(0);
        price.setText("");

    }

    public void tablelord() {
        try {
            String sqll = "SELECT * FROM cafe.storeitemlist order by name";
            pst = (PreparedStatement) DBConnect.con.prepareStatement(sqll);
            rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) tdetails.getModel();
            model.setRowCount(0);
            int k = 0;
            while (rs.next()) {
                Object row[] = {
                    rs.getString("type"),
                     rs.getString("number"),
                    rs.getString("category"),
                    rs.getString("price"),
                    rs.getString("name"),
                    rs.getString("id"),};
                model.addRow(row);
                k++;
            }
            for (int i = k; i < 11; i++) {
                Object rowData[] = {
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",};
                model.addRow(rowData);
            }
        } catch (SQLException ex) {

        }
    }

    

    public void category() {
        try {
            String sql = "SELECT name  FROM cafe.storecategory order by name ";
            pst = (PreparedStatement) DBConnect.con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");

                cmcategory.addItem(name);

            }

        } catch (SQLException ex) {

        }
    }
}
