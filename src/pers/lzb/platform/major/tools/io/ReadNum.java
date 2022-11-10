package pers.lzb.platform.major.tools.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class ReadNum {

    public static String num;

    /**
     * 读取文件中数字,数字为目前主键下一位
     *
     * @author lzb
     */

    public void readNum() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("num.txt"));

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (!line.isEmpty()) {
                String[] num = line.split("");
                ReadNum.num = num[0];
            }
        }
    }
}
