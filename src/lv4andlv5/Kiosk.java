package lv4andlv5;

import lv4andlv5.manager.CartManager;
import lv4andlv5.manager.FoodManager;
import lv4andlv5.screen.*;

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

            int categoryIndex = categoryScreen.input();
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
