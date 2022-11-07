package pers.lzb.platform.major.tools;

import pers.lzb.platform.major.trunk.Account;

import java.io.IOException;
import java.util.ArrayList;

public class JudgePassword {
    /**
     * 判断账号密码是否正确
     *
     * @param array    存储账号信息的数组
     * @param username 用户名
     * @param password 密码
     * @return 查找结果
     * @author lzb
     */
    public boolean judgePassword(ArrayList<Account> array, String username, String password) throws IOException {
        Print print = new Print();
        for (int i = 0; i < array.size(); ++i) {
            if (username.equals(array.get(i).getUsername())) {
                if (password.equals(array.get(i).getPassword())) {
                    GetName getName = new GetName();
                    getName.getName(username);
                    print.printAndNote("密码正确！", GetName.name + "输入密码正确！");
                    print.printAndNote("登录成功！", GetName.name + "登录成功！");
                    return true;
                }
                print.printAndNote("密码错误！", "用户输入密码错误！");
                return false;
            }
        }
        print.printAndNote("用户不存在！", "用户输入账号不存在");
        print.print("请先注册！");
        return false;
    }

}

