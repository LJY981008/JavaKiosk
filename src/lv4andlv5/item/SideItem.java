package lv4andlv5.item;

import lv4andlv5.food.Desert;

public class SideItem extends Desert {
    public SideItem(int index, String name, double price, String information) {
        super(index, name, price, information);
    }
    @Override
    public void printMenu() {
        System.out.println(getIndex() + ". " + getName() + "\t| W " + getPrice() + "\t | " + getInformation());
    }

}
