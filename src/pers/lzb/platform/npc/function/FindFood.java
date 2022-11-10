package pers.lzb.platform.npc.function;

import pers.lzb.platform.major.tools.io.GetName;
import pers.lzb.platform.major.tools.io.Print;
import pers.lzb.platform.major.tools.io.Read;
import pers.lzb.platform.npc.judge.JudgeShopName;
import pers.lzb.platform.npc.trunk.Menu;

import java.io.IOException;
import java.util.*;


//查询菜品
public class FindFood {
    /**
     * 查询菜名
     *
     * @param foodFileName 菜单文件路径
     * @author lzb
     */

    public void findFood(String foodFileName) throws IOException {
        Read read = new Read();
        ArrayList<Menu> array;
        array = read.read(foodFileName);
        Scanner sc = new Scanner(System.in);
        Print print = new Print();

        print.print("请输入你的店名！");
        String shopName = sc.nextLine();

        JudgeShopName judgeShopName = new JudgeShopName();
        if (!judgeShopName.judgeShopName(array, shopName)) {
            print.printAndNote("你还没有添加任何菜", GetName.name + " 在 " + shopName + " 未输入菜品");
        } else {
            for (int i = 0; i < array.size(); ++i) {
                if (shopName.equals(array.get(i).getShopName())) {
                    print.print(array.get(i).getShopName() + " " + array.get(i).getFood() + " " + array.get(i).getPrice() + "元");
                    print.note(GetName.name + " 查找到 " + array.get(i).getShopName() + " 的菜品 " + array.get(i).getFood() + ",价格为 " + array.get(i).getPrice() + "元");
                }
            }
        }
    }
}
