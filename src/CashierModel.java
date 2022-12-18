
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class CashierModel extends HomklinngernModel {
    //ของฝั่ง cashier
    List<List> orderList = new ArrayList<>();
    private String orderName;
    private String orderPrice;
    private int cash = 0;
    
    public void setCash(int cash){
        this.cash = cash;
    }
    
    // สำหรับ menu ในหน้า cashier
    public ArrayList<Menu> getMenuList(CashierView view) {
        //ดึง database ตาราง menu ใส่ array
        System.out.println("get menu : "+ getUsername());
        ArrayList<Menu> menuList = new ArrayList<Menu>();
        PreparedStatement ps;
        ResultSet rs;
//        String user = lview.getJtuser().getText();
        //ดึง ตาราง menu
        String query = "SELECT * FROM `menu` WHERE `username_menu` =? AND `category_menu` =?";
        try {
            String cat = String.valueOf(view.getJcbmenu().getSelectedItem());
            ps = getConnection().prepareStatement(query);
            ps.setString(1, getUsername());
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
    
    public void showComboCashier(CashierView view){
        //ส่วน combobox
            PreparedStatement ps;
            ResultSet rs;
            String query = "SELECT * FROM `category` WHERE `username_cate` =?";
            //ดึง ตาราง category
            try {
                ps = getConnection().prepareStatement(query);
                ps.setString(1, getUsername());
                rs = ps.executeQuery();
                view.getJcbmenu().removeAllItems();
                while (rs.next()) {
                    String cate = rs.getString("category_cate"); //ดึง cloumn category_cate
                    view.getJcbmenu().addItem(cate);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
    }
    
    public void showMenuCashier(CashierView view) {
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
        showOrderCashier(view);
    }
    
    public void clearOrderList(CashierView view){
        orderList = new ArrayList<>();
        cash = 0;
        showOrderCashier(view);
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
                showOrderCashier(view);
                break;
            }
        }
    }
    
    
    // แสดงตารางตามข้อมูลใน list
    public void showOrderCashier(CashierView view) {
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
            showBillCashier(view);
        }
    }
    
    public void showBillCashier(CashierView view) {
        int totalPrice = 0;
        String textBill = "";
        textBill += ("-----------------------------------------------------------------------\n"
               + "\t" + "HOM  - KLIN - NGERN \n"
               + "\t" + "   " + "1234 Main Street\n" 
               + "\t" + "         " + "Suite 567\n" 
               + "\t" + "City Name, State 64321\n" 
               + "\t" + "       " + "023-334-2345\n"
               + "-----------------------------------------------------------------------\n\n");
        
        for(List innerlist : orderList){
            // ปริ้นแต่ละออเด้อ
            String name = innerlist.get(0).toString();
            int price = Integer.parseInt(innerlist.get(1).toString());
            int qty = Integer.parseInt(innerlist.get(2).toString());
            int price2 = price*qty;
            
            totalPrice += price2;
            textBill += " x "+ qty + "  " +name+"\t"+price2+"฿\n\n";
        }
        textBill += "-----------------------------------------------------------------------\n";
        textBill += "-----------------------------------------------------------------------\n";
        textBill += "\n TOTAL\t"+totalPrice;
        textBill += "\n CASH\t"+cash;
        if (cash == 0){
            textBill += "\n CHANGE\t 0" + "\n";
        }
        else if(cash > totalPrice){
            textBill += "\n CHANGE\t "+(cash-totalPrice);
        }
        textBill += "\n-----------------------------------------------------------------------\n";
        textBill += "----------------------THANK YOU------------------------------";
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
    
}
