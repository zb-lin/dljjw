package pers.lzb.platform;

import java.io.IOException;
import java.util.ArrayList;

//查询菜品
public class FindFood {

    public void findFood(String foodFileName) throws IOException {
        ArrayList<Account> array = new ArrayList<>();
        ReadFile readFile = new ReadFile();
        readFile.readFile(foodFileName, array);
        if (array.size() == 0) {
            System.out.println("无信息！");
            System.out.println("请输入信息！");
        } else {
            for (Account account : array) {
                System.out.println(account.getUsername() + " " + account.getPassword());

            }
        }
    }

}
