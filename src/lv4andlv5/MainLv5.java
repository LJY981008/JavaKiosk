package lv4andlv5;

import lv4andlv5.manager.CartManager;
import lv4andlv5.manager.CookingManager;
import lv4andlv5.manager.FoodManager;

public class MainLv5 {
    public static void main(String[] args) {
        CookingManager cookingManager = new CookingManager();
        CartManager cartManager = new CartManager();
        FoodManager foodManager = new FoodManager(cookingManager.cooking());
        Kiosk kiosk = new Kiosk(foodManager, cartManager);
        kiosk.start();
    }
}
