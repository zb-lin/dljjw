package pers.lzb.platform;

import java.io.*;

import java.util.ArrayList;

public class WriteFile {
    public void writeFile(String fileName, ArrayList<Account> array) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        for (int i = 0; i < array.size(); ++i) {
            Account account = array.get(i);
            StringBuilder sb=new StringBuilder();  //！！
            sb.append(account.getUsername() + "," + account.getPassword());
            bw.write(sb.toString());
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }

}
