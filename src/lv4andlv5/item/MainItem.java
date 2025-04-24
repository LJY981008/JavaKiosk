package lv4andlv5.item;

import lv4andlv5.food.Burger;

public class MainItem extends Burger {
    public MainItem(int index, String name, double price, String information) {
        super(index, name, price, information);
    }
    @Override
    public void printMenu() {
        System.out.println(getIndex() + ". " + getName() + "\t| W " +  getPrice() + "\t | " + getInformation());
    }
}
