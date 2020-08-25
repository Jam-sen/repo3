package com.province.controller;

import com.province.dao.ProvinceDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CityCountServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String provinceName = request.getParameter ("provinceName");
        ProvinceDao dao = new ProvinceDao ();
        int count = dao.cityCount (provinceName);
        response.setContentType ("text/html;charset=utf-8");
        PrintWriter printWriter = response.getWriter ();
        if (count != 0) {
            printWriter.print ("此省份共有" + count + "座城市");
        } else {
            printWriter.print ("无此省份数据");
        }
    }
}
