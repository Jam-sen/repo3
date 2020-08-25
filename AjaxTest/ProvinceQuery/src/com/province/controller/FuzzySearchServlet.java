package com.province.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.province.dao.ProvinceDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FuzzySearchServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String provinceName = request.getParameter ("provinceName");
        ProvinceDao dao = new ProvinceDao ();
        List<String> list= dao.fuzzySearch(provinceName);
        String fuzzyName ="";
        for (String name :
                list) {
            fuzzyName += name+" ";
        }
        response.setContentType ("text/html;charset=utf-8");
        PrintWriter printWriter = response.getWriter ();
        printWriter.print (fuzzyName);
    }
}
