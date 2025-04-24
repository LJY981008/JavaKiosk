package lv4andlv5;

import lv4andlv5.enums.Discount;
import lv4andlv5.food.Food;
import lv4andlv5.manager.CartManager;
import lv4andlv5.manager.MenuManager;

import java.util.*;

/**
 * 키오스크 입출력 클래스
 */
public class Kiosk {
    private final MenuManager menuManager;
    private final CartManager cartManager;

    Kiosk(MenuManager menuManager, CartManager cartManager) {
        this.menuManager = menuManager;
        this.cartManager = cartManager;
    }

    /**
     * 키오스크 시작
     */
    public void start() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            menuManager.printCategory();

            System.out.println("[ ORDER MENU ]");
            System.out.println("4. Orders\t| 장바구니를 확인 후 주문합니다.");
            System.out.println("5. Cancel\t| 진행중인 주문을 취소합니다.");

            int categoryIndex = categoryMenu(sc);
            if (categoryIndex == -1) {
                break;
            }else if(categoryIndex != -2){
                foodMenu(sc, categoryIndex);
            }
        }
        System.out.println("프로그램을 종료합니다.");
        sc.close();
    }

    /**
     * 카테고리 화면
     * @param sc 스캐너
     * @return -1 = 중지, 비정상작동
     */
    public int categoryMenu(Scanner sc) {
        int index = -1;
        try {
            String input = sc.nextLine();
            index = Integer.parseInt(input) - 1;
            if (index == -1) {
                return -1;
            } else if (index == 3) {
                if(cartManager.isEmpty()){
                    System.out.println("!!!!장바구니에 담긴 음식이 없습니다.!!!!");
                    return -2;
                }
                System.out.println("아래와 같이 주문하시겠습니까?");
                return order(sc) ? -1 : -2;
            } else if (index == 4) {
                return cancel(sc);
            } else if (index >= menuManager.getFoodsSize() || index < -1) {
                throw new InputMismatchException();
            } else {
                menuManager.printMenu(index);
            }
        } catch (InputMismatchException e) {
            System.out.println("잘못된 입력입니다.");
            sc.next();
            return -1;
        } catch (Exception e) {
            System.out.println("알수없는 오류 발생.");
            sc.next();
            return -1;
        }
        return index;
    }

    /**
     * 음식목록화면
     * @param sc 스캐너
     * @param categoryIndex 선택했던 카테고리의 index
     */
    public void foodMenu(Scanner sc, int categoryIndex) {
        try {
            String input = sc.nextLine();
            int index = Integer.parseInt(input);
            if (index == 0) {
                System.out.println("이전화면으로 돌아갑니다.");
            } else if (index > menuManager.getFoodsSize() || index < 0) {
                throw new InputMismatchException();
            } else {
                Food selectFood = menuManager.printSelect(index, categoryIndex);
                System.out.println(selectFood.getName() + "을 장바구니에 추가하시겠습니까?");
                System.out.println("1. 확인\t2. 취소");
                boolean flag = sc.nextLine().equals("1");
                if (flag) {
                    System.out.println("선택한 메뉴");
                    cartManager.addFood(selectFood);
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

    /**
     * 주문하기
     * @param sc 스캐너
     * @return true = 주문, false = 메뉴판
     */
    public boolean order(Scanner sc){
        if(cartManager.isEmpty()) return false;
        System.out.println("[ Orders ]");
        cartManager.printCart();
        System.out.println("[ Total ]");
        System.out.println("W " + cartManager.getTotalPrice());
        System.out.println("1. 주문\t2. 메뉴판");
        boolean flag = sc.nextLine().equals("1");
        if(flag){
            double totalPrice = discount(sc);
            System.out.println("주문이 완료되었습니다. 금액은 W " + String.format("%.2f", totalPrice) + " 입니다.");
            cartManager.payment();
        }else{
            System.out.println("메뉴판으로 돌아갑니다.");
            return false;
        }
        return true;
    }

    /**
     * 주문취소
     * @param sc 스캐너
     * @return -2 = 키오스크의 처음으로
     */
    public int cancel(Scanner sc){
        System.out.println("취소하실 음식을 선택해주세요");
        System.out.println("[ Orders ]");
        cartManager.printCart();
        System.out.println("0. 돌아가기");
        String input = sc.nextLine();
        try {
            if(!input.equals("0")) cartManager.removeFood(Integer.parseInt(input));
        }catch (NumberFormatException e){
            System.out.println("잘못입력하셨습니다.");
        }
        return -2;
    }

    /**
     * 할인율 적용
     * @param sc 스캐너
     * @return 할인적용 후의 가격
     */
    public double discount(Scanner sc){
        System.out.println("할인 정보를 입력해주세요.");
        System.out.println(
                "1. 국가유공자\t: 10% \n" +
                "2. 군인\t:  5%\n" +
                "3. 학생\t:  3%\n" +
                "4. 일반\t:  0%"
        );
        double discountTotal = 0;
        try {
            int input = Integer.parseInt(sc.nextLine());

            switch (input){
                case 1:{
                    discountTotal = Discount.NATIONAL.getDiscount(cartManager.getTotalPrice());
                    break;
                }
                case 2:{
                    discountTotal = Discount.SOLDIER.getDiscount(cartManager.getTotalPrice());
                    break;
                }
                case 3:{
                    discountTotal = Discount.STUDENT.getDiscount(cartManager.getTotalPrice());
                    break;
                }
                default:{
                    discountTotal = Discount.NORMAL.getDiscount(cartManager.getTotalPrice());
                }

            }
        }catch (NumberFormatException e){
            System.out.println("잘못입력하셨습니다.");
            System.out.println("할인이 적용되지않고 진행됩니다.");
            discountTotal = Discount.NORMAL.getDiscount(cartManager.getTotalPrice());
        }
        return discountTotal;
    }
}
