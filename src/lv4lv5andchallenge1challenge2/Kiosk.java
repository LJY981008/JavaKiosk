package lv4lv5andchallenge1challenge2;

import lv4lv5andchallenge1challenge2.manager.CartManager;
import lv4lv5andchallenge1challenge2.manager.FoodManager;
import lv4lv5andchallenge1challenge2.screen.*;

/**
 * 키오스크 입출력 클래스
 */
public class Kiosk {
    private final FoodManager foodManager;
    private final CartManager cartManager;

    Kiosk(FoodManager foodManager, CartManager cartManager) {
        this.foodManager = foodManager;
        this.cartManager = cartManager;
    }

    /**
     * 키오스크 시작
     */
    public void start() {
        CategoryScreen categoryScreen = new CategoryScreen(foodManager, cartManager);
        while (true) {
            categoryScreen.printScreen();

            int categoryIndex = categoryScreen.inputEvent();
            if (categoryIndex == 0) {
                break;
            } else {
                ScreenEvent nextScreen = categoryScreen.selectCategory(categoryIndex);
                if (!(nextScreen instanceof CategoryScreen)) nextScreen.printScreen();
            }
        }
        System.out.println("프로그램을 종료합니다.");
    }
}
