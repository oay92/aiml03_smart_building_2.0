package com.aiml03.project.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aiml03.project.model.bean.Person;
import com.aiml03.project.model.dao.PersonDAO;
import com.aiml03.project.util.ConnectionFactory;
import com.aiml03.project.util.DataFormat;

@WebServlet("/ProcessUserRegistration.do")
public class ProcessUserRegistration extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//Retrieve from data
		String buildingNum = request.getParameter("buildingNum");
		String unitNum = request.getParameter("unitNum");				
		String userName = request.getParameter("userName");
		String userEmail = request.getParameter("userEmail");
		String userPhone = request.getParameter("userPhone");		
		String[] contact = request.getParameterValues("primaryContact");
		
		DataFormat format = new DataFormat();
		int primary = 0;		
		if (contact != null)
			primary = ((format.formatString(contact[0]).equals("1")) ? 1: 0);
		
		String userPhoto = "";
		

		Person person = new Person(0, buildingNum, unitNum, userName, userEmail, userPhone, userPhoto, primary, 0);
	
		try 
		{
			Connection conn = ConnectionFactory.getConnection();
			
			//Create a personDAO
			PersonDAO personDAO = new PersonDAO(conn);
		
			//Insert user information into the database
			personDAO.insertPerson(person);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		response.sendRedirect("userRegister?buildingNum="+buildingNum+"&unitNum="+unitNum);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}
