
import java.awt.Color;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class HomklinngernController implements ActionListener, MouseListener{
    //view
    private LoginView loginview;
    private SignupView signupview;
    private HomeView homeview;
    private CashierView cashierview;
    private CategoryView categoryview;
    private OptionView optionview;
    private NewOptionView newopview;
    private UpdateOptionView updateopview;
    private DeleteOptionView deleteopview;
    private UserView userview;
    //model
    private HomklinngernModel model;
    private LoginModel loginmodel;
    private SignupModel signupmodel;
    private CashierModel cashiermodel;
    private CategoryModel categorymodel;
    private OptionModel optionmodel;
    private NewOptionModel newopmodel;
    private UpdateOptionModel updateopmodel;
    private DeleteOptionModel deleteopmodel;
    private UserModel usermodel;
    private HomeModel homemodel;
    
    private Login login;
    private boolean selected;
    
    

    public HomklinngernController() {
        loginview = new LoginView();
        signupview = new SignupView();
        homeview = new HomeView();
        cashierview = new CashierView();
        categoryview = new CategoryView();
        optionview = new OptionView();
        newopview = new NewOptionView();
        deleteopview = new DeleteOptionView();
        updateopview = new UpdateOptionView();
        userview = new UserView();
        
        model = new HomklinngernModel();
        loginmodel = new LoginModel();
        signupmodel = new SignupModel();
        cashiermodel = new CashierModel();
        categorymodel = new CategoryModel();
        optionmodel = new OptionModel();
        newopmodel = new NewOptionModel();
        updateopmodel = new UpdateOptionModel();
        deleteopmodel = new DeleteOptionModel();
        usermodel = new UserModel();
        homemodel = new HomeModel();
        
        login = new Login();
        
        homeview.getJbcashier().addActionListener(this);
        homeview.getJbmenu().addActionListener(this);
        homeview.getJbback().addActionListener(this);
        
        cashierview.getJbback().addActionListener(this);
        cashierview.getJbmenu().addActionListener(this);
        cashierview.getJbadd().addActionListener(this);
        cashierview.getJbclear().addActionListener(this);
        cashierview.getJbdelete().addActionListener(this);
        cashierview.getJbbill().addActionListener(this);
        cashierview.getJbprint().addActionListener(this);
        
        categoryview.getJbback().addActionListener(this);
        categoryview.getJbmenu().addActionListener(this);
        categoryview.getJbup().addActionListener(this);
        categoryview.getJbdel().addActionListener(this);
        categoryview.getJbadd().addActionListener(this);
        categoryview.getJbdot().addActionListener(this);
        //small frame of category
        optionview.getJbnew().addActionListener(this);
        optionview.getJbup().addActionListener(this);
        optionview.getJbdel().addActionListener(this);
        
        newopview.getJbok().addActionListener(this);
        updateopview.getJbok().addActionListener(this);
        deleteopview.getJbyes().addActionListener(this);
        deleteopview.getJbno().addActionListener(this);
        
        loginview.getJbsign().addActionListener(this);
        loginview.getJblogin().addActionListener(this);
        loginview.getJcheckb().addActionListener(this);
        loginview.getJtuser().addActionListener(this);
        loginview.getJpass().addActionListener(this);
        loginview.getJtuser().addMouseListener(this); //จำรหัสผ่าน
        
        signupview.getJbb().addActionListener(this);
        signupview.getJbregis().addActionListener(this);
    }
    
    public static void main(String[] args) {
        new HomklinngernController();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // กดปุ่ม sign up ใน login
        if (e.getSource() == (loginview.getJbsign())) {
            loginmodel.ButtonColorSignup(loginview); 
            signupview.getJf().setVisible(true);
            loginview.getJf().dispose();
            
            // กดปุ่ม back ใน sign up
        } else if (e.getSource() == (signupview.getJbb())) {
            loginview.getJf().setVisible(true);
            signupmodel.backSignup(signupview);

            // กดปุ่ม register ใน sign up
        } else if (e.getSource() == (signupview.getJbregis())) {
            signupmodel.register(signupview);
            
        // กดปุ่ม login ใน login
        } else if (e.getSource() == (loginview.getJblogin())) {
            //เปลี่ยนสีปุ่มตอนเม้าท์ไปโดน
            homemodel.MouseEnteredCashier(homeview);
            homemodel.MouseExitedCashier(homeview);
            homemodel.MouseEnteredMenu(homeview);
            homemodel.MouseExitedMenu(homeview);
            //เปลี่ยนสีปุ่ม
            loginmodel.ButtonColorLogin(loginview); 
            loginmodel.login(loginview, homeview, model);
            // ทุก model จำ user
            String uname = model.getUsername();
            categorymodel.setUsername(uname);
            cashiermodel.setUsername(uname);
            newopmodel.setUsername(uname);
            deleteopmodel.setUsername(uname);
            updateopmodel.setUsername(uname);
            //ตั้งให้ขึ้นชื่อร้าน
            homeview.getJlhname().setText(model.getShopName());
            cashierview.getJlhtext().setText(model.getShopName());
            categoryview.getJltext().setText(model.getShopName());
            userview.getJlhtext().setText(model.getShopName());
              //เงื่อนไข savefile
            selected = loginview.getJcheckb().isSelected(); //selected ใช้ตรวจสอบ Jcheckb ว่ามีการเลือกมั้ย
            login.username = loginview.getJtuser().getText(); //ให้ login.username เก็บค่า .....
            login.password = String.valueOf(loginview.getJpass().getPassword());  //ให้ login.password เก็บค่า .....
            if (selected && (login.username.equals(uname))) { //true -> มันจะเข้าเงื่อนไข ต้องติ้กที่  Jcheckbox ก่อน
                try {
                    loginmodel.savefile(login, "saveflie"); //เรียกใช้ฟังก์ชั่น savefile ใน loginmodel ให้มัน save ชื่อ savefile
                    System.out.println(login.username);
                    System.out.println("save file");
                } catch (Exception en) {
                    System.out.println("Couldn't save " + en.getMessage());
                }
            }
        }
        // ปุ่ม cashier ใน home
        if (e.getSource().equals(homeview.getJbcashier())) {
            //สร้างข้อมูลหน้า cashier
            cashiermodel.showComboCashier(cashierview);
            cashiermodel.clearOrderList(cashierview); // ล้างของเก่า
            cashiermodel.showMenuCashier(cashierview);
            cashiermodel.setClick(cashierview);
            
            String bill = cashierview.getJtabill().getText();
            usermodel.showBill(userview, bill);
            
            cashierview.getJf().setVisible(true);
            userview.getJf().setVisible(true);
            homeview.getJf().dispose();
        } // ปุ่ม get menu ใน chasier / สร้างตารางตาม category ที่เลือก
        else if (e.getSource().equals(cashierview.getJbmenu())) {
            cashiermodel.showMenuCashier(cashierview); // รันใหม่ตาม cat ใหม่
        } // ปุ่ม add ใน cashier
        else if (e.getSource().equals(cashierview.getJbadd())) {
            cashiermodel.addOrderList(cashierview);
            
            String bill = cashierview.getJtabill().getText();
            usermodel.showBill(userview, bill);
        } // ปุ่ม clear ใน cashier
        else if (e.getSource().equals(cashierview.getJbclear())) {
            cashiermodel.clearOrderList(cashierview);
            
            String bill = cashierview.getJtabill().getText();
            usermodel.showBill(userview, bill);
        } // ปุ่ม pay ใน cashier
        else if (e.getSource().equals(cashierview.getJbbill())) {
            cashiermodel.setCash(Integer.parseInt(cashierview.getJtfpay().getText()));
            cashiermodel.showBillCashier(cashierview);
            
            String bill = cashierview.getJtabill().getText();
            usermodel.showBill(userview, bill);
        } // ปุ่ม delete ใน cashier
        else if (e.getSource().equals(cashierview.getJbdelete())) {
            cashiermodel.deleteOrderList(cashierview);
            
            String bill = cashierview.getJtabill().getText();
            usermodel.showBill(userview, bill);
        } // ปุ่ม menu ใน home
        else if (e.getSource().equals(homeview.getJbmenu())) {
            categorymodel.showCatCat(categoryview);
            categorymodel.setClick(categoryview); //กดแล้วขึ้นที่ textField

            categoryview.getJf().setVisible(true);
            homeview.getJf().dispose();
        } // ปุ่ม get menu ใน category / สร้างตารางตาม category ที่เลือก
        else if (e.getSource().equals(categoryview.getJbmenu())) {
            categorymodel.showMenuCat(categoryview); // รันใหม่ตาม cat ใหม่
        } // ปุ่ม add ใน category
        else if (e.getSource().equals(categoryview.getJbadd())) {
            categorymodel.addMenu(categoryview);
            categoryview.getJtname().setText("");
            categoryview.getJtprice().setText("");
        } // ปุ่ม update ใน category
        else if (e.getSource().equals(categoryview.getJbup())) {
            categorymodel.updateMenu(categoryview);
            categoryview.getJtname().setText("");
            categoryview.getJtprice().setText("");
        } // ปุ่ม delete ใน category
        else if (e.getSource().equals(categoryview.getJbdel())) {
            categorymodel.deleteMenu(categoryview);
            categoryview.getJtname().setText("");
            categoryview.getJtprice().setText("");
        } 
        //Option of catagory
        
        //btn ... in catagory
        else if (e.getSource().equals(categoryview.getJbdot())) {
            optionview.getJf().setVisible(true);
        } 

        //btn new in ...
        else if (e.getSource().equals(optionview.getJbnew())) {
            newopview.getJf().setVisible(true);
            optionview.getJf().dispose();
        } 
        
        //btn ok in new cat
        else if (e.getSource().equals(newopview.getJbok())) {
            newopmodel.addNewCat(newopview);
            categorymodel.showCatCat(categoryview);
            
            newopview.getJf().setVisible(false);
            optionview.getJf().dispose();
        } 

        //btn up in ...
        else if (e.getSource().equals(optionview.getJbup())) {
            updateopview.getJf().setVisible(true);
            optionview.getJf().dispose();
        } 
        
        //btn ok in update cat
        else if (e.getSource().equals(updateopview.getJbok())) {
            System.out.println("click ok in update");
            updateopmodel.updateCat(updateopview);
            categorymodel.showCatCat(categoryview);
            
            updateopview.getJf().setVisible(false);
            optionview.getJf().dispose();
        } 

        //btn delete in ...
        else if (e.getSource().equals(optionview.getJbdel())) {
            deleteopview.getJf().setVisible(true);
            optionview.getJf().dispose();
            
        } 
        //btn yes in delete catgory
        else if (e.getSource().equals(deleteopview.getJbyes())) {
            deleteopmodel.deleteCat(deleteopview);
            categorymodel.showCatCat(categoryview);
            
            deleteopview.getJf().setVisible(false);
            optionview.getJf().dispose();
            
        } 
        
        //btn no in delete catgory
        else if (e.getSource().equals(deleteopview.getJbno())) {
            deleteopview.getJf().setVisible(false);
            optionview.getJf().dispose();
            
        } 

        // ปุ่ม print bill
        else if (e.getSource().equals(cashierview.getJbprint())) {
            try {
                cashierview.getJtabill().print();
            } catch (PrinterException ex) {
                System.out.println(ex);
            }
        } // ปุ่ม back ใน cashier
        else if (e.getSource().equals(cashierview.getJbback())) {
            homeview.getJf().setVisible(true);
            cashierview.getJf().dispose();
            userview.getJf().dispose();
        } // ปุ่ม back ใน category
        else if (e.getSource().equals(categoryview.getJbback())) {
            homeview.getJf().setVisible(true);
            categoryview.getJf().dispose();
        } // ปุ่ม back ใน home
        else if (e.getSource()
                .equals(homeview.getJbback())) {
            loginmodel.ButtonColorBackHome(loginview); 
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
    
    @Override
    public void mouseClicked(MouseEvent e) {
                    //เงื่อนไข loadfile
            try {
                login = (Login) loginmodel.loadfile("saveflie"); //เรียกใช่ฟังก์ชัน loadfile ใน loginmodel เพื่อให้ทำการโหลดไฟล์ที่ชื่อ saveflie
                loginview.getJtuser().setText(login.username); //ให้ settext ใน username เป็น login.username (มันอยู่ใน savefile)
                loginview.getJpass().setText(login.password);
                System.out.println("load file");
            } catch (Exception en) {
                System.out.println("Couldn't load " + en.getMessage());
            }
    }
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}

