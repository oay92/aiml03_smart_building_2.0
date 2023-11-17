package com.aiml03.project.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Admin.do")
public class Admin extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// Clean Request Attributes
		Enumeration<String> rNames = request.getAttributeNames();
		while(rNames.hasMoreElements())
		{
			request.removeAttribute((String)rNames.nextElement());
		}			
		
		String myPage = request.getParameter("myPage");
		
		if (myPage.equals("account"))
		{
			response.sendRedirect("account");
		}
		else if (myPage.equals("people"))
		{
			response.sendRedirect("people");
		}
		else if (myPage.equals("plate"))
		{
			response.sendRedirect("plate");
		}
		else if (myPage.equals("search"))
		{
			response.sendRedirect("search");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
