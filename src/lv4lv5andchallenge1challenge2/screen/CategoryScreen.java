package lv4lv5andchallenge1challenge2.screen;

import lv4lv5andchallenge1challenge2.manager.CartManager;
import lv4lv5andchallenge1challenge2.manager.MenuManager;
import lv4lv5andchallenge1challenge2.screen.interfaces.NeedReturnScreen;
import lv4lv5andchallenge1challenge2.screen.interfaces.ScreenEvent;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 카테고리 화면
 */
public class CategoryScreen implements NeedReturnScreen {
    private final MenuManager menuManager;
    private final CartManager cartManager;
    private final Scanner sc;
    private int screenListCount = 1;    // 화면에 표시되는 카테고리의 개수

    /**
     * 생성자
     * @param menuManager 음식전체 관리자
     * @param cartManager 쇼핑카트 관리자
     * @param sc 입력스캐너
     */
    public CategoryScreen(MenuManager menuManager, CartManager cartManager, Scanner sc) {
        this.menuManager = menuManager;
        this.cartManager = cartManager;
        this.sc = sc;
    }

    /**
     * 전체 카테고리 출력
     */
    @Override
    public void printScreen() {
        String[] categoryArray = menuManager.getCategoryToArray();
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
    public int selectedScreen() {
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
    public ScreenEvent getSelectCategory(int categoryIndex) {
        int orderBtn = this.screenListCount - 1;
        int cancelBtn = this.screenListCount;
        try {
            if (cartManager.isEmpty()) throw new InputMismatchException();
            if (orderBtn == categoryIndex) {
                System.out.println("아래와 같이 주문하시겠습니까?");
                return new CartOrderScreen(cartManager, sc);
            } else if (cancelBtn == categoryIndex) {
                return new CancelScreen(cartManager, sc);
            }
        } catch (InputMismatchException e) {
            System.out.println("!!!!장바구니에 담긴 음식이 없습니다.!!!!");
            return this;
        }
        return new FoodScreen(menuManager, cartManager, categoryIndex, sc);
    }
}
