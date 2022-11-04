package pers.lzb.platform;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ChangeShopName {
    public void changeShopName(String foodFileName, String shopName) throws IOException {
        ArrayList<Menu> array = new ArrayList<>();
        ReadMenu readMenu = new ReadMenu();
        readMenu.readMenu(foodFileName, array);
        Menu menu = new Menu();
        WriteMenu writeMenu = new WriteMenu();
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入你新的店名！");
        String newShopName = sc.nextLine();
        if (newShopName.equals(shopName)) {
            System.out.println("你的新店名与旧店名相同！");
        } else {
            for (int i = 0; i < array.size(); ++i) {
                if (shopName.equals(array.get(i).getShopName())) {
                    menu.setShopName(newShopName);
                    menu.setFood(array.get(i).getFood());
                    menu.setPrice(array.get(i).getPrice());
                    array.set(i, menu);
                    writeMenu.writeMenu(foodFileName, array);
                }
            }
            System.out.println("修改成功！");
        }
    }
}
