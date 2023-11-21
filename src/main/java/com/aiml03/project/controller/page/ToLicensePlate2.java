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

import com.aiml03.project.model.bean.Plate;
import com.aiml03.project.model.bean.Person;
import com.aiml03.project.model.dao.PlateDAO;
import com.aiml03.project.model.dao.PersonDAO;
import com.aiml03.project.util.ConnectionFactory;
import com.aiml03.project.util.PathConverter;

@WebServlet("/licensePlate2")
public class ToLicensePlate2 extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String buildingNum = request.getParameter("buildingNum");
		String unitNum = request.getParameter("unitNum");
		
		request.setAttribute("buildingNum", buildingNum);
		request.setAttribute("unitNum", unitNum);
		
		try 
		{
			Connection conn = ConnectionFactory.getConnection();
			
			PlateDAO plateDAO = new PlateDAO(conn);
			List<Plate> plateList = plateDAO.getNumberPlateByBuildingNumAndUnitNum(buildingNum, unitNum);
			
			conn.close();
			HttpSession session = request.getSession();
			session.setAttribute("plateList", plateList);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
				
		request.getRequestDispatcher(PathConverter.convertToWebInfPath(request.getServletPath())).forward(request, response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
