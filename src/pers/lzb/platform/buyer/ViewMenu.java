package pers.lzb.platform.buyer;


import pers.lzb.platform.account.tools.Print;

import java.io.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ViewMenu {
    /**
     * 看菜单
     *
     * @author lzb
     */
    public void viewMenu(Connection connection) throws IOException, SQLException {
        Print print = new Print();


        String sql = "SELECT id,shopName,food,price FROM test.npc";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();


        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String shopName = resultSet.getString("shopName");
            String foodName = resultSet.getString("food");
            String price = resultSet.getString("price");
            print.print(id + "  " + shopName + "  " + foodName + "  " + price);

        }
        resultSet.close();
        preparedStatement.close();

    }
}



