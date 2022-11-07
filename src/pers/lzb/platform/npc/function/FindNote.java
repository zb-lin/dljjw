package pers.lzb.platform.npc.function;

import pers.lzb.platform.major.tools.GetName;
import pers.lzb.platform.major.tools.Print;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


public class FindNote {
    /**
     * 查询操作note
     *
     * @author lzb
     */
    public void findNote() throws IOException {
        Print print = new Print();

        BufferedReader bufferedReader = new BufferedReader(new FileReader("note.txt"));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] str = line.split(" ");
            if ((!line.isEmpty()) && GetName.name.equals(str[0])) {
                print.print(line);
            }
        }
        bufferedReader.close();
    }
}
