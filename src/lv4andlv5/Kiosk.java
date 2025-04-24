package lv4andlv5;

import lv4andlv5.manager.MenuManager;

import java.util.*;

/**
 * 키오스크 입출력 클래스
 */
public class Kiosk {
    private final MenuManager menuManager;
    Kiosk(MenuManager menuManager) {
        this.menuManager = menuManager;
    }
    /**
     * 키오스크 시작
     */
    public void start() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            menuManager.printCategory();
            int categoryIndex = categoryMenu(sc);
            if(categoryIndex == -1) break;
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
    public int categoryMenu(Scanner sc){
        int index = -1;
        try{
            String input = sc.nextLine();
            index = Integer.parseInt(input) - 1;
            if(index == -1){
                System.out.println("프로그램을 종료합니다");
                return -1;
            }else if(index >= menuManager.getFoodsSize() || index < -1){
                throw new InputMismatchException();
            }else{
                menuManager.printMenu(index);
            }
        }catch (InputMismatchException e){
            System.out.println("잘못된 입력입니다.");
            sc.next();
            return -1;
        }catch (Exception e){
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
    public void foodMenu(Scanner sc, int categoryIndex){
        try {
            String input = sc.nextLine();
            int index = Integer.parseInt(input) - 1;
            if (index == -1) {
                System.out.println("이전화면으로 돌아갑니다.");
            } else if (index >= menuManager.getFoodsSize() || index < -1) {
                throw new InputMismatchException();
            } else {
                menuManager.printSelect(index, categoryIndex);
            }
        } catch (InputMismatchException e) {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
        } catch (Exception e) {
            System.out.println("알수없는 오류 발생");
        }
    }
}
