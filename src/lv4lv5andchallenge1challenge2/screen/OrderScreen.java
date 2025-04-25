package lv4lv5andchallenge1challenge2.screen;

import lv4lv5andchallenge1challenge2.enums.Discount;
import lv4lv5andchallenge1challenge2.manager.CartManager;
import java.util.Scanner;

/**
 * 주문하기 화면
 */
public class OrderScreen implements ScreenEvent {
    private final CartManager cartManager;

    public OrderScreen(CartManager cartManager) {
        this.cartManager = cartManager;
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
        inputEvent();
    }

    /**
     * 주문하기 화면에서 입력
     * @return 0
     */
    @Override
    public int inputEvent() {
        Scanner sc = new Scanner(System.in);
        boolean flag = sc.nextLine().equals("1");
        if (flag) {
            double totalPrice = discount(sc);
            System.out.println("주문이 완료되었습니다. 금액은 W " + String.format("%.2f", totalPrice) + " 입니다.");
            cartManager.resetCart();
        } else {
            System.out.println("메뉴판으로 돌아갑니다.");
        }
        return 0;
    }

    /**
     * 할인율 적용
     * @param sc 스캐너
     * @return 할인적용 후의 가격
     */
    public double discount(Scanner sc) {
        System.out.println("할인 정보를 입력해주세요.");
        System.out.println("1. 국가유공자\t: 10% \n" + "2. 군인\t:  5%\n" + "3. 학생\t:  3%\n" + "4. 일반\t:  0%");
        double discountTotal = 0;
        try {
            int input = Integer.parseInt(sc.nextLine());

            switch (input) {
                case 1: {
                    discountTotal = Discount.NATIONAL.getDiscount(cartManager.getTotalPrice());
                    break;
                }
                case 2: {
                    discountTotal = Discount.SOLDIER.getDiscount(cartManager.getTotalPrice());
                    break;
                }
                case 3: {
                    discountTotal = Discount.STUDENT.getDiscount(cartManager.getTotalPrice());
                    break;
                }
                default: {
                    discountTotal = Discount.NORMAL.getDiscount(cartManager.getTotalPrice());
                }

            }
        } catch (NumberFormatException e) {
            System.out.println("잘못입력하셨습니다.");
            System.out.println("할인이 적용되지않고 진행됩니다.");
            discountTotal = Discount.NORMAL.getDiscount(cartManager.getTotalPrice());
        }
        return discountTotal;
    }
}
