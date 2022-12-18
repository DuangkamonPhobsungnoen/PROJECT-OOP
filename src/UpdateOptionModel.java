
import java.sql.*;
import javax.swing.JOptionPane;


public class UpdateOptionModel extends OptionModel {
    
    public void updateCat(UpdateOptionView view){
        String newCat = view.getJtcat().getText();
        if(newCat.trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Name must not be empty");
        }
        else{
            String query = "";
            int id = 0;
            //ต้องเปลี่ยน cat ในตาราง menu ก่อน
            PreparedStatement ps;
            ResultSet rs;
            //ดึง ตาราง menu
            query = "SELECT * FROM `menu` WHERE `username_menu` =? AND `category_menu` =?";
            try {
                ps = getConnection().prepareStatement(query);
                ps.setString(1, getUsername());
                ps.setString(2, getSelectCat());
                System.out.println("ps "+ps);
                rs = ps.executeQuery();
                while (rs.next()) {
                    id = rs.getInt("ID");
                    query = "UPDATE `menu` SET `category_menu`='"+newCat+"' WHERE `ID`="+id;
                    System.out.println("query "+query);
                    Statement st = getConnection().createStatement();
                    st.executeUpdate(query);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            // เปลี่ยนในตาราง category
            id = getIDCat();
            query = "UPDATE `category` SET `category_cate`='"+newCat+"' WHERE `ID`="+id;
            executeSQLQuery(query, "Updated");
        }
        
    }
    
}
