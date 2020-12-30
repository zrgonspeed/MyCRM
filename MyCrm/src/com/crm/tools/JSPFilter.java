package com.crm.tools;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.crm.info.HrEmployee;

public class JSPFilter implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		String path = req.getRequestURI();
        
		request.setCharacterEncoding("utf-8");
		
		if (path.contains("login") || 
				path.contains("/js/") || 
				path.contains("/image/") || 
				path.contains("/media/")  ||
				path.contains("/img/") || 
				path.contains("/css/")
				 || path.contains("/images/")) {
			
			// 放行
			chain.doFilter(request, response); 
			return;
		}
		
		HttpSession session = req.getSession();
		HrEmployee emp = (HrEmployee) session.getAttribute("emp");
		
		// 如果session中存在emp证明用户登录，可以放行。否则认为未登陆重定向到login.jsp
		if (emp == null) {
			res.sendRedirect(req.getContextPath() + "/login.jsp");
		} else {
			chain.doFilter(request, response);
		}

	}

	public void destroy() {
	}

	public void init(FilterConfig arg0) throws ServletException {
	}
}
