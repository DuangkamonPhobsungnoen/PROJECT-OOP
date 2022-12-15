
public class Menu {

    private String name;
    private int price;

    //สร้าง constructor
    public Menu(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
