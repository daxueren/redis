package com.fiberhome.redis.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiberhome.redis.bean.Province;
import com.fiberhome.redis.dao.ProvinceDao;
import com.fiberhome.redis.dao.ProvinceDaoImpl;
import com.fiberhome.redis.utils.JedisPoolUtils;
import org.springframework.util.CollectionUtils;
import redis.clients.jedis.Jedis;

import java.util.Collections;
import java.util.List;

public class ProvinceServiceImpl implements ProvinceService{
    private ProvinceDao provinceDao = new ProvinceDaoImpl();
    @Override
    public List<Province> findAll() {
        List<Province> provinceList = provinceDao.findAll();
        return provinceList;
    }

    @Override
    public String findAllJson() {
        Jedis jedis = JedisPoolUtils.getJedis();
        String provinceJson = jedis.get("province");
        if (provinceJson==null || provinceJson.length()==0){
            System.out.println("cache not found data,loading datasource...");
            List<Province> provinceList = provinceDao.findAll();
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                provinceJson = objectMapper.writeValueAsString(provinceList);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            jedis.set("province", provinceJson);
            jedis.close();
        }else {
            System.out.println("loading cache...");
        }
        return provinceJson;
    }
}
