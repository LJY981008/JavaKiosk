package lv4;

import java.util.ArrayList;
import java.util.List;

public class MainLv4 {
    public static void main(String[] args) {
        List<Menu> items = new ArrayList<>();
        items.add(new MainItem(1,"ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        items.add(new MainItem(2,"SmokeShack", 8.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        items.add(new MainItem(3,"Cheeseburger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        items.add(new MainItem(4,"Hamburger", 5.4, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        items.add(new SideItem(5,"Potato", 2.5, "감자튀김"));
        items.add(new SideItem(6,"Coke", 2.0, "코카콜라"));



        Kiosk kiosk = new Kiosk(items);
        kiosk.start();
    }
}
