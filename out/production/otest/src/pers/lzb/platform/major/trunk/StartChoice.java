package pers.lzb.platform.major.trunk;

import pers.lzb.platform.major.tools.Print;
import pers.lzb.platform.major.tools.SignUp;

import java.io.IOException;

public class StartChoice {
    /**
     * 选择进入不同入口
     *
     * @param fileName     账户文件路径
     * @param foodFileName 菜单文件路径
     * @param number       用户选择 1: 注册  2: 登录  3: 退出
     * @author lzb
     */
    public void startChoice(String fileName, String foodFileName, int number) throws IOException {
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
            default:  // 退出
                print.note("退出");
                System.exit(0);
        }
    }
}
