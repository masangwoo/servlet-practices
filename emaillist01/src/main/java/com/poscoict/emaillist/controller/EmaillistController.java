package com.poscoict.emaillist.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poscoict.emaillist.dao.EmaillistDao;
import com.poscoict.emaillist.vo.EmaillistVo;

public class EmaillistController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String actionName = request.getParameter("a");
		
		if("list".equals(actionName)) {
			
		}else if("form".equals(actionName)){
			
		}else if("add".equals(actionName)){
			String firstName = request.getParameter("fn");
        	String lastName = request.getParameter("ln");
        	String email = request.getParameter("email");
        	
        	EmaillistVo vo = new EmaillistVo();
    		vo.setFirstName(firstName);
    		vo.setLastName(lastName);
    		vo.setEmail(email);
    		
    		new EmaillistDao().insert(vo);
    		
    		response.sendRedirect(request.getContextPath()+"/el");
		}else {
			EmaillistDao dao = new EmaillistDao();
			List<EmaillistVo> list = dao.findAll();
			
			request.setAttribute("list",list);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
