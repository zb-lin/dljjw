package pers.lzb.platform;

import java.io.*;
import java.util.*;

public class ReadFile {

    // 读文件
    public void readFile(String fileName, ArrayList<Account> array) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = br.readLine()) != null) {
            String[] str = line.split(" ");
            Account account = new Account();
            account.setUsername(str[0]);
            account.setPassword(str[1]);
            array.add(account);
        }
        br.close();
    }
}
