
package pers.lzb.platform.buyer;

import pers.lzb.platform.account.tools.AccountHandler;
import pers.lzb.platform.account.tools.Print;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Customer {
    /**
     * 顾客点餐开始页面
     *
     * @author lzb
     */
    public void customer(Connection connection) throws IOException, SQLException {
        Print print = new Print();
        Scanner sc = new Scanner(System.in);
        CustomerHandler customerHandler = new CustomerHandler();
        while (true) {
            print.print("如果你想看菜单,请按: 1 ");
            print.print("如果你想搜索某样菜,请按: 2");
            print.print("直接点餐请按其他数字");
            String num = sc.nextLine();
            if (num.equals("1")) {
                print.print("请看菜单！！");
                print.print("编号  店名  菜名  价格");
                CustomerHandler viewMenu = new CustomerHandler();
                viewMenu.viewMenu(connection);
            } else if (num.equals("2")) {
                customerHandler.fuzzySearch(connection);
            } else {
                break;
            }
        }
        customerHandler.order(connection);
        customerHandler.foodDelivery();
    }
}
