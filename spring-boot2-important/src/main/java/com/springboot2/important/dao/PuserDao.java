package com.springboot2.important.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PuserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int getRowResult(){

        int rowCount = this.jdbcTemplate.
                queryForObject("select count(*)from puser",Integer.class);

        return rowCount;
    }
}

