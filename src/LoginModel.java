
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class LoginModel {
    public void login(LoginView view,HomeView hview ,HomklinngernModel model){
        PreparedStatement ps;
            ResultSet rs;
            String uname = view.getJtuser().getText();
            String pass = String.valueOf(view.getJpass().getPassword());
            String query = "SELECT * FROM `member` WHERE `Username` =? AND `Password` =?";
            try {
                ps = HomklinngernModel.getConnection().prepareStatement(query);
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
}
