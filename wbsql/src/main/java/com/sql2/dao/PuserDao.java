package com.sql2.dao;

import com.sql2.entity.Puser;

import java.util.Map;

public interface PuserDao {

    public int getRowResult();

    public String getRowStringResult(int departmentId);

    public Puser getPuser(int userId);

    public Map getTableMapInfo(int userId);

    public Integer insertPuser(final Puser puser);

    public Integer queryByNameParameter(int departmentId);

    public int update(Puser puser);
}
