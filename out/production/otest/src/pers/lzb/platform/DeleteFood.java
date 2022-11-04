package pers.lzb.platform;

import java.io.*;
import java.util.*;

public class DeleteFood {
    public void deleteFood(String foodFileName) throws IOException {
        ArrayList<Menu> array = new ArrayList<>();
        ReadMenu readMenu = new ReadMenu();
        readMenu.readMenu(foodFileName, array);
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入要删除的菜的编号！");
            String id = sc.nextLine();
//            System.out.println("请输入你的店名！");
//            String shopName = sc.nextLine();
//            System.out.println("输入你想删除的菜品！");
//            String food = sc.nextLine();
            boolean flag = true;
            for (int i = 0; i < array.size(); ++i) {
                Menu menu = array.get(i);
                if (menu.getID().equals(id)) {   //变量放在括号里面避免空指针
                    array.remove(i);
                    WriteMenu writeMenu = new WriteMenu();
                    writeMenu.writeMenu(foodFileName, array);
                    System.out.println("删除成功！");
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("未找到该信息");
            }
            System.out.println("按1返回选择系统！");
            int num = sc.nextInt();
            if (num == 1) {
                break;
            }
        }
    }
}
