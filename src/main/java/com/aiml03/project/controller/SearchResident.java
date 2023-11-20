package com.aiml03.project.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aiml03.project.model.bean.ResidentDetails;
import com.aiml03.project.model.dao.SearchByDAO;
import com.aiml03.project.util.ConnectionFactory;

@WebServlet("/SearchResident.do")
public class SearchResident extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		// Retrieving initialization parameters
		String bNo = request.getParameter("buildingNo");
		String uNo = request.getParameter("unitNo");
//		int uNo = Integer.parseInt(request.getParameter("unitNo"));

		// Establishing a database connectionS
		Connection conn;
		try {
			conn = ConnectionFactory.getConnection();
			System.out.println(conn);
			// Creating a SearchDAO instance
			SearchByDAO searchByDAO = new SearchByDAO(conn);
			System.out.println(searchByDAO);
			// Finding account by building no. and unit no.
			List<ResidentDetails> rd = searchByDAO.searchByBuildingAndUnit(bNo, uNo);
			System.out.println(rd);
			// Closing the database connection
			conn.close();
			
			if (rd != null) {
				request.setAttribute("Resident_information", rd);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		request.getRequestDispatcher("SearchBy").forward(request, response);
		// request.setAttribute("error", "Database error. Please try again later.");
		// request.getRequestDispatcher("error.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
