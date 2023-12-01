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

@WebServlet("/editTakePhoto")
public class ToEditTakePhoto extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		
		String pID = request.getParameter("pID");
		String buildingNum = request.getParameter("buildingNum");
		String unitNum = request.getParameter("unitNum");				
		String userName = request.getParameter("userName");
		String userEmail = request.getParameter("userEmail");
		String userPhone = request.getParameter("userPhone");		
		String[] contact = request.getParameterValues("primaryContact");
		
		DataFormat format = new DataFormat();
		int primary = 0;		
		if (contact != null)
			primary = ((format.formatString(contact[0]).equals("1")) ? 1: 0);		
		
		String userPhoto = "";
		Person person = new Person(Integer.parseInt(pID), buildingNum, unitNum, userName, userEmail, userPhone, userPhoto, primary, 0);
		
		session.setAttribute("person", person);
		
		request.getRequestDispatcher(PathConverter.convertToWebInfPath(request.getServletPath())).forward(request, response);					
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
