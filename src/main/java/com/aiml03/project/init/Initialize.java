package com.aiml03.project.init;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Initialize implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

    public void contextInitialized(ServletContextEvent sce)  { 
		ServletContext context = sce.getServletContext();

		// initial
		context.setAttribute("root", context.getContextPath());
		context.setAttribute("webName", "Smart Building");
		context.setAttribute("component", "/WEB-INF/view/component");
    }
	
}
