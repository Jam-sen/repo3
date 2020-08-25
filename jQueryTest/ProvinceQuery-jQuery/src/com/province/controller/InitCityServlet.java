package com.province.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.province.dao.CityDao;
import com.province.entity.City;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class InitCityServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding ("UTF-8");
        String id  = request.getParameter ("id");
        String json = "{\"name\":\"无城市信息\"}";
        CityDao dao = new CityDao ();
        List<City> list = new ArrayList<> ();
        if (id!=null){
            list = dao.initCity(Integer.parseInt (id));
        }
        if (list.size ()!=0){
            ObjectMapper objectMapper = new ObjectMapper ();
            json = objectMapper.writeValueAsString (list);
        }
        response.setContentType ("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter ();
        writer.print (json);
    }
}
