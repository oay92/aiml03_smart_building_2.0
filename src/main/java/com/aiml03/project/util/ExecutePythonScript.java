package com.aiml03.project.util;

import java.io.IOException;

public class ExecutePythonScript 
{
	public void runPython() 
	{ 
		System.out.println("runPython");
		
		String [] cmd = new String[3];
		cmd[0] = "python3";
		cmd[1] = "C:/Demo/myscript.py";
		cmd[2] = "hi";
		
		try 
		{
			Process p = Runtime.getRuntime().exec(cmd);
			p.waitFor();
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
		catch (InterruptedException e2) 
		{
			e2.printStackTrace();
		}
	}
}
