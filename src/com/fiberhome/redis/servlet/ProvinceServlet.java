package com.fiberhome.redis.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiberhome.redis.bean.Province;
import com.fiberhome.redis.service.ProvinceService;
import com.fiberhome.redis.service.ProvinceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/provinceServlet")
public class ProvinceServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ProvinceService provinceService = new ProvinceServiceImpl();
//        List<Province> provinceList = provinceService.findAll();
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String json = objectMapper.writeValueAsString(provinceList);
//        System.out.println(json);

        ProvinceService provinceService = new ProvinceServiceImpl();
        String json = provinceService.findAllJson();
        System.out.println(json);

        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(json);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
