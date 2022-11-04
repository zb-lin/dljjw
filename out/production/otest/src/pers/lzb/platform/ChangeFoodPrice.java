package pers.lzb.platform;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ChangeFoodPrice {
    public void changeFoodPrice(String foodFileName, String shopName) throws IOException {
        ArrayList<Menu> array = new ArrayList<>();
        ReadMenu readMenu = new ReadMenu();
        readMenu.readMenu(foodFileName, array);
        Menu menu = new Menu();
        WriteMenu writeMenu = new WriteMenu();
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入你要修改的价格的菜名！");
        String foodName = sc.nextLine();

        boolean flag = true;

        for (int i = 0; i < array.size(); ++i) {
            if (shopName.equals(array.get(i).getShopName())) {
                if (foodName.equals(array.get(i).getFood())) {
                    flag = false;
                }
            }
        }

        if (flag) {
            System.out.println("你要修改的菜不存在！");
        } else {

            System.out.println("请输入新的价格！");
            String newFoodPrice = sc.nextLine();

            for (int i = 0; i < array.size(); ++i) {
                if (shopName.equals(array.get(i).getShopName())) {
                    if (foodName.equals(array.get(i).getFood())) {
                        menu.setShopName(shopName);
                        menu.setFood(foodName);
                        menu.setPrice(newFoodPrice);
                        array.set(i, menu);
                        writeMenu.writeMenu(foodFileName, array);
                    }
                }
            }
            System.out.println("修改成功！");
        }
    }
}
