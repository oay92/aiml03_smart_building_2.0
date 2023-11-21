package com.aiml03.project.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aiml03.project.model.dao.AccountDAO;
import com.aiml03.project.util.ConnectionFactory;

@WebServlet("/Account.do")
public class CreateAccount extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String level = request.getParameter("level");
		String userID = request.getParameter("userID");
		String password = request.getParameter("password");
		
		request.removeAttribute("display1");
		request.removeAttribute("display2");
		
		try 
		{
			Connection conn = ConnectionFactory.getConnection();
			AccountDAO account = new AccountDAO(conn);

			boolean found = account.isAccountExist(userID);
			
			if (found)
			{
				conn.close();
				response.sendRedirect("account?display1=block");
			}
			else
			{
				account.insertAccountInfo(userID, password, level);
				
				conn.close();
				response.sendRedirect("account?display2=block");
			}			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}
