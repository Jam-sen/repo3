package com.province.dao;

import com.province.entity.Province;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProvinceDao {
    public Province queryProvinceById(String provinceId) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Province province = null;
        try {
            Class.forName ("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection ("jdbc:mysql://localhost:3306/province", "root", "yaosen..");
            preparedStatement = conn.prepareStatement ("select *from province where Id=?");
            if (provinceId.trim ().length () > 0) {
                preparedStatement.setInt (1, Integer.parseInt (provinceId));
                resultSet = preparedStatement.executeQuery ();
                if (resultSet.next ()) {
                    province = new Province (resultSet.getInt ("Id"), resultSet.getString ("name"), resultSet.getString ("jiancheng"), resultSet.getString ("shenghui"));
                }
            } else {
                province = new Province ();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        } catch (SQLException throwables) {
            throwables.printStackTrace ();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close ();
                } catch (SQLException throwables) {
                    throwables.printStackTrace ();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close ();
                } catch (SQLException throwables) {
                    throwables.printStackTrace ();
                }
            }
            if (conn != null) {
                try {
                    conn.close ();
                } catch (SQLException throwables) {
                    throwables.printStackTrace ();
                }
            }
        }
        return province;
    }

    public List<String> fuzzySearch(String provinceName) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<String> list = new ArrayList<> ();
        try {
            Class.forName ("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection ("jdbc:mysql://localhost:3306/province", "root", "yaosen..");
            String s = "select name from province where name like '%" + provinceName + "%'";
            preparedStatement = conn.prepareStatement (s);
            resultSet = preparedStatement.executeQuery ();
            while (resultSet.next ()) {
                list.add (resultSet.getString (1));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        } catch (SQLException throwables) {
            throwables.printStackTrace ();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close ();
                } catch (SQLException throwables) {
                    throwables.printStackTrace ();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close ();
                } catch (SQLException throwables) {
                    throwables.printStackTrace ();
                }
            }
            if (conn != null) {
                try {
                    conn.close ();
                } catch (SQLException throwables) {
                    throwables.printStackTrace ();
                }
            }
        }
        return list;
    }

    public int cityCount(String provinceName) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Province province = null;
        try {
            Class.forName ("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection ("jdbc:mysql://localhost:3306/province", "root", "yaosen..");
            preparedStatement = conn.prepareStatement ("select count(c.provinceid) from province p join city c on p.id=c.provinceid where p.name=? group by c.provinceid;");
            preparedStatement.setString (1, provinceName);
            resultSet = preparedStatement.executeQuery ();
            if (resultSet.next ()) {
                return resultSet.getInt (1);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        } catch (SQLException throwables) {
            throwables.printStackTrace ();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close ();
                } catch (SQLException throwables) {
                    throwables.printStackTrace ();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close ();
                } catch (SQLException throwables) {
                    throwables.printStackTrace ();
                }
            }
            if (conn != null) {
                try {
                    conn.close ();
                } catch (SQLException throwables) {
                    throwables.printStackTrace ();
                }
            }
        }
        return 0;
    }
}
