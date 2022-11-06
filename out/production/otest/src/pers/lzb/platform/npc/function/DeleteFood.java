package pers.lzb.platform.npc.function;

import pers.lzb.platform.major.tools.GetName;
import pers.lzb.platform.major.tools.Print;
import pers.lzb.platform.major.tools.Read;
import pers.lzb.platform.npc.judge.JudgeFoodInFor;
import pers.lzb.platform.npc.judge.JudgeShopName;
import pers.lzb.platform.npc.trunk.Menu;
import pers.lzb.platform.npc.trunk.WriteMenu;

import java.io.*;
import java.util.*;

public class DeleteFood {
    /**
     * 删除菜品
     *
     * @param foodFileName 菜单文件路径
     * @author lzb
     */
    public void deleteFood(String foodFileName) throws IOException {
        Read read = new Read();
        ArrayList<Menu> array;
        array = read.read(foodFileName);
        Print print = new Print();

        Scanner sc = new Scanner(System.in);

        print.print("请输入你的店名！");
        String shopName = sc.nextLine();

        JudgeShopName judgeShopName = new JudgeShopName();
        if (!judgeShopName.judgeShopName(array, shopName)) {
            print.printAndNote("未找到该店铺信息！", GetName.name+"输入不存在的店铺");
            return;
        }

        print.print("输入你想删除的菜品！");
        String foodName = sc.nextLine();
        JudgeFoodInFor judgeFoodInFor = new JudgeFoodInFor();

        for (int i = 0; i < array.size(); ++i) {
            if (judgeFoodInFor.judgeFoodInFor(array, shopName, foodName, i)) {
                array.remove(i);
                WriteMenu writeMenu = new WriteMenu();
                writeMenu.writeMenu(foodFileName, array);
                print.printAndNote("删除成功！",GetName.name+"删除"+shopName+"的"+foodName);
                return;
            }
        }
        print.printAndNote("未找到该菜品!",GetName.name+"未输入"+foodName);
    }
}
