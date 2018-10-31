package com.ksa.core.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class XMLReader {
	
	public String readXMLAsString(String fileName) {
		String result = null;
		try {
			File file = new File(getClass().getClassLoader().getResource(fileName).getFile());
			Path path = Paths.get(file.getAbsolutePath());
		    result = new String(Files.readAllBytes(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

}
