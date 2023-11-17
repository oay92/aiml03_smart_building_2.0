package com.aiml03.project.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aiml03.project.model.bean.Account;
import com.aiml03.project.model.dao.AccountDAO;
import com.aiml03.project.util.ConnectionFactory;

@WebServlet("/ChangePassword.do")
public class ChangePassword extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String password = request.getParameter("password1");

		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("account");
		
		try 
		{
			Connection conn = ConnectionFactory.getConnection();
			AccountDAO accountDAO = new AccountDAO(conn);
			
			accountDAO.updatePassword(password, account.getaID());
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		response.sendRedirect("changePassword?display=block");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
