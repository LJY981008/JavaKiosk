package lv4andlv5.food;

/**
 * 음식들이 구현해야하는 인터페이스
 */
public interface Food {
    void printMyInfo(int count);    // 해당 메뉴를 출력 + 해당메뉴의 갯수
    void printMyInfo();             // 해당 메뉴를 출력
    void setCartIndex(int index);   // 장바구니에 들어가면 세팅되는 index
    int getCartIndex();             // 장바구니에 들어갔을 때 세팅된 index 반환
    int getIndex();                 // 메뉴판에서의 index
    String getName();               // 음식 이름
    String getPrice();              // 음식 가격
    String getInformation();        // 음식의 정보
    String getCategory();           // 음식의 카테고리
}
