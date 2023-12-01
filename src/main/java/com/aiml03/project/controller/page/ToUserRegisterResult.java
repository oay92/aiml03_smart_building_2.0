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
		String buildingNum = request.getParameter("buildingNum");
		String unitNum = request.getParameter("unitNum");
		
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
		
		request.setAttribute("buildingNum", buildingNum);
		request.setAttribute("unitNum", unitNum);
		
		request.getRequestDispatcher(PathConverter.convertToWebInfPath(request.getServletPath())).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
