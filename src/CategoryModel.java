
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
    
    // สำหรับ menu ในหน้า category
    public ArrayList<Menu> getMenuList(CategoryView view) {
        //ดึง database ตาราง menu ใส่  array
        ArrayList<Menu> menuList = new ArrayList<Menu>();
        PreparedStatement ps;
        ResultSet rs;
        //ดึง ตาราง menu
        String query = "SELECT * FROM `menu` WHERE `username_menu` =? AND `category_menu` =?";
        try {
            String cat = String.valueOf(view.getCb().getSelectedItem());
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
        selectCat = String.valueOf(view.getCb().getSelectedItem());
        return menuList;
    }
    
    public void showMenuCat(CategoryView view) {
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
        String newName = view.getJtname().getText();
        int newPrice =  Integer.parseInt(view.getJtprice().getText());
        int lastID = lastID("menu","username_menu")+1;
        selectCat = String.valueOf(view.getCb().getSelectedItem());
        String query = "INSERT INTO `menu`(`username_menu`, `category_menu`, `name`, `price`, `ID`) "
                + "VALUES ('"+getUsername()+"', '"+selectCat+"', '"+newName+"', '"+newPrice+"', '"+lastID+"')";
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
