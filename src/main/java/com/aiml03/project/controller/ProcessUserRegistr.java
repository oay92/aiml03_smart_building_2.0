package com.aiml03.project.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aiml03.project.model.bean.Person;
import com.aiml03.project.model.dao.PersonDAO;

@WebServlet("/ProcessUserRegistr.do")
public class ProcessUserRegistr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//Retrieve from data
	String buildingNum = request.getParameter("building_num");
	int unitNum = Integer.parseInt(request.getParameter("unit"));
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	int phone = Integer.parseInt(request.getParameter("phone"));
	int primaryContact = Integer.parseInt(request.getParameter("primaryContact"));
	
	//Create a person object
	Person person = new Person(0, buildingNum, unitNum, name, email, email, null, phone, primaryContact);
	
	//Connect to the database
	try {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/aiml03","root","123456");
		
		//Create a personDAO
		PersonDAO personDAO = new PersonDAO(conn);
		
		//Insert user information into the database
		personDAO.insertPerson(person);
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	response.sendRedirect("buildingUnit.jsp");//TBD!
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
