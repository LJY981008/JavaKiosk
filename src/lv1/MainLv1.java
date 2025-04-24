package lv1;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.SortedMap;

public class MainLv1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String stopper = "";
        String[][] menu = new String[4][2];
        menu[0][0] = "ShackBurger";
        menu[0][1] = "W 6.9";
        menu[1][0] = "SmokeShack";
        menu[1][1] = "W 8.9";
        menu[2][0] = "Cheeseburger";
        menu[2][1] = "W 6.9";
        menu[3][0] = "Hamburger";
        menu[3][1] = "W 5.4";

        while(!stopper.equals("0")){
            String input = "";
            System.out.println("1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
            System.out.println("2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
            System.out.println("3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
            System.out.println("4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거");
            System.out.println("0. 종료");
            try {
                input = sc.nextLine();
                int index = Integer.parseInt(input) - 1;
                if (index == -1) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                } else if (index > 3 || index < -1) {
                    throw new InputMismatchException();
                } else {
                    System.out.println("선택한 메뉴 : " + menu[index][0] + ", 가격 : " + menu[index][1]);
                }
            }catch (InputMismatchException e){
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }catch (Exception e){
                System.out.println("알수없는 오류 발생. 다시 입력해주세요.");
            }
        }

        sc.close();
    }
}
