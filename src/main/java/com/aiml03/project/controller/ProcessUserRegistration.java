package com.aiml03.project.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

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
import com.aiml03.project.util.ExecutePythonScript;

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
		
		int pID = 0;
		try 
		{
			Connection conn = ConnectionFactory.getConnection();
			
			//Create a personDAO
			PersonDAO personDAO = new PersonDAO(conn);
		
			//Insert user information into the database
			personDAO.insertPerson(person);
			pID = personDAO.getLastInsertPID();
			
			
			// Call python script
			ExecutePythonScript pythonScript = new ExecutePythonScript();
			List<String> features = pythonScript.runPython(Integer.toString(pID));		
						
			personDAO.insertFacialFeatures(pID, features);
			
			conn.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
				
		session.removeAttribute("person");
		response.sendRedirect("userRegisterResult?buildingNum="+person.getBuildingNum()+"&unitNum="+person.getUnitNum());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}
