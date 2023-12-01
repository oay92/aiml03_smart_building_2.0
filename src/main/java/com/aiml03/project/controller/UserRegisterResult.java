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

@WebServlet("/UserRegisterResult.do")
public class UserRegisterResult extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String buildingNum = request.getParameter("buildingNum");
		String unitNum = request.getParameter("unitNum");
				
		String action = request.getParameter("action");
		String pID = request.getParameter("pID");
				
		if (action.equals("add"))
		{
			if (buildingNum.equals("") && unitNum.equals(""))
				response.sendRedirect("index");
			else						
				response.sendRedirect("userRegister?buildingNum="+buildingNum+"&unitNum="+unitNum);
		}
		else if (action.equals("delete"))
		{
			try 
			{
				Connection conn = ConnectionFactory.getConnection();
				PersonDAO personDAO = new PersonDAO(conn);
				personDAO.deletePersonbyID(Integer.parseInt(pID));	

				conn.close();
				response.sendRedirect("userRegisterResult?buildingNum="+buildingNum+"&unitNum="+unitNum);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}				
		}
		else if (action.equals("edit"))
		{
			try 
			{
				Connection conn = ConnectionFactory.getConnection();
				PersonDAO personDAO = new PersonDAO(conn);
				Person person = personDAO.getPersonInfoByID(Integer.parseInt(pID));

				conn.close();
				
				if (person != null)
				{
					request.setAttribute("person", person);

					request.getRequestDispatcher(PathConverter.convertToWebInfPath("editUserRegisterInfo")).forward(request, response);
				}
				else
				{
					response.sendRedirect("admin");
				}
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
