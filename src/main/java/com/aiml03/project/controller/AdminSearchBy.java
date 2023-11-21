package com.aiml03.project.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aiml03.project.model.bean.Person;
import com.aiml03.project.model.dao.PersonDAO;
import com.aiml03.project.util.ConnectionFactory;
import com.aiml03.project.util.PathConverter;

@WebServlet("/AdminSearchBy.do")
public class AdminSearchBy extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String buildingNum = request.getParameter("buildingNum");
		String unitNum = request.getParameter("unitNum");
		
		try 
		{
			Connection conn = ConnectionFactory.getConnection();
			PersonDAO personDAO = new PersonDAO(conn);
			
			List<Person> personList = personDAO.getAllPersonByBuildingNumberAndUnitNumber(buildingNum, unitNum);
			
			request.setAttribute("personList", personList);
			
			request.getRequestDispatcher(PathConverter.convertToWebInfPath("adminSearchBy")).forward(request, response);
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
