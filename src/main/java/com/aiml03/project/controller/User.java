package com.aiml03.project.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aiml03.project.model.bean.*;
import com.aiml03.project.model.dao.PersonDAO;
import com.aiml03.project.util.ConnectionFactory;
import com.aiml03.project.util.PathConverter;

@WebServlet("/User.do")
public class User extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String myPage = request.getParameter("myPage");

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
		
		if (myPage.equals("profile")) 
		{
			Account account = (Account) session.getAttribute("account");
			
			String buildingNum = "", unitNum = "";
			if (account != null)
			{
				unitNum = account.getUserID().substring(1, account.getUserID().length());
				buildingNum = account.getUserID().substring(0, 1);
			}
			
			try 
			{
				Connection conn = ConnectionFactory.getConnection();
				PersonDAO personDAO = new PersonDAO(conn);
				List<Person> personList = personDAO.getAllPersonByBuildingNumberAndUnitNumber(buildingNum, unitNum);
				
				conn.close();
				request.setAttribute("personList", personList);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			
			request.getRequestDispatcher(PathConverter.convertToWebInfPath("userProfile")).forward(request, response);
		}
		else if (myPage.equals("lobby"))
		{
			
		}
		else if (myPage.equals("parking-lot"))
		{
			
		}
		else if (myPage.equals("chat"))
		{
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
