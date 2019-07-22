package edu.ustb.dao.impl;


import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import edu.ustb.dao.RtDao;
import edu.ustb.domain.Route;
import edu.ustb.util.JDBCUtils;

import java.util.List;

public class RtDaoImpl implements RtDao {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());

    public List<Route> find(int cid) {
        String sql="select * from tab_route where cid = ? ";
        return template.query(sql,new BeanPropertyRowMapper<Route>(Route.class),cid);
    }
}
