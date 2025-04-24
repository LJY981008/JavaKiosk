package lv3;

public class MenuItem {
    private String menu;
    private String price;
    private String information;
    MenuItem(String menu, double price, String information){
        this.menu = menu;
        this.price = String.valueOf(price);
        this.information = information;
    }

    public String[] getMenu(){
        return new String[]{this.menu, this.price, this.information};
    }

}
