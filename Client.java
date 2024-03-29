package com.example.clientserver;

import java.awt.event.ActionEvent;
import java.io.*;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Hamza
 */
public class Client extends javax.swing.JFrame {
    static Socket socket;
    static BufferedReader entree;
    static PrintWriter sortie;
    static boolean connected = false;
    static ObjectInputStream in;
    static ObjectOutputStream out;
    static boolean La_reponse_existe=false;
    static String current_question;
    static String Current_Score;

int index=0,correct=0;
/**
     * Creates new form Client
     */
    public Client() throws IOException {
        initComponents();
        
        
  jButton2ActionPerformed(null);
    }

    /**
     *
     */
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jColorChooser1 = new javax.swing.JColorChooser();
        jColorChooser2 = new javax.swing.JColorChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("  Client Quiz");

        jLabel2.setText("Question?");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel4.setText("Mon Score");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jButton1.setText("Connecter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);

            }
        });

        jButton2.setText("Next");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButton2ActionPerformed(evt);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        jButton3.setText("Quitter");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel3.setText("Ma réponse");

        jLabel5.setText("user");

        jLabel6.setText("password");

        jTextField3.setText("");
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                            .addComponent(jTextField3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(jButton1))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addComponent(jButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel2)))
                .addContainerGap(149, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(35, 35, 35)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(58, 58, 58))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(ActionEvent evt) {
        setConnected(connectServer());
        jButton1.setVisible(false);
        BtnDeJxVisible();
        Start();
        jTextArea1.setText(current_question);
        jTextField1.setText("");
// display your score
        jTextField2.setText("your score is"+Current_Score);
        La_reponse_existe=false;

    }

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) throws IOException {//GEN-FIRST:event_jButton2ActionPerformed
 // display the next question
        La_reponse_existe=true;
         jTextArea1.setText(current_question);
        String l = jTextField1.getText();
        System.out.println(l);
        if(out!=null)
        out.writeObject("reponse" + "/" + l);
        jTextField1.setText("");

    }//GEN-LAST:event_jButton2ActionPerformed
 
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        System.exit(0);
        logout();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Client().setVisible(true);
                    BtnDeJxInVisible();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private static javax.swing.JButton jButton2;
    private static javax.swing.JButton jButton3;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JColorChooser jColorChooser2;
    private static javax.swing.JLabel jLabel1;
    private static javax.swing.JLabel jLabel2;
    private static javax.swing.JLabel jLabel3;
    private static javax.swing.JLabel jLabel4;
    private static javax.swing.JLabel jLabel5;
    private static javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private static javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTextArea jTextArea1;
    private static javax.swing.JTextField jTextField1;
    private static javax.swing.JTextField jTextField2;
    private static javax.swing.JPasswordField jTextField3;
    private static javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
    public static boolean isConnected() {
        return connected;
    }

    public static boolean test(){
        try {
            out.writeObject("test");
            String result = (String) in.readObject();
            return result!=null;
        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }
    }
    public static void Start(){
        try {
            out.writeObject("name/Hamza");
            String result = (String) in.readObject();
            if(result.equals("name/accepted"));
            {
                new Thread(new Client.QuestionThread_client()).start();
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    static class QuestionThread_client extends Thread {
        Timer timer = new Timer();
        private String[] messagerRecu;
        @Override
        public void run() {
            TimerTask myTask = new TimerTask() {
                @Override
                public void run() {
                    try {
                        String s = null;

                        while (true){
                            s = (String) in.readObject();
                            messagerRecu = s.split("/");
                            switch (messagerRecu[0]) {
                                case "question":
                                        System.out.println(messagerRecu[0]+":"+messagerRecu[1]);
                                        current_question=messagerRecu[1]+"\n a-"+messagerRecu[2]+"\n b-"+messagerRecu[3];
                                        jTextArea1.setText(current_question);
                                        jTextField1.setText("");
                                        System.out.println("a-"+messagerRecu[2]);
                                        System.out.println("b-"+messagerRecu[3]);
                                    break;
                                case "score":
                                    Current_Score=messagerRecu[1];
                                    System.out.println("your score :"+messagerRecu[1]);
                                    // display your score
                                    jTextField2.setText("your score is  "+Current_Score);
                                    break;}
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }

                }};
            timer.schedule(myTask, 0, 150);
        }
    }

    public static void setConnected(boolean connected) {
        if(connected==true)
           Client.connected = connected;
    }
    public static boolean connectServer() {

        try {

            socket = new Socket("localhost", 1842);
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
            return true;
        } catch (IOException ex) {
            System.out.println(ex);
            return false;
        }

    }
    public static String logout() {
        try {
            out.writeObject("/quit");
            return (String) in.readObject();
        } catch (IOException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } finally {
            setConnected(false);
        }

        return null;
    }

public static void BtnDeJxInVisible()
{
     jLabel1.setVisible(false);
     jLabel2.setVisible(false);
     jLabel3.setVisible(false);
     jLabel4.setVisible(false);
    jTextArea1.setVisible(false);
    jScrollPane1.setVisible(false);
    jTextField1.setVisible(false);
    jTextField2.setVisible(false);
    jButton2.setVisible(false);
    jButton3.setVisible(false);
}

    public static void BtnDeJxVisible()
    {
        jLabel1.setVisible(true);
        jLabel2.setVisible(true);
        jLabel3.setVisible(true);
        jLabel4.setVisible(true);
        jTextArea1.setVisible(true);
        jScrollPane1.setVisible(true);
        jTextField1.setVisible(true);
        jTextField2.setVisible(true);
        jButton2.setVisible(true);
        jButton3.setVisible(true);
        jTextField4.setVisible(false);
        jTextField3.setVisible(false);
        jLabel6.setVisible(false);
        jLabel5.setVisible(false);
    }
}
