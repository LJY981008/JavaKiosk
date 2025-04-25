package lv4andlv5.manager;

import lv4andlv5.food.Food;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 장바구니 관리자
 */
public class CartManager {
    private final Map<Food, Integer> myCart;
    private double totalPrice = 0.0;
    private int selectFoodIndex = 1;
    public CartManager(){
        myCart = new HashMap<>();
    }

    /**
     * 장바구니 품목 추가
     * @param selectFood 주문한 음식의 데이터
     */
    public void addFood(Food selectFood){
        System.out.println("---------------------------------------------------------");
        if(!myCart.containsKey(selectFood)){
            selectFood.setCartIndex(selectFoodIndex);
            selectFoodIndex++;
        }
        myCart.merge(selectFood, 1, Integer::sum);

        totalPrice += Double.parseDouble(selectFood.getPrice());
        System.out.println(selectFood.getName() + "이 장바구니에 추가되었습니다.");
        System.out.println("---------------------------------------------------------");
    }

    /**
     * 장바구니 선택된 항목 삭제
     * @param index 선택한 항목의 index
     */
    public void removeFood(int index){
        System.out.println("---------------------------------------------------------");
        Food[] foods = myCart.keySet().toArray(new Food[0]);
        Optional<Food> food = Arrays.stream(foods).filter(temp -> temp.getCartIndex() == index).findFirst();

        myCart.computeIfPresent(food.get(), (key, value) -> value - 1);
        totalPrice -= Double.parseDouble(food.get().getPrice());
        System.out.println(food.get().getName() + "이 장바구니에서 제외되었습니다.");
        if(myCart.get(food.get()) <= 0) myCart.remove(food.get());

        //음식이 삭제되면 index 재배치
        this.selectFoodIndex = 1;
        for(Food key : myCart.keySet()){
            key.setCartIndex(this.selectFoodIndex++);
        }
        System.out.println("---------------------------------------------------------");
    }

    /**
     * 장바구니가 비었는지 확인
     * @return true = 비어있음, false = 비어있지않음
     */
    public boolean isEmpty(){
        return myCart.isEmpty();
    }

    /**
     * 장바구니 전체 + 전체가격 출력
     */
    public void printCart(){
        if(myCart.isEmpty()) return;
        System.out.println("---------------------------------------------------------");
        Food[] foods = SortManager.cartToArraySort(myCart);
        for(Food food : foods){
            System.out.print(food.getCartIndex() + ". ");
            food.printMyInfo(myCart.get(food));
        }
        System.out.println("총 합 : W" + totalPrice);
        System.out.println("---------------------------------------------------------");
    }

    /**
     * 장바구니 초기화
     */
    public void resetCart(){
        myCart.clear();
        totalPrice = 0;
    }

    /**
     * 장바구니 전체 가격 반환
     * @return 전체 가격
     */
    public double getTotalPrice(){
        return totalPrice;
    }
}
