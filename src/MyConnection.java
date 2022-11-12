
import java.sql.Connection;
import java.sql.DriverManager;
public class MyConnection {
    
    // create a function to connect with mysql database
    public static Connection getConnection(){
     
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/Hom_klin_ngern", "root", "");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return con;
    }
    
}    
