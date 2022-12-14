
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
    private boolean selected;
    private String username;
    private String shopName;
    
    List<List> orderList = new ArrayList<>();
    private String orderName;
    private String orderPrice;
    
    private int cash = 0;

    public HomklinngernController() {
        loginview = new LoginView();
        signupview = new SignupView();
        homeview = new HomeView();
        cashierview = new CashierView();
        categoryview = new CategoryView();

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
                    ps = MyConnection.getConnection().prepareStatement(query);
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
                ps = MyConnection.getConnection().prepareStatement(query);
                ps.setString(1, uname);
                ps.setString(2, pass);
                rs = ps.executeQuery();
                if (rs.next()) {
                    //เก็บ username แลพ shopName ปัจจุบัน
                    username = rs.getString("Username");
                    shopName = rs.getString("ShopName");
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
                ps = MyConnection.getConnection().prepareStatement(query);
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
            Show_Menu_Cashier(); // method อยู่ด้านล่าง
            
            
            
            // เก็บเมนูส่วนที่คลิก table menu
            cashierview.getJtmenu().addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    int i = cashierview.getJtmenu().getSelectedRow();
                    TableModel model = cashierview.getJtmenu().getModel();
                    orderName = model.getValueAt(i, 0).toString();
                    orderPrice = model.getValueAt(i, 1).toString();
                }
            });
                    
            // เก็บเมนูส่วนที่คลิก table order
            cashierview.getJtorder().addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    int i = cashierview.getJtorder().getSelectedRow();
                    TableModel model = cashierview.getJtorder().getModel();
                    orderName = model.getValueAt(i, 0).toString();
                    orderPrice = model.getValueAt(i, 1).toString();
                }
            } 
            
            
        );
            
        cashierview.getJf().setVisible(true);
        homeview.getJf().dispose();
    } 

    // ปุ่ม get menu ใน chasier / สร้างตารางตาม category ที่เลือก
    else if (e.getSource ().equals(cashierview.getJbmenu())) {
        Show_Menu_Cashier(); // รันใหม่ตาม cat ใหม่
    } 
    
    // ปุ่ม add ใน cashier
    else if (e.getSource ().equals(cashierview.getJbadd())) {
        addOrderList();
    } 
    
    // ปุ่ม clear ใน cashier
    else if (e.getSource ().equals(cashierview.getJbclear())) {
        // clear orderlist
        orderList = new ArrayList<>();
        // อัพเดตตาราง
        Show_Order_Cashier();
    } 
    
    // ปุ่ม pay ใน cashier
    else if (e.getSource ().equals(cashierview.getJbbill())) {
        cash = Integer.parseInt(cashierview.getJtfpay().getText());
        Show_Bill_Cashier();
    } 
    
    // ปุ่ม delete ใน cashier
    else if (e.getSource ().equals(cashierview.getJbdelete())) {
        // loop หา order นั้นมาลบ
        for(List innerlist : orderList){
            if(innerlist.get(0).toString().equals(orderName)){
                int num = (int)innerlist.get(2)-1; //ลดลง 1 ชิ้น
                if(num==0){// หมดแล้ว
                    boolean isRemoved = orderList.remove(innerlist);
                }
                else{// เปลี่ยนค่าจำนวน
                    innerlist.set(2,num);
                }
                // อัพเดตตาราง
                Show_Order_Cashier();
                break;
            }
        }
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

// สำหรับ menu ในหน้า cashier
public ArrayList<Menu> getMenuList() {
        //ดึง database ตาราง menu ใส่ array
        ArrayList<Menu> menuList = new ArrayList<Menu>();
        PreparedStatement ps;
        ResultSet rs;
        //ดึง ตาราง menu
        String query = "SELECT * FROM `menu` WHERE `username_menu` =? AND `category_menu` =?";
        try {
            String cat = String.valueOf(cashierview.getJcbmenu().getSelectedItem());
            ps = MyConnection.getConnection().prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, cat);
            rs = ps.executeQuery();
            Menu menu;
            while (rs.next()) {
                menu = new Menu(rs.getString("name"), rs.getInt("price"));
                menuList.add(menu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return menuList;
    }

    public void Show_Menu_Cashier() {
        // ดึงจาก array มาแสดง
        ArrayList<Menu> list = getMenuList();
        DefaultTableModel model = (DefaultTableModel) cashierview.getJtmenu().getModel();
        model.setRowCount(0); //ถ้าไม่มีบรรทัดนี้ เมนูจะเพิ่มต่อกันเรื่อยๆ
        Object[] row = new Object[2];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getName();
            row[1] = list.get(i).getPrice();
            model.addRow(row);
        }
    }

    // สำหรับตารางอาหารที่เลือก  เก็บเป็น list ซ้อน list
    public void addOrderList() {
        //ดึง database ตาราง menu ใส่ array
        ArrayList order = new ArrayList();
        boolean first = true;
        
        // loop หา order ซ้ำ เพิ่ม qty
        for(List innerlist : orderList){
            if(innerlist.get(0).toString().equals(orderName)){
                int num = (int)innerlist.get(2)+1;
                innerlist.set(2,num);
                first = false;
            }
        }
        
        if(first){
            order.add(orderName);
            order.add(orderPrice);
            order.add(1);
            orderList.add(order);
        }
        
        // อัพเดตดาตาราง
        Show_Order_Cashier();
    }

    // แสดงตารางตามข้อมูลใน list
    public void Show_Order_Cashier() {
        // ดึงจาก array มาแสดง
        if(orderName != null){ //ต้องกดเลือกก่อน
            DefaultTableModel model = (DefaultTableModel) cashierview.getJtorder().getModel();
            model.setRowCount(0);
            Object[] row = new Object[3];		
            for(List innerlist : orderList){
                row[0] = innerlist.get(0);
                row[1] = innerlist.get(1);
                row[2] = innerlist.get(2);
                model.addRow(row);
            }
            // อัพเดตบิล
            Show_Bill_Cashier();
        }
        
        
    }
    
    public void Show_Bill_Cashier() {
        int totalPrice = 0;
        String textBill = "";
        
        for(List innerlist : orderList){
            // ปริ้นแต่ละออเด้อ
            String name = innerlist.get(0).toString();
            int price = Integer.parseInt(innerlist.get(1).toString());
            int qty = Integer.parseInt(innerlist.get(2).toString());
            int price2 = price*qty;
            
            totalPrice += price2;
            textBill += "x "+ qty + "\t"+name+"\t"+price2+"฿\n";
        }
        
        textBill += "\n\n\nTOTAL\t"+totalPrice;
        textBill += "\nCASH\t"+cash;
        textBill += "\nCHANGE\t"+(cash-totalPrice);
        cashierview.getJtabill().setText(textBill);
    }


    public static void main(String[] args) {
        new HomklinngernController();
    }
}
