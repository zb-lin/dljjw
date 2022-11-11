package pers.lzb.platform.account.major;

import pers.lzb.platform.account.tools.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class StartChoice {
    /**
     * 选择进入不同入口进行注册,登录,管理员登录等操作
     *
     * @author lzb
     */
    enum Operation {
        SIGNUP, LOGIN, CHANGE, DELETE
    }

    public void startChoice(Operation operation, Connection conn) throws IOException, SQLException, ClassNotFoundException {
        Print print = new Print();
        if (operation == Operation.SIGNUP) {
            AccountHandler.SignUp signUp = new AccountHandler.SignUp();
            signUp.signUp(conn);
        } else if (operation == Operation.LOGIN) {
            StartLogin startLogin = new StartLogin();
            startLogin.startLogin(conn);
        } else if (operation == Operation.CHANGE) {
            AccountHandler.ChangePassword changePassword = new AccountHandler.ChangePassword();
            changePassword.changePassword(conn);

        } else if (operation == Operation.DELETE) {
            AccountHandler.DeleteAccount deleteAccount = new AccountHandler.DeleteAccount();
            deleteAccount.deleteAccount(conn);
        }


    }

}
