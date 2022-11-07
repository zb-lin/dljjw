package pers.lzb.platform.major.trunk;


public class Account {
    /**
     * 账号信息
     */

    private String username;  // 用户名
    private String password;  // 密码

    public void setUsername(String username) {
        this.username = username;  // 取得用户名
    }

    public String getUsername() {
        return username;  // 返回用户名
    }

    public void setPassword(String password) {
        this.password = password;  // 取得密码
    }

    public String getPassword() {
        return password;  // 返回密码
    }

}