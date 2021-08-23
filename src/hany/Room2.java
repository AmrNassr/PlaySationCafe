/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hany;

import com.sbix.jnotify.NPosition;
import com.sbix.jnotify.NoticeType;
import com.sbix.jnotify.NoticeWindow;
import jaco.mp3.player.MP3Player;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author amnassar
 */
public class Room2 extends javax.swing.JFrame {

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
    private int hour;
    private int minute;
    private int second;
    private int csecond;
    private boolean isStart;
    int count = 0;
    String str;
    String mark = "No";
    String music = "No";
    String path;
    String hourpeice;
    public String markroom = "No";
    public float totalroomhour = 0;
    public float totalroomhour1 = 0;
    public static final int LONG_DELAY = 10000;

    private ImageIcon icon;
    public static MP3Player mp3;
    float amountt = 0;

    public Room2() throws IOException, ParseException {
        try {
            initComponents();
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
            tdetails.getTableHeader().setOpaque(false);
            tdetails.getTableHeader().setBackground(new Color(28, 57, 81));
            tdetails.getTableHeader().setForeground(new Color(255, 255, 255));
            tdetails.getTableHeader().setPreferredSize(new Dimension(40, 40));
            tdetails.setRowHeight(25);
            Calendar cal = new GregorianCalendar();
            day = cal.get(Calendar.DAY_OF_MONTH);
            month = cal.get(Calendar.MONTH) + 1;
            year = cal.get(Calendar.YEAR);
            Font bigFont = new Font("Arial", Font.BOLD, 16); // or whatever
            tdetails.getTableHeader().setFont(bigFont);
            items();
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
            icon = new ImageIcon(getClass().getResource("playstation.png"));
            this.setIconImage(icon.getImage());
            p2.setVisible(false);
            p3.setVisible(false);
            p4.setVisible(false);
            ButtonGroup G1 = new ButtonGroup();
            G1.add(open);
            G1.add(timee);
            ButtonGroup G2 = new ButtonGroup();
            G2.add(single);
            G2.add(doublee);
            single.setSelected(true);
            open.setSelected(true);
            ((DefaultEditor) minnumber.getEditor()).getTextField().setEditable(false);
            ((DefaultEditor) minnumber2.getEditor()).getTextField().setEditable(false);
            ((DefaultEditor) hournumber2.getEditor()).getTextField().setEditable(false);
            ((DefaultEditor) hournumber.getEditor()).getTextField().setEditable(false);
            JComponent editor = minnumber.getEditor();
            JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor) editor;
            spinnerEditor.getTextField().setHorizontalAlignment(JTextField.CENTER);
            JComponent editor2 = minnumber2.getEditor();
            JSpinner.DefaultEditor spinnerEditor2 = (JSpinner.DefaultEditor) editor2;
            spinnerEditor2.getTextField().setHorizontalAlignment(JTextField.CENTER);
            JComponent editor3 = hournumber2.getEditor();
            JSpinner.DefaultEditor spinnerEditor3 = (JSpinner.DefaultEditor) editor3;
            spinnerEditor3.getTextField().setHorizontalAlignment(JTextField.CENTER);
            JComponent editor4 = hournumber.getEditor();
            JSpinner.DefaultEditor spinnerEditor4 = (JSpinner.DefaultEditor) editor4;
            spinnerEditor4.getTextField().setHorizontalAlignment(JTextField.CENTER);
            playstationtype();
            auto_id();
            String sqldd = "SELECT total FROM cafe.roomitems where date='" + datee + "' and buyserial='" + serialbuy.getText() + "' and room='Room2'";
            pst = (PreparedStatement) DBConnect.con.prepareStatement(sqldd);
            rs = pst.executeQuery();
            while (rs.next()) {
                amountt = amountt + (rs.getFloat("total"));
            }
            billtotalcafe.setText("" + amountt);
            fulltotal.setText("" + (Float.parseFloat(billtotalcafe.getText()) + Float.parseFloat(billtotal.getText())));
            tablelord();
        } catch (SQLException ex) {
            Logger.getLogger(Room2.class.getName()).log(Level.SEVERE, null, ex);
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
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        pause = new javax.swing.JLabel();
        p2 = new javax.swing.JLabel();
        reset = new javax.swing.JLabel();
        p4 = new javax.swing.JLabel();
        start = new javax.swing.JLabel();
        p3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        sec = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        billtotalcafe = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        timee = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        minnumber = new javax.swing.JSpinner();
        cmitem = new javax.swing.JComboBox();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tdetails = new javax.swing.JTable();
        single = new javax.swing.JCheckBox();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        date1 = new javax.swing.JLabel();
        min = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        doublee = new javax.swing.JCheckBox();
        hournumber = new javax.swing.JSpinner();
        minnumber2 = new javax.swing.JSpinner();
        jLabel23 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        billtotal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        khsm = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        open = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        gametype = new javax.swing.JComboBox();
        jLabel22 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        hour2 = new javax.swing.JLabel();
        serial = new javax.swing.JLabel();
        number = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        hournumber2 = new javax.swing.JSpinner();
        jLabel31 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        msec = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        hour1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        fulltotal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        serialbuy = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        numberr = new javax.swing.JLabel();
        available = new javax.swing.JLabel();
        itemnamee = new javax.swing.JLabel();
        serialid = new javax.swing.JLabel();
        gameprice = new javax.swing.JLabel();
        gamepricedouble = new javax.swing.JLabel();
        serialid4 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1060, 750));
        setMinimumSize(new java.awt.Dimension(1060, 750));
        setUndecorated(true);
        setResizable(false);

        jPanel10.setBackground(new java.awt.Color(28, 57, 81));
        jPanel10.setForeground(new java.awt.Color(255, 255, 255));
        jPanel10.setMaximumSize(new java.awt.Dimension(1060, 750));
        jPanel10.setMinimumSize(new java.awt.Dimension(1060, 750));
        jPanel10.setPreferredSize(new java.awt.Dimension(1060, 750));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton5.setBackground(new java.awt.Color(102, 152, 205));
        jButton5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("مسح العملية");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 690, 210, 40));

        jButton3.setBackground(new java.awt.Color(102, 152, 205));
        jButton3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("مسح العنصر");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 590, 150, 40));

        jButton4.setBackground(new java.awt.Color(102, 152, 205));
        jButton4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("اضافة");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 230, 70, 30));

        pause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/exstopwatch/icons8_Pause_30px_1.png"))); // NOI18N
        pause.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pauseMousePressed(evt);
            }
        });
        jPanel10.add(pause, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 480, -1, -1));

        p2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/exstopwatch/icons8_Pause_30px_2.png"))); // NOI18N
        p2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                p2MousePressed(evt);
            }
        });
        jPanel10.add(p2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 480, -1, -1));

        reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/exstopwatch/icons8_Synchronize_30px.png"))); // NOI18N
        reset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                resetMousePressed(evt);
            }
        });
        jPanel10.add(reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 480, 50, -1));

        p4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/exstopwatch/icons8_Synchronize_30px_1.png"))); // NOI18N
        p4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                p4MousePressed(evt);
            }
        });
        jPanel10.add(p4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 480, -1, -1));

        start.setIcon(new javax.swing.ImageIcon(getClass().getResource("/exstopwatch/icons8_Play_30px.png"))); // NOI18N
        start.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                startMousePressed(evt);
            }
        });
        jPanel10.add(start, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 480, -1, -1));

        p3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/exstopwatch/icons8_Play_30px_1.png"))); // NOI18N
        p3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                p3MousePressed(evt);
            }
        });
        jPanel10.add(p3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 480, -1, -1));

        jLabel6.setBackground(new java.awt.Color(0, 0, 204));
        jLabel6.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Room 2");
        jPanel10.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 140));

        jButton2.setBackground(new java.awt.Color(102, 152, 205));
        jButton2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("مغادرة الصفحة");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 690, 210, 40));

        jButton1.setBackground(new java.awt.Color(102, 152, 205));
        jButton1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("تقفيل الحساب");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 690, 210, 40));

        sec.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        sec.setForeground(new java.awt.Color(255, 255, 255));
        sec.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sec.setText("00");
        jPanel10.add(sec, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 50, 40, 50));

        jPanel3.setBackground(new java.awt.Color(102, 152, 205));
        jPanel3.setMaximumSize(new java.awt.Dimension(100, 80));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel36.setBackground(new java.awt.Color(0, 0, 204));
        jLabel36.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("اجمالي الكافيتريا");
        jPanel3.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 45));

        billtotalcafe.setEditable(false);
        billtotalcafe.setBackground(new java.awt.Color(102, 152, 205));
        billtotalcafe.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        billtotalcafe.setForeground(new java.awt.Color(255, 255, 255));
        billtotalcafe.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        billtotalcafe.setText("0");
        jPanel3.add(billtotalcafe, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 100, 40));

        jPanel10.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, -1, -1));

        jLabel24.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel24.setText("بدء");
        jPanel10.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 440, 70, 30));

        timee.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        timee.setText("وقت");
        jPanel10.add(timee, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, 90, 20));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setText("COUNT UP TIMER");
        jPanel10.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 20, 180, -1));

        jLabel30.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel30.setText("عدد");
        jPanel10.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 230, 40, 30));

        minnumber.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        minnumber.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));
        jPanel10.add(minnumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 360, 60, 30));

        cmitem.setEditable(true);
        cmitem.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));
        cmitem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmitemActionPerformed(evt);
            }
        });
        jPanel10.add(cmitem, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 230, 130, 30));

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/exstopwatch/cafeteria.png"))); // NOI18N
        jPanel10.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 150, -1, 70));

        jScrollPane1.setBackground(new java.awt.Color(102, 152, 205));
        jScrollPane1.setForeground(new java.awt.Color(102, 152, 205));

        tdetails.setBackground(new java.awt.Color(102, 152, 205));
        tdetails.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        tdetails.setForeground(new java.awt.Color(255, 255, 255));
        tdetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "مجموع", "العدد", "السعر", "المنتج", "id"
            }
        ));
        tdetails.setFocusable(false);
        tdetails.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tdetails.setRowHeight(25);
        tdetails.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tdetails.setShowVerticalLines(false);
        tdetails.getTableHeader().setReorderingAllowed(false);
        tdetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tdetailsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tdetails);

        jPanel10.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 290, 450, 270));

        single.setText("Single");
        jPanel10.add(single, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, 90, 30));

        jLabel20.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("الساعات");
        jPanel10.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 330, 60, 30));

        jLabel21.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("الدقائق");
        jPanel10.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 330, 60, 30));

        date1.setText("date");
        jPanel10.add(date1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, -1, -1));

        min.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        min.setForeground(new java.awt.Color(255, 255, 255));
        min.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        min.setText("00");
        jPanel10.add(min, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 50, 40, 50));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/playstation (2).png"))); // NOI18N
        jPanel10.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, 70));

        doublee.setText("Double");
        jPanel10.add(doublee, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, 80, 30));

        hournumber.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        hournumber.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));
        jPanel10.add(hournumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, 60, 30));

        minnumber2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        minnumber2.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));
        jPanel10.add(minnumber2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 610, 60, 30));

        jLabel23.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel23.setText("اعادة");
        jPanel10.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 440, 70, 30));

        jLabel33.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/exstopwatch/add.png"))); // NOI18N
        jLabel33.setText("اضافة وقت");
        jPanel10.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, 470, 40));

        jPanel2.setBackground(new java.awt.Color(102, 152, 205));
        jPanel2.setMaximumSize(new java.awt.Dimension(100, 80));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setBackground(new java.awt.Color(0, 0, 204));
        jLabel5.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("اجمالي اللعب");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 45));

        billtotal.setEditable(false);
        billtotal.setBackground(new java.awt.Color(102, 152, 205));
        billtotal.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        billtotal.setForeground(new java.awt.Color(255, 255, 255));
        billtotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        billtotal.setText("0");
        jPanel2.add(billtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 100, 40));

        jPanel10.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText(":");
        jPanel10.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 50, -1, 50));

        jPanel1.setBackground(new java.awt.Color(102, 152, 205));
        jPanel1.setMaximumSize(new java.awt.Dimension(100, 80));
        jPanel1.setMinimumSize(new java.awt.Dimension(100, 80));
        jPanel1.setPreferredSize(new java.awt.Dimension(100, 80));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 0, 204));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("خصم");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 34));

        khsm.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        khsm.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        khsm.setText("0");
        jPanel1.add(khsm, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 80, 30));

        jPanel10.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 30, -1, -1));

        jLabel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel10.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 470, 100));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/exstopwatch/stopwatch_1.png"))); // NOI18N
        jLabel19.setText("الوقت");
        jPanel10.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 250, 40));

        open.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        open.setText("مفتوح");
        jPanel10.add(open, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 90, 20));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText(":");
        jPanel10.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 50, 10, 50));

        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel10.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 470, 110));

        gametype.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));
        gametype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gametypeActionPerformed(evt);
            }
        });
        jPanel10.add(gametype, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 80, 30));

        jLabel22.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel22.setText("ايقاف");
        jPanel10.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 440, 70, 30));

        jLabel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel10.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 470, 100));

        jLabel35.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("الساعات");
        jPanel10.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 610, 60, 30));

        jLabel32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel10.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, 470, 100));

        jLabel28.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        jLabel28.setText("الكافيتريا");
        jPanel10.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 170, 90, 40));

        hour2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        hour2.setForeground(new java.awt.Color(255, 255, 255));
        hour2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hour2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/exstopwatch/stopwatch.png"))); // NOI18N
        jPanel10.add(hour2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 40, 80, 70));

        serial.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        serial.setForeground(new java.awt.Color(255, 255, 255));
        serial.setText("Serial");
        jPanel10.add(serial, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 410, 160, 40));

        number.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        number.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        number.setText("1");
        number.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberActionPerformed(evt);
            }
        });
        jPanel10.add(number, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 230, 50, 30));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel14.setText("نوع الجهاز");
        jPanel10.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 80, 70));

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/exstopwatch/game-controller (1).png"))); // NOI18N
        jPanel10.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, 90, 50));

        hournumber2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        hournumber2.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));
        jPanel10.add(hournumber2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 610, 60, 30));

        jLabel31.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel31.setText("الصنف");
        jPanel10.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 230, 70, 30));

        jLabel34.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("الدقائق");
        jPanel10.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 610, 60, 30));

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/exstopwatch/joystick.png"))); // NOI18N
        jPanel10.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, 80, 50));

        msec.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        msec.setForeground(new java.awt.Color(255, 255, 255));
        msec.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msec.setText("00");
        jPanel10.add(msec, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 50, 30, 50));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText(":");
        jPanel10.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 50, 20, 50));

        price.setEditable(false);
        price.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        price.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel10.add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 230, 50, 30));

        hour1.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        hour1.setForeground(new java.awt.Color(255, 255, 255));
        hour1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hour1.setText("00");
        jPanel10.add(hour1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 50, 40, 50));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/nYwGq3.jpg"))); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0), 2));
        jPanel10.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 510, 540));

        jLabel11.setText("jLabel11");
        jPanel10.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/exstopwatch/2.png"))); // NOI18N
        jPanel10.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 0, 440, 140));

        jPanel4.setBackground(new java.awt.Color(102, 152, 205));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel37.setBackground(new java.awt.Color(0, 0, 204));
        jLabel37.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("اجمالي الحساب");
        jPanel4.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 40));

        fulltotal.setEditable(false);
        fulltotal.setBackground(new java.awt.Color(102, 152, 205));
        fulltotal.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        fulltotal.setForeground(new java.awt.Color(255, 255, 255));
        fulltotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fulltotal.setText("0");
        jPanel4.add(fulltotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 100, 40));

        jPanel10.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 100, 80));

        jLabel3.setBackground(new java.awt.Color(21, 31, 41));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/exstopwatch/2.png"))); // NOI18N
        jPanel10.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 140));

        serialbuy.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        serialbuy.setForeground(new java.awt.Color(255, 255, 255));
        serialbuy.setText("jLabel36");
        jPanel10.add(serialbuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 150, 70));

        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/nYwGq3.jpg"))); // NOI18N
        jLabel25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0), 2));
        jPanel10.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 140, 510, 540));

        jLabel26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel10.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 160, 490, 120));

        jLabel27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel10.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 290, 490, 370));

        numberr.setText("jLabel36");
        jPanel10.add(numberr, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 200, -1, -1));

        available.setText("jLabel36");
        jPanel10.add(available, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 180, -1, -1));

        itemnamee.setText("jLabel36");
        jPanel10.add(itemnamee, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 290, -1, -1));

        serialid.setText("jLabel1");
        jPanel10.add(serialid, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 650, -1, -1));

        gameprice.setText("jLabel36");
        jPanel10.add(gameprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, -1, -1));

        gamepricedouble.setText("jLabel36");
        jPanel10.add(gamepricedouble, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, -1, -1));

        serialid4.setText("jLabel36");
        jPanel10.add(serialid4, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 190, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void p3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p3MousePressed

    }//GEN-LAST:event_p3MousePressed

    private void p4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p4MousePressed

    }//GEN-LAST:event_p4MousePressed

    private void startMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startMousePressed
        jButton1.setEnabled(false);
        if ((gameprice.getText().trim().isEmpty() && gamepricedouble.getText().trim().isEmpty())
                || ((timee.isSelected()) && (hournumber.getValue().toString().equals("0") && minnumber.getValue().toString().equals("0")))
                || gametype.getSelectedItem().toString().equals("-")) {
            JOptionPane.showMessageDialog(this, "اكمل البيانات");
        } else {
            timee.setEnabled(false);
            open.setEnabled(false);
            minnumber.setEnabled(false);
            hournumber.setEnabled(false);
            gametype.setEnabled(false);
            single.setEnabled(false);
            doublee.setEnabled(false);
            p3.setVisible(true);
            start.setVisible(false);
            pause.setVisible(true);
            p2.setVisible(false);
            p4.setVisible(false);
            reset.setVisible(true);
            people.fulltimepanel2.setBackground(new Color(204, 255, 255));
            isStart = true;
            if (single.isSelected()) {
                hourpeice = gameprice.getText();
            } else {
                hourpeice = gamepricedouble.getText();
            }
            if (open.isSelected()) {

                Thread th = new Thread() {
                    public void run() {
                        while (isStart == true) {
                            try {
                                sleep(100);

                                csecond++;
                                if (csecond == 9) {
                                    second++;
                                    csecond = 0;
                                }
                                if (second == 60) {
                                    minute++;
                                    second = 0;
                                }
                                if (minute == 60) {
                                    hour++;
                                    minute = 0;
                                }
                                if (Integer.parseInt(sec.getText()) > 0 && Integer.parseInt(sec.getText()) < 10) {
                                    sec.setText("0" + second);
                                    //  people.secondd.setText("0" + second);
                                } else {
                                    sec.setText("" + second);
                                    //  people.secondd.setText("" + second);
                                }
                                if (Integer.parseInt(hour1.getText()) > 0 && Integer.parseInt(hour1.getText()) < 10) {
                                    hour1.setText("0" + hour);
                                    //people.fulltime.setText("0" + hour);
                                } else {
                                    hour1.setText("" + hour);
                                    // people.fulltime.setText("" + hour);
                                }
                                if (Integer.parseInt(min.getText()) > 0 && Integer.parseInt(min.getText()) < 10) {
                                    min.setText("0" + minute);
                                    // people.minutee.setText("0" + minute);
                                } else {
                                    min.setText("" + minute);
                                    // people.minutee.setText("" + minute);
                                }
                                msec.setText("" + csecond);
                                // people.msecondd.setText("" + csecond);
                                people.fulltime2.setText(hour1.getText() + " : " + min.getText() + " : " + sec.getText() + " : " + msec.getText());
                            } catch (Exception ex) {
                                System.out.print("something is wrong");
                            }
                        }

                    }

                };
                th.start();

            } else {
                float numberofhours;
                csecond = 9;
                if (mark.equals("No")) {
                    minute = (Integer) minnumber.getValue();
                    hour = (Integer) hournumber.getValue();
                    numberofhours = ((hour) + (float) minute / 60);
                    totalroomhour1 = totalroomhour1 + numberofhours;
                    billtotal.setText("" + (Float.parseFloat(billtotal.getText()) + (numberofhours * Float.parseFloat(hourpeice))));
                    fulltotal.setText("" + (Float.parseFloat(billtotalcafe.getText()) + Float.parseFloat(billtotal.getText())));
                    if (minute == 1 && hour == 0) {
                        min.setText("" + 0);
                        sec.setText("59");
                    } else if (minute > 1 && hour == 0) {
                        min.setText("" + (minute - 1));
                        second = 59;
                    } else if (hour == 1 && minute == 0) {
                        hour1.setText("0");
                        min.setText("59");
                        sec.setText("59");
                    } else if (hour == 1 && minute == 1) {
                        hour1.setText("0" + hour);
                        min.setText("0");
                        sec.setText("59");
                    } else if (hour == 1 && minute > 1) {
                        hour1.setText("" + hour);
                        min.setText("" + minute);
                        sec.setText("59");
                    } else {
                        min.setText("" + minute);
                        hour1.setText("" + hour);
                        sec.setText("59");
                    }

                    Thread th = new Thread() {
                        public void run() {

                            while (isStart == true && csecond > 0) {

                                try {
                                    sleep(100);

                                    if (csecond > 0) {
                                        csecond--;
                                    }

                                    if (csecond == 0) {
                                        if (second != 0) {
                                            second--;
                                            csecond = 9;
                                        }
                                    }
                                    if (second == 0) {
                                        if (minute != 0) {
                                            minute--;
                                            second = 60;
                                        }

                                    }
                                    if (minute == 0) {
                                        if (hour != 0) {
                                            hour--;
                                            minute = 60;
                                        }

                                    }
                                    if (Integer.parseInt(sec.getText()) > 0 && Integer.parseInt(sec.getText()) < 11) {
                                        sec.setText("0" + second);
                                        // people.secondd.setText("0" + second);
                                    } else {
                                        sec.setText("" + second);
                                        //   people.secondd.setText("" + second);
                                    }
                                    if (Integer.parseInt(hour1.getText()) > 0 && Integer.parseInt(hour1.getText()) < 10) {
                                        hour1.setText("0" + hour);
                                        //   people.fulltime.setText("0" + hour);
                                    } else {
                                        hour1.setText("" + hour);
                                        //  people.fulltime.setText("" + hour);
                                    }
                                    if (Integer.parseInt(min.getText()) > 0 && Integer.parseInt(min.getText()) < 10) {
                                        min.setText("0" + minute);
                                        //  people.minutee.setText("0" + minute);
                                    } else {
                                        min.setText("" + minute);
                                        // people.minutee.setText("" + minute);
                                    }
                                    msec.setText("" + csecond);
                                    //  people.msecondd.setText("" + csecond);
                                    people.fulltime2.setText(hour1.getText() + " : " + min.getText() + " : " + sec.getText() + " : " + msec.getText());
                                } catch (Exception ex) {
                                    System.out.print("something is wrong");
                                }

                                if (second == 0 && minute == 0 && hour == 0 && music.equals("No")) {
                                    path = "D:\\cafe\\13767_nice_larm_clock.mp3";
                                    mp3 = new MP3Player(new File(path));
                                    mp3.play();
                                    new NoticeWindow(NoticeType.ERROR_NOTIFICATION, " Room 2  Time Finished", NoticeWindow.LONG_DELAY, NPosition.BOTTOM_RIGHT);
                                    music = "yes";
                                    people.fulltimepanel2.setBackground(Color.red);

                                }
                            }
                        }
                    };
                    th.start();
                } else {
                    minute = minute + (Integer) minnumber2.getValue();
                    hour = hour + (Integer) hournumber2.getValue();
                    numberofhours = (((Integer) hournumber2.getValue()) + (float) (Integer) minnumber2.getValue() / 60);
                    billtotal.setText("" + (Float.parseFloat(billtotal.getText()) + (numberofhours * Float.parseFloat(hourpeice))));
                    fulltotal.setText("" + (Float.parseFloat(billtotalcafe.getText()) + Float.parseFloat(billtotal.getText())));
                    totalroomhour1 = totalroomhour1 + numberofhours;
                    minnumber2.setValue(0);
                    hournumber2.setValue(0);
                    Thread th = new Thread() {

                        public void run() {

                            while (isStart == true && csecond > 0) {
                                try {
                                    sleep(100);

                                    if (csecond > 0) {
                                        csecond--;
                                    }

                                    if (csecond == 0) {
                                        if (second != 0) {
                                            second--;
                                            csecond = 9;
                                        }
                                    }
                                    if (second == 0) {
                                        if (minute != 0) {
                                            minute--;
                                            second = 60;
                                        }

                                    }
                                    if (minute == 0) {
                                        if (hour != 0) {
                                            hour--;
                                            minute = 60;
                                        }

                                    }
                                    if (Integer.parseInt(sec.getText()) > 0 && Integer.parseInt(sec.getText()) < 10) {
                                        sec.setText("0" + second);
                                        // people.secondd.setText("0" + second);
                                    } else {
                                        sec.setText("" + second);
                                        //  people.secondd.setText("" + second);
                                    }
                                    if (Integer.parseInt(hour1.getText()) > 0 && Integer.parseInt(hour1.getText()) < 10) {
                                        hour1.setText("0" + hour);
                                        // people.fulltime.setText("0" + hour);
                                    } else {
                                        hour1.setText("" + hour);
                                        //   people.fulltime.setText("" + hour);
                                    }
                                    if (Integer.parseInt(min.getText()) > 0 && Integer.parseInt(min.getText()) < 10) {
                                        min.setText("0" + minute);
                                        //  people.minutee.setText("0" + minute);
                                    } else {
                                        min.setText("" + minute);
                                        //  people.minutee.setText("" + minute);
                                    }
                                    msec.setText("" + csecond);
                                    // people.msecondd.setText("" + csecond);
                                    people.fulltime2.setText(hour1.getText() + " : " + min.getText() + " : " + sec.getText() + " : " + msec.getText());
                                } catch (Exception ex) {
                                    System.out.print("something is wrong");
                                }

                                if (second == 0 && minute == 0 && hour == 0 && music.equals("No")) {

                                    path = "D:\\cafe\\13767_nice_larm_clock.mp3";
                                    mp3 = new MP3Player(new File(path));
                                    mp3.play();
                                    new NoticeWindow(NoticeType.ERROR_NOTIFICATION, " Room 2  Time Finished", NoticeWindow.LONG_DELAY, NPosition.BOTTOM_RIGHT);
                                    music = "yes";
                                    people.fulltimepanel2.setBackground(Color.red);

                                }
                            }
                            return;

                        }
                    };
                    th.start();
                }

            }

        }

    }//GEN-LAST:event_startMousePressed

    private void resetMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetMousePressed

        timee.setEnabled(true);
        open.setEnabled(true);
        minnumber.setEnabled(true);
        hournumber.setEnabled(true);
        gametype.setEnabled(true);
        single.setEnabled(true);
        doublee.setEnabled(true);

        if (open.isSelected()) {
            p4.setVisible(true);
            reset.setVisible(false);
            pause.setVisible(true);
            start.setVisible(true);
            isStart = false;
            csecond = 0;
            second = 0;
            minute = 0;
            hour = 0;
            mark = "No";
            music = "No";
            hour1.setText("0" + hour);
            min.setText("0" + minute);
            sec.setText("0" + second);
            msec.setText("0" + csecond);
            people.fulltime2.setText(hour1.getText() + " : " + min.getText() + " : " + sec.getText() + " : " + msec.getText());
        } else {
            String hourpeice;
            if (single.isSelected()) {
                hourpeice = gameprice.getText();
            } else {
                hourpeice = gamepricedouble.getText();
            }
            float totalminus = totalroomhour1 * Float.parseFloat(hourpeice);
            billtotal.setText("" + (Float.parseFloat(billtotal.getText()) - totalminus));
            totalroomhour1 = 0;
            fulltotal.setText("" + (Float.parseFloat(billtotalcafe.getText()) + Float.parseFloat(billtotal.getText())));
            p4.setVisible(true);
            reset.setVisible(false);
            pause.setVisible(true);
            start.setVisible(true);
            isStart = false;
            csecond = 0;
            second = 0;
            minute = 0;
            hour = 0;
            min.setText("" + minute);
            hour1.setText("" + hour);
            sec.setText("" + second);
            msec.setText("0" + csecond);
            mark = "No";
            music = "No";
        }


    }//GEN-LAST:event_resetMousePressed

    private void p2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p2MousePressed
        pause.setVisible(true);
        isStart = true;

    }//GEN-LAST:event_p2MousePressed

    private void pauseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pauseMousePressed
        p2.setVisible(true);
        jButton1.setEnabled(true);
        pause.setVisible(false);
        start.setVisible(true);
        p3.setVisible(false);
        p4.setVisible(false);
        reset.setVisible(true);
        mark = "Yes";
        isStart = false;
        if (open.isSelected()) {
            float totalroomhour11 = Float.parseFloat(hour1.getText()) + (Float.parseFloat(min.getText()) / 60);
            float totalbilltotal = totalroomhour11 * (Float.parseFloat(hourpeice));
            billtotal.setText("" + totalbilltotal);
        }
    }//GEN-LAST:event_pauseMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String type, kind, gametypee, timetype, kshmm, paid;
        if (single.isSelected()) {
            type = "single";
        } else {
            type = "double";
        }
        if (open.isSelected()) {
            timetype = "open";
        } else {
            timetype = "time";
        }
        gametypee = gametype.getSelectedItem().toString();
        kshmm = khsm.getText();
        if (timee.isSelected()) {
            try {
                float totalx = Float.parseFloat(fulltotal.getText()) - Float.parseFloat(kshmm);
                String sql = "INSERT INTO cafe.room (gametype,timee,type,date,fulldate,timetype,kshm,total,totalplay,totalitem,roomnumber,buyserial) VALUES"
                        + " ('" + gametypee + "','" + totalroomhour1 + "','" + type + "','" + datee + "','" + fulldatee + "','" + timetype + "',"
                        + "'" + kshmm + "','" + totalx + "','" + billtotal.getText() + "','" + billtotalcafe.getText() + "','Room 2','" + serialbuy.getText() + "')";
                pst = (PreparedStatement) DBConnect.con.prepareStatement(sql);
                pst.execute();
                String sqll = "INSERT INTO cafe.roomitems (item,number,price,total,date,fulldate,buyserial,room) VALUES"
                        + " ('" + gametypee + "','" + totalroomhour1 + "','" + hourpeice + "',"
                        + "'" + billtotal.getText() + "','" + datee + "','" + fulldatee + "','" + serialbuy.getText() + "','Room2')";
                pst = (PreparedStatement) DBConnect.con.prepareStatement(sqll);
                pst.execute();
                JOptionPane.showMessageDialog(rootPane, " تم تقفيل الحساب " + totalx);
                people.fulltime2.setText("00" + " : " + "00" + " : " + "00" + " : " + "00");
                markroom = "Yes";
                people.fulltimepanel2.setBackground(new Color(204, 204, 204));
                auto_id();
                this.dispose();

            } catch (SQLException ex) {
                Logger.getLogger(Room2.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            float totalroomhour11 = Float.parseFloat(hour1.getText()) + (Float.parseFloat(min.getText()) / 60);
            float totalbilltotal = totalroomhour11 * (Float.parseFloat(hourpeice));
            try {
                float totalx = Float.parseFloat(fulltotal.getText()) - Float.parseFloat(kshmm);

                String sql = "INSERT INTO cafe.room (gametype,timee,type,date,fulldate,timetype,kshm,total,totalplay,totalitem,roomnumber,buyserial) VALUES"
                        + " ('" + gametypee + "','" + totalroomhour11 + "','" + type + "','" + datee + "','" + fulldatee + "','" + timetype + "',"
                        + "'" + kshmm + "','" + totalx + "','" + totalbilltotal + "','" + billtotalcafe.getText() + "','Room 2','" + serialbuy.getText() + "')";
                pst = (PreparedStatement) DBConnect.con.prepareStatement(sql);
                pst.execute();
                String sqll = "INSERT INTO cafe.roomitems (item,number,price,total,date,fulldate,buyserial,room) VALUES"
                        + " ('" + gametypee + "','" + totalroomhour1 + "','" + hourpeice + "',"
                        + "'" + billtotal.getText() + "','" + datee + "','" + fulldatee + "','" + serialbuy.getText() + "','Room2')";
                pst = (PreparedStatement) DBConnect.con.prepareStatement(sqll);
                pst.execute();
                JOptionPane.showMessageDialog(rootPane, " تم تقفيل الحساب " + totalx);
                people.fulltime2.setText("00" + " : " + "00" + " : " + "00" + " : " + "00");
                markroom = "Yes";
                people.fulltimepanel2.setBackground(new Color(204, 204, 204));
                auto_id();
                this.dispose();

            } catch (SQLException ex) {
                Logger.getLogger(Room2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        people.room2.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        float amount = 0;
        String seriall = serialbuy.getText();

        if (serialid4.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "من فضلك اختر العنصر ");

        } else {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this, "هل تريد حفظ العملية", "رسالة تاكيد ؟ ", dialogButton);
            if (dialogResult == 0) {
                try {
                    String sql = "DELETE FROM cafe.roomitems WHERE id='" + serialid4.getText() + "'";
                    pst = (PreparedStatement) DBConnect.con.prepareStatement(sql);
                    pst.execute();
                    String sqla1 = "UPDATE cafe.storeitemlist SET number =number+" + numberr.getText() + "   where name='" + itemnamee.getText() + "'";
                    pst = (PreparedStatement) DBConnect.con.prepareStatement(sqla1);
                    pst.executeUpdate();
                    serialid4.setText("");
                    numberr.setText("");
                    tablelord();
                    String sqldd = "SELECT total FROM cafe.roomitems where date='" + datee + "' and buyserial='" + seriall + "'";
                    pst = (PreparedStatement) DBConnect.con.prepareStatement(sqldd);
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        amount = amount + (rs.getFloat("total"));
                    }
                    billtotalcafe.setText("" + amount);
                    fulltotal.setText("" + (Float.parseFloat(billtotalcafe.getText()) + Float.parseFloat(billtotal.getText())));
                } catch (SQLException ex) {

                }
            } else {

                JOptionPane.showMessageDialog(this, " الغاء");
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        float amount = 0;
        float total = 0;
        String seriall = serialbuy.getText();
        total = Float.parseFloat(number.getText()) * Float.parseFloat(price.getText());
        try {
            if (Integer.parseInt(number.getText()) < Integer.parseInt(available.getText())) {
                String sql = "INSERT INTO cafe.roomitems (item,number,price,total,date,fulldate,buyserial,room) VALUES"
                        + " ('" + cmitem.getSelectedItem() + "','" + number.getText() + "','" + price.getText() + "',"
                        + "'" + total + "','" + datee + "','" + fulldatee + "','" + seriall + "','Room2')";
                pst = (PreparedStatement) DBConnect.con.prepareStatement(sql);
                pst.execute();
                String sqla1d = "UPDATE cafe.storeitemlist SET number =number-" + number.getText() + " WHERE  name='" + cmitem.getSelectedItem().toString() + "'";
                pst = (PreparedStatement) DBConnect.con.prepareStatement(sqla1d);
                pst.executeUpdate();
                String sqll33 = "INSERT INTO cafe.storeitemlogs (name,number,type,date,fulldate,price) "
                        + "VALUES('" + cmitem.getSelectedItem().toString() + "','" + number.getText() + "','كافيتريا','" + datee + "','" + fulldatee + "','" + price.getText() + "')";
                pst = (PreparedStatement) DBConnect.con.prepareStatement(sqll33);
                pst.execute();
                String sqldd = "SELECT total FROM cafe.roomitems where date='" + datee + "' and buyserial='" + seriall + "'";
                pst = (PreparedStatement) DBConnect.con.prepareStatement(sqldd);
                rs = pst.executeQuery();
                while (rs.next()) {
                    amount = amount + (rs.getFloat("total"));
                }
                billtotalcafe.setText("" + amount);
                fulltotal.setText("" + (Float.parseFloat(billtotalcafe.getText()) + Float.parseFloat(billtotal.getText())));
                tablelord();
            } else {
                JOptionPane.showMessageDialog(rootPane, "لا يوجد عدد كافي بالمخزن");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Room2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "هل تريد حفظ العمليه", "تاكيد العمليه", dialogButton);
        if (dialogResult == 0) {
            markroom = "Yes";
             people.fulltime2.setText("00" + " : " + "00" + " : " + "00" + " : " + "00");
            this.dispose();
        } else {

        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void cmitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmitemActionPerformed
        Object obj = evt.getSource();
        if (obj == cmitem) {

            try {
                String sqll = "SELECT *  FROM cafe.storeitemlist where  name='" + cmitem.getSelectedItem().toString() + "'";

                pst = (PreparedStatement) DBConnect.con.prepareStatement(sqll);

                rs = pst.executeQuery();

                while (rs.next()) {
                    price.setText(rs.getString("price"));
                    available.setText(rs.getString("number"));
                    if (rs.getString("type").equals("مشروبات")) {
                        available.setText("100");
                    }

                }
            } catch (SQLException ex) {
            }
        }
    }//GEN-LAST:event_cmitemActionPerformed

    private void tdetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tdetailsMouseClicked
        DefaultTableModel tmodel = (DefaultTableModel) tdetails.getModel();
        int selectrowindex = tdetails.getSelectedRow();
        serialid4.setText(tmodel.getValueAt(selectrowindex, 4).toString());
        numberr.setText(tmodel.getValueAt(selectrowindex, 1).toString());
        itemnamee.setText(tmodel.getValueAt(selectrowindex, 3).toString());
        //        name.setText(tmodel.getValueAt(selectrowindex, 2).toString());
        //        phone.setText(tmodel.getValueAt(selectrowindex, 0).toString());
        //        cmtype.setSelectedItem(tmodel.getValueAt(selectrowindex, 1).toString());
    }//GEN-LAST:event_tdetailsMouseClicked

    private void gametypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gametypeActionPerformed
        Object obj = evt.getSource();
        if (obj == gametype) {

            try {
                String sqll = "SELECT *  FROM cafe.playstationtype where  name='" + gametype.getSelectedItem().toString() + "'";

                pst = (PreparedStatement) DBConnect.con.prepareStatement(sqll);

                rs = pst.executeQuery();

                while (rs.next()) {
                    gameprice.setText(rs.getString("price"));
                    gamepricedouble.setText(rs.getString("double"));

                }
            } catch (SQLException ex) {
            }
        }
    }//GEN-LAST:event_gametypeActionPerformed

    private void numberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numberActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel available;
    private javax.swing.JTextField billtotal;
    private javax.swing.JTextField billtotalcafe;
    private javax.swing.JComboBox cmitem;
    private javax.swing.JLabel date1;
    private javax.swing.JCheckBox doublee;
    private javax.swing.JTextField fulltotal;
    private javax.swing.JLabel gameprice;
    private javax.swing.JLabel gamepricedouble;
    private javax.swing.JComboBox gametype;
    public static javax.swing.JLabel hour1;
    private javax.swing.JLabel hour2;
    private javax.swing.JSpinner hournumber;
    private javax.swing.JSpinner hournumber2;
    private javax.swing.JLabel itemnamee;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField khsm;
    public static javax.swing.JLabel min;
    private javax.swing.JSpinner minnumber;
    private javax.swing.JSpinner minnumber2;
    public static javax.swing.JLabel msec;
    private javax.swing.JTextField number;
    private javax.swing.JLabel numberr;
    private javax.swing.JRadioButton open;
    private javax.swing.JLabel p2;
    private javax.swing.JLabel p3;
    private javax.swing.JLabel p4;
    private javax.swing.JLabel pause;
    private javax.swing.JTextField price;
    private javax.swing.JLabel reset;
    public static javax.swing.JLabel sec;
    private javax.swing.JLabel serial;
    private javax.swing.JLabel serialbuy;
    private javax.swing.JLabel serialid;
    private javax.swing.JLabel serialid4;
    private javax.swing.JCheckBox single;
    private javax.swing.JLabel start;
    private javax.swing.JTable tdetails;
    private javax.swing.JRadioButton timee;
    // End of variables declaration//GEN-END:variables

    public void tablelord() {
        try {
            String sqll = "SELECT * FROM cafe.roomitems where buyserial='" + serialbuy.getText() + "' and date='" + datee + "' and room ='Room2' order by id";
            pst = (PreparedStatement) DBConnect.con.prepareStatement(sqll);
            rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) tdetails.getModel();
            model.setRowCount(0);
            int x = 1;
            while (rs.next()) {
                Object row[] = {
                    rs.getString("total"),
                    rs.getString("number"),
                    rs.getString("price"),
                    rs.getString("item"),
                    rs.getString("id"),};
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

    public void items() {
        try {
            String sql = "SELECT * FROM cafe.storeitemlist where type='بيع' and number >0";
            pst = (PreparedStatement) DBConnect.con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String namee = rs.getString("name");

                cmitem.addItem(namee);

            }

        } catch (SQLException ex) {

        }
        try {
            String sql = "SELECT * FROM cafe.storeitemlist where type='مشروبات' ";
            pst = (PreparedStatement) DBConnect.con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String namee = rs.getString("name");

                cmitem.addItem(namee);

            }

        } catch (SQLException ex) {

        }
    }

    public void playstationtype() {
        try {
            String sql = "SELECT * FROM cafe.playstationtype ";
            pst = (PreparedStatement) DBConnect.con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String namee = rs.getString("name");

                gametype.addItem(namee);

            }

        } catch (SQLException ex) {

        }
    }

    public void auto_id() {

        try {
            String sqll = "SELECT Distinct buyserial FROM cafe.room where buyserial like 'R2%'  order by id DESC limit 1";
            pst = (PreparedStatement) DBConnect.con.prepareStatement(sqll);
            rs = pst.executeQuery();
            if (rs.next()) {
                String rnno = rs.getString("buyserial");
                int co = rnno.length();
                String txt = rnno.substring(0, 3);
                String num = rnno.substring(3, co);
                int n = Integer.parseInt(num);
                n++;
                String snum = Integer.toString(n);
                String ftxt = txt + snum;
                serialbuy.setText(ftxt);
            } else {
                serialbuy.setText("R2-1001");

            }
        } catch (SQLException ex) {

        }

    }
}
