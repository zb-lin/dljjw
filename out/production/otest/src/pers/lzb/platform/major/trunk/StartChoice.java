package pers.lzb.platform.major.trunk;

import pers.lzb.platform.major.tools.SignUp;

import java.io.IOException;
import java.util.Scanner;

public class StartChoice {
    public void startChoice(String fileName, String foodFileName, int number) throws IOException {
        switch (number) {
            case 1:                                //注册
                SignUp signUp = new SignUp();
                signUp.signUp(fileName);
                break;
            case 2:                                //登录
                StartLogin startLogin = new StartLogin();
                startLogin.startLogin(fileName, foodFileName);
                break;
            default:              //退出
                System.exit(0);
        }
    }
}
