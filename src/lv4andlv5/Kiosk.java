package lv4andlv5;

import lv4andlv5.manager.Menu;

import java.util.*;

public class Kiosk {
    private final Menu menu;
    Kiosk(Menu menu) {
        this.menu = menu;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        String input = "";
        while (true) {
            menu.printCategori();
            try{
                input = sc.nextLine();
                int index = Integer.parseInt(input) - 1;
                if(index == -1){
                    System.out.println("프로그램을 종료합니다");
                    break;
                }else if(index >= menu.getCategoriSize() || index < -1){
                    throw new InputMismatchException();
                }else{
                    menu.printMenu(index);
                }
            }catch (InputMismatchException e){
                System.out.println("잘못된 입력입니다. 다시 입력해주세요");
                sc.next();
                continue;
            }catch (Exception e){
                System.out.println("알수없는 오류 발생");
                sc.next();
                continue;
            }


            try {
                input = sc.nextLine();
                int index = Integer.parseInt(input) - 1;
                if (index == -1) {
                    System.out.println("이전화면으로 돌아갑니다.");
                } else if (index >= menu.getFoodListSize() || index < -1) {
                    throw new InputMismatchException();
                } else {
                    menu.printSelect(index);
                }
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            } catch (Exception e) {
                System.out.println("알수없는 오류 발생");
            }
        }
    }


}
