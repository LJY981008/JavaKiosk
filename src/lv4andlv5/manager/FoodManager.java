package lv4andlv5.manager;

import lv4andlv5.food.Food;
import java.util.*;

/**
 * 메뉴관리자 클래스
 */
public class FoodManager {
    private final Map<Food, Integer> foodMap;
    private final Map<String, Integer> categoryMap;

    /**
     * 생성자
     * 카테고리와 음식을 map을 통해 관리
     * @param items 음식리스트
     */
    public FoodManager(List<Food> items) {
        foodMap = new HashMap<>();
        categoryMap = new HashMap<>();

        for(Food item : items){
            int categoryIndex = Character.getNumericValue(item.getCategory().charAt(0));
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
     * 전체 카테고리 반환
     */
    public String[] getCategoryToArray(){
        return SortManager.categoryToArraySort(categoryMap);
    }

    /**
     * 해당 카테고리의 전체 음식 반환
     * @param categoryIndex 카테고리 index
     * @return 카테고리의 전체 음식 배열
     */
    public Food[] getFoodOfCategory(int categoryIndex){
        Food[] allFoods = SortManager.foodsToArraySort(foodMap);

        return Arrays.stream(allFoods)
                .filter(food ->foodMap.get(food) == categoryIndex)
                .toArray(Food[]::new);
    }

    /**
     * 선택한 음식의 Optional객체 반환
     * @param index
     * @param categoryIndex
     * @return
     */
    public Optional<Food> selectFood(int index, int categoryIndex) {
        String[] categoryArray = categoryMap.keySet().toArray(new String[0]);
        String category = Arrays.stream(categoryArray)
                .filter(item -> categoryMap.get(item).equals(categoryIndex))
                .findFirst().get();

        Food[] foods = foodMap.keySet().toArray(new Food[0]);
        Optional<Food> food = Arrays.stream(foods)
                .filter(item -> Objects.equals(item.getCategory(), category) && item.getIndex() == index)
                .findFirst();

        return food;
    }
}
