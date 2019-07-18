package edu.ustb.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import edu.ustb.dao.RouteDao;
import edu.ustb.domain.Route;
import edu.ustb.domain.RouteImg;
import edu.ustb.util.JDBCUtils;

public class RouteDaoImpl implements RouteDao{
	private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
	
	@Override
	public int findTotalCount(int cid) {
		String sql = "select count(*) from tab_route where cid = ?";
		return template.queryForObject(sql, Integer.class,cid);
	}
	
	@Override
	public List<Route> findByPage(int cid,int start,int pagesize) {
		String sql = "select * from tab_route where cid = ? limit ?,?";
		return template.query(sql,new BeanPropertyRowMapper<Route>(Route.class),cid,start,pagesize);
	}
	
	@Override
	public int findTotalCount(int cid,String rname) {
		String sql = "select count(*) from tab_route where 1 = 1 ";
		StringBuilder stringBuilder = new StringBuilder(sql);
		List params = new ArrayList();
		if(cid != 0) {
			stringBuilder.append(" and cid = ? ");
			params.add(cid);
		}
		if(rname != null && rname.length() > 0) {
			stringBuilder.append(" and rname like ? ");
			params.add("%"+rname+"%");
		}
		sql = stringBuilder.toString();
		return template.queryForObject(sql, Integer.class,params.toArray());
	}
	
	@Override
	public List<Route> findByPage(int cid,int start,int pageSize,String rname) {
		String sql = "select * from tab_route where 1 = 1 ";
		StringBuilder stringBuilder = new StringBuilder(sql);
		List params = new ArrayList();
		if(cid != 0) {
			stringBuilder.append(" and cid = ? ");
			params.add(cid);
		}
		if(rname != null && rname.length() > 0) {
			stringBuilder.append(" and rname like ? ");
			params.add("%"+rname+"%");
		}
		stringBuilder.append(" limit ?,? ");
		sql = stringBuilder.toString();
		
		params.add(start);
		params.add(pageSize);
		
		return template.query(sql, new BeanPropertyRowMapper<Route>(Route.class),params.toArray());
	}
	
	@Override
	public List<Route> findByRid(int rid){
		String sql="select * from tab_route where rid=?";
		
		return template.query(sql, new BeanPropertyRowMapper<Route>(Route.class),rid);
	}
	
	@Override
	public List<RouteImg> findImgByRid(int rid){
		String sql="select * from tab_route_img where rid=?";
		
		return template.query(sql, new BeanPropertyRowMapper<RouteImg>(RouteImg.class),rid);

		
	}
}
