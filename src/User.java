
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    
    //สร้าง constructor
    public User(int ID, String FirstName, String LastName, int Age){
        this.id = ID;
        this.firstName = FirstName;
        this.lastName = LastName;
        this.age = Age;
    }
    
    //สร้าง getter ทั้งหทด
    public int getId(){
        return id;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public int getAge(){
        return age;
    }
    
}
