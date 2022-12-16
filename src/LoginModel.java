
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LoginModel extends HomklinngernModel{
    public void login(LoginView view,HomeView hview ,HomklinngernModel model){
        PreparedStatement ps;
            ResultSet rs;
            String uname = view.getJtuser().getText();
            String pass = String.valueOf(view.getJpass().getPassword());
            String query = "SELECT * FROM `member` WHERE `Username` =? AND `Password` =?";
            try {
                ps = getConnection().prepareStatement(query);
                ps.setString(1, uname);
                ps.setString(2, pass);
                rs = ps.executeQuery();
                if (rs.next()) {
                    //เก็บ username แลพ shopName ปัจจุบัน ให้ model
                    model.setUsername(uname);
                    model.setShopName(rs.getString("ShopName"));
                    hview.getJf().setVisible(true);
                    view.getJf().dispose();
                    } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Username or Password", "Login Failed", 2);
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    //ฟังก์ชัน savefile
    public static void savefile(Serializable data, String fileName) throws Exception {
        try(ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)))) { //Paths.get(fileName))) การสร้าง path ไฟล์ใน Java
            oos.writeObject(data);
        }
     }
    //ฟังก์ชัน loadfile
    public static Object loadfile(String fileName) throws Exception {
        try(ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) {
            return ois.readObject();
        }
    }
}

//            //เงื่อนไข savefile
//            selected = loginview.getJcheckb().isSelected(); //selected ใช้ตรวจสอบ Jcheckb ว่ามีการเลือกมั้ย
//            login.username = loginview.getJtuser().getText(); //ให้ login.username เก็บค่า .....
//            login.password = String.valueOf(loginview.getJpass().getPassword());  //ให้ login.password เก็บค่า .....
//            if (selected) { //true -> มันจะเข้าเงื่อนไข ต้องติ้กที่  Jcheckbox ก่อน
//                try {
//                    loginmodel.savefile(login, "saveflie"); //เรียกใช้ฟังก์ชั่น savefile ใน loginmodel ให้มัน save ชื่อ savefile
//                    System.out.println("save file");
//                } catch (Exception en) {
//                    System.out.println("Couldn't save " + en.getMessage());
//                }

//            //เงื่อนไข loadfile
//  try {
//                    login = (Login) loginmodel.loadfile("saveflie"); //เรียกใช่ฟังก์ชัน loadfile ใน loginmodel เพื่อให้ทำการโหลดไฟล์ที่ชื่อ saveflie
//                    loginview.getJtuser().setText(login.username); //ให้ settext ใน username เป็น login.username (มันอยู่ใน savefile)
//                    loginview.getJpass().setText(login.password);
//                    System.out.println("load file");
//                } catch (Exception en) {
//                    System.out.println("Couldn't load " + en.getMessage());
//                }