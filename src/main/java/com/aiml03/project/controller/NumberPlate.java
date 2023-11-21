package com.aiml03.project.controller;

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
import com.aiml03.project.model.dao.PlateDAO;
import com.aiml03.project.util.ConnectionFactory;
import com.aiml03.project.util.DataFormat;
import com.aiml03.project.util.PathConverter;

@WebServlet("/NumberPlate.do")
public class NumberPlate extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		DataFormat format = new DataFormat();
		String action = request.getParameter("myAction");
	
		HttpSession session = request.getSession();
		List<Plate>plateList = (List<Plate>) session.getAttribute("plateList");
		
		if (plateList != null)
		{
			Plate plate = plateList.get(0);
			String buildingNum = plate.getBuildingNum();
			String unitNum = plate.getUnitNum();
		
			try
			{
				Connection conn = ConnectionFactory.getConnection();
				PlateDAO plateDAO = new PlateDAO(conn);
				
				if (format.formatString(action).equals("add"))
				{
					String numberPlate = request.getParameter("numberPlate");				
					plateDAO.insertNumberPlate(buildingNum, unitNum, numberPlate);

				}
				else if (format.formatString(action).equals("delete"))
				{
					String nID = request.getParameter("nID");
					int ID = ((format.formatString(nID).equals("")) ? 0 : Integer.parseInt(nID));
					
					plateDAO.deleteNumberPlateByID(Integer.parseInt(nID));
				}				
				
				plateList = plateDAO.getNumberPlateByBuildingNumAndUnitNum(buildingNum, unitNum);
				
				conn.close();
				session.setAttribute("plateList", plateList);	
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
	
		request.getRequestDispatcher(PathConverter.convertToWebInfPath("licensePlate2")).forward(request, response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
