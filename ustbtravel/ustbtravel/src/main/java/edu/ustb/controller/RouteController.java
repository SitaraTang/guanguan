package edu.ustb.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.ustb.domain.Route;
import edu.ustb.domain.RouteImg;
import edu.ustb.domain.User;
import edu.ustb.service.RouteService;
import edu.ustb.service.FavoriteService;
import edu.ustb.service.impl.FavoriteServiceImpl;
import edu.ustb.service.impl.RouteServiceImpl;
import edu.ustb.service.RouteService;
import edu.ustb.vo.PageBean;

/**
 * Servlet implementation class RouteController
 */
@WebServlet("/route/*")
public class RouteController extends BaseServlet {
	private RouteService routeServiceImpl = new RouteServiceImpl();
	private FavoriteService favoriteService = new FavoriteServiceImpl();


	public void load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取参数
		String cid = request.getParameter("cid");
		String currentPage = request.getParameter("currentPage");
		String rname = request.getParameter("rname");
		PageBean<Route> pb=new PageBean<Route>();
		if(cid=="") {
			cid="0";
		}
		if(currentPage=="") {
			currentPage="1";
		}
		if("null".equals(rname)) {
			pb = routeServiceImpl.pageQuery(Integer.parseInt(cid),Integer.parseInt(currentPage), 10,null);
		}
		//调用业务，查询
		else {
			pb = routeServiceImpl.pageQuery(Integer.parseInt(cid),Integer.parseInt(currentPage), 10,rname);
		}
		//响应数据
		writeValue(pb, response);
	}

	public void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rid = request.getParameter("rid");
		Route route = new Route();
		List<RouteImg> routeImgList=new ArrayList();
		route = routeServiceImpl.findByRid(Integer.parseInt(rid));
		routeImgList = routeServiceImpl.findImgByRid(Integer.parseInt(rid));
		route.setRouteImgList(routeImgList);
		writeValue(route, response);
	}
	
	public void addFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rid=request.getParameter("rid");  
		User user = (User) request.getSession().getAttribute("user");
		favoriteService.saveFavorite(user, rid);
	}
}
