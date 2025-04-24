package lv4andlv5.manager;

import lv4andlv5.food.Food;
import java.util.*;

/**
 * 메뉴관리자
 */
public class Menu {
    private final Map<Food, Integer> foodMap;
    private final Map<String, Integer> categoryMap;

    /**
     * 생성자
     * 카테고리와 음식을 map을 통해 관리
     * @param items 음식리스트
     */
    public Menu(List<Food> items) {
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
     * index 순으로 카테고리 정렬
     * @return 정렬된 배열
     */
    public String[] categoryToArraySort(){
        String[] array = categoryMap.keySet().toArray(new String[0]);
        Arrays.sort(array, (o1, o2) -> {
            int value1 = categoryMap.get(o1);
            int value2 = categoryMap.get(o2);
            return value1 - value2;
        });
        return array;
    }

    /**
     * 선택된 카테고리의 음식을 index 순으로 정렬
     * @return 정렬된 배열
     */
    public Food[] foodsToArraySort(){
        Food[] foods = foodMap.keySet().toArray(new Food[0]);
        Arrays.sort(foods, (o1, o2) ->{
            int value1 = o1.getIndex();
            int value2 = o2.getIndex();
            return value1 - value2;
        });
        return foods;
    }

    /**
     * 전체 카테고리 출력
     */
    public void printCategory(){
        String[] categoryArr = categoryToArraySort();
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
        Food[] foods = foodsToArraySort();
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
