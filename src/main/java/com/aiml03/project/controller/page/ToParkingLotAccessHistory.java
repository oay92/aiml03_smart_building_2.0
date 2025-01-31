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

import com.aiml03.project.model.bean.Account;
import com.aiml03.project.model.bean.Plate;
import com.aiml03.project.model.dao.PlateDAO;
import com.aiml03.project.util.ConnectionFactory;
import com.aiml03.project.util.PathConverter;

@WebServlet("/parkingLotAccessHistory")
public class ToParkingLotAccessHistory extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try 
		{
			HttpSession session = request.getSession();
			Account account = (Account) session.getAttribute("account");

			String buildingNum = "", unitNum = "";
			if (account != null)
			{
				buildingNum = account.getUserID().substring(0, 1);
				unitNum = account.getUserID().substring(1, account.getUserID().length());
			}		
			
			Connection conn = ConnectionFactory.getConnection();
			
			PlateDAO plateDAO = new PlateDAO(conn);
			
			List<Plate>historyList = plateDAO.getNumberPlateRecognitionHistoryByBuildingNumAndUnitNum(buildingNum, unitNum);
			
			request.setAttribute("historyList", historyList);
			request.getRequestDispatcher(PathConverter.convertToWebInfPath(request.getServletPath())).forward(request, response);			
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
