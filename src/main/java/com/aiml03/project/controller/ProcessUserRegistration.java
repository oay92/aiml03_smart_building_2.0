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
import javax.servlet.http.HttpSession;

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
		String myPhoto = request.getParameter("myPhoto");
				
		HttpSession session = request.getSession();
		Person person = (Person) session.getAttribute("person");
		person.setPhoto(myPhoto);
		
		try 
		{
			Connection conn = ConnectionFactory.getConnection();
			
			//Create a personDAO
			PersonDAO personDAO = new PersonDAO(conn);
		
			//Insert user information into the database
			personDAO.insertPerson(person);
			
			conn.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		response.sendRedirect("userRegister?buildingNum="+person.getBuildingNum()+"&unitNum="+person.getUnitNum());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}
