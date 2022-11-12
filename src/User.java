/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sa
 */
public class User {
    private String shopName;
    private String username;
    private String password;
    private String confirm;
    
    //สร้าง constructor
    public User(String shopName, String username, String password, String confirm){
        this.shopName = shopName;
        this.username = username;
        this.password = password;
        this.confirm = confirm;
    }
    
    //สร้าง getter ทั้งหทด
    public String getShopName(){
        return shopName;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String getConfirm(){
        return confirm;
    }
    
}
