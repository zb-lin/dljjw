package pers.lzb.platform.major.tools;

import pers.lzb.platform.major.tools.io.Print;

import java.io.IOException;
import java.util.Scanner;

public class DeleteAccount {
    /**
     * 利用MySQL注销账号(本地文件保留)
     *
     * @author lzb
     */
    public void deleteAccount() throws IOException {

        Print print = new Print();
        print.print("请输入要注销的账号id");
        Scanner sc = new Scanner(System.in);
        String id = sc.nextLine();
        DatabaseOperation.connect(2, id, null, null);
    }
}
