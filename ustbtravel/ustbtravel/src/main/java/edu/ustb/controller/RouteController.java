package edu.ustb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.ustb.domain.Route;
import edu.ustb.service.RouteService;
import edu.ustb.service.impl.RouteServiceImpl;
import edu.ustb.vo.PageBean;

/**
 * Servlet implementation class RouteController
 */
@WebServlet("/route/load")
public class RouteController extends BaseServlet {
	private RouteService routeServiceImpl = new RouteServiceImpl();


	public void load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取参数
		String cid = request.getParameter("cid");
		String currentPage = request.getParameter("currentPage");
		String rname = request.getParameter("rname");
		if(cid=="") {
			cid="0";
		}
		if(currentPage=="") {
			currentPage="1";
		}
		//调用业务，查询
		PageBean<Route> pb=new PageBean<Route>();
		pb = routeServiceImpl.pageQuery(Integer.parseInt(cid),Integer.parseInt(currentPage), 10,null);
		
		//响应数据
		writeValue(pb, response);
	}
}