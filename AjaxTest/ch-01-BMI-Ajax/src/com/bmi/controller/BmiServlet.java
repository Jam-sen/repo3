package com.bmi.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BmiServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String height = request.getParameter ("height");
        String weight = request.getParameter ("weight");
        float bmi = 0;
        if (height.trim ().length () > 0 && weight.trim ().length () > 0) {
            float h = Float.valueOf (height);
            float w = Float.valueOf (weight);
            bmi = w / (h * h);
        }
        response.setContentType ("text/html;charset=utf-8");
        PrintWriter printWriter = response.getWriter ();
        if (bmi <= 18.5) {
            printWriter.print ("您的bmi指数为" + bmi + ",过轻");
        } else if (bmi > 18.5 && bmi <= 23.9) {
            printWriter.print ("您的bmi指数为" + bmi + ",正常");
        } else if (bmi > 23.9 && bmi <= 27) {
            printWriter.print ("您的bmi指数为" + bmi + ",过重");
        } else if (bmi > 27 && bmi <= 32) {
            printWriter.print ("您的bmi指数为" + bmi + "，肥胖");
        } else {
            printWriter.print ("您的bmi指数为" + bmi + ",非常肥胖");
        }
    }
}
