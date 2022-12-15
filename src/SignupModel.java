
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class SignupModel {
    public void backSignup(SignupView view){
        view.getJf().dispose();
        view.getJtname().setText("");
        view.getJtuser().setText("");
        view.getJpass().setText("");
        view.getJcpass().setText("");
    }
    
    public void register(SignupView view){
        String name = view.getJtname().getText();
        String uname = view.getJtuser().getText();
        String password = String.valueOf(view.getJpass().getPassword());
        String confirm = String.valueOf(view.getJcpass().getPassword());
            int count = 0;
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Add a name");
                count += 1;
            } else if (uname.equals("")) {
                JOptionPane.showMessageDialog(null, "Add a username");
                count += 1;
            } else if (password.equals("") | password.equals("jPasswordField1")) {
                JOptionPane.showMessageDialog(null, "Add a password");
                count += 1;
            } else if (!password.equals(confirm)) {
                JOptionPane.showMessageDialog(null, "Retype the password again");
                count += 1;
            }
            PreparedStatement ps;
            String query = "INSERT INTO `member`(`ShopName`, `Username`, `Password`, `Comfirm`) VALUES (?, ?, ?, ?)";
            try {
                if (count == 0) {
                    ps = HomklinngernModel.getConnection().prepareStatement(query);
                    ps.setString(1, name);
                    ps.setString(2, uname);
                    ps.setString(3, password);
                    ps.setString(4, confirm);
                    if (ps.executeUpdate() > 0) {
                        JOptionPane.showMessageDialog(null, "New User Add");
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(SignupView.class.getName()).log(Level.SEVERE, null, ex);
            }

    }
    
}
