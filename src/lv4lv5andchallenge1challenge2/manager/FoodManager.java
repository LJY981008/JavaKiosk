package lv4lv5andchallenge1challenge2.manager;

import lv4lv5andchallenge1challenge2.food.Food;
import java.util.*;

/**
 * 메뉴관리자 클래스
 */
public class FoodManager {
    private final Map<Food, Integer> foodCountMap;      //음식의 개수
    private final Map<String, Integer> categoryIndexMap;//카테고리의 index

    /**
     * 생성자
     * 카테고리와 음식을 map을 통해 관리
     * @param items 음식리스트
     */
    public FoodManager(List<Food> items) {
        foodCountMap = new HashMap<>();
        categoryIndexMap = new HashMap<>();

        for(Food item : items){
            int categoryIndex = Character.getNumericValue(item.getCategory().charAt(0));
            foodCountMap.put(item, categoryIndex);
            categoryIndexMap.put(item.getCategory(), categoryIndex);
        }
    }

    /**
     * @return 음식 전체 개수
     */
    public int getFoodsSize() {
        return foodCountMap.size();
    }

    /**
     * 전체 카테고리 반환
     */
    public String[] getCategoryToArray(){
        return SortManager.categoryToArraySort(categoryIndexMap);
    }

    /**
     * 해당 카테고리의 전체 음식 반환
     * @param categoryIndex 카테고리 index
     * @return 카테고리의 전체 음식 배열
     */
    public Food[] getFoodOfCategory(int categoryIndex){
        Food[] allFoods = SortManager.foodsToArraySort(foodCountMap);

        return Arrays.stream(allFoods)
                .filter(food -> foodCountMap.get(food) == categoryIndex)
                .toArray(Food[]::new);
    }

    /**
     * 선택한 음식의 Optional객체 생성
     * @param categoryIndex 선택한 카테고리의 번호
     * @param index 선택한 음식의 번호
     * @return 선택한 음식의 Optional 객체
     */
    public Optional<Food> selectFood(int categoryIndex, int index) {
        String[] categoryArray = categoryIndexMap.keySet().toArray(new String[0]);
        String category = Arrays.stream(categoryArray)
                .filter(item -> categoryIndexMap.get(item).equals(categoryIndex))
                .findFirst().get();

        Food[] foods = foodCountMap.keySet().toArray(new Food[0]);
        Optional<Food> food = Arrays.stream(foods)
                .filter(item -> Objects.equals(item.getCategory(), category) && item.getIndex() == index)
                .findFirst();

        return food;
    }
}
