package pers.lzb.platform.major.tools;

import pers.lzb.platform.major.trunk.Account;

import java.io.*;
import java.util.*;

public class ReadFile {
    /**
     * 读取账号文件数据
     *
     * @param fileName 账号文件路径
     * @param array    存放数据的数组
     * @author lzb
     */
    public void readFile(String fileName, ArrayList<Account> array) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));  // 从字符输入流中读取文本并缓冲字符
        String line;
        while ((line = br.readLine()) != null) {  // 一次读取一行文本
            if (!line.isEmpty()) {  // 避免line是空行
                String[] str = line.split("大三角包擦肩曹三");  // 用该字符串分隔账号和密码，避免账号密码有奇怪东西
                Account account = new Account();
                account.setUsername(str[0]);
                account.setPassword(str[1]);
                array.add(account);
            }
        }
        br.close();
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 9ca00c1522d237e8c1b7547038182fa02ddc376f
