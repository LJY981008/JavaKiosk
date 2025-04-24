package lv4andlv5.food;

/**
 * 음식들이 구현해야하는 인터페이스
 */
public interface Food {
    void printMenu(int count);
    void printMenu();
    void setCartIndex(int index);
    int getCartIndex();
    int getIndex();
    String getName();
    String getPrice();
    String getInformation();
    String getCategory();
}
