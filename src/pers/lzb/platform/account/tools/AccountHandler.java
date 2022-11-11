package pers.lzb.platform.account.tools;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class AccountHandler {
    public static class SignUp {
        /**
         * 注册交互界面
         *
         * @param connection 连接
         * @author lzb
         */
        public void signUp(Connection connection) throws IOException, ClassNotFoundException, SQLException {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Statement statement = connection.createStatement();
            Scanner sc = new Scanner(System.in);
            Print print = new Print();

            print.print("请输入id:");
            String id = sc.nextLine();

            String sql = " select id from account1 where id=? ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);  // 给sql语句的第1个问号赋值
            ResultSet res = ps.executeQuery();
            if (res.next()) {
                print.print("该用户已注册");
            } else {
                print.print("请输入密码：");
                print.print("你的密码必须同时包括数字和字母且大于3位");
                String password = sc.nextLine();
                String pattern = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{3,1000}$";  // 正则表达式


                if (!Pattern.matches(pattern, password)) {  // 判断password是否符合要求
                    print.print("你的密码必须同时包括数字和字母且大于3位");
                } else {
                    statement.executeUpdate("insert  into account1 value ('" + id + "','" + password + "')");
                    print.printAndNote("注册成功!", "用户注册成功,账号id为 " + id + ",密码为: " + password);
                }
            }


        }
    }

    public static class Login {
        /**
         * 登录交互界面
         *
         * @return 账号是否存在
         * @author lzb
         */
        public boolean login(Connection connection) throws IOException, SQLException {
            Print print = new Print();
            Scanner sc = new Scanner(System.in);

            print.print("请输入你的账号");
            String id = sc.nextLine();
            String sql1 = " select id from account1 where id=? ";
            PreparedStatement ps = connection.prepareStatement(sql1);
            ps.setString(1, id);  // 给sql语句的第1个问号赋值
            ResultSet res = ps.executeQuery();
            if (res.next()) {
                print.print("请输入密码");
                String password = sc.nextLine();
                String sql2 = "select * from account1 where id= ? and password= ?";
                PreparedStatement ps1 = connection.prepareStatement(sql2);
                ps1.setString(1, id);
                ps1.setString(2, password);
                ResultSet res1 = ps1.executeQuery();
                if (res1.next()) {
                    GetID getID = new GetID();
                    getID.getID(id);
                    print.printAndNote("登录成功！", GetID.ID + "登录成功");
                    ps.close();
                    res.close();
                    return true;
                } else {
                    print.print("密码错误");
                    ps.close();
                    res.close();
                }
            } else {
                print.print("该用户还未注册");
            }
            ps.close();
            res.close();
            return false;
        }

    }

    public static class DeleteAccount {
        /**
         * 利用MySQL注销账号(本地文件保留)
         *
         * @author lzb
         */
        public void deleteAccount(Connection connection) throws IOException, SQLException {
            Print print = new Print();
            Scanner sc = new Scanner(System.in);

            print.print("请输入注销的账号");
            String id = sc.nextLine();
            print.print("请输入密码");
            String password = sc.nextLine();

            String sql1 = "select id from account1 where id= ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String sql2 = "select * from account1 where id = ? and password =?";
                PreparedStatement preparedStatement1 = connection.prepareStatement(sql2);
                preparedStatement1.setString(1, id);
                preparedStatement1.setString(2, password);
                ResultSet resultSet1 = preparedStatement1.executeQuery();
                if (resultSet1.next()) {
                    String sql3 = "delete from account1 where id = ?";
                    PreparedStatement preparedStatement2 = connection.prepareStatement(sql3);
                    preparedStatement2.setString(1, id);
                    preparedStatement2.executeUpdate();
                    print.print("删除成功");
                    preparedStatement2.close();
                    resultSet1.next();
                } else {
                    print.print("密码错误");
                }
            } else {
                print.print("此账号未注册");
            }

            preparedStatement.close();
            resultSet.close();
        }
    }

    public static class ChangePassword {
        /**
         * 利用MySQL修改账号信息
         *
         * @author lzb
         */
        public void changePassword(Connection connection) throws IOException, SQLException {
            Print print = new Print();
            Scanner sc = new Scanner(System.in);
            print.print("请输入id");
            String id = sc.nextLine();

            print.print("请输入原来的密码");
            String oldPassword = sc.nextLine();


            String sql1 = " select id from account1 where id=? ";
            PreparedStatement ps = connection.prepareStatement(sql1);
            ps.setString(1, id);
            ResultSet res = ps.executeQuery();
            if (res.next()) {
                String sql2 = " select * from account1 where id= ? and password= ?";
                PreparedStatement ps1 = connection.prepareStatement(sql2);
                ps1.setString(1, id);
                ps1.setString(2, oldPassword);
                ResultSet res1 = ps1.executeQuery();
                if (res1.next()) {
                    print.print("请输入修改后的密码");
                    String newPassword = sc.nextLine();
                    String updateSql = "update account1 set password = ? where id = ?";//定义要执行的sql语句
                    PreparedStatement ps2 = connection.prepareStatement(updateSql);//在sql里执行语句
                    ps2.setString(1, newPassword);
                    ps2.setString(2, id);
                    ps2.executeUpdate();  // 执行更新
                    print.print("修改成功！");
                } else {
                    print.print("密码错误");
                }
            } else {
                print.print("此用户名还未注册，请先注册！");
            }

            ps.close();
            res.close();
        }
    }


}
