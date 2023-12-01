package com.aiml03.project.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aiml03.project.model.bean.Person;
import com.aiml03.project.model.bean.Plate;
import com.aiml03.project.model.dao.PersonDAO;
import com.aiml03.project.model.dao.PlateDAO;
import com.aiml03.project.util.ConnectionFactory;
import com.aiml03.project.util.PathConverter;

@WebServlet("/BuildingUnit.do")
public class BuildingUnit extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String page = request.getParameter("page");
		String buildingNum = request.getParameter("buildingNum");
		String unitNum = request.getParameter("unitNum");
						
		HttpSession session = request.getSession();
		
		try 
		{
			Connection conn = ConnectionFactory.getConnection();
			
			if (page.equals("person"))
			{
				PersonDAO personDAO = new PersonDAO(conn);
				boolean found = personDAO.isPersonFoundByBuildingNumberAndUnitNumber(buildingNum, unitNum);
			
				conn.close();
				
				if (!found)
					response.sendRedirect("userRegister?buildingNum="+buildingNum+"&unitNum="+unitNum);
				else
					response.sendRedirect("userRegisterResult?buildingNum="+buildingNum+"&unitNum="+unitNum);
			}
			else if (page.equals("plate"))
			{
				PlateDAO plateDAO = new PlateDAO(conn);
				boolean found = plateDAO.isNumberPlateExistByBuildingNumAndUnitNum(buildingNum, unitNum);
				
				conn.close();
				
				if (!found)
					response.sendRedirect("numberPlate?buildingNum="+buildingNum+"&unitNum="+unitNum);
				else
					response.sendRedirect("numberPlateResult?buildingNum="+buildingNum+"&unitNum="+unitNum);				
			}
			else
			{
				
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
