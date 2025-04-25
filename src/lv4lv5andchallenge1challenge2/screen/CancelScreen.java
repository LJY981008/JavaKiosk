package lv4lv5andchallenge1challenge2.screen;

import lv4lv5andchallenge1challenge2.manager.CartManager;
import java.util.Scanner;

/**
 * 주문취소 화면
 */
public class CancelScreen implements ScreenEvent {
    private final CartManager cartManager;
    public CancelScreen(CartManager cartManager){
        this.cartManager = cartManager;
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
        inputEvent();
    }

    /**
     * 사용자 입력으로 선택
     * @return 0
     */
    @Override
    public int inputEvent() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        try {
            if (!input.equals("0")) cartManager.removeFood(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            System.out.println("잘못입력하셨습니다.");
        }
        return 0;
    }
}
