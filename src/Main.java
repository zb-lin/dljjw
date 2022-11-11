
import pers.lzb.platform.account.tools.Print;
import pers.lzb.platform.account.major.Start;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;


public class Main {
    /**
     * 平台的最初入口
     *
     * @author lzb
     */
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        Print print = new Print();
        Scanner sc = new Scanner(System.in);

        print.print("欢迎来到庸叔的印度npc国际外卖平台！！");

        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/test";
        String userName = "root";
        String password = "123456";

        Connection conn = DriverManager.getConnection(url, userName, password);
        Start start = new Start();
        start.start(conn);
    }
}



