package pers.lzb.platform.npc.function;

import pers.lzb.platform.major.tools.io.ReadNum;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFoodName {
    public void writeFoodName() throws IOException {
        ReadFoodNum readFoodNum = new ReadFoodNum();
        readFoodNum.readFoodNum();

        BufferedWriter bw = new BufferedWriter(new FileWriter("foodNum.txt"));

        int number = Integer.parseInt(ReadNum.num);
        number++;

        bw.write(Integer.toString(number));
        bw.newLine();
        bw.flush();
        bw.close();
    }
}
