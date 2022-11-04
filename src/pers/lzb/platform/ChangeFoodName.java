package pers.lzb.platform;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class ChangeFoodName {


    public void changeFoodName(String foodFileName, String shopName) throws IOException {
        ArrayList<Menu> array = new ArrayList<>();
        ReadMenu readMenu = new ReadMenu();
        readMenu.readMenu(foodFileName, array);
        Menu menu = new Menu();
        WriteMenu writeMenu = new WriteMenu();
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入你要修改的菜名！");
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

            System.out.println("请输入你新的菜名！");
            String newFoodName = sc.nextLine();

            if (newFoodName.equals(foodName)) {
                System.out.println("你的新菜名与旧菜名相同！");
            } else {
                for (int i = 0; i < array.size(); ++i) {
                    if (shopName.equals(array.get(i).getShopName())) {
                        menu.setShopName(shopName);
                        menu.setFood(newFoodName);
                        menu.setPrice(array.get(i).getPrice());
                        array.set(i, menu);
                        writeMenu.writeMenu(foodFileName, array);
                    }
                }
                System.out.println("修改成功！");
            }
        }


    }

}
