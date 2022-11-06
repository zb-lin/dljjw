package pers.lzb.platform.major.trunk;

import java.io.IOException;
import java.util.Scanner;

public class Start {
    public void start(String fileName, String foodFileName) throws IOException {
        while (true) {
            System.out.println("________________________");
            System.out.println("|如果你还没有注册,请按:1   |");
            System.out.println("|如果你已经注册,请按:2登录  |");
            System.out.println("|如果你想退出,请按:其他数字  |");
            System.out.println("|-----------------------|");
            Scanner sc = new Scanner(System.in);
            int number = sc.nextInt();
            StartChoice startChoice = new StartChoice();
            startChoice.startChoice(fileName, foodFileName, number);
        }
    }
}
