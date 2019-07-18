package edu.ustb.dao;

import java.util.List;

import edu.ustb.domain.Route;
import edu.ustb.domain.RouteImg;

public interface RouteDao {

	public int findTotalCount(int cid);
	public List<Route> findByPage(int cid,int start,int pagesize);
	public int findTotalCount(int cid,String rname);
	public List<Route> findByPage(int cid,int start,int pageSize,String rname);
	public List<Route> findByRid(int rid);
	public List<RouteImg> findImgByRid(int rid);
}
