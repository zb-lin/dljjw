package pers.lzb.platform;

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class ChangeFood {
    public void changeFood(String foodFileName) throws IOException {
        Read read = new Read();
        ArrayList<Menu> array;
        array=read.read(foodFileName);
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入你的店名！");
        String shopName = sc.nextLine();

        JudgeShopName judgeShopName = new JudgeShopName();

        if (judgeShopName.judgeShopName(array,shopName)) {
            System.out.println("你还没有输入你的菜品！");
        } else {
            ChangeFoodChoice changeFoodChoice = new ChangeFoodChoice();
            changeFoodChoice.changeFoodChoice(foodFileName,shopName);
        }
    }
}
