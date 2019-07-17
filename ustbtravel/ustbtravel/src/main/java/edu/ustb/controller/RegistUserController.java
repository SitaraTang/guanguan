package edu.ustb.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.ustb.domain.User;
import edu.ustb.service.UserService;
import edu.ustb.service.impl.UserServiceImpl;
import edu.ustb.vo.ResultInfo;

@WebServlet("/registUserServlet")
public class RegistUserController extends HttpServlet {
	private UserService service = new UserServiceImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取所有请求参数
		Map<String, String[]> map = request.getParameterMap();
		User user = new User();
		try {
			// 封装对象
			BeanUtils.populate(user, map);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		// 调用service添加会员

		boolean flag = service.regist(user);
		// 封装响应信息
		ResultInfo info = new ResultInfo();
		if (flag) {
			info.setFlag(true);
		} else {
			info.setFlag(false);
			info.setErrorMsg("注册失败");
		}
		// 将响应信息对象转变json字符串
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(info);
		// 将json数据写回客户端
		// 设置content-type
		response.setContentType("application/json;charset=utf-8");
		// 响应浏览器

		response.getWriter().write(result);

	}
	/*
	 * author:txq
	 * description:add doGet
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//验证校验
        String check = request.getParameter("check");
        //从sesion中获取验证码
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");//为了保证验证码只能使用一次
        //比较
        if(checkcode_server == null || !checkcode_server.equalsIgnoreCase(check)){
            //验证码错误
            ResultInfo info = new ResultInfo();
            //注册失败
            info.setFlag(false);
            info.setErrorMsg("验证码错误");
            //将info对象序列化为json
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(info);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(json);
            return;
        }
	}
}
