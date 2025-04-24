package lv4andlv5;

public class DrinkItem extends Drink{
    DrinkItem(int index, String name, double price, String information) {
        super(index, name, price, information);
    }

    @Override
    public void printMenu() {
        System.out.println(getIndex() + ". " + getName() + "\t| W " + getPrice() + "\t | " + getInformation());
    }
}
