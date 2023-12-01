package com.aiml03.project.controller.page;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aiml03.project.util.PathConverter;

/**
 * Servlet implementation class ToBuildingUnit
 */
@WebServlet("/buildingUnit")
public class ToBuildingUnit extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String page = request.getParameter("page");

		request.setAttribute("page", page);
		request.getRequestDispatcher(PathConverter.convertToWebInfPath(request.getServletPath())).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}

