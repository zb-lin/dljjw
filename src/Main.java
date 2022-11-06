
import pers.lzb.platform.major.trunk.Start;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {
        String fileName = "data.txt";                     //文件路径
        String foodFileName = "foodData.txt";
        System.out.println("欢迎来到庸叔的印度npc国际外卖平台！！");
        Start start = new Start();
        start.start(fileName, foodFileName);
    }
}