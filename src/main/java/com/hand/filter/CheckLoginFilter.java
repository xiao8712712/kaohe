package com.hand.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class CheckLoginFilter
 */
public class CheckLoginFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public CheckLoginFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest arg0 = (HttpServletRequest) request;
		HttpServletResponse arg1 = (HttpServletResponse) response;
		arg0.setCharacterEncoding("UTF-8");
		arg1.setCharacterEncoding("UTF-8");
		String name = null;
		System.out.println("============过滤器开始执行====================");
		name = (String) arg0.getSession().getAttribute("name");
		System.out.println(name);
		System.out.println(arg0.getServletPath().toString());
		System.out.println(arg0.getContextPath());
		if ((name == null)
				&& ((arg0.getServletPath().equals("/index.jsp")) || (arg0.getServletPath().equals("/ServletTest")))) {// 没登陆前，访问index和SerletTest时不用进行权限校验
			chain.doFilter(request, response);
		}
		if (name == null) {
			arg0.setAttribute("msg", "没有登陆！请先登陆！");
			arg0.getRequestDispatcher("/index.jsp").forward(arg0, arg1);
		}
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}
}
