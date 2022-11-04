package pers.lzb.platform;

import java.io.*;
import java.util.*;

public class DeleteFood {
    public void deleteFood(String foodFileName) throws IOException {
        ArrayList<Menu> array = new ArrayList<>();
//        ReadMenu readMenu = new ReadMenu();
        ReadMenu.readMenu(foodFileName, array);
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除的菜的编号！");
        while (true) {
            String id = sc.nextLine();
//            System.out.println("请输入你的店名！");
//            String shopName = sc.nextLine();
//            System.out.println("输入你想删除的菜品！");
//            String food = sc.nextLine();
            int index = -1;
            for (int i = 0; i < array.size(); ++i) {
                Menu menu = array.get(i);
                if (menu.getID().equals(id)) {   //变量放在括号里面避免空指针
                    index = i;
                    break;
                }
            }
            if (index >= 0) {
                array.remove(index);
//                WriteMenu writeMenu = new WriteMenu();
                WriteMenu.writeMenu(foodFileName, array);
                System.out.println("删除成功！");
                break;
            } else {
                System.out.println("未找到该菜品！");
            }

        }
    }
}
