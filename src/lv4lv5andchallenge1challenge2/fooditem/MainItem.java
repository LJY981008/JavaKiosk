package lv4lv5andchallenge1challenge2.fooditem;

import lv4lv5andchallenge1challenge2.model.FoodCommon;

/**
 * 메인음식 메뉴 데이터
 */
public class MainItem extends FoodCommon {
    public MainItem(int index, String name, double price, String information) {
        super(index, name, price, information);
    }

    // 내 카테고리 반환
    @Override
    public String getCategory() {
        return "1. Main";
    }
}
