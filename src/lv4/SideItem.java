package lv4;

public class SideItem implements Food {
    private int index;
    private String name;
    private String price;
    private String information;
    SideItem(int index, String name, double price, String information){
        this.index = index;
        this.name = name;
        this.price = String.valueOf(price);
        this.information = information;
    }
    @Override
    public void printMenu() {
        System.out.println(index + ". " + name + "\t| W " +  price + "\t | " + information);
    }
}
