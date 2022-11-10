package pers.lzb.platform.major.tools;

import java.io.IOException;
import java.util.Scanner;

public class DeleteAccount {
    /**
     * 利用MySQL注销账号
     *
     * @author lzn
     */
    public void deleteAccount() throws IOException {

        Print print = new Print();
        print.print("请输入要注销的账号id");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        DatabaseOperation.connect(2, id, null, null);
    }
}
