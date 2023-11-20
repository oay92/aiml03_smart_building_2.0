package com.aiml03.project.controller.page;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ToHistory")
public class ToHistory extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	List<String> faceTimestamps = retrieveFaceTimestampsFromDatabase(); // 获取面部时间戳列表
        List<String> plateTimestamps = retrievePlateTimestampsFromDatabase(); // 获取车牌时间戳列表

        request.setAttribute("faceTimestamps", faceTimestamps);
        request.setAttribute("plateTimestamps", plateTimestamps);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/history.jsp");
        dispatcher.forward(request, response);
        
    }

    private List<String> retrieveFaceTimestampsFromDatabase() {
        List<String> faceTimestamps = new ArrayList<>();

        faceTimestamps.add("FaceTimestamp1");
        faceTimestamps.add("FaceTimestamp2");
        // ...

        return faceTimestamps;
    }

    private List<String> retrievePlateTimestampsFromDatabase() {
        List<String> plateTimestamps = new ArrayList<>();

        plateTimestamps.add("PlateTimestamp1");
        plateTimestamps.add("PlateTimestamp2");
        // ...

        return plateTimestamps;
    }

}
