
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class OptionModel extends CategoryModel {
    
    // Execute SQL Query for Option add update delete category
    public void executeSQLQuery(String query, String Message) {
        System.out.println("in execute");
        try {
            Statement st = getConnection().createStatement();
            if (st.executeUpdate(query) != 0) {
                JOptionPane.showMessageDialog(null, "Category " + Message + " Success");
            } else {
                JOptionPane.showMessageDialog(null, "Category not " + Message);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Category not " + e);
        }
    }

}
