package com.aiml03.project.util;

public class PathConverter {
	public static String convertToWebInfPath(String path) {
		String PREFIX = "WEB-INF/view/";
		String SUFFIX = ".jsp";

		return PREFIX + path + SUFFIX;
	}
}
