package pers.lzb.platform;

import java.io.*;
import java.util.*;

public class AddFood {
    public void addFood(String foodFileName) throws IOException {
        ArrayList<Menu> array = new ArrayList<>();
        ReadMenu readMenu = new ReadMenu();
        readMenu.readMenu(foodFileName, array);
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的店名！");
        String shopName = sc.nextLine();

        System.out.println("请输入菜的名字！");
        String food = sc.nextLine();

        for (int i = 0; i < array.size(); ++i) {
            if (array.get(i).getShopName().equals(shopName)) {
                if (array.get(i).getFood().equals(food)) {
                    System.out.println("你已经添加过该菜品！");
                    return;
                }
            }
        }

        System.out.println("请输入菜的价格！");
        String price = sc.nextLine();

        Menu menu = new Menu();
        menu.setShopName(shopName);
        menu.setFood(food);
        menu.setPrice(price);


        array.add(menu);
        WriteMenu writeMenu = new WriteMenu();
        writeMenu.writeMenu(foodFileName, array);
        System.out.println("您的菜品已添加成功！！");

    }

}

