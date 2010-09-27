package org.mobile.common.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddSortServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		String method = req.getParameter("method");
		String parameter = req.getParameter("param");
		
		if (parameter == null || parameter.length() == 0) {
			System.out.println("输入信息不能够为空");
		} 
		if(method.equals("addSort")){
			System.out.println("method:" + method);
			System.out.println("parameter:" + parameter);
		}
//			if (parameter.equals("admin")) {
//				out.println("用户名 [" + parameter + "] 已经存在，请使用其他用户名");
//			} else {
//				out.println("用户名 [" + parameter + "] 尚未存在，可以使用该用户名注册");
//			}
	}
}
