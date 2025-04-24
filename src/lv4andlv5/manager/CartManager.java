package lv4andlv5.manager;

import lv4andlv5.food.Food;

import java.util.HashMap;
import java.util.Map;

public class CartManager {
    Map<Food, Integer> myCart;
    public CartManager(){
        myCart = new HashMap<>();
    }
    public void addFood(Food selectFood){
        System.out.println("---------------------------------------------------------");
        myCart.merge(selectFood, 1, Integer::sum);
        System.out.println(selectFood.getName() + "이 장바구니에 추가되었습니다.");
        System.out.println("---------------------------------------------------------");
    }
    public void removeFood(Food selectFood){
        System.out.println("---------------------------------------------------------");
        if(myCart.get(selectFood) != null){
            myCart.computeIfPresent(selectFood, (key, value) -> value - 1);
            System.out.println(selectFood.getName() + "이 장바구니에서 제외되었습니다.");
        }
        System.out.println("---------------------------------------------------------");
    }
    public void printCart(){

        System.out.println("---------------------------------------------------------");
        for(Food food : myCart.keySet()){
            food.printMenu(myCart.get(food));
        }
        System.out.println("---------------------------------------------------------");
    }
}
