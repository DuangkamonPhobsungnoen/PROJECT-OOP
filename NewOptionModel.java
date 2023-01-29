
import javax.swing.JOptionPane;

public class NewOptionModel extends OptionModel {
    
    public void addNewCat(NewOptionView view){
        String newCat = view.getJtcat().getText();
        if(newCat.trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Name must not be empty");
        }
        else{
            int lastID = lastID("category")+1;
            String query = "INSERT INTO `category`(`username_cate`, `category_cate`, `ID`) "
                + "VALUES ('"+getUsername()+"', '"+newCat+"', '"+lastID+"')";
            executeSQLQuery(query, "Added");
        }
    }
    
}
