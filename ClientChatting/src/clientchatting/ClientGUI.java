/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientchatting;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author SerMiGO
 */
public class ClientGUI extends javax.swing.JFrame {
    private static A_Chat_Client ChatClient;
    public static String UserName = "Anonymous";
    public static String p2pPort = "1111";
    public static DefaultListModel def= new DefaultListModel();
    public static int flagSeen = 1;
    
public String ClientName;
    /**
     * Creates new form ClientGUI
     */
    public ClientGUI() {
        initComponents();   
        jLabel2.setText(ClientName);
        BDiss.setVisible(false);
        
        
       }
    
    
    
    
    
public static void setDef(String X)
    {
        def.addElement(X);
         System.out.println(def.getSize());
    }
public static void removeDef(String X)
    {
        def.removeElement(X);
    }

public static void runP2P (String N, int X)
    {
     System.out.println("chatting.ClientGUI.runP2P()" + N + X);
     mainscreen_p2p p1 = new mainscreen_p2p(UserName, Integer.parseInt(p2pPort),N, X);
    }
public static void runCRoom (String[]X,int PORT)
    {
        chattRoomGUI CRGUI = new chattRoomGUI(X, PORT);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Bsend = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        chatarea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        messagearea = new javax.swing.JTextArea();
        loginname = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        BDiss = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Bp2p = new javax.swing.JButton();
        BchatRoom = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        onlineUsr = new javax.swing.JList<>();
        jLabel6 = new javax.swing.JLabel();
        portbox = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tt = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Client");

        Bsend.setText("Send");
        Bsend.setEnabled(false);
        Bsend.setSelected(true);
        Bsend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BsendActionPerformed(evt);
            }
        });

        chatarea.setEditable(false);
        chatarea.setColumns(20);
        chatarea.setRows(5);
        jScrollPane2.setViewportView(chatarea);

        messagearea.setColumns(20);
        messagearea.setRows(5);
        messagearea.setEnabled(false);
        messagearea.setMaximumSize(new java.awt.Dimension(4, 22));
        messagearea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SeenHandler(evt);
            }
        });
        jScrollPane1.setViewportView(messagearea);

        jButton4.setText("connect");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        BDiss.setText("Disconnect");
        BDiss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BDissActionPerformed(evt);
            }
        });

        jLabel3.setText("Choose the Client");

        Bp2p.setText("P2P with selected");
        Bp2p.setEnabled(false);
        Bp2p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bp2pActionPerformed(evt);
            }
        });

        BchatRoom.setText("Create chat room");
        BchatRoom.setEnabled(false);
        BchatRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BchatRoomActionPerformed(evt);
            }
        });

        onlineUsr.setModel(def);
        onlineUsr.setEnabled(false);
        jScrollPane3.setViewportView(onlineUsr);

        jLabel6.setText("Port");

        portbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                portboxActionPerformed(evt);
            }
        });

        jButton1.setText("☺");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("☹");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("♥");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setText("☻");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("☃");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("☢");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clientchatting/icon.png"))); // NOI18N

        jLabel5.setText("Seen By:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel1))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(loginname)
                                    .addComponent(portbox, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BDiss))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addGap(10, 10, 10)
                                        .addComponent(jButton2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton7))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Bsend, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeen)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BchatRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(Bp2p, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addComponent(tt, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addGap(2, 2, 2)
                                .addComponent(jScrollPane3))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel1)
                                            .addComponent(loginname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel6)
                                            .addComponent(portbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BDiss, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jSeen))
                                .addGap(9, 9, 9))))
                    .addComponent(tt))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(Bp2p)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BchatRoom))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3)
                            .addComponent(jButton5)
                            .addComponent(jButton6)
                            .addComponent(jButton7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Bsend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE))))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        Bsend.getAccessibleContext().setAccessibleName("SendButton");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BsendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BsendActionPerformed
        // TODO add your handling code here:
        SEND();
        flagSeen = 1;
    }//GEN-LAST:event_BsendActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        UserName = loginname.getText();
        p2pPort = portbox.getText();
        ENTER();
        jLabel2.setText(p2pPort);
        jLabel7.setText(UserName);
        jButton4.setVisible(false);
        BDiss.setVisible(true);
        loginname.setVisible(false);
        portbox.setVisible(false);
        BDiss.setVisible(true);
        Bsend.setEnabled(true);
        messagearea.setEnabled(true);
        onlineUsr.setEnabled(true);
        Bp2p.setEnabled(true);
        BchatRoom.setEnabled(true);
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void BDissActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BDissActionPerformed
        // TODO add your handling code here:
        BDiss.setVisible(false);
        Bsend.setEnabled(false);
        messagearea.setEnabled(false);
        onlineUsr.setEnabled(false);
        Bp2p.setEnabled(false);
        BchatRoom.setEnabled(false);
        DISCONNECT();
    }//GEN-LAST:event_BDissActionPerformed

    private void portboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_portboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_portboxActionPerformed

    private void Bp2pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bp2pActionPerformed
        // TODO add your handling code here:
        ChatClient.p2pRequest(onlineUsr.getSelectedValue());
        String selected = (String) onlineUsr.getSelectedValue(); // 3mlna casting
    }//GEN-LAST:event_Bp2pActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        messagearea.append("☹");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        messagearea.append("♥"); 
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
         messagearea.append("☻"); 
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        messagearea.append("☃"); 
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        messagearea.append("☢");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        messagearea.append("☺");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void SeenHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SeenHandler
        // TODO add your handling code here:
        if (flagSeen == 0)
        {
        ChatClient.sendSeen(UserName);
        flagSeen = 1;
        }
    }//GEN-LAST:event_SeenHandler

    private void BchatRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BchatRoomActionPerformed
        // TODO add your handling code here
         String[] Temp = new String[onlineUsr.getSelectedIndices().length + 1];
         for(int i = 0; i< onlineUsr.getSelectedIndices().length;i++)
         {
             Temp[i] = onlineUsr.getSelectedValue();
         }
         System.out.println(onlineUsr.getSelectedIndices().length);
         Temp[onlineUsr.getSelectedIndices().length] = UserName;
         ChatClient.CRoomRequest(Temp,onlineUsr.getSelectedIndices().length + 1);
    }//GEN-LAST:event_BchatRoomActionPerformed
 public static void Connect()
    {
        try
        {
            final int PORT = 1234;
            final String HOST = "192.168.43.143";
            Socket SOCK = new Socket(HOST, PORT);
//            System.out.println("You connected to: "+ HOST);
            
            ChatClient = new A_Chat_Client(SOCK);
            
            PrintWriter OUT = new PrintWriter(SOCK.getOutputStream());
            OUT.println(UserName);
            OUT.flush();
            OUT.println(p2pPort);
            OUT.flush();
            
            Thread X = new Thread(ChatClient);
            X.start();
            
        }
        catch(Exception e)
        {
            System.out.print(e);
            JOptionPane.showMessageDialog(null, "Server not responding.");
            System.exit(0);
        }
    }
    
    public static void Initialize()
    {  
       
    }
    
    
    public static void ENTER()
    {
        if(!loginname.getText().equals(""))
        {
           
            Connect();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please enter a name!");
        }
    }
    
//    public static Socket mm(String x)
//    {
//    
//    
//        return S
//    }
    
     public static void SEND()
    {
        if(!messagearea.getText().equals(""))
        {
            ChatClient.SEND(messagearea.getText());
            messagearea.requestFocus();
        }
    }
     
     
    
      public static void DISCONNECT()
    {
        try
        {
            ChatClient.DISCONNECT();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
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
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientGUI().setVisible(true);
                
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BDiss;
    private javax.swing.JButton BchatRoom;
    private javax.swing.JButton Bp2p;
    private javax.swing.JButton Bsend;
    public static javax.swing.JTextArea chatarea;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JLabel jSeen;
    private static javax.swing.JTextField loginname;
    public static javax.swing.JTextArea messagearea;
    public static javax.swing.JList<String> onlineUsr;
    private javax.swing.JTextField portbox;
    private javax.swing.JLabel tt;
    // End of variables declaration//GEN-END:variables
}