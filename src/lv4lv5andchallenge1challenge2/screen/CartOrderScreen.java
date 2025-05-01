package lv4lv5andchallenge1challenge2.screen;

import lv4lv5andchallenge1challenge2.manager.CartManager;
import lv4lv5andchallenge1challenge2.manager.PaymentManager;
import lv4lv5andchallenge1challenge2.screen.screenmodel.NoneReturnScreen;

import java.util.Scanner;

/**
 * 주문하기 화면
 */
public class CartOrderScreen implements NoneReturnScreen {
    private final CartManager cartManager;
    private final PaymentManager paymentManager;
    private final Scanner sc;

    /**
     * 생성자
     * @param cartManager 쇼핑카트 관리자
     * @param sc 입력스캐너
     */
    public CartOrderScreen(CartManager cartManager, Scanner sc) {
        this.cartManager = cartManager;
        paymentManager = new PaymentManager(cartManager);
        this.sc = sc;
    }

    /**
     * 주문하기위해 선택한 음식들
     */
    @Override
    public void printScreen() {
        if (cartManager.isEmpty()) return;
        System.out.println("[ Orders ]");
        cartManager.printCart();
        System.out.println("[ Total ]");
        System.out.println("W " + cartManager.getTotalPrice());
        System.out.println("1. 주문\t2. 메뉴판");
        selectedScreen();
    }

    /**
     * 주문하기 화면에서 입력
     */
    @Override
    public void selectedScreen() {
        boolean flag = sc.nextLine().equals("1");
        if (flag) {
            double totalPrice = paymentManager.discount(sc);
            System.out.println("주문이 완료되었습니다. 금액은 W " + String.format("%.2f", totalPrice) + " 입니다.");
            cartManager.resetCart();
        } else {
            System.out.println("메뉴판으로 돌아갑니다.");
        }
    }
}
