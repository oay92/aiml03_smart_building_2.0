package com.aiml03.project.controller.page;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aiml03.project.util.DataFormat;
import com.aiml03.project.util.PathConverter;

@WebServlet("/account")
public class ToAccount extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		DataFormat format = new DataFormat();
		
		String display1 = format.formatString(request.getParameter("display1"));
		String display2 = format.formatString(request.getParameter("display2"));
		
		if (display1.equals("")) display1 = "none";
		if (display2.equals("")) display2 = "none";
		
		request.setAttribute("display1", display1);
		request.setAttribute("display2", display2);
		
		request.getRequestDispatcher(PathConverter.convertToWebInfPath(request.getServletPath())).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
