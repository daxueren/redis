package com.fiberhome.redis.service;

import com.fiberhome.redis.bean.Province;

import java.util.List;

public interface ProvinceService {
    public List<Province> findAll();
    public String findAllJson();
}
