
import java.sql.Connection;
import java.sql.DriverManager;
public class MyConnection {
    
    // create a function to connect with mysql database
    public static Connection getConnection(){
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:4306/hom_klin_ngern", "root", "");
            System.out.println("Connect");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("Not connect");
        }
        
        return con;
    }
    public static void main(String[] args) {
        getConnection();
    }
    
}    
