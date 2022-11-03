package pers.lzb.platform;

import java.io.IOException;
import java.util.ArrayList;


public class Find {
    //查询npc
    public void Npc(String fileName) throws IOException {
        ArrayList<Account> array = new ArrayList<Account>();
        ReadFile readFile =new ReadFile();
        readFile.readFile(fileName, array);
        if (array.size() == 0) {
            System.out.println("无信息！");
            System.out.println("请输入信息！");
            return;
        } else {
            for (int i = 0; i < array.size(); ++i) {
                Account account = array.get(i);
                System.out.println(account.getUsername() + " " + account.getPassword());

            }
        }


    }

}
