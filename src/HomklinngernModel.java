
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class HomklinngernModel {

    private SignupView signup;

    public HomklinngernModel() {
        signup = new SignupView();
    }
        // create a function to connect with mysql database
        public static Connection getConnection() {
            Connection con = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/hom_klin_ngern", "root", "");
                System.out.println("Connect");
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            return con;
        }
}
