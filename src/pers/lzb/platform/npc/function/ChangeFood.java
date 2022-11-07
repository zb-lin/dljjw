package pers.lzb.platform.npc.function;

import pers.lzb.platform.major.tools.GetName;
import pers.lzb.platform.major.tools.Print;
import pers.lzb.platform.major.tools.Read;
import pers.lzb.platform.npc.change.ChangeFoodChoice;
import pers.lzb.platform.npc.judge.JudgeShopName;
import pers.lzb.platform.npc.trunk.Menu;

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class ChangeFood {
    /**
     * 改变菜单信息的方法的入口
     *
     * @param foodFileName 菜单文件路径
     * @author lzb
     */
    public void changeFood(String foodFileName) throws IOException {
        Read read = new Read();
        ArrayList<Menu> array;
        array = read.read(foodFileName);
        Scanner sc = new Scanner(System.in);
        Print print = new Print();

        print.print("请输入你的店名！");
        String shopName = sc.nextLine();

        JudgeShopName judgeShopName = new JudgeShopName();

        if (!judgeShopName.judgeShopName(array, shopName)) {
            print.printAndNote("你还没有输入你的菜品！", GetName.name + " 还未在 " + shopName + " 输入任何菜品");
        } else {
            ChangeFoodChoice changeFoodChoice = new ChangeFoodChoice();
            changeFoodChoice.changeFoodChoice(foodFileName, shopName);
        }
    }
}
