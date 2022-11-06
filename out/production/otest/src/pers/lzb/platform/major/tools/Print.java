package pers.lzb.platform.major.tools;


import java.io.*;

public class Print {
    /**
     * 代替系统输出,记录操作日志
     *
     * @param str 输出的字符串
     * @author lzb
     */

    public void print(String str) {
        System.out.println(str);
    }

    public void printAndNote(String string, String str) throws IOException {
        System.out.println(string);
        FileWriter fw = new FileWriter("note.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.append(str);
        bw.newLine();
        bw.close();
        fw.close();
    }

    public void note(String str) throws IOException {
        FileWriter fw = new FileWriter("note.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.append(str);
        bw.newLine();
        bw.close();
        fw.close();
    }
}
