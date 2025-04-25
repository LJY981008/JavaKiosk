package lv4andlv5;

import lv4andlv5.manager.CartManager;
import lv4andlv5.manager.CookingManager;
import lv4andlv5.manager.FoodManager;

public class MainLv5 {
    public static void main(String[] args) {
        CookingManager cookingManager = new CookingManager();
        FoodManager foodManager = new FoodManager(cookingManager.cooking());
        CartManager cartManager = new CartManager();
        Kiosk kiosk = new Kiosk(foodManager, cartManager);
        kiosk.start();
    }
}
