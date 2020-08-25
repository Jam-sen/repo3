package com.province.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.province.dao.ProvinceDao;
import com.province.entity.Province;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class InitProvinceServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProvinceDao dao = new ProvinceDao();
        List<Province> list = dao.initProvince();
        ObjectMapper mapper = new ObjectMapper ();
        String json = mapper.writeValueAsString (list);
        response.setContentType ("text/html;charset=UTF-8");
        response.getWriter ().print (json);
    }
}
