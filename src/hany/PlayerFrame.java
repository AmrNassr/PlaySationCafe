/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hany;

import jaco.mp3.player.MP3Player;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.nio.file.Paths;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Majey
 */
public class PlayerFrame extends javax.swing.JFrame {

    /**
     * Creates new form PlayerFrame
     */
    
    // Define MP3Player Class From JACO MP3Player Lib
    MP3Player player;
    // Define File For Song
    File songFile;
    // Define Current Directory Like If We Use JFileChooser then where it statys.
    String currentDirectory ; // I am using home.user this will call file chooser in user documents.
    // Here I define currentPath of the running app class
    String currentPath;
    // This String Will Be For Image Name or Path
    String imagePath;
    // We need to set app title as string
    String appName = "JOBME TECH SOLUTIONS - (MP3 Player)";
    
    // Now Check If Repeat Button is Enabled or not
    boolean repeat = false;
    
    // Here I am making a boolean for windowCollapsed
    boolean windowCollapsed = false;
    
    // Here I need to define mouse x and y for to get mouse position on screen.
    int xMouse, yMouse;
    
    public PlayerFrame( String x,String y ) {
        initComponents();
        // Set App Title Here
        appTitle.setText(appName);
        currentDirectory=y;
        
        // Here I am going to set a default song file. It's not necessary.
        songFile = new File(x);
        
        // Now make a string to get file name
        String fileName = songFile.getName();
        // Here set our song name label with this name
        songNameDisplay.setText(fileName);
        
        // Add our method to player variable
        player = mp3Player();
        // Now add song to player as playlist.
        player.addToPlayList(songFile);
        
        // Here get current path and images path in strings
        currentPath = Paths.get(".").toAbsolutePath().normalize().toString();
        imagePath = "\\images";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        headerPanel = new javax.swing.JPanel();
        appTitle = new javax.swing.JLabel();
        quitBtn = new javax.swing.JLabel();
        settingsBtn = new javax.swing.JLabel();
        songNameMainPanel = new javax.swing.JPanel();
        songNameSubPanel = new javax.swing.JPanel();
        songNameDisplay = new javax.swing.JLabel();
        controlPanel = new javax.swing.JPanel();
        repeatBtn = new javax.swing.JLabel();
        pauseBtn = new javax.swing.JLabel();
        playBtn = new javax.swing.JLabel();
        stopBtn = new javax.swing.JLabel();
        openBtn = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        volumeDownBtn = new javax.swing.JLabel();
        volumeUpBtn = new javax.swing.JLabel();
        volumeFullBtn = new javax.swing.JLabel();
        muteBtn = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        mainPanel.setBackground(new java.awt.Color(7, 63, 86));

        headerPanel.setBackground(new java.awt.Color(36, 93, 116));

        appTitle.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        appTitle.setForeground(new java.awt.Color(34, 202, 237));
        appTitle.setText("APP TITLE");
        appTitle.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                appTitleMouseDragged(evt);
            }
        });
        appTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                appTitleMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                appTitleMousePressed(evt);
            }
        });

        quitBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        quitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jobme/pk/images/quit.png"))); // NOI18N
        quitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quitBtnMouseClicked(evt);
            }
        });

        settingsBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        settingsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jobme/pk/images/settings.png"))); // NOI18N
        settingsBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                settingsBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(appTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(settingsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(appTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(quitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(settingsBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        songNameMainPanel.setBackground(new java.awt.Color(7, 63, 86));

        songNameSubPanel.setBackground(new java.awt.Color(7, 63, 86));
        songNameSubPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(34, 202, 237), 1, true));

        songNameDisplay.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        songNameDisplay.setForeground(new java.awt.Color(34, 202, 237));
        songNameDisplay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        songNameDisplay.setText("PLAYING");

        javax.swing.GroupLayout songNameSubPanelLayout = new javax.swing.GroupLayout(songNameSubPanel);
        songNameSubPanel.setLayout(songNameSubPanelLayout);
        songNameSubPanelLayout.setHorizontalGroup(
            songNameSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(songNameSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(songNameSubPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(songNameDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, 950, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        songNameSubPanelLayout.setVerticalGroup(
            songNameSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
            .addGroup(songNameSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(songNameDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout songNameMainPanelLayout = new javax.swing.GroupLayout(songNameMainPanel);
        songNameMainPanel.setLayout(songNameMainPanelLayout);
        songNameMainPanelLayout.setHorizontalGroup(
            songNameMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(songNameMainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(songNameSubPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        songNameMainPanelLayout.setVerticalGroup(
            songNameMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(songNameMainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(songNameSubPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        controlPanel.setBackground(new java.awt.Color(7, 63, 86));

        repeatBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        repeatBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jobme/pk/images/repeat.png"))); // NOI18N
        repeatBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                repeatBtnMouseClicked(evt);
            }
        });

        pauseBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pauseBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jobme/pk/images/pause.png"))); // NOI18N
        pauseBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pauseBtnMouseClicked(evt);
            }
        });

        playBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jobme/pk/images/play.png"))); // NOI18N
        playBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playBtnMouseClicked(evt);
            }
        });

        stopBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stopBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jobme/pk/images/stop.png"))); // NOI18N
        stopBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stopBtnMouseClicked(evt);
            }
        });

        openBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        openBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jobme/pk/images/open.png"))); // NOI18N
        openBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                openBtnMouseClicked(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        volumeDownBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        volumeDownBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jobme/pk/images/volume_down.png"))); // NOI18N
        volumeDownBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                volumeDownBtnMouseClicked(evt);
            }
        });

        volumeUpBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        volumeUpBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jobme/pk/images/volume_up.png"))); // NOI18N
        volumeUpBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                volumeUpBtnMouseClicked(evt);
            }
        });

        volumeFullBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        volumeFullBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jobme/pk/images/volume_full.png"))); // NOI18N
        volumeFullBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                volumeFullBtnMouseClicked(evt);
            }
        });

        muteBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        muteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jobme/pk/images/mute.png"))); // NOI18N
        muteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                muteBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout controlPanelLayout = new javax.swing.GroupLayout(controlPanel);
        controlPanel.setLayout(controlPanelLayout);
        controlPanelLayout.setHorizontalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(repeatBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pauseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(playBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stopBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(openBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(volumeDownBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(volumeUpBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(volumeFullBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(muteBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        controlPanelLayout.setVerticalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(repeatBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pauseBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addComponent(playBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addComponent(stopBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addComponent(openBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addComponent(volumeDownBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addComponent(volumeUpBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addComponent(volumeFullBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addComponent(muteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(songNameMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(controlPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(songNameMainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(controlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void playBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playBtnMouseClicked
        // TODO add your handling code here:
        player.play();
    }//GEN-LAST:event_playBtnMouseClicked

    private void stopBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stopBtnMouseClicked
        // TODO add your handling code here:
        player.stop();
    }//GEN-LAST:event_stopBtnMouseClicked

    private void pauseBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pauseBtnMouseClicked
        // TODO add your handling code here:
        player.pause();
    }//GEN-LAST:event_pauseBtnMouseClicked

    private void repeatBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_repeatBtnMouseClicked
        // TODO add your handling code here:
        if(repeat == false){
            repeat = true;
            player.setRepeat(repeat);
            
            String image = currentPath+imagePath+"\\repeat_enabled.png";
            repeatBtn.setIcon(new ImageIcon(image));
        }else if(repeat == true){
            repeat = false;
            player.setRepeat(repeat);
            
            String image = currentPath+imagePath+"\\repeat.png";
            repeatBtn.setIcon(new ImageIcon(image));            
        }
    }//GEN-LAST:event_repeatBtnMouseClicked

    private void appTitleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appTitleMousePressed
        // TODO add your handling code here:
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_appTitleMousePressed

    private void appTitleMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appTitleMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_appTitleMouseDragged

    private void quitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quitBtnMouseClicked
player.stop();        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_quitBtnMouseClicked

    private void settingsBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsBtnMouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Your settings dilog will be popup here!");
    }//GEN-LAST:event_settingsBtnMouseClicked

    private void openBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openBtnMouseClicked
        // TODO add your handling code here:
        JFileChooser openFileChooser = new JFileChooser(currentDirectory);
        openFileChooser.setFileFilter(new FileTypeFilter(".mp3", "Open MP3 Files Only!"));
        int result = openFileChooser.showOpenDialog(null);
        if(result == JFileChooser.APPROVE_OPTION){
            songFile = openFileChooser.getSelectedFile();
            player.addToPlayList(songFile);
            player.skipForward();
            currentDirectory = songFile.getAbsolutePath();
            songNameDisplay.setText("Playing Now... | " + songFile.getName());
        }
    }//GEN-LAST:event_openBtnMouseClicked

    private void appTitleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appTitleMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount() == 2){
            if(windowCollapsed == false){
                windowCollapsed = true;
                this.setSize(new Dimension(this.getSize().width, 50));
                
                appTitle.setFont(new Font("Nirmala UI", 0, 12));
                appTitle.setText("Playing Now... | " + songFile.getName());
            }else if(windowCollapsed == true){
                windowCollapsed = false;
                this.setSize(new Dimension(this.getSize().width, 250));
                
                appTitle.setFont(new Font("Nirmala UI", 0, 18));
                appTitle.setText(appName);
            }
        }
    }//GEN-LAST:event_appTitleMouseClicked

    private void volumeDownBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volumeDownBtnMouseClicked
        // TODO add your handling code here:
        volumeDownControl((float) 0.1);
    }//GEN-LAST:event_volumeDownBtnMouseClicked

    private void volumeUpBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volumeUpBtnMouseClicked
        // TODO add your handling code here:
        volumeUpControl(0.1);
    }//GEN-LAST:event_volumeUpBtnMouseClicked

    private void volumeFullBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volumeFullBtnMouseClicked
        // TODO add your handling code here:
        volumeControl(1.0);
    }//GEN-LAST:event_volumeFullBtnMouseClicked

    private void muteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_muteBtnMouseClicked
        // TODO add your handling code here:
        volumeControl((float) 0.0);
    }//GEN-LAST:event_muteBtnMouseClicked

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
            java.util.logging.Logger.getLogger(PlayerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlayerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlayerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlayerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel appTitle;
    private javax.swing.JPanel controlPanel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel muteBtn;
    private javax.swing.JLabel openBtn;
    private javax.swing.JLabel pauseBtn;
    private javax.swing.JLabel playBtn;
    private javax.swing.JLabel quitBtn;
    private javax.swing.JLabel repeatBtn;
    private javax.swing.JLabel settingsBtn;
    private javax.swing.JLabel songNameDisplay;
    private javax.swing.JPanel songNameMainPanel;
    private javax.swing.JPanel songNameSubPanel;
    private javax.swing.JLabel stopBtn;
    private javax.swing.JLabel volumeDownBtn;
    private javax.swing.JLabel volumeFullBtn;
    private javax.swing.JLabel volumeUpBtn;
    // End of variables declaration//GEN-END:variables
    
    // I am going to create a custom MP3Player Method
    private MP3Player mp3Player(){
        MP3Player mp3Player = new MP3Player();
        return mp3Player;
    }
    
    // Let's Set Volume Down Method It's not necessary to remeber this code.
    private void volumeDownControl(float valueToPlusMinus){
        // Get Mixer Information From AudioSystem
        Mixer.Info[] mixers = AudioSystem.getMixerInfo();
        // Now use a for loop to list all mixers
        for(Mixer.Info mixerInfo : mixers){
            // Get Mixer
            Mixer mixer = AudioSystem.getMixer(mixerInfo);
            // Now Get Target Line
            Line.Info[] lineInfos = mixer.getTargetLineInfo();
            // Here again use for loop to list lines
            for(Line.Info lineInfo : lineInfos){
                // Make a null line
                Line line = null;
                // Make a boolean as opened
                boolean opened = true;
                // Now use try exception for opening a line
                try{
                    line = mixer.getLine(lineInfo);
                    opened = line.isOpen() || line instanceof Clip;
                    // Now Check If Line Is not Opened
                    if(!opened){
                        // Open Line
                        line.open();
                    }
                    // Make a float control
                    FloatControl volControl = (FloatControl) line.getControl(FloatControl.Type.VOLUME);
                    // Get Current Volume Now
                    float currentVolume = volControl.getValue();
                    // Make a temp float variable and store valuePlusMinus
                    float volumeToCut = valueToPlusMinus;
                    // Make a float and calculate the addition or subtraction in volume
                    float changedCalc = (float) ((float)currentVolume-(float)volumeToCut);
                    // Now Set This Changed Value Into Volume Line.
                    volControl.setValue(changedCalc);
                    
                }catch (LineUnavailableException lineException){
                }catch (IllegalArgumentException illException){
                }finally{
                    // Close Line If it opened
                    if(line != null && !opened){
                        line.close();
                    }
                }
            }
        }
    }
    
    // Let's Set Volume Up Method It's not necessary to remeber this code.
    private void volumeUpControl(double valueToPlusMinus){
        // Get Mixer Information From AudioSystem
        Mixer.Info[] mixers = AudioSystem.getMixerInfo();
        // Now use a for loop to list all mixers
        for(Mixer.Info mixerInfo : mixers){
            // Get Mixer
            Mixer mixer = AudioSystem.getMixer(mixerInfo);
            // Now Get Target Line
            Line.Info[] lineInfos = mixer.getTargetLineInfo();
            // Here again use for loop to list lines
            for(Line.Info lineInfo : lineInfos){
                // Make a null line
                Line line = null;
                // Make a boolean as opened
                boolean opened = true;
                // Now use try exception for opening a line
                try{
                    line = mixer.getLine(lineInfo);
                    opened = line.isOpen() || line instanceof Clip;
                    // Now Check If Line Is not Opened
                    if(!opened){
                        // Open Line
                        line.open();
                    }
                    // Make a float control
                    FloatControl volControl = (FloatControl) line.getControl(FloatControl.Type.VOLUME);
                    // Get Current Volume Now
                    double currentVolume = volControl.getValue();
                    // Make a temp float variable and store valuePlusMinus
                    double volumeToCut = valueToPlusMinus;
                    // Make a float and calculate the addition or subtraction in volume
                    float changedCalc = (float) ((float)currentVolume+(float)volumeToCut);
                    // Now Set This Changed Value Into Volume Line.
                    volControl.setValue(changedCalc);
                    
                }catch (LineUnavailableException lineException){
                }catch (IllegalArgumentException illException){
                }finally{
                    // Close Line If it opened
                    if(line != null && !opened){
                        line.close();
                    }
                }
            }
        }
    }
    
    // Let's Set Volume Method It's not necessary to remeber this code.
    private void volumeControl(double valueToPlusMinus){
        // Get Mixer Information From AudioSystem
        Mixer.Info[] mixers = AudioSystem.getMixerInfo();
        // Now use a for loop to list all mixers
        for(Mixer.Info mixerInfo : mixers){
            // Get Mixer
            Mixer mixer = AudioSystem.getMixer(mixerInfo);
            // Now Get Target Line
            Line.Info[] lineInfos = mixer.getTargetLineInfo();
            // Here again use for loop to list lines
            for(Line.Info lineInfo : lineInfos){
                // Make a null line
                Line line = null;
                // Make a boolean as opened
                boolean opened = true;
                // Now use try exception for opening a line
                try{
                    line = mixer.getLine(lineInfo);
                    opened = line.isOpen() || line instanceof Clip;
                    // Now Check If Line Is not Opened
                    if(!opened){
                        // Open Line
                        line.open();
                    }
                    // Make a float control
                    FloatControl volControl = (FloatControl) line.getControl(FloatControl.Type.VOLUME);
                    // Get Current Volume Now
                    float currentVolume = volControl.getValue();
                    // Make a temp float variable and store valuePlusMinus
                    double volumeToCut = valueToPlusMinus;
                    // Make a float and calculate the addition or subtraction in volume
                    float changedCalc = (float) ((float)volumeToCut);
                    // Now Set This Changed Value Into Volume Line.
                    volControl.setValue(changedCalc);
                    
                }catch (LineUnavailableException lineException){
                }catch (IllegalArgumentException illException){
                }finally{
                    // Close Line If it opened
                    if(line != null && !opened){
                        line.close();
                    }
                }
            }
        }
    }
}
