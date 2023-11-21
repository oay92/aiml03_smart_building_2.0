package com.aiml03.project.controller.page;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aiml03.project.model.bean.Person;
import com.aiml03.project.util.DataFormat;
import com.aiml03.project.util.PathConverter;

@WebServlet("/takePhoto")
public class ToTakePhoto extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String myPage = request.getParameter("myPage");
		
		HttpSession session = request.getSession();
		
		DataFormat format = new DataFormat();
		if (format.formatString(myPage).equals("done"))
		{
			Person person = (Person) session.getAttribute("person");
			
			if (person != null)
			{
				System.out.println("person is not null");
				response.sendRedirect("userRegisterResult");
			}
			else
			{
				System.out.println("person is null");
				response.sendRedirect("admin");
			}
		}
		else if (myPage.equals("photo"))
		{
			String buildingNum = request.getParameter("buildingNum");
			String unitNum = request.getParameter("unitNum");				
			String userName = request.getParameter("userName");
			String userEmail = request.getParameter("userEmail");
			String userPhone = request.getParameter("userPhone");		
			String[] contact = request.getParameterValues("primaryContact");
			
			int primary = 0;		
			if (contact != null)
				primary = ((format.formatString(contact[0]).equals("1")) ? 1: 0);		
			
			String userPhoto = "";
			Person person = new Person(0, buildingNum, unitNum, userName, userEmail, userPhone, userPhoto, primary, 0);
			
			session.setAttribute("person", person);
			
			request.getRequestDispatcher(PathConverter.convertToWebInfPath(request.getServletPath())).forward(request, response);			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
