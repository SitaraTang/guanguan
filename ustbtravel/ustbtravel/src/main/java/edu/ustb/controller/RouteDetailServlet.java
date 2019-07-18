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

/**
 * Servlet implementation class RouteDetailServlet
 */
@WebServlet("/RouteDetailServlet")
public class RouteDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RouteService routeService=new RouteService();
	Route route=new Route();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RouteDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session=request.getSession();
		
		int id=Integer.parseInt(request.getParameter("route.rid"));
		
		List<Route> list=new ArrayList();
		
		List<Route>=routeService.findByRid(id);
		
		
	}
	

}
