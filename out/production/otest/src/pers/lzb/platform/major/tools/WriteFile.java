package pers.lzb.platform.major.tools;

import pers.lzb.platform.major.trunk.Account;

import java.io.*;

import java.util.ArrayList;

public class WriteFile {
    /**
     * 将数组信息写入文件
     *
     * @param fileName 账号文件路径
     * @author lzb
     */
    public void writeFile(String fileName, ArrayList<Account> array) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));  // 写入
        for (int i = 0; i < array.size(); ++i) {
            Account account = array.get(i);
            bw.write(account.getUsername() + "大三角包擦肩曹三" + account.getPassword() // 用不会用到的字符串分隔账号密码
            );  // 写入到缓冲区
            bw.newLine();  // 换行
            bw.flush();  // 刷新缓冲流，把数据写入到文件里
        }
        bw.close();  // 关闭文件
    }

}
