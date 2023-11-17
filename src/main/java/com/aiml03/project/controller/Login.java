package com.aiml03.project.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aiml03.project.model.bean.Account;
import com.aiml03.project.model.dao.AccountDAO;
import com.aiml03.project.util.ConnectionFactory;

@WebServlet("/Login.do")
public class Login extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String userID = request.getParameter("userID");
		String password = request.getParameter("password");
		
		// Clean Request Attributes
		Enumeration<String> rNames = request.getAttributeNames();
		while(rNames.hasMoreElements())
		{
			request.removeAttribute((String)rNames.nextElement());
		}		
				
		try 
		{
			Connection conn = ConnectionFactory.getConnection();
			AccountDAO accountDAO = new AccountDAO(conn);
			Account account = accountDAO.findAccountByUserIDAndPassword(userID, password);
			
			if (account == null)
			{
				request.setAttribute("error", "Login Failed !!");
				request.getRequestDispatcher("login").forward(request, response);
			}
			else
			{
				HttpSession session = request.getSession();
				session.setAttribute("account", account);
				
				if (account.getUpdatePassword() == 1)
					response.sendRedirect("changePassword?display=none");					
				else if (account.getLevel().equals("admin"))
					response.sendRedirect("admin");
				else if (account.getLevel().equals("user"))
					response.sendRedirect("user");
			}
		
			conn.close();
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
