package pers.lzb.platform.major.tools;

import pers.lzb.platform.major.trunk.Account;

import java.io.*;
import java.util.*;

public class ReadFile {

    // 读文件
    public void readFile(String fileName, ArrayList<Account> array) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));  //从字符输入流中读取文本并缓冲字符
        String line;
        while ((line = br.readLine()) != null) {           //一次读取一行文本
<<<<<<< HEAD:src/pers/lzb/platform/major/tools/ReadFile.java
=======

>>>>>>> 913256cc50054b46235986208786b218c86e5f2f:src/pers/lzb/platform/ReadFile.java
            String[] str = line.split(" ");
            Account account = new Account();
            account.setUsername(str[0]);
            account.setPassword(str[1]);
            array.add(account);
        }
        br.close();
    }
}
