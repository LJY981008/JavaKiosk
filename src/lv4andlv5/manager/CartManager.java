package lv4andlv5.manager;

import lv4andlv5.food.Food;

import java.util.HashMap;
import java.util.Map;

public class CartManager {
    private Map<Food, Integer> myCart;
    private double totalPrice = 0.0;
    public CartManager(){
        myCart = new HashMap<>();
    }
    public void addFood(Food selectFood){
        System.out.println("---------------------------------------------------------");
        myCart.merge(selectFood, 1, Integer::sum);
        totalPrice += Double.parseDouble(selectFood.getPrice());
        System.out.println(selectFood.getName() + "이 장바구니에 추가되었습니다.");
        System.out.println("---------------------------------------------------------");
    }
    public void removeFood(Food selectFood){
        System.out.println("---------------------------------------------------------");
        if(myCart.get(selectFood) != null){
            myCart.computeIfPresent(selectFood, (key, value) -> value - 1);
            totalPrice -= Double.parseDouble(selectFood.getPrice());
            System.out.println(selectFood.getName() + "이 장바구니에서 제외되었습니다.");
        }
        System.out.println("---------------------------------------------------------");
    }
    public void payment(){
        totalPrice = 0;
        myCart.clear();
    }
    public void printCart(){
        System.out.println("---------------------------------------------------------");
        for(Food food : myCart.keySet()){
            food.printMenu(myCart.get(food));
        }
        System.out.println("총 합 : W" + totalPrice);
        System.out.println("---------------------------------------------------------");
    }
    public double getTotalPrice(){
        return totalPrice;
    }
}
