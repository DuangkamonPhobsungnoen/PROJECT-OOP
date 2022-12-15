
import java.sql.*;

public class HomklinngernModel {
    private String username;
    private String shopName;

    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getShopName() {
        return shopName;
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
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("Not Connect");
        }
        return con;
    }
    
    public int lastID(String table,String col_user){
        // หาไอดีสุดท้ายในตารางนั้นๆ
        PreparedStatement ps;
        ResultSet rs;
        int lastID = 0;
        String query = "SELECT * FROM `"+table+"` WHERE `"+col_user+"` =?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                int thisID = rs.getInt("ID");
                System.out.println("inloop");
                if (thisID > lastID){
                    lastID = thisID;
                }
            }
            System.out.println("outloop");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lastID;
    }
    
    
}
