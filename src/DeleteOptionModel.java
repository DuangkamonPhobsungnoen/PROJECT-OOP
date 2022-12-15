
import java.sql.*;


public class DeleteOptionModel extends OptionModel {
    public void deleteCat(DeleteOptionView view){
        String query = "";
        int id = 0;
        //ลบในตาราง menu ให้หมด
        PreparedStatement ps;
        ResultSet rs;
        //ดึง ตาราง menu
        query = "SELECT * FROM `menu` WHERE `username_menu` =? AND `category_menu` =?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, getUsername());
            ps.setString(2, getSelectCat());
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt("ID");
                query = "DELETE FROM `menu` WHERE `ID`="+id;
                Statement st = getConnection().createStatement();
                st.executeUpdate(query);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //ลบในตาราง cat
        id = getIDCat();
        query = "DELETE FROM `category` WHERE `ID`="+id;
        executeSQLQuery(query, "Deleted");
    }
}
