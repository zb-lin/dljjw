package pers.lzb.platform;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AddFood {
    public void addFood(String foodFileName) throws IOException {
        ArrayList<Menu> array = new ArrayList<>();
        ReadMenu readMenu = new ReadMenu();
        readMenu.readMenu(foodFileName, array);
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入菜的编号！");
        String id = sc.nextLine();

        System.out.println("请输入你的店名！");
        String shopName = sc.nextLine();

        System.out.println("请输入菜的名字！");
        String foodOne = sc.nextLine();

        System.out.println("请输入菜的价格！");
        String priceOne = sc.nextLine();

//        System.out.println("请输入你第二道菜的名字！");
//        String foodTwo = sc.nextLine();
//
//        System.out.println("请输入你第二道菜的名字价格！");
//        String priceTwo = sc.nextLine();

        Menu menu = new Menu();
        menu.setID(id);
        menu.setShopName(shopName);
        menu.setFoodOne(foodOne);
        menu.setPriceOne(priceOne);
//        menu.setFoodTwo(foodTwo);
//        menu.setPriceTwo(priceTwo);

        array.add(menu);
        WriteMenu writeMenu = new WriteMenu();
        writeMenu.writeMenu(foodFileName, array);
        System.out.println("您的菜品已添加成功！！");


    }

}

