package com.crm.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class PermissionFilter implements Filter {

	
	public PermissionFilter() {

	}

	
	public void init(FilterConfig fConfig) throws ServletException {

	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		/**
		 * 首先将参数中的ServletRequest和ServletResponse强制转换为
		 * HttpServletRequest和HttpServletResponse
		 */
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		// 获取请求中的ServletPath
		String servletPath = req.getServletPath();
		
		// 获取session对象
		HttpSession session = req.getSession();
		
		// 获取session对象中的flag值
		String flag = (String) session.getAttribute("flag");
		
		// 如果用户访问的是首页 或者是login.jsp 或者执行登录操作 那么就将请求转发给下一个组件进行处理
		if (servletPath != null && (servletPath.equals("/xcrm/nav/login.jsp") 
				|| (servletPath.equals("/xcrm/nav/register.jsp"))
				||(servletPath.equals("/xcrm/nav/index.jsp"))
				
				||(servletPath.equals("/xcrm/img/1.png"))
				||(servletPath.equals("/xcrm/img/2.png"))
				||(servletPath.equals("/xcrm/img/3.png"))
				||(servletPath.equals("/xcrm/img/4.png"))
				
				||(servletPath.equals("/xcrm/nav/look_more.jsp"))
				|| (servletPath.equals("/checkRegisterServlet"))
				|| (servletPath.equals("/checkLoginServlet"))
				||(servletPath.equals("/xcrm/nav/about.jsp")))) {
			
			chain.doFilter(request, response);
			
		} else {
			
			/**
			 * 业务逻辑： 对于请求的其他url都会进行权限校验
			 * 如果用户处于登录状态 可以直接进行访问
			 */
			if (flag != null && flag.equals("login_success")) {
				
				chain.doFilter(request, response);
				
				// 如果用户登录失败 返回login.jsp
			} else if (flag != null && flag.equals("login_error")) {
				
				// 同时提示用户 登录失败
				req.setAttribute("msg", "登录失败，请重新登录！！！<br />");
				
				// 同时把用户所访问的url保存到request对象中
				req.setAttribute("return_uri", servletPath);
				RequestDispatcher rd = req.getRequestDispatcher("/xcrm/nav/login.jsp");
				rd.forward(req, resp);
				
			} else {
				
				// 如果用户没有登录 同样也返回login.jsp 提示 尚未登录
				req.setAttribute("msg", "您尚为登录！！！");
				
				// 同样将用户访问的url保存到request对象中
				req.setAttribute("return_uri", servletPath);
				RequestDispatcher rd = req.getRequestDispatcher("/xcrm/nav/login.jsp");
				rd.forward(req, resp);
			}
		}

	}

	
	public void destroy() {

	}

}
