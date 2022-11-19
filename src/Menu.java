/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sa
 */
public class Menu {
    private String userMenu;
    private String categoryMenu;
    private String name;
    private int price;
    
    //สร้าง constructor
    public Menu(String userMenu, String categoryMenu, String name, int price){
        this.userMenu = userMenu;
        this.categoryMenu = categoryMenu;
        this.name = name;
        this.price = price;
    }
    
    //สร้าง getter ทั้งหทด
    public String getUserMenu(){
        return userMenu;
    }
    public String getCategoryMenu(){
        return categoryMenu;
    }
    public String getName(){
        return name;
    }
    public int getPrice(){
        return price;
    }
}
