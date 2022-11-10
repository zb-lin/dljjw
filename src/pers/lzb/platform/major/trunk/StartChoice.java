package pers.lzb.platform.major.trunk;

import pers.lzb.platform.major.tools.*;

import java.io.IOException;
import java.sql.SQLException;

public class StartChoice {
    /**
     * 选择进入不同入口进行注册,登录,注销,修改等操作
     *
     * @param fileName     账户文件路径
     * @param foodFileName 菜单文件路径
     * @param number       用户选择 1: 注册  2: 登录  3: 退出
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
                print.note("注销账号");
                DeleteAccount deleteAccount = new DeleteAccount();
                deleteAccount.deleteAccount();
                break;
            case 4:
                print.print("查询账号");
                DatabaseOperation.connect(3, 1, null, null);
                break;
            case 5:
                print.note("修改账号");
                ChangeAccount changeAccount = new ChangeAccount();
                changeAccount.changeAccount();
                break;
            default:  // 退出
                print.note(GetName.name + " 退出");
                print.print("\n");
                System.exit(0);
        }
    }

}

