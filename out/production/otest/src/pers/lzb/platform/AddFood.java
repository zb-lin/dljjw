package pers.lzb.platform;

import java.io.*;
import java.util.*;

public class AddFood {
    public void addFood(String foodFileName) throws IOException {
        Read read = new Read();
        ArrayList<Menu> array = read.read(foodFileName);

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的店名！");
        String shopName = sc.nextLine();

        System.out.println("请输入菜的名字！");
        String foodName = sc.nextLine();

<<<<<<< HEAD
        JudgeFood judgeFood = new JudgeFood();
        if (judgeFood.judgeFood(array, shopName, foodName)) {
            System.out.println("你已经添加过该菜品！");
            return;
=======
        for (int i = 0; i < array.size(); ++i) {
            if (array.get(i).getShopName().equals(shopName)) {
                if (array.get(i).getFood().equals(food)) {
                    System.out.println("你已经添加过该菜品！");
                    return;
                }
            }
>>>>>>> 913256cc50054b46235986208786b218c86e5f2f
        }
        System.out.println("请输入菜的价格！");
        String price = sc.nextLine();

        Set set = new Set();
        set.set(array, foodFileName, shopName, foodName, price);
        System.out.println("您的菜品已添加成功！！");

    }

}

