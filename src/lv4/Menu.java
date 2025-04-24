package lv4;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    List<Food> foodList = new ArrayList<>();

    Menu(List<Food> items) {
        this.foodList = items;
    }

    public int getSize() {
        return foodList.size();
    }

    /**
     * 전체 메뉴 출력
     */
    public void printMenu() {
        for (int i = 0; i < foodList.size(); i++) {
            foodList.get(i).printMenu();
        }
    }

    /**
     * 선택한 메뉴 출력
     */
    public void printSelect(int index) {
        System.out.println("선택한 메뉴");
        foodList.get(index).printMenu();
        System.out.println("---------------------------------------------------------");
    }
}
