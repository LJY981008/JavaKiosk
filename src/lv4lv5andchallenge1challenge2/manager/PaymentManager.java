package lv4lv5andchallenge1challenge2.manager;

import lv4lv5andchallenge1challenge2.enums.Discount;

import java.util.Scanner;

public class PaymentManager {
    private final CartManager cartManager;

    /**
     * 생성자
     * @param cartManager 쇼핑카트 관리자
     */
    public PaymentManager(CartManager cartManager) {
        this.cartManager = cartManager;
    }

    /**
     * 결제 할인율 적용
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
