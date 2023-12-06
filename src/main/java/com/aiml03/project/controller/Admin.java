package com.aiml03.project.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		// Clean Session Attributes
		HttpSession session = request.getSession();
		Enumeration<String> sNames = session.getAttributeNames();
		while(sNames.hasMoreElements())
		{
			String attributeName = (String)sNames.nextElement();
			if (!attributeName.equals("account"))
			{
				System.out.println("remove session attribute: " + attributeName);
				session.removeAttribute(attributeName);
			}
		}			
		
		String myPage = request.getParameter("myPage");
		
		if (myPage.equals("account"))
		{
			response.sendRedirect("account");
		}
		else if (myPage.equals("person"))
		{
			response.sendRedirect("buildingUnit?page=person");
		}
		else if (myPage.equals("plate"))
		{
			//response.sendRedirect("licensePlate1");
			response.sendRedirect("buildingUnit?page=plate");
		}
		else if (myPage.equals("search"))
		{
			response.sendRedirect("adminSearchBy");
		}
		else if (myPage.equals("face-log"))
		{
			response.sendRedirect("faceRecognitionHistory");
		}
		else if (myPage.equals("plate-log"))
		{
			response.sendRedirect("plateRecognitionHistory");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
