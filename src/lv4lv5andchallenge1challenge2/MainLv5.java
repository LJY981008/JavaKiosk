package lv4lv5andchallenge1challenge2;

import lv4lv5andchallenge1challenge2.manager.CartManager;
import lv4lv5andchallenge1challenge2.manager.CookingManager;
import lv4lv5andchallenge1challenge2.manager.MenuManager;

/**
 * 프로그램 실행
 */
public class MainLv5 {
    public static void main(String[] args) {
        CookingManager cookingManager = new CookingManager();
        MenuManager menuManager = new MenuManager(cookingManager.cooking());
        CartManager cartManager = new CartManager();
        Kiosk kiosk = new Kiosk(menuManager, cartManager);
        kiosk.start();
    }
}
