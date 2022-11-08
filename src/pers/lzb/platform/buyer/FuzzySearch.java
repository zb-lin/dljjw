package pers.lzb.platform.buyer;

import pers.lzb.platform.major.tools.Print;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.HashMap;
import java.util.Scanner;

public class FuzzySearch {
    /**
     * 实现对菜单的单字段模糊搜索
     *
     * @author lzb
     */
    public void fuzzySearch() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("foodData.txt"));
        Scanner sc = new Scanner(System.in);
        Print print = new Print();
        print.print("请输入关键词");

        HashMap<String, Integer> hashMap = new HashMap<>();
        String key = sc.nextLine();
        String[] str = key.split("");

        String line;
        int maxCount = 0;
        while ((line = bufferedReader.readLine()) != null) {
            if (!line.isEmpty()) {
                int count = 0;  // 记录这一行出现几个关键字
                for (int i = 0; i < str.length; ++i) {
                    int number = line.indexOf(str[i]);  // 这一行出现key的某个字符时count++
                    if (number != -1) {
                        ++count;
                    }
                }
                if (count > maxCount) {
                    maxCount = count;
                }
                hashMap.put(line, count);
            }
        }

        bufferedReader = new BufferedReader(new FileReader("foodData.txt"));  // 将line重头读起
        for (int i = maxCount; i >= 0; --i) {
            while ((line = bufferedReader.readLine()) != null) {  // 每次循环后linePut==null
                if ((!line.isEmpty()) && (hashMap.get(line) == i)) {
                    String[] strings = line.split("!@#%#@!#@#@");
                    for (int j = 0; j < strings.length; ++j) {
                        System.out.print(strings[j] + " ");
                    }
                    print.print("");
                }
            }
            bufferedReader = new BufferedReader(new FileReader("foodData.txt"));  // 将line重头读起
        }
    }
}
