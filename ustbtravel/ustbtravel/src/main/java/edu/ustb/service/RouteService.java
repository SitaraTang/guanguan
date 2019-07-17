package edu.ustb.service;

import edu.ustb.domain.Route;
import edu.ustb.vo.PageBean;

public interface RouteService {
	public PageBean<Route> pageQuery(int cid,int currentPage,int pageSize);
	public PageBean<Route> pageQuery(int cid,int currentPage,int pageSize,String rname);
}
