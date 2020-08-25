package com.province.dao;

import com.province.entity.City;
import com.province.entity.Province;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDao {
    public List<City> initCity(int id) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<City> list = new ArrayList<> ();
        try {
            Class.forName ("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection ("jdbc:mysql://localhost:3306/Province", "root", "yaosen..");
            preparedStatement = conn.prepareStatement ("select name from city where provinceid=?");
            preparedStatement.setInt (1,id);
            resultSet = preparedStatement.executeQuery ();
            while (resultSet.next ()) {
                City city = new City ();
                city.setName (resultSet.getString ("name"));
                list.add (city);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        } catch (SQLException throwables) {
            throwables.printStackTrace ();
        }
        return list;
    }
}
