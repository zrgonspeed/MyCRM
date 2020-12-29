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
        
		if (path.contains("login") || 
				path.contains("/js/") || 
				path.contains("/image/") || 
				path.contains("/media/")  ||
				path.contains("/img/") || 
				path.contains("/css/")
				 || path.contains("/images/")) {
			
			// ����
			chain.doFilter(request, response); 
			return;
		}
		
		HttpSession session = req.getSession();
		HrEmployee emp = (HrEmployee) session.getAttribute("emp");
		
		// ���session�д���emp֤���û���¼�����Է��С�������Ϊδ��½�ض���login.jsp
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
