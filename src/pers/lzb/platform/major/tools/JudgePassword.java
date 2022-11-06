package pers.lzb.platform.major.tools;

import pers.lzb.platform.major.trunk.Account;

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
    public boolean judgePassword(ArrayList<Account> array, String username, String password) {
        for (int i = 0; i < array.size(); ++i) {
            if (username.equals(array.get(i).getUsername())) {
                if (password.equals(array.get(i).getPassword())) {
                    System.out.println("密码正确！");
                    System.out.println("登录成功！");
                    return true;
                }
                System.out.println("密码错误！");
                return false;
            }
        }
        System.out.println("用户不存在！");
        System.out.println("请先注册！");
        return false;
    }
}
