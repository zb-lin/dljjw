package pers.lzb.platform;

import java.io.*;
import java.util.*;

public class DeleteFood {
    public void deleteFood(String foodFileName) throws IOException {
        ArrayList<Menu> array = new ArrayList<>();
        ReadMenu readMenu = new ReadMenu();
        readMenu.readMenu(foodFileName, array);

        Scanner sc = new Scanner(System.in);

        System.out.println("请输入你的店名！");
        String shopName = sc.nextLine();
        boolean flag = true;
        for (int i = 0; i < array.size(); ++i) {
            if (array.get(i).getShopName().equals(shopName)) {
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("未找到该店铺信息！");
            return;
        }

        System.out.println("输入你想删除的菜品！");
        String food = sc.nextLine();

        for (int i = 0; i < array.size(); ++i) {
            if (array.get(i).getFood().equals(food)) {
                array.remove(i);
                WriteMenu writeMenu = new WriteMenu();
                writeMenu.writeMenu(foodFileName, array);
                System.out.println("删除成功！");
            }
        }
    }
}
