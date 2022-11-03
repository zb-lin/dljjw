package pers.lzb.platform;
import java.io.*;
import java.util.*;

public class ReadFile {

    // 读文件
    public void readFile(String fileName, ArrayList<Account> array) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = br.readLine()) != null) {
            String[] str = line.split(",");
            Account account = new Account();  //报错在Account在加一个就行
            account.setUsername(str[0]);
//            account.setPassword(str[1]);           //注释掉后也可以输入，不注释反而会数组越界
            array.add(account);
        }
        br.close();
    }
}
