package com.aiml03.project.controller.page;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ToUserRegister")
public class ToUserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String selection1 = request.getParameter("selectedOption1");
		String selection2 = request.getParameter("selectedOption2");
		
		request.setAttribute("selection1", selection1);
		request.setAttribute("selection2", selection2);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/userRegister.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
