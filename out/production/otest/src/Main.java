
import pers.lzb.platform.major.tools.Print;
import pers.lzb.platform.major.trunk.Start;

import java.io.IOException;


public class Main {
    /**
     * 平台的最初入口
     *
     * @author lzb
     */

    public static void main(String[] args) throws IOException {
        String fileName = "data.txt";  // 文件路径
        String foodFileName = "foodData.txt";  // 文件路径

        Print print = new Print();
        print.note("\n");

        print.print("欢迎来到庸叔的印度npc国际外卖平台！！");
        print.note("开始!");
        Start start = new Start();  // 进入选择注册或登录
        start.start(fileName, foodFileName);
    }
}