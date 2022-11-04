package pers.lzb.platform;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    public void order(String foodFileName) throws IOException {

        ArrayList<Menu> array = new ArrayList<>();
        ReadMenu readMenu = new ReadMenu();
        readMenu.readMenu(foodFileName, array);
        Scanner sc = new Scanner(System.in);


        System.out.println("请输入你要的店家！！");
        String shopName = sc.nextLine();

        System.out.println("请输入你要的菜！");
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
            System.out.println("你要的菜不存在！");
        }


        for (int i = 0; i < array.size(); ++i) {
            if (shopName.equals(array.get(i).getShopName())) {
                if (foodName.equals(array.get(i).getFood())) {
                    System.out.println("谢谢惠顾,一共是" + array.get(i).getPrice() + "元");
                }
            }
        }
    }
}
