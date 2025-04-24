package lv4;

import java.util.*;

public class Kiosk {
    private List<Menu> menuItems = new ArrayList<>();
    Kiosk(List<Menu> items){
        this.menuItems = items;
    }
    public void start(){
        Scanner sc = new Scanner(System.in);
        String input = "";
        while (!input.equals("0")){
            printMenu();
            try {
                input = sc.nextLine();
                int index = Integer.parseInt(input) - 1;
                if (index == -1) {
                    System.out.println("프로그램을 종료합니다.");
                } else if (index >= menuItems.size() || index < -1) {
                    throw new InputMismatchException();
                }else{
                    printSelect(index);
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
     */
    public void printMenu(){
        for(int i = 0; i < menuItems.size(); i++){
            menuItems.get(i).printMenu();
        }
    }

    /**
     * 선택한 메뉴 출력
     */
    public void printSelect(int index){
        System.out.println("선택한 메뉴");
        menuItems.get(index).printMenu();
        System.out.println("---------------------------------------------------------");
    }
}
