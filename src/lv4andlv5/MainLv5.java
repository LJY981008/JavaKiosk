package lv4andlv5;

import lv4andlv5.food.Food;
import lv4andlv5.item.DrinkItem;
import lv4andlv5.item.MainItem;
import lv4andlv5.item.SideItem;
import lv4andlv5.manager.CartManager;
import lv4andlv5.manager.MenuManager;

import java.util.ArrayList;
import java.util.List;

public class MainLv5 {
    public static void main(String[] args) {
        List<Food> items = new ArrayList<>();
        items.add(new MainItem(1,"ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        items.add(new MainItem(2,"SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        items.add(new MainItem(3,"Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        items.add(new MainItem(4,"Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        items.add(new DrinkItem(1,"ZeroCoke", 2.0, "제로 코카콜라"));
        items.add(new DrinkItem(2,"Coke", 2.0, "코카콜라"));

        items.add(new SideItem(1, "Potato", 2.5, "감자튀김"));
        items.add(new SideItem(2, "Cheese Ball", 3.5, "치즈볼"));
        items.add(new SideItem(3, "Large Potato", 3.5, "감자튀김 라지"));


        CartManager cartManager = new CartManager();
        MenuManager menuManager = new MenuManager(items);
        Kiosk kiosk = new Kiosk(menuManager, cartManager);
        kiosk.start();
    }
}
