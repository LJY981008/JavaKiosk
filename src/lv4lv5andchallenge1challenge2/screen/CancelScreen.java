package lv4lv5andchallenge1challenge2.screen;

import lv4lv5andchallenge1challenge2.manager.CartManager;
import lv4lv5andchallenge1challenge2.screen.screenmodel.NoneReturnScreen;

import java.util.Scanner;

/**
 * 주문취소 화면
 */
public class CancelScreen implements NoneReturnScreen {
    private final CartManager cartManager;
    private final Scanner sc;

    /**
     * 생성자
     * @param cartManager 쇼핑카트 관리자
     * @param sc 입력스캐너
     */
    public CancelScreen(CartManager cartManager, Scanner sc) {
        this.cartManager = cartManager;
        this.sc = sc;
    }

    /**
     * 취소할 주문 선택지
     */
    @Override
    public void printScreen() {
        System.out.println("취소하실 음식을 선택해주세요");
        System.out.println("[ Orders ]");
        cartManager.printCart();
        System.out.println("0. 돌아가기");
        selectedScreen();
    }

    /**
     * 사용자 입력으로 선택
     */
    @Override
    public void selectedScreen() {
        String input = sc.nextLine();
        try {
            if (!input.equals("0")) cartManager.removeFood(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            System.out.println("잘못입력하셨습니다.");
        }
    }
}
