package pers.lzb.platform;

import java.io.*;
import java.util.*;

public class ReadFile {

    // 读文件
    public void readFile(String fileName, ArrayList<Account> array) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));  //从字符输入流中读取文本并缓冲字符
        String line;
        while ((line = br.readLine()) != null) {           //一次读取一行文本

            String[] str = line.split(" ");
            Account account = new Account();
            account.setUsername(str[0]);
            account.setPassword(str[1]);
            array.add(account);
        }
        br.close();
    }
}
