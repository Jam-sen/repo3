package com.province.dao;

import com.province.entity.Province;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProvinceDao {
    public List<Province> initProvince() {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Province> list = new ArrayList<> ();
        try {
            Class.forName ("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection ("jdbc:mysql://localhost:3306/province", "root", "yaosen..");
            preparedStatement = conn.prepareStatement ("select *from province");
            resultSet = preparedStatement.executeQuery ();
            while (resultSet.next ()) {
                list.add (new Province (resultSet.getInt (1), resultSet.getString ("name"), resultSet.getString ("jiancheng"), resultSet.getString ("shenghui")));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        } catch (SQLException throwables) {
            throwables.printStackTrace ();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close ();
                }
                if (preparedStatement != null) {
                    preparedStatement.close ();
                }
                if (conn != null) {
                    conn.close ();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace ();
            }
        }
        return list;
    }
}
