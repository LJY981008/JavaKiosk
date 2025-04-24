package lv3;

public class MainLv3 {
    public static void main(String[] args) {
        MenuItem[] items = new MenuItem[4];
        items[0] = new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        items[1] = new MenuItem("SmokeShack", 8.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        items[2] = new MenuItem("Cheeseburger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        items[3] = new MenuItem("Hamburger", 5.4, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");

        Kiosk kiosk = new Kiosk(items);
        kiosk.start();
    }
}
