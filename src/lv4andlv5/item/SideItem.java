package lv4andlv5.item;

import lv4andlv5.food.FoodCommon;

/**
 * 사이드 메뉴 데이터
 */
public class SideItem extends FoodCommon {
    private int cartIndex;
    public SideItem(int index, String name, double price, String information) {
        super(index, name, price, information);
    }
    // 내 카테고리 반환
    @Override
    public String getCategory(){
        return "2. Side";
    }
    @Override
    public int getCartIndex() {
        return cartIndex;
    }

    @Override
    public void setCartIndex(int index) {
        cartIndex = index;
    }
}
