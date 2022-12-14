
import java.util.List;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class HomklinngernController implements ActionListener {

    private LoginView loginview;
    private SignupView signupview;
    private HomeView homeview;
    private CashierView cashierview;
    private CategoryView categoryview;
    private HomklinngernModel model;
    private boolean selected;
    private String username;
    private String shopName;

    public HomklinngernController() {
        loginview = new LoginView();
        signupview = new SignupView();
        homeview = new HomeView();
        cashierview = new CashierView();
        categoryview = new CategoryView();
        model = new HomklinngernModel();

        homeview.getJbcashier().addActionListener(this);
        homeview.getJbmenu().addActionListener(this);
        homeview.getJbback().addActionListener(this);
        cashierview.getJbback().addActionListener(this);
        cashierview.getJbmenu().addActionListener(this);
        cashierview.getJbadd().addActionListener(this);
        cashierview.getJbclear().addActionListener(this);
        cashierview.getJbdelete().addActionListener(this);
        cashierview.getJbbill().addActionListener(this);
        categoryview.getJbback().addActionListener(this);
        loginview.getJbsign().addActionListener(this);
        loginview.getJblogin().addActionListener(this);
        loginview.getJcheckb().addActionListener(this);
        signupview.getJbb().addActionListener(this);
        signupview.getJbregis().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // กดปุ่ม sign up ใน login
        if (e.getSource() == (loginview.getJbsign())) {
            signupview.getJf().setVisible(true);
            loginview.getJf().dispose();

            // กดปุ่ม back ใน sign up
        } else if (e.getSource() == (signupview.getJbb())) {
            loginview.getJf().setVisible(true);
            signupview.getJf().dispose();
            signupview.getJtname().setText("");
            signupview.getJtuser().setText("");
            signupview.getJpass().setText("");
            signupview.getJcpass().setText("");

            // กดปุ่ม register ใน sign up
        } else if (e.getSource() == (signupview.getJbregis())) {
            String name = signupview.getJtname().getText();
            String uname = signupview.getJtuser().getText();
            String password = String.valueOf(signupview.getJpass().getPassword());
            String confirm = String.valueOf(signupview.getJcpass().getPassword());
            int count = 0;
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Add a name");
                count += 1;
            } else if (uname.equals("")) {
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
            String query = "INSERT INTO `member`(`ShopName`, `Username`, `Password`, `Comfirm`) VALUES (?, ?, ?, ?)";
            try {
                if (count == 0) {
                    ps = HomklinngernModel.getConnection().prepareStatement(query);
                    ps.setString(1, name);
                    ps.setString(2, uname);
                    ps.setString(3, password);
                    ps.setString(4, confirm);
                    if (ps.executeUpdate() > 0) {
                        JOptionPane.showMessageDialog(null, "New User Add");
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(SignupView.class.getName()).log(Level.SEVERE, null, ex);
            }

            // กดปุ่ม login ใน login
        } else if (e.getSource() == (loginview.getJblogin())) {
            PreparedStatement ps;
            ResultSet rs;
            String uname = loginview.getJtuser().getText();
            String pass = String.valueOf(loginview.getJpass().getPassword());
            String query = "SELECT * FROM `member` WHERE `Username` =? AND `Password` =?";
            try {
                ps = HomklinngernModel.getConnection().prepareStatement(query);
                ps.setString(1, uname);
                ps.setString(2, pass);
                rs = ps.executeQuery();
                if (rs.next()) {
                    //เก็บ username แลพ shopName ปัจจุบัน
                    username = rs.getString("Username");
                    shopName = rs.getString("ShopName");
                    model.setUsername(username);
                    model.setShopName(shopName);
                    //ตั้งให้ขึ้นชื่อร้าน
                    homeview.getJlhname().setText(shopName);
                    cashierview.getJlhtext().setText(shopName);
                    categoryview.getJltext().setText(shopName);

                    homeview.getJf().setVisible(true);
                    loginview.getJf().dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Username or Password", "Login Failed", 2);
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        // ปุ่ม cashier ใน home
        if (e.getSource().equals(homeview.getJbcashier())) {
            //สร้างข้อมูลหน้า cashier

            //ส่วน combobox
            PreparedStatement ps;
            ResultSet rs;
            String query = "SELECT * FROM `category` WHERE `username_cate` =?";
            //ดึง ตาราง category
            try {
                ps = model.getConnection().prepareStatement(query);
                ps.setString(1, username);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String cate = rs.getString("category_cate"); //ดึง cloumn category_cate
                    cashierview.getJcbmenu().addItem(cate);
                }
            } catch (SQLException ex) {
                Logger.getLogger(HomklinngernController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //ส่วนตราง
            model.clearOrderList(cashierview); // ล้างของเก่า
            model.Show_Menu_Cashier(cashierview); 
            model.setClick(cashierview);
            
            
            cashierview.getJf().setVisible(true);
            homeview.getJf().dispose();
    } 

    // ปุ่ม get menu ใน chasier / สร้างตารางตาม category ที่เลือก
    else if (e.getSource ().equals(cashierview.getJbmenu())) {
        model.Show_Menu_Cashier(cashierview); // รันใหม่ตาม cat ใหม่
    } 
    
    // ปุ่ม add ใน cashier
    else if (e.getSource ().equals(cashierview.getJbadd())) {
        model.addOrderList(cashierview);
    } 
    
    // ปุ่ม clear ใน cashier
    else if (e.getSource ().equals(cashierview.getJbclear())) {
        model.clearOrderList(cashierview);
    } 
    
    // ปุ่ม pay ใน cashier
    else if (e.getSource ().equals(cashierview.getJbbill())) {
        model.setCash(Integer.parseInt(cashierview.getJtfpay().getText()));
        model.Show_Bill_Cashier(cashierview);
    } 
    
    // ปุ่ม delete ใน cashier
    else if (e.getSource ().equals(cashierview.getJbdelete())) {
        model.deleteOrderList(cashierview);
    } 

    // ปุ่ม menu ใน home
    else if (e.getSource ().equals(homeview.getJbmenu())) {
        categoryview.getJf().setVisible(true);
        homeview.getJf().dispose();
    } 

    // ปุ่ม back ใน cashier
    else if (e.getSource ().equals(cashierview.getJbback())) {
        homeview.getJf().setVisible(true);
        cashierview.getJf().dispose();
    } 

    // ปุ่ม back ใน category
    else if (e.getSource ().equals(categoryview.getJbback())) {
        homeview.getJf().setVisible(true);
        categoryview.getJf().dispose();
    } 

    // ปุ่ม back ใน home
    else if (e.getSource () 
        .equals(homeview.getJbback())) {
            selected = loginview.getJcheckb().isSelected();
        //isSelected ใช้ตรวจสอบ loginview.getJcheckb() ว่าถูกเลือกอยู่หรือไม่ (ถ้าถูกเลือก => true)
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
