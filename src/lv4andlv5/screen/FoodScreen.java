package lv4andlv5.screen;

import lv4andlv5.food.Food;
import lv4andlv5.manager.CartManager;
import lv4andlv5.manager.FoodManager;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

/**
 * 음식 리스트 화면
 */
public class FoodScreen implements ScreenEvent{
    private final FoodManager foodManager;
    private final CartManager cartManager;
    private final int categoryIndex;
    public FoodScreen(FoodManager foodManager, CartManager cartManager , int categoryIndex){
        this.foodManager = foodManager;
        this.cartManager = cartManager;
        this.categoryIndex = categoryIndex;
    }

    /**
     * 선택한 카테고리에서의 음식 선택지
     */
    @Override
    public void printScreen() {
        if(this.categoryIndex < 1) return;
        for (Food food : foodManager.getFoodOfCategory(categoryIndex)) {
            food.printMyInfo();
        }
        input();
    }

    /**
     * 음식 선택
     * @return 0
     */
    @Override
    public int input() {
        Scanner sc = new Scanner(System.in);
        try {
            String input = sc.nextLine();
            int index = Integer.parseInt(input);

            if (index == 0) {
                System.out.println("이전화면으로 돌아갑니다.");
            } else if (index < 0 || foodManager.getFoodsSize() < index) {
                throw new InputMismatchException();
            } else {
                Optional<Food> selectFood = foodManager.selectFood(index, categoryIndex);

                if (selectFood.isEmpty()) throw new InputMismatchException();
                System.out.println(selectFood.get().getName() + "을 장바구니에 추가하시겠습니까?");
                System.out.println("1. 확인\t2. 취소");

                boolean flag = sc.nextLine().equals("1");
                if (flag) {
                    System.out.println("선택한 메뉴");
                    cartManager.addFood(selectFood.get());
                    cartManager.printCart();
                } else {
                    System.out.println("취소되었습니다.");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
        } catch (Exception e) {
            System.out.println("알수없는 오류 발생");
        }
        return 0;
    }
}
