package lv2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MainLv2 {
    public static void main(String[] args) {
        List<MenuItem> menuItems = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String input = "";

        menuItems.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", 8.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger", 5.4, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));

        while (!input.equals("0")){
            printMenu(menuItems);
            try {
                input = sc.nextLine();
                int index = Integer.parseInt(input) - 1;
                if (index == -1) {
                    System.out.println("프로그램을 종료합니다.");
                } else if (index > menuItems.size() || index < -1) {
                    throw new InputMismatchException();
                }else{
                    printSelect(menuItems.get(index));
                }
            }catch (InputMismatchException e){
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }catch (Exception e){
                System.out.println("알수없는 오류 발생");
            }
        }
    }

    /**
     * 전체 메뉴 출력
     * @param _menuItems 메뉴리스트
     */
    public static void printMenu(List<MenuItem> _menuItems){
        for(int i = 0; i < _menuItems.size(); i++){
            String[] menuItem = _menuItems.get(i).getMenu();    // index = 0 메뉴이름, 1 가격, 2 설명
            System.out.println(i+1 + ". " + menuItem[0] + "\t| W " +  menuItem[1] + "\t | " + menuItem[2]);
        }
    }

    /**
     * 선택한 메뉴 출력
     * @param menuItem 선택된 메뉴
     */
    public static void printSelect(MenuItem menuItem){
        String[] menu = menuItem.getMenu();
        System.out.println("선택한 메뉴 : " + menu[0] + ", 가격 : " + menu[1]);
    }
}
