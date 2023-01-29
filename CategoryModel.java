
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class CategoryModel extends HomklinngernModel {
    
    //ของฝั่ง category
    private String selectName;
    private int selectPrice;
    private String selectCat;
    private int idMenu = 0;

    public String getSelectCat() {
        return selectCat;
    }

    public void setSelectCat(String selectCat) {
        this.selectCat = selectCat;
    }
    
    // สำหรับดึง menu จาก database
    public ArrayList<Menu> getMenuList(CategoryView view) {
        //เก็บข้อมูลเป็น ArrayList
        ArrayList<Menu> menuList = new ArrayList<Menu>();
        PreparedStatement ps;
        ResultSet rs;
        //ดึง ตาราง menu
        String query = "SELECT * FROM `menu` WHERE `username_menu` =? AND `category_menu` =?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, getUsername());
            ps.setString(2, selectCat);
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
    
    public void showMenuCat(CategoryView view) {
        // ดึงจาก array มาแสดง
        selectCat = String.valueOf(view.getCb().getSelectedItem());
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
    
    public void showCatCat(CategoryView view){
        //ส่วน combobox
            PreparedStatement ps;
            ResultSet rs;
            String query = "SELECT * FROM `category` WHERE `username_cate` =?";
            //ดึง ตารางตาม category มาใส่ combo
            try {
                ps = getConnection().prepareStatement(query);
                ps.setString(1, getUsername());
                rs = ps.executeQuery();
                view.getCb().removeAllItems(); // เคลียก่อนเผื่ออัพเดต
                while (rs.next()) {
                    String cate = rs.getString("category_cate"); //ดึง cloumn category_cate
                    view.getCb().addItem(cate);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            selectCat = String.valueOf(view.getCb().getSelectedItem());
            showMenuCat(view);
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
                    ps.setString(1, getUsername());
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
    
    
    public int getIDCat(){
        // หา ID ใน database
                int id = 0;
                PreparedStatement ps;
                ResultSet rs;
                String query = "SELECT * FROM `category` WHERE `username_cate` =? AND `category_cate` =?";
                try {
                    ps = getConnection().prepareStatement(query);
                    ps.setString(1, getUsername());
                    ps.setString(2, selectCat);
                    System.out.println(ps);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        id = rs.getInt("ID");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                return id;
    }
    
    // Execute SQL Query for add update delete Menu
    public void executeSQLQuery(String query, String Message, CategoryView view) {
        try {
            Statement st = getConnection().createStatement();
            if (st.executeUpdate(query) != 0) {
                //refresh JTable
                 showMenuCat(view);
                JOptionPane.showMessageDialog(null, "Data " + Message + " Success");
            } else {
                JOptionPane.showMessageDialog(null, "Data not " + Message);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data not " + e);
        }
    }
    
    public void addMenu(CategoryView view) {
        if(checkedInput(view)){
            String newName = view.getJtname().getText();
            int newPrice =  Integer.parseInt(view.getJtprice().getText());
            int lastID = lastID("menu")+1;
            selectCat = String.valueOf(view.getCb().getSelectedItem());
            String query = "INSERT INTO `menu`(`username_menu`, `category_menu`, `name`, `price`, `ID`) "
                    + "VALUES ('"+getUsername()+"', '"+selectCat+"', '"+newName+"', '"+newPrice+"', '"+lastID+"')";
            executeSQLQuery(query, "Added", view);
        }
    }

    public void updateMenu(CategoryView view) {
        if(checkedInput(view)){
            String newName = view.getJtname().getText();
            int newPrice =  Integer.parseInt(view.getJtprice().getText());
            String query = "UPDATE `menu` SET `name`='"+newName+"',`price`='"+newPrice+"' WHERE `ID`="+idMenu;
            executeSQLQuery(query, "Updated", view);
        }
    }

    public void deleteMenu(CategoryView view) {
        String name = view.getJtname().getText();
        if(name.equals("")){
            JOptionPane.showMessageDialog(null, "Please select menu.");
        }
        else{
            String query = "DELETE FROM `menu` WHERE id ="+idMenu;
            executeSQLQuery(query, "Deleted", view);
        }
    }
    
    public boolean checkedInput(CategoryView view){
        String inputName = view.getJtname().getText();
        String inputPrice = view.getJtprice().getText();
        if(inputName.trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Name must not be empty.");
            return false;
        }
        else if(true){
            try{
                Integer.parseInt(inputPrice);
                return true;
            } 
            catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Price must be integer.");
                return false;
            }
        }
        else{
            return true;
        }
    }
    
    
    public int lastID(String table){
        // หาไอดีสุดท้ายในตารางนั้นๆ
        PreparedStatement ps;
        ResultSet rs;
        int lastID = 0;
        String query = "SELECT * FROM `"+table+"`";
        try {
            ps = getConnection().prepareStatement(query);
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
    
    
    
}
