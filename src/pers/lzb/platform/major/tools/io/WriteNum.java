package pers.lzb.platform.major.tools.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteNum {
    /**
     * 对常量num+1,实现id自增
     *
     * @author lzb
     */
    public void writeNum() throws IOException {
        ReadNum readNum = new ReadNum();
        readNum.readNum();

        BufferedWriter bw = new BufferedWriter(new FileWriter("num.txt"));

        int number = Integer.parseInt(ReadNum.num);
        number++;

        bw.write(Integer.toString(number));
        bw.newLine();
        bw.flush();
        bw.close();

    }

}
