
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class HomklinngernController implements ActionListener {

    private LoginView loginview;
    private SignupView signupview;
    private HomeView homeview;
    private MenuView menuview;
    private boolean selected;

    public HomklinngernController() {
        loginview = new LoginView();
        signupview = new SignupView();
        homeview = new HomeView();
        menuview = new MenuView();

        homeview.getJbcashier().addActionListener(this);
        homeview.getJbmenu().addActionListener(this);
        homeview.getJbback().addActionListener(this);
        menuview.getJbback().addActionListener(this);
        loginview.getJbsign().addActionListener(this);
        loginview.getJblogin().addActionListener(this);
        loginview.getJcheckb().addActionListener(this);
        signupview.getJbb().addActionListener(this);
        signupview.getJbregis().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == (loginview.getJbsign())) {
            signupview.getJf().setVisible(true);
            loginview.getJf().dispose();
        } else if (e.getSource() == (signupview.getJbb())) {
            loginview.getJf().setVisible(true);
            signupview.getJf().dispose();
            signupview.getJtname().setText("");
            signupview.getJtuser().setText("");
            signupview.getJpass().setText("");
            signupview.getJcpass().setText("");
        } else if (e.getSource() == (signupview.getJbregis())) {
            String name = signupview.getJtname().getText();
            String username = signupview.getJtuser().getText();
            String password = String.valueOf(signupview.getJpass().getPassword());
            String confirm = String.valueOf(signupview.getJcpass().getPassword());
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
                    if (ps.executeUpdate() > 0) {
                        JOptionPane.showMessageDialog(null, "New User Add");
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(SignupView.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource() == (loginview.getJblogin())) {
            PreparedStatement ps;
            ResultSet rs;
            String uname = loginview.getJtuser().getText();
            String pass = String.valueOf(loginview.getJpass().getPassword());
            String query = "SELECT * FROM `member` WHERE `Member_Username` =? AND `Member_Password` =?";
            try {
                ps = MyConnection.getConnection().prepareStatement(query);
                ps.setString(1, uname);
                ps.setString(2, pass);
                rs = ps.executeQuery();
                if (rs.next()) {
                    homeview.getJf().setVisible(true);
                    loginview.getJf().dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Username or Password", "Login Failed", 2);
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource().equals(homeview.getJbcashier())) {
            menuview.getJf().setVisible(true);
            homeview.getJf().dispose();
        } else if (e.getSource().equals(menuview.getJbback())) {
            homeview.getJf().setVisible(true);
            menuview.getJf().dispose();
        } else if (e.getSource().equals(homeview.getJbback())) {
            selected = loginview.getJcheckb().isSelected(); //isSelected ใช้ตรวจสอบ loginview.getJcheckb() ว่าถูกเลือกอยู่หรือไม่ (ถ้าถูกเลือก => true)
//            System.out.println(selected); //test true, false
            if (selected) { //true
                loginview.getJf().setVisible(true);
                homeview.getJf().dispose();
                System.out.println("Save password");
            } else { //false
                loginview.getJf().setVisible(true);
                homeview.getJf().dispose();
                loginview.getJtuser().setText("");
                loginview.getJpass().setText("");

            }
        }
    }

    public static void main(String[] args) {
        new HomklinngernController();
    }
}
