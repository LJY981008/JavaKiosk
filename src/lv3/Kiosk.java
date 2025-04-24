package lv3;

import java.util.*;

public class Kiosk {
    private List<MenuItem> menuItems = new ArrayList<>();
    Kiosk(MenuItem[] items){
        this.menuItems.addAll(Arrays.asList(items));
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
                } else if (index > menuItems.size() || index < -1) {
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
            String[] menuItem = menuItems.get(i).getMenu();    // index = 0 메뉴이름, 1 가격, 2 설명
            System.out.println(i+1 + ". " + menuItem[0] + "\t| W " +  menuItem[1] + "\t | " + menuItem[2]);
        }
    }

    /**
     * 선택한 메뉴 출력
     */
    public void printSelect(int index){
        String[] menu = menuItems.get(index).getMenu();     // index = 0 메뉴이름, 1 가격
        System.out.println("선택한 메뉴 : " + menu[0] + ", 가격 : " + menu[1]);
    }
}
