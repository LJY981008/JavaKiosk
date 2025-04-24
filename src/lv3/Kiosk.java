package lv3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<MenuItem> menuItems = new ArrayList<>();
    Kiosk(MenuItem[] items){
        this.menuItems.addAll(Arrays.asList(items));
    }
    public void start(){

    }
}
