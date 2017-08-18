package com.crm.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class EncodingFilter implements Filter {

	//首先声明一个成员变量 用来保存当前应用的字符集名称
	private String charEncoding=null;
	
    public EncodingFilter() {
    	
    }

    
	public void init(FilterConfig fConfig) throws ServletException {
		//在部署描述符中设置该应用的默认字符编码集 在init方法中获取到该设置
		charEncoding=fConfig.getInitParameter("encoding");
		//如果字符编码的名称没有设置 就抛出一个异常
		if (charEncoding==null) {
			throw new ServletException("Encoding中的编码设置为空！！！");
		}
	}

	

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//如果当前应用的默认编码，与请求中的编码值不一致
		if (!charEncoding.equals(request.getCharacterEncoding())) {
			//那么就将请求中的编码设置成当前默认的编码设置
			request.setCharacterEncoding(charEncoding);
		}
		//将响应的编码设置也改成当前默认的编码设置
		response.setCharacterEncoding(charEncoding);
		chain.doFilter(request, response);
	}
	
	
	public void destroy() {
		
	}

	
}
