
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class SIGN_UP extends javax.swing.JFrame {

    public SIGN_UP() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg_data = new javax.swing.JPanel();
        text_name = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        Enter_Name = new javax.swing.JLabel();
        Enter_Username = new javax.swing.JLabel();
        text_username = new javax.swing.JTextField();
        Enter_Password = new javax.swing.JLabel();
        Confirm_Password = new javax.swing.JLabel();
        REGISTER = new javax.swing.JButton();
        text_password = new javax.swing.JPasswordField();
        text_confirm = new javax.swing.JPasswordField();
        Back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg_data.setBackground(new java.awt.Color(255, 204, 0));

        text_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_nameActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("TH SarabunPSK", 1, 40)); // NOI18N
        jLabel1.setText("SIGN UP");

        Enter_Name.setFont(new java.awt.Font("TH SarabunPSK", 1, 24)); // NOI18N
        Enter_Name.setText("Enter Name");

        Enter_Username.setFont(new java.awt.Font("TH SarabunPSK", 1, 24)); // NOI18N
        Enter_Username.setText("Enter Username");

        text_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_usernameActionPerformed(evt);
            }
        });

        Enter_Password.setFont(new java.awt.Font("TH SarabunPSK", 1, 24)); // NOI18N
        Enter_Password.setText("Enter Password");

        Confirm_Password.setFont(new java.awt.Font("TH SarabunPSK", 1, 24)); // NOI18N
        Confirm_Password.setText("Confirm Password");

        REGISTER.setFont(new java.awt.Font("TH SarabunPSK", 1, 18)); // NOI18N
        REGISTER.setText("REGISTER");
        REGISTER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                REGISTERActionPerformed(evt);
            }
        });

        text_password.setText("jPasswordField1");

        text_confirm.setText("jPasswordField1");

        Back.setFont(new java.awt.Font("TH SarabunPSK", 1, 18)); // NOI18N
        Back.setText("BACK");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bg_dataLayout = new javax.swing.GroupLayout(bg_data);
        bg_data.setLayout(bg_dataLayout);
        bg_dataLayout.setHorizontalGroup(
            bg_dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bg_dataLayout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(jLabel1)
                .addGap(118, 118, 118)
                .addGroup(bg_dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(text_username)
                    .addComponent(text_name, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(text_password)
                    .addComponent(text_confirm)
                    .addGroup(bg_dataLayout.createSequentialGroup()
                        .addGroup(bg_dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Enter_Password)
                            .addComponent(Confirm_Password)
                            .addComponent(Enter_Name)
                            .addComponent(Enter_Username)
                            .addGroup(bg_dataLayout.createSequentialGroup()
                                .addComponent(REGISTER, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(117, 117, 117))
        );
        bg_dataLayout.setVerticalGroup(
            bg_dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bg_dataLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(Enter_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(text_name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Enter_Username)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(text_username, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Enter_Password)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bg_dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bg_dataLayout.createSequentialGroup()
                        .addComponent(text_password, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Confirm_Password))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(text_confirm, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(bg_dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(REGISTER, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg_data, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg_data, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void REGISTERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_REGISTERActionPerformed
        String name = text_name.getText();
        String username = text_username.getText();
        String password = String.valueOf(text_password.getPassword());
        String confirm = String.valueOf(text_confirm.getPassword());
        int count = 0;

        if (name.equals("")) {
            JOptionPane.showMessageDialog(null, "Add a name");
            count += 1;
        } else if (username.equals("")) {
            JOptionPane.showMessageDialog(null, "Add a username");
            count += 1;
        } else if (password.equals("") | password.equals("jPasswordField1")) {
            JOptionPane.showMessageDialog(null, "Add a password");
            count += 1;
        } else if (!password.equals(confirm)) {
            JOptionPane.showMessageDialog(null, "Retype the password again");
            count += 1;
        }

        PreparedStatement ps;
        String query = "INSERT INTO `member`(`Member_Name`, `Member_Username`, `Member_Password`, `Member_Comfirm`) VALUES (?, ?, ?, ?)";
        try {
            if (count == 0) {
                ps = MyConnection.getConnection().prepareStatement(query);
                ps.setString(1, name);
                ps.setString(2, username);
                ps.setString(3, password);
                ps.setString(4, confirm);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SIGN_UP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_REGISTERActionPerformed

    private void text_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_usernameActionPerformed

    private void text_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_nameActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        LOGIN lg = new LOGIN();
        lg.setVisible(true);
        lg.pack();
        lg.setLocationRelativeTo(null);
        lg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_BackActionPerformed

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
            java.util.logging.Logger.getLogger(SIGN_UP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SIGN_UP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SIGN_UP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SIGN_UP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SIGN_UP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JLabel Confirm_Password;
    private javax.swing.JLabel Enter_Name;
    private javax.swing.JLabel Enter_Password;
    private javax.swing.JLabel Enter_Username;
    private javax.swing.JButton REGISTER;
    private javax.swing.JPanel bg_data;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField text_confirm;
    private javax.swing.JTextField text_name;
    private javax.swing.JPasswordField text_password;
    private javax.swing.JTextField text_username;
    // End of variables declaration//GEN-END:variables
}
