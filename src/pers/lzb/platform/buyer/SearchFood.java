package pers.lzb.platform.buyer;

import pers.lzb.platform.major.tools.Print;
<<<<<<< HEAD
=======
import pers.lzb.platform.major.tools.Read;
import pers.lzb.platform.npc.trunk.Menu;
>>>>>>> 9ca00c1522d237e8c1b7547038182fa02ddc376f

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
<<<<<<< HEAD
=======
import java.util.ArrayList;
>>>>>>> 9ca00c1522d237e8c1b7547038182fa02ddc376f
import java.util.Scanner;

public class SearchFood {
    /**
     * 用于买家的搜索操作
     *
     * @author lzb
     */


    public void searchFood() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("foodData.txt"));
        Scanner sc = new Scanner(System.in);
        Print print = new Print();
        print.print("请输入关键词");
        String key = sc.nextLine();

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (!line.isEmpty()) {
                int number = line.indexOf(key);  // 查找子字符串
                if (number != -1) {
                    String[] strings = line.split("阿斯达多所大所");
                    for (int i = 0; i < strings.length; ++i) {
                        System.out.print(strings[i] + " ");
                    }
                    print.print("");  // 吞掉换行符
                }

            }
        }

    }
}
