package pers.lzb.platform.npc.function;

import pers.lzb.platform.major.tools.io.ReadNum;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFoodNum {
    public void readFoodNum() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("foodNum.txt"));

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (!line.isEmpty()) {
                String[] num = line.split("");
                ReadNum.num = num[0];
            }
        }
    }
}
