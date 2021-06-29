package com.fiberhome.redis.dao;

import com.fiberhome.redis.bean.Province;
import com.fiberhome.redis.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProvinceDaoImpl implements ProvinceDao{
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Province> findAll() {
        String sql = "select * from province";
        List<Province> provinceList = jdbcTemplate.query(sql,new BeanPropertyRowMapper<Province>(Province.class));
        return provinceList;
    }
}
