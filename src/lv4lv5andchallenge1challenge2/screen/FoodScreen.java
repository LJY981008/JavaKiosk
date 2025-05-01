package lv4lv5andchallenge1challenge2.screen;

import lv4lv5andchallenge1challenge2.fooditem.foodmodel.Food;
import lv4lv5andchallenge1challenge2.manager.CartManager;
import lv4lv5andchallenge1challenge2.manager.MenuManager;
import lv4lv5andchallenge1challenge2.screen.screenmodel.NoneReturnScreen;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

/**
 * 음식 리스트 화면
 */
public class FoodScreen implements NoneReturnScreen {
    private final MenuManager menuManager;
    private final CartManager cartManager;
    private final Scanner sc;
    private final int categoryIndex;

    /**
     * 생성자
     * @param menuManager 음식전체 관리자
     * @param cartManager 장바구니 관리자
     * @param categoryIndex 선택한 카테고리의 index
     * @param sc 입력스캐너
     */
    public FoodScreen(MenuManager menuManager, CartManager cartManager, int categoryIndex, Scanner sc) {
        this.menuManager = menuManager;
        this.cartManager = cartManager;
        this.categoryIndex = categoryIndex;
        this.sc = sc;
    }

    /**
     * 선택한 카테고리에서의 음식 선택지
     */
    @Override
    public void printScreen() {
        if (this.categoryIndex < 1) return;
        for (Food food : menuManager.getFoodOfCategory(categoryIndex)) {
            food.printMyInfo();
        }
        selectedScreen();
    }

    /**
     * 음식 선택
     */
    @Override
    public void selectedScreen() {
        try {
            String input = sc.nextLine();
            int index = Integer.parseInt(input);

            if (index == 0) {
                System.out.println("이전화면으로 돌아갑니다.");
            } else if (index < 0 || menuManager.getFoodsSize() < index) {
                throw new InputMismatchException();
            } else {
                Optional<Food> selectFood = menuManager.selectFood(index, categoryIndex);

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
    }
}
