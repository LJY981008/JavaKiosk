package lv4andlv5.food;

abstract public class Drink implements Food {
    private int index;
    private String name;
    private String price;
    private String information;
    private String categori = "2. Drink";
    public Drink(int index, String name, double price, String information){
        this.index = index;
        this.name = name;
        this.price = String.valueOf(price);
        this.information = information;
    }
    @Override
    public int getIndex(){
        return index;
    }
    @Override
    public String getName(){
        return name;
    }
    @Override
    public String getCategori() {
        return categori;
    }
    @Override
    public String getInformation() {
        return information;
    }
    @Override
    public String getPrice() {
        return price;
    }
}
