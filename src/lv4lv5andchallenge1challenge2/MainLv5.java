package lv4lv5andchallenge1challenge2;

import lv4lv5andchallenge1challenge2.manager.CartManager;
import lv4lv5andchallenge1challenge2.manager.CookingManager;
import lv4lv5andchallenge1challenge2.manager.FoodManager;

public class MainLv5 {
    public static void main(String[] args) {
        CookingManager cookingManager = new CookingManager();
        FoodManager foodManager = new FoodManager(cookingManager.cooking());
        CartManager cartManager = new CartManager();
        Kiosk kiosk = new Kiosk(foodManager, cartManager);
        kiosk.start();
    }
}
