package com.aiml03.project.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ExecutePythonScript 
{
	public List<String> runPython(String pID) 
	{ 
		List<String> features = new ArrayList<String>();
		
		try 
		{
            // Command to run the Python script
            String pythonScriptPath = "C:/Users/Student/Desktop/aiml03_smart_building_3.0/face_recognition_system/face_detection.py";
            
            // Command and arguments to be executed
            String[] cmd = {"python", pythonScriptPath, pID};

            // Create ProcessBuilder to execute the command
            ProcessBuilder processBuilder = new ProcessBuilder(cmd);

            // Start the process
            Process process = processBuilder.start();

            // Get the output from the Python script
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            
            String line;
            while ((line = reader.readLine()) != null) 
            {
            	System.out.println(line);
            	
                if (line.indexOf("f=") >= 0)
                {                	
                	String f = line.substring(line.indexOf("=")+1, line.length());
                	features.add(f.trim());
                }
            }
            
            // Wait for the process to finish
            int exitCode = process.waitFor();
            System.out.println("Python script exited with code " + exitCode);
        } 
		catch (IOException | InterruptedException e) 
		{
            e.printStackTrace();
        }
		
		return features;
	}
}
