package pers.lzb.platform.major.trunk;

import pers.lzb.platform.major.tools.*;
import pers.lzb.platform.major.tools.io.GetName;
import pers.lzb.platform.major.tools.io.Print;
import pers.lzb.platform.major.trunk.administrator.Administrator;

import java.io.IOException;
import java.sql.SQLException;

public class StartChoice {
    /**
     * 选择进入不同入口进行注册,登录,管理员登录等操作
     *
     * @param fileName     账户文件路径
     * @param foodFileName 菜单文件路径
     * @param number       用户选择 1: 注册  2: 登录  3: 修改信息  4: 管理员登录
     * @author lzb
     */
    public void startChoice(String fileName, String foodFileName, int number) throws IOException, SQLException {
        Print print = new Print();
        switch (number) {
            case 1:  // 注册
                print.note("注册");
                SignUp signUp = new SignUp();  // 进入注册
                signUp.signUp(fileName);
                break;
            case 2:  // 登录
                print.note("登录");
                StartLogin startLogin = new StartLogin();  // 进入登录
                startLogin.startLogin(fileName, foodFileName);
                break;

            case 3:
                print.print("管理员登录");
                Administrator administrator = new Administrator();
                administrator.administrator();
                break;

            default:  // 退出
                print.note(GetName.name + " 退出");
                print.print("\n");
                System.exit(0);
        }
    }

}

