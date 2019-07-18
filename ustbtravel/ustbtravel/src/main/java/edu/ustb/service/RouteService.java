package edu.ustb.service;

import java.util.List;

import edu.ustb.domain.Route;
import edu.ustb.domain.RouteImg;
import edu.ustb.vo.PageBean;

public interface RouteService {
	public PageBean<Route> pageQuery(int cid,int currentPage,int pageSize);
	public PageBean<Route> pageQuery(int cid,int currentPage,int pageSize,String rname);
	public Route findByRid(int rid);
	public List<RouteImg> findImgByRid(int rid);
}
