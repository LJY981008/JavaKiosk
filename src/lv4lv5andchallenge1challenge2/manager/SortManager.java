package lv4lv5andchallenge1challenge2.manager;

import lv4lv5andchallenge1challenge2.food.Food;

import java.util.Arrays;
import java.util.Map;

/**
 * 정렬 클래스
 */
public class SortManager {
    /**
     * index 순으로 카테고리 정렬
     * @return 정렬된 배열
     */
    public static String[] categoryToArraySort(Map<String, Integer> categoryMap){
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
    public static Food[] foodsToArraySort(Map<Food, Integer> foodMap){
        Food[] foods = foodMap.keySet().toArray(new Food[0]);
        Arrays.sort(foods, (o1, o2) ->{
            int value1 = o1.getIndex();
            int value2 = o2.getIndex();
            return value1 - value2;
        });
        return foods;
    }

    /**
     * 장바구니 내용 정렬
     * @param map 장바구니
     * @return 정렬된 배열
     */
    public static Food[] cartToArraySort(Map<Food, Integer> map){
        Food[] foods = map.keySet().toArray(new Food[0]);
        Arrays.sort(foods, ((o1, o2) -> {
            int value1 = o1.getCartIndex();
            int value2 = o2.getCartIndex();
            return value1 - value2;
        }));
        return foods;
    }
}
