package pers.lzb.platform;

import java.io.*;

import java.util.ArrayList;

public class WriteFile {
    public void writeFile(String fileName, ArrayList<Account> array) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));   //写入
        for (int i = 0; i < array.size(); ++i) {
            Account account = array.get(i);
            StringBuilder sb = new StringBuilder();
            sb.append(account.getUsername() + " " + account.getPassword());
            bw.write(sb.toString());    //写入到缓冲区
            bw.newLine();                 //换行
            bw.flush();                    //刷新缓冲流，把数据写入到文件里
        }
        bw.close();                     //关闭
    }

}
