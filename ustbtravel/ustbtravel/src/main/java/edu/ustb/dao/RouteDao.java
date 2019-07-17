package edu.ustb.dao;

import java.util.List;

import edu.ustb.domain.Route;

public interface RouteDao {

	public int findTotalCount(int cid);
	public List<Route> findByPage(int cid,int start,int pagesize);
	public int findTotalCount(int cid,String rname);
	public List<Route> findByPage(int cid,String start,int pageSize,String rname);
}
