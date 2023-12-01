package com.aiml03.project.controller;

import java.io.IOException;
import java.sql.Connection;
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
import com.aiml03.project.util.ExecutePythonScript;

@WebServlet("/UpdateUserRegisterInfo.do")
public class UpdateUserRegisterInfo extends HttpServlet 
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
		
			PersonDAO personDAO = new PersonDAO(conn);
			personDAO.updatePersonInfoByID(person);
			
			// Call python script
			ExecutePythonScript pythonScript = new ExecutePythonScript();
			List<String> features = pythonScript.runPython(Integer.toString(person.getpID()));					
			
			personDAO.updateFacialFeatures(person.getpID(), features);
			
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
