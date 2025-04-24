package lv4andlv5.food;

/**
 * 모든 음식 데이터 구현 기본값
 */
public abstract class FoodCommon implements Food{
    private final int index;
    private final String name;
    private final String price;
    private final String information;

    public FoodCommon(int index, String name, double price, String information){
        this.index = index;
        this.name = name;
        this.price = String.valueOf(price);
        this.information = information;
    }
    // 음식번호
    @Override
    public int getIndex(){
        return index;
    }
    // 음식이름
    @Override
    public String getName(){
        return name;
    }
    // 음식 정보
    @Override
    public String getInformation() {
        return information;
    }
    // 음식 가격
    @Override
    public String getPrice() {
        return price;
    }
    // 내 정보 출력
    @Override
    public void printMenu() {
        System.out.println(getIndex() + ". " + getName() + "\t| W " + getPrice() + "\t | " + getInformation());
    }
}
