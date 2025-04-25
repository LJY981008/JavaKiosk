package lv4andlv5.screen;

import lv4andlv5.manager.CartManager;
import lv4andlv5.manager.FoodManager;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 카테고리 화면
 */
public class CategoryScreen implements ScreenEvent{
    private final FoodManager foodManager;
    private final CartManager cartManager;
    private int screenListCount = 1;    // 화면에 표시되는 카테고리의 개수
    public CategoryScreen(FoodManager foodManager, CartManager cartManager){
            this.foodManager = foodManager;
            this.cartManager = cartManager;
    }

    /**
     * 전체 카테고리 출력
     */
    @Override
    public void printScreen() {
        String[] categoryArray = foodManager.getCategoryToArray();
        this.screenListCount = 1;
        System.out.println("[ Main Menu ]");
        for (String category : categoryArray) {
            System.out.println(category);
            this.screenListCount++;
        }
        System.out.println("[ ORDER MENU ]");
        System.out.println(screenListCount++ + ". Orders\t| 장바구니를 확인 후 주문합니다.");
        System.out.println(screenListCount + ". Cancel\t| 진행중인 주문을 취소합니다.");
        System.out.println("0. 종료");
    }

    /**
     * 사용자 입력으로 카테고리 선택
     * @return 선택한 카테고리의 index
     */
    @Override
    public int inputEvent() {
        Scanner sc = new Scanner(System.in);
        int index;
        try {
            String input = sc.nextLine();
            index = Integer.parseInt(input);
            if (index < 0 || screenListCount < index) throw new InputMismatchException();
        } catch (InputMismatchException e) {
            System.out.println("잘못된 입력입니다.");
            return 0;
        } catch (Exception e) {
            System.out.println("알수없는 오류 발생.");
            return 0;
        }
        return index;
    }

    /**
     * 선택한 카테고리 반환
     * @param categoryIndex 선택한 카테고리의 index
     * @return 선택한 카테고리의 화면 객체
     */
    public ScreenEvent selectCategory(int categoryIndex) {
        int orderBtn = this.screenListCount - 1;
        int cancelBtn = this.screenListCount;
        try {
            if (orderBtn == categoryIndex) {
                if (cartManager.isEmpty()) throw new InputMismatchException();
                System.out.println("아래와 같이 주문하시겠습니까?");
                return new OrderScreen(cartManager);
            } else if (cancelBtn == categoryIndex) {
                if (cartManager.isEmpty()) throw new InputMismatchException();
                return new CancelScreen(cartManager);
            }
        } catch (InputMismatchException e) {
            System.out.println("!!!!장바구니에 담긴 음식이 없습니다.!!!!");
            return new CategoryScreen(foodManager, cartManager);
        }
        return new FoodScreen(foodManager, cartManager, categoryIndex);
    }
}
