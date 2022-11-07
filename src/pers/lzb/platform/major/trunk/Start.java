package pers.lzb.platform.major.trunk;


import pers.lzb.platform.major.tools.Print;

import java.io.IOException;
import java.util.Scanner;


public class Start {
    /**
     * 通过输入数字进入选择方法
     *
     * @param fileName     账户文件路径
     * @param foodFileName 菜单文件路径
     * @author lzb
     */
    public void start(String fileName, String foodFileName) throws IOException {
        Print print = new Print();
        while (true) {
            print.print("如果你还没有注册,请按: 1");
            print.print("如果你已经注册,请按: 2 登录");
            print.print("如果你想退出,请按: 其他数字");


            Scanner sc = new Scanner(System.in);
            int number = sc.nextInt();
            StartChoice startChoice = new StartChoice();
            startChoice.startChoice(fileName, foodFileName, number);
        }
    }
}