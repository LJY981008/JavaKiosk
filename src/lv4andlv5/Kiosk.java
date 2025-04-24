package lv4andlv5;

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
            }
            foodMenu(sc, categoryIndex);

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
                System.out.println("프로그램을 종료합니다");
                return -1;
            } else if (index == 3) {
                System.out.println("아래와 같이 주문하시겠습니까?");
                order(sc);
                return -1;
            } else if (index == 4) {

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

    public void order(Scanner sc){
        System.out.println("[ Orders ]");
        cartManager.printCart();
        System.out.println("[ Total ]");
        System.out.println("W " + cartManager.getTotalPrice());
        System.out.println("1. 주문\t2. 메뉴판");
        boolean flag = sc.nextLine().equals("1");
        if(flag){
            System.out.println("주문이 완료되었습니다. 금액은 W " + cartManager.getTotalPrice() + " 입니다.");
            cartManager.payment();
        }else{
            System.out.println("메뉴판으로 돌아갑니다.");
        }
    }
}
