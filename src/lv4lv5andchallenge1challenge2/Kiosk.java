package lv4lv5andchallenge1challenge2;

import lv4lv5andchallenge1challenge2.manager.CartManager;
import lv4lv5andchallenge1challenge2.manager.MenuManager;
import lv4lv5andchallenge1challenge2.screen.*;
import lv4lv5andchallenge1challenge2.screen.interfaces.ScreenEvent;

import java.util.Scanner;

/**
 * 키오스크 제어 클래스
 */
public class Kiosk {
    private final CategoryScreen categoryScreen;
    private final Scanner sc;

    public Kiosk(MenuManager menuManager, CartManager cartManager) {
        this.sc = new Scanner(System.in);
        this.categoryScreen = new CategoryScreen(menuManager, cartManager, sc);
    }

    /**
     * 키오스크 시작
     */
    public void start() {
        while (true) {
            categoryScreen.printScreen();

            int categoryIndex = categoryScreen.selectedScreen();
            if (categoryIndex == 0) {
                break;
            } else {
                ScreenEvent nextScreen = categoryScreen.getSelectCategory(categoryIndex);
                if (!(nextScreen instanceof CategoryScreen)) nextScreen.printScreen();
            }
        }
        System.out.println("프로그램을 종료합니다.");
        sc.close();
    }
}
