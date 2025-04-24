package lv4andlv5.manager;

import lv4andlv5.food.Food;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CartManager {
    private Map<Food, Integer> myCart;
    private Map<Integer, Food> indexCart;
    private double totalPrice = 0.0;
    private int index = 1;
    public CartManager(){
        myCart = new HashMap<>();
        indexCart = new HashMap<>();
    }
    public void addFood(Food selectFood){
        System.out.println("---------------------------------------------------------");
        if(!myCart.containsKey(selectFood)){
            selectFood.setCartIndex(index);
            index++;
        }
        myCart.merge(selectFood, 1, Integer::sum);

        totalPrice += Double.parseDouble(selectFood.getPrice());
        System.out.println(selectFood.getName() + "이 장바구니에 추가되었습니다.");
        System.out.println("---------------------------------------------------------");
    }
    public void removeFood(int index){
        System.out.println("---------------------------------------------------------");
        for(Food food : myCart.keySet()){
            if(food.getCartIndex() == index) {
                if(myCart.get(food) != null){
                    myCart.computeIfPresent(food, (key, value) -> value - 1);
                    totalPrice -= Double.parseDouble(food.getPrice());
                    System.out.println(food.getName() + "이 장바구니에서 제외되었습니다.");
                }
                if(myCart.get(food) <= 0) myCart.remove(food);
            }
        }
        System.out.println("---------------------------------------------------------");
    }
    public void payment(){
        totalPrice = 0;
        myCart.clear();
    }
    public boolean isEmpty(){
        return myCart.isEmpty();
    }
    public void printCart(){
        if(myCart.isEmpty()) return;
        System.out.println("---------------------------------------------------------");
        Food[] foods = SortManager.cartToArraySort(myCart);
        for(Food food : foods){
            System.out.print(food.getCartIndex() + ". ");
            food.printMenu(myCart.get(food));
        }
        System.out.println("총 합 : W" + totalPrice);
        System.out.println("---------------------------------------------------------");
    }
    public double getTotalPrice(){
        return totalPrice;
    }
}
