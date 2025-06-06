package lv4lv5andchallenge1challenge2.fooditem;

import lv4lv5andchallenge1challenge2.fooditem.foodmodel.FoodCommon;

/**
 * 음료수 메뉴 데이터
 */
public class DrinkItem extends FoodCommon {
    public DrinkItem(int index, String name, double price, String information) {
        super(index, name, price, information);
    }

    // 내 카테고리 반환
    @Override
    public String getCategory() {
        return "3. Drink";
    }
}
