

public class NewOptionModel extends OptionModel {
    
    public void addNewCat(NewOptionView view){
        String newCat = view.getJtcat().getText();
        int lastID = lastID("category","username_cate")+1;
        System.out.println(lastID);
        String query = "INSERT INTO `category`(`username_cate`, `category_cate`, `ID`) "
                + "VALUES ('"+getUsername()+"', '"+newCat+"', '"+lastID+"')";
        executeSQLQuery(query, "Added");
    }
    
}
