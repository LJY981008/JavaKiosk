package lv4andlv5.manager;

import lv4andlv5.food.Food;
import java.util.*;

/**
 * 메뉴관리자 클래스
 */
public class MenuManager {
    private final Map<Food, Integer> foodMap;
    private final Map<String, Integer> categoryMap;

    /**
     * 생성자
     * 카테고리와 음식을 map을 통해 관리
     * @param items 음식리스트
     */
    public MenuManager(List<Food> items) {
        foodMap = new HashMap<>();
        categoryMap = new HashMap<>();
        for(Food item : items){
            int categoryIndex = Character.getNumericValue(item.getCategory().charAt(0)) -1;
            foodMap.put(item, categoryIndex);
            categoryMap.put(item.getCategory(), categoryIndex);
        }
    }

    /**
     * @return 음식 전체 개수
     */
    public int getFoodsSize() {
        return foodMap.size();
    }

    /**
     * 전체 카테고리 출력
     */
    public void printCategory(){
        String[] categoryArr = SortManager.categoryToArraySort(categoryMap);
        System.out.println("[ Main Menu ]");
        for(String category : categoryArr){
            System.out.println(category);
        }
        System.out.println("0. 종료");
    }

    /**
     * 전체 메뉴 출력
     */
    public void printMenu(int categoryIndex) {
        Food[] foods = SortManager.foodsToArraySort(foodMap);
        for (Food food : foods) {
            if(foodMap.get(food) == categoryIndex){
                food.printMenu();
            }
        }
        System.out.println("0. 뒤로가기");
    }

    /**
     * 선택한 메뉴 출력
     */
    public void printSelect(int index, int categoryIndex) {
        System.out.print("선택한 메뉴 : ");
        for(Food food : foodMap.keySet()){
            if(foodMap.get(food) == categoryIndex){
                if(food.getIndex() == index) food.printMenu();
            }
        }
        System.out.println("---------------------------------------------------------");
    }
}
