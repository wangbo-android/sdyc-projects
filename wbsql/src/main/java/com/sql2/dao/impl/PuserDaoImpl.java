package com.sql2.dao.impl;

import com.sql2.dao.PuserDao;
import com.sql2.entity.Puser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

@Repository
public class PuserDaoImpl implements PuserDao{

    @Autowired
    private JdbcTemplate jtl;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public int getRowResult() {

        return this.jtl.
                queryForObject("select count(*)from puser",Integer.class);
    }

    @Override
    public String getRowStringResult(int departmentId) {

        return null;
    }

    @Override
    public Puser getPuser(int userId) {

        String sql = "select * from puser where id=?";

        Puser puser = jtl.queryForObject(sql,new UserRowMapper(),userId);

        return puser;
    }

    @Override
    public Map getTableMapInfo(int userId){

        String sql = "select * from puser where id=?";

        return jtl.queryForMap(sql,userId);
    }

    @Override
    public Integer insertPuser(Puser puser) {

        final String sql = "insert into puser(name,department_id) values(?,?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jtl.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {

                PreparedStatement ps = connection.prepareStatement(sql,new String[]{"id"});

                ps.setString(1,puser.getName());
                ps.setInt(2,puser.getDepartmentId());

                return ps;
            }
        },keyHolder);

        return keyHolder.getKey().intValue();
    }

    @Override
    public Integer queryByNameParameter(int departmentId){

        String sql = "select count(1) from puser where department_id=:departmentId";

        MapSqlParameterSource namedParamters = new MapSqlParameterSource();
        namedParamters.addValue("departmentId",departmentId);
        Integer count = namedParameterJdbcTemplate.queryForObject(sql,namedParamters,Integer.class);

        return count;
    }

    @Override
    public int update(Puser puser) {

        String sql = "update puser set name=:name and department_id=:departmentId where id=:id";

        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(puser);

        return namedParameterJdbcTemplate.update(sql,sqlParameterSource);
    }

    static class UserRowMapper implements RowMapper<Puser>{

        @Nullable
        @Override
        public Puser mapRow(ResultSet resultSet, int i) throws SQLException {

            Puser puser = new Puser();

            puser.setId(resultSet.getInt("id"));
            puser.setName(resultSet.getString("name"));
            puser.setDepartmentId(resultSet.getInt("department_id"));
            puser.setCreateTime(resultSet.getDate("create_time"));

            return puser;
        }
    }
}
