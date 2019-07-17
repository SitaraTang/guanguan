/**
 * author:txq
 * description:登录功能控制层
 */
package edu.ustb.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.ustb.domain.ResultInfo;
import edu.ustb.domain.User;
import edu.ustb.service.UserService;
import edu.ustb.service.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取用户名和密码数据
		Map<String, String[]> map = request.getParameterMap();
		// 封装User对象
		User user = new User();
		try {
			BeanUtils.populate(user, map);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		// 调用Service查询
		UserService service = new UserServiceImpl();
		User u = service.login(user);

		ResultInfo info = new ResultInfo();

		// 判断用户对象是否为null
		if (u == null) {
			// 用户名密码或错误
			info.setFlag(false);
			info.setErrorMsg("用户名密码或错误");
		}
		// 判断用户是否激活
		if (u != null && !"Y".equals(u.getStatus())) {
			// 用户尚未激活
			info.setFlag(false);
			info.setErrorMsg("您尚未激活，请激活");
		}
		// 判断登录成功
		if (u != null && "Y".equals(u.getStatus())) {
			request.getSession().setAttribute("user", u);// 登录成功标记

			// 登录成功
			info.setFlag(true);
		}

		// 响应数据
		ObjectMapper mapper = new ObjectMapper();

		response.setContentType("application/json;charset=utf-8");
		mapper.writeValue(response.getOutputStream(), info);
	}

}
