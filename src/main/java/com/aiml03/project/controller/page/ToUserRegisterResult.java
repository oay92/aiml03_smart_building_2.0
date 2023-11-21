package com.aiml03.project.controller.page;

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
import com.aiml03.project.util.DataFormat;
import com.aiml03.project.util.PathConverter;

@WebServlet("/userRegisterResult")
public class ToUserRegisterResult extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		Person person = (Person) session.getAttribute("person");
	
		DataFormat format = new DataFormat();
		if (person != null && !format.formatString(person.getBuildingNum()).equals("") && !format.formatString(person.getUnitNum()).equals(""))
		{
			List<Person> personList = null;
			try 
			{
				Connection conn = ConnectionFactory.getConnection();
				PersonDAO personDAO = new PersonDAO(conn);
				
				personList = personDAO.getAllPersonByBuildingNumberAndUnitNumber(person.getBuildingNum(), person.getUnitNum());
				
				request.setAttribute("personList", personList);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			
			request.getRequestDispatcher(PathConverter.convertToWebInfPath(request.getServletPath())).forward(request, response);
		}
		else
		{
			response.sendRedirect("admin");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
