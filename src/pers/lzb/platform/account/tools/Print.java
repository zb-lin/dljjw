package pers.lzb.platform.account.tools;


import java.io.*;

public class Print {
    /**
     * 普通输出
     *
     * @param str 输出的字符串
     * @author lzb
     */

    public void print(String str) {

        System.out.println(str);
    }

    /**
     * 输出并计入日记
     *
     * @param string 输出内容
     * @param str    日记内容
     * @author lzb
     */
    public void printAndNote(String string, String str) throws IOException {

        System.out.println(string);
        FileWriter fileWriter = new FileWriter("note.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.append(str);
        bufferedWriter.newLine();
        bufferedWriter.close();
        fileWriter.close();
    }

    /**
     * 记日记
     *
     * @param str 计入日记内容
     * @author lzb
     */

    public void note(String str) throws IOException {

        FileWriter fileWriter = new FileWriter("note.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.append(str);
        bufferedWriter.newLine();
        bufferedWriter.close();
        fileWriter.close();
    }
}
