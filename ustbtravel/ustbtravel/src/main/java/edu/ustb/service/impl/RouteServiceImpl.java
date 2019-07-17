package edu.ustb.service.impl;

import java.util.List;

import edu.ustb.dao.RouteDao;
import edu.ustb.dao.impl.RouteDaoImpl;
import edu.ustb.domain.Route;
import edu.ustb.domain.RouteImg;
import edu.ustb.domain.Seller;
import edu.ustb.service.RouteService;
import edu.ustb.vo.PageBean;

public class RouteServiceImpl implements RouteService{
	private RouteDao routeDao = new RouteDaoImpl();
	
	@Override
	public PageBean<Route> pageQuery(int cid,int currentPage,int pageSize){
		PageBean<Route> pb = new PageBean<Route>();
		pb.setCurrentPage(currentPage);
		pb.setPageSize(pageSize);
		int totalCount = routeDao.findTotalCount(cid);
		pb.setTotalCount(totalCount);
		int start = (currentPage-1)*pageSize;
		List<Route> list = routeDao.findByPage(cid, start, pageSize);
		pb.setList(list);
		int totalPage = totalCount % pageSize == 0 ? totalCount/pageSize : totalCount/pageSize+1;
		pb.setTotalPage(totalPage);
		return pb;
	}
	
	@Override
	public PageBean<Route> pageQuery(int cid,int currentPage,int pageSize,String rname){
		PageBean<Route> pb = new PageBean<Route>();
		pb.setCurrentPage(currentPage);
		pb.setPageSize(pageSize);
		int totalCount = routeDao.findTotalCount(cid,rname);
		pb.setTotalCount(totalCount);
		int start = (currentPage-1)*pageSize;
		List<Route> list = routeDao.findByPage(cid, start, pageSize,rname);
		pb.setList(list);
		int totalPage = totalCount % pageSize == 0 ? totalCount/pageSize : totalCount/pageSize+1;
		pb.setTotalPage(totalPage);
		return pb;
	}
}
