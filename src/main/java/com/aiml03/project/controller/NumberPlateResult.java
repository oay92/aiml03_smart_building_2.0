package com.aiml03.project.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aiml03.project.model.dao.PlateDAO;
import com.aiml03.project.util.ConnectionFactory;

@WebServlet("/numberPlateResult.do")
public class NumberPlateResult extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String action = request.getParameter("action");
		String nID = request.getParameter("nID");
		String buildingNum = request.getParameter("buildingNum");
		String unitNum = request.getParameter("unitNum");
		
		if (action.equals("add"))
		{
			response.sendRedirect("numberPlate?buildingNum="+buildingNum+"&unitNum="+unitNum);
		}
		else if (action.equals("delete"))
		{
			try 
			{
				Connection conn = ConnectionFactory.getConnection();
				PlateDAO plateDAO = new PlateDAO(conn);
				plateDAO.deleteNumberPlateByID(Integer.parseInt(nID));
				
				conn.close();
				response.sendRedirect("numberPlateResult?buildingNum="+buildingNum+"&unitNum="+unitNum);	
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}
