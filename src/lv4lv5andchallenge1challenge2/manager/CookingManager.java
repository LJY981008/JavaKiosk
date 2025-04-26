package lv4lv5andchallenge1challenge2.manager;

import lv4lv5andchallenge1challenge2.model.Food;
import lv4lv5andchallenge1challenge2.fooditem.DrinkItem;
import lv4lv5andchallenge1challenge2.fooditem.MainItem;
import lv4lv5andchallenge1challenge2.fooditem.SideItem;

import java.util.ArrayList;
import java.util.List;

/**
 * 음식 객체 생성
 */
public class CookingManager {
    /**
     * 음식 생성
     * @return 음식객체리스트
     */
    public List<Food> cooking() {
        List<Food> items = new ArrayList<>();
        items.add(new MainItem(1, "ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        items.add(new MainItem(2, "SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        items.add(new MainItem(3, "Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        items.add(new MainItem(4, "Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        items.add(new DrinkItem(1, "ZeroCoke", 2.0, "제로 코카콜라"));
        items.add(new DrinkItem(2, "Coke", 2.0, "코카콜라"));

        items.add(new SideItem(1, "Potato", 2.5, "감자튀김"));
        items.add(new SideItem(2, "Cheese Ball", 3.5, "치즈볼"));
        items.add(new SideItem(3, "Large Potato", 3.5, "감자튀김 라지"));
        return items;
    }
}
