package lv4andlv5.manager;

import lv4andlv5.food.Food;

import java.util.*;

public class Menu {
    private List<Food> foodList;
    private Map<String, Integer> categoris;

    public Menu(List<Food> items) {
        this.foodList = items;
        categoris = new HashMap<>();
        for(Food item : items){
            categoris.put(item.getCategori(), categoris.getOrDefault(item.getCategori(), 0) + 1);
        }
    }

    public int getCategoriSize(){
        return categoris.size();
    }
    public int getFoodListSize() {
        return foodList.size();
    }

    public String[] categoriToArray(){
        String[] array = categoris.keySet().toArray(new String[0]);
        Arrays.sort(array, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                char c1 = o1.charAt(0);
                char c2 = o2.charAt(0);
                return c1 - c2;
            }
        });
        return array;
    }

    public void printCategori(){
        String[] categoriArr = categoriToArray();
        System.out.println("[ Main Menu ]");
        for(String categori : categoriArr){
            System.out.println(categori);
        }
        System.out.println("0. 종료");
    }

    /**
     * 전체 메뉴 출력
     */
    public void printMenu(int index) {
        String[] categoriArr = categoriToArray();
        for (Food food : foodList) {
            if(food.getCategori().equals(categoriArr[index])){
                food.printMenu();
            }
        }
        System.out.println("0. 뒤로가기");
    }

    /**
     * 선택한 메뉴 출력
     */
    public void printSelect(int index) {
        System.out.print("선택한 메뉴 : ");
        foodList.get(index).printMenu();
        System.out.println("---------------------------------------------------------");
    }
}
