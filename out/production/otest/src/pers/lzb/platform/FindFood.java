package pers.lzb.platform;

import java.io.IOException;
import java.util.*;


//查询菜品
public class FindFood {

    public void findFood(String foodFileName) throws IOException {
        ArrayList<Menu> array = new ArrayList<Menu>();
        ReadMenu readMenu = new ReadMenu();
        readMenu.readMenu(foodFileName, array);
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入你的店名！");
        String shopName = sc.nextLine();

        boolean flag = true;

        for (int i = 0; i < array.size(); ++i) {
            if (shopName.equals(array.get(i).getShopName())) {
                flag = false;
            }
        }

        if (flag) {
            System.out.println("你还没有输入你的菜品！");
        } else {
            for (int i = 0; i < array.size(); ++i) {
                if (shopName.equals(array.get(i).getShopName())) {
                    System.out.println(array.get(i).getShopName() + " " + array.get(i).getFood() + " " + array.get(i).getPrice());
                }
            }
        }
    }
}
