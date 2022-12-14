
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class HomklinngernModel {
    private String username;
    private String shopName;
    
    //ของฝั่ง category
    private String selectName;
    private int selectPrice;
    private String selectCat;
    private int idMenu = 0;
    private int lastID = 0;
    
    //ของฝั่ง cashier
    List<List> orderList = new ArrayList<>();
    private String orderName;
    private String orderPrice;
    private int cash = 0;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    // create a function to connect with mysql database
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:4306/hom_klin_ngern", "root", "");
            System.out.println("Connect");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return con;
    }
    
    // สำหรับ menu ในหน้า cashier
    public ArrayList<Menu> getMenuList(CashierView view) {
        //ดึง database ตาราง menu ใส่ array
        ArrayList<Menu> menuList = new ArrayList<Menu>();
        PreparedStatement ps;
        ResultSet rs;
        //ดึง ตาราง menu
        String query = "SELECT * FROM `menu` WHERE `username_menu` =? AND `category_menu` =?";
        try {
            String cat = String.valueOf(view.getJcbmenu().getSelectedItem());
            ps = getConnection().prepareStatement(query);
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
    
    public void Show_Menu_Cashier(CashierView view) {
        // ดึงจาก array มาแสดง
        ArrayList<Menu> list = getMenuList(view);
        DefaultTableModel model = (DefaultTableModel) view.getJtmenu().getModel();
        model.setRowCount(0); //ถ้าไม่มีบรรทัดนี้ เมนูจะเพิ่มต่อกันเรื่อยๆ
        Object[] row = new Object[2];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getName();
            row[1] = list.get(i).getPrice();
            model.addRow(row);
        }
    }
    
    // สำหรับตารางอาหารที่เลือก  เก็บเป็น list ซ้อน list
    public void addOrderList(CashierView view) {
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
        Show_Order_Cashier(view);
    }
    
    public void clearOrderList(CashierView view){
        orderList = new ArrayList<>();
        Show_Order_Cashier(view);
    }
    
    public void deleteOrderList(CashierView view){
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
                Show_Order_Cashier(view);
                break;
            }
        }
    }
    
    public void setCash(int cash){
        this.cash = cash;
        
    }
    
    // แสดงตารางตามข้อมูลใน list
    public void Show_Order_Cashier(CashierView view) {
        // ดึงจาก array มาแสดง
        if(orderName != null){ //ต้องกดเลือกก่อน
            DefaultTableModel model = (DefaultTableModel) view.getJtorder().getModel();
            model.setRowCount(0);
            Object[] row = new Object[3];		
            for(List innerlist : orderList){
                row[0] = innerlist.get(0);
                row[1] = innerlist.get(1);
                row[2] = innerlist.get(2);
                model.addRow(row);
            }
            // อัพเดตบิล
            Show_Bill_Cashier(view);
        }
    }
    
    public void Show_Bill_Cashier(CashierView view) {
        int totalPrice = 0;
        String textBill = "";
        textBill += ("-------------------------------------\n"
               + "\t" + "HOM  - GIN - GRUEN \n"
               + "\t" + "   " + "1234 Main Street\n" 
               + "\t" + "         " + "Suite 567\n" 
               + "\t" + "City Name, State 64321\n" 
               + "\t" + "       " + "023-334-2345\n"
               + "-------------------------------------\n\n");
        
        for(List innerlist : orderList){
            // ปริ้นแต่ละออเด้อ
            String name = innerlist.get(0).toString();
            int price = Integer.parseInt(innerlist.get(1).toString());
            int qty = Integer.parseInt(innerlist.get(2).toString());
            int price2 = price*qty;
            
            totalPrice += price2;
            textBill += " x "+ qty + "\t"+name+"\t"+price2+"฿\n\n";
        }
        textBill += "-------------------------------------\n";
        textBill += "-------------------------------------\n";
        textBill += "\n TOTAL\t"+totalPrice;
        textBill += "\n CASH\t"+cash;
        textBill += "\n CHANGE "+(cash-totalPrice)+"\n";
        textBill += "-------------------------------------\n";
        textBill += "--------------THANK YOU--------------";
        view.getJtabill().setText(textBill);
    }
    
    public void setClick(CashierView view){
        // เก็บเมนูส่วนที่คลิก table menu
        view.getJtmenu().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int i = view.getJtmenu().getSelectedRow();
                TableModel model = view.getJtmenu().getModel();
                orderName = model.getValueAt(i, 0).toString();
                orderPrice = model.getValueAt(i, 1).toString();
            }
        });
        
        // เก็บเมนูส่วนที่คลิก table order
        view.getJtorder().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int i = view.getJtorder().getSelectedRow();
                TableModel model = view.getJtorder().getModel();
                orderName = model.getValueAt(i, 0).toString();
                orderPrice = model.getValueAt(i, 1).toString();
            }
        });
    }
    
    
    // สำหรับ menu ในหน้า category
    public ArrayList<Menu> getMenuList(CategoryView view) {
        //ดึง database ตาราง menu ใส่ array
        ArrayList<Menu> menuList = new ArrayList<Menu>();
        PreparedStatement ps;
        ResultSet rs;
        //ดึง ตาราง menu
        String query = "SELECT * FROM `menu` WHERE `username_menu` =? AND `category_menu` =?";
        try {
            String cat = String.valueOf(view.getCb().getSelectedItem());
            ps = getConnection().prepareStatement(query);
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

    public void Show_Menu_Cat(CategoryView view) {
        // ดึงจาก array มาแสดง
        ArrayList<Menu> list = getMenuList(view);
        DefaultTableModel model = (DefaultTableModel)view.getTable().getModel();
        model.setRowCount(0); //ถ้าไม่มีบรรทัดนี้ เมนูจะเพิ่มต่อกันเรื่อยๆ
        Object[] row = new Object[2];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getName();
            row[1] = list.get(i).getPrice();
            model.addRow(row);
        }
    }

    public void setClick(CategoryView view) {
        // เก็บเมนูส่วนที่คลิก table menu
        view.getTable().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int i = view.getTable().getSelectedRow();
                TableModel model = view.getTable().getModel();
                view.getJtname().setText(model.getValueAt(i, 0).toString());
                view.getJtprice().setText(model.getValueAt(i, 1).toString());

                //เอาค่าจาก textField ปัจจุบัน
                selectName = view.getJtname().getText();
                selectPrice = Integer.parseInt(view.getJtprice().getText());
                selectCat = String.valueOf(view.getCb().getSelectedItem());
                String p = selectPrice+"";
                // หา ID ใน database

                PreparedStatement ps;
                ResultSet rs;
                String query = "SELECT * FROM `menu` WHERE `username_menu` =? AND `category_menu` =? AND `name` =? AND `price` =?";
                try {
                    ps = getConnection().prepareStatement(query);
                    ps.setString(1, username);
                    ps.setString(2, selectCat);
                    ps.setString(3, selectName);
                    ps.setString(4,p );
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        idMenu = rs.getInt("ID");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // Execute SQL Query for add update delete
    public void executeSQLQuery(String query, String Message, CategoryView view) {
        try {
            Statement st = getConnection().createStatement();
            if (st.executeUpdate(query) != 0) {
                //refresh JTable
                 Show_Menu_Cat(view);
                JOptionPane.showMessageDialog(null, "Data " + Message + " Success");
            } else {
                JOptionPane.showMessageDialog(null, "Data not " + Message);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data not " + e);
        }
    }

    public int lastID(){
        ArrayList<Menu> menuList = new ArrayList<Menu>();
        PreparedStatement ps;
        ResultSet rs;
        String query = "SELECT * FROM `menu` WHERE `username_menu` =?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                int thisID = rs.getInt("ID");
                if (thisID > lastID){
                    lastID = thisID;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lastID;
    }
    
    public void addMenu(CategoryView view) {
        String newName = view.getJtname().getText();
        int newPrice =  Integer.parseInt(view.getJtprice().getText());
        int lastID = lastID()+1;
        selectCat = String.valueOf(view.getCb().getSelectedItem());
        String query = "INSERT INTO `menu`(`username_menu`, `category_menu`, `name`, `price`, `ID`) "
                + "VALUES ('"+username+"', '"+selectCat+"', '"+newName+"', '"+newPrice+"', '"+lastID+"')";
        executeSQLQuery(query, "Added", view);
    }

    public void updateMenu(CategoryView view) {
        String newName = view.getJtname().getText();
        int newPrice =  Integer.parseInt(view.getJtprice().getText());
        String query = "UPDATE `menu` SET `name`='"+newName+"',`price`='"+newPrice+"' WHERE `ID`="+idMenu;
        executeSQLQuery(query, "Updated", view);
    }

    public void deleteMenu(CategoryView view) {
        String query = "DELETE FROM `menu` WHERE id ="+idMenu;
        executeSQLQuery(query, "Deleted", view);
    }
    
}
