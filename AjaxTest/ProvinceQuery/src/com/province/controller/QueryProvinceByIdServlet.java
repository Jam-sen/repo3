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

public class QueryProvinceByIdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String provinceId = request.getParameter ("provinceId");
        ProvinceDao dao = new ProvinceDao ();
        if (provinceId!=null){
            Province province = dao.queryProvinceById(provinceId);
            if (province != null) {
                //创建出Json工具包中的ObjectMapper对象
                ObjectMapper objectMapper=new ObjectMapper ();
                //writeValueAsString（）方法将对象转换为json格式字符串
                String json = objectMapper.writeValueAsString (province);
                response.setContentType ("text/html;charset=utf-8");
                PrintWriter printWriter= response.getWriter ();
                printWriter.print (json);
                System.out.println (json);
            }
        }
    }
}
