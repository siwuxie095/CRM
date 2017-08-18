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

public class PermissionXFilter implements Filter {

    public PermissionXFilter() {
    	
    }

    public void init(FilterConfig fConfig) throws ServletException {
		
	}
    
	

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
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
		String crmName = (String) session.getAttribute("crmName");
		
		if (servletPath != null && (servletPath.equals("/xcrm/nav/index.jsp"))
				||(servletPath.equals("/xcrm/nav/look_more.jsp"))
				
				||(servletPath.equals("/xcrm/img/1.png"))
				||(servletPath.equals("/xcrm/img/2.png"))
				||(servletPath.equals("/xcrm/img/3.png"))
				||(servletPath.equals("/xcrm/img/4.png"))
				
				|| (servletPath.equals("/xcrm/nav/login.jsp"))
				|| (servletPath.equals("/xcrm/nav/register.jsp"))
				|| (servletPath.equals("/checkLoginServlet"))
				|| (servletPath.equals("/checkRegisterServlet"))
				|| (servletPath.equals("/logoutServlet"))
				||(servletPath.equals("/xcrm/nav/about.jsp"))
				||(servletPath.equals("/xcrm/crm_mgt/add_crm_info.jsp"))
				||(servletPath.equals("/addCrmInfoServlet"))
				||(servletPath.equals("/xcrm/crm_mgt_jump/add_succ.jsp"))
				
				||(servletPath.equals("/xcrm/js/role.js"))
				||(servletPath.equals("/xcrm/js/role.data.js"))
				||(servletPath.equals("/xcrm/js/jquery-1.11.0.min.js"))
				||(servletPath.equals("/xcrm/css/main.css"))
				
				||(servletPath.equals("/xcrm/crm_mgt_jump/lack_crm_info.jsp"))) {
			
			chain.doFilter(request, response);
			
		} else {
		
				if (crmName != null ) {
					chain.doFilter(request, response);
				}else {
					req.setAttribute("msg", "请先添加个人信息再进行操作，跳转中...<br />");
					String foward="/xcrm/crm_mgt_jump/lack_crm_info.jsp";
					RequestDispatcher rd = req.getRequestDispatcher(foward);
					rd.forward(req, resp);
				}
				
		}
	}

	
	public void destroy() {
	}

}
