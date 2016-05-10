package com.yt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class ParseProperties {

	private Properties pro = new Properties();
	String value = null;
	
	
	private void loadProperties(String propertiesPath){
		try {
			InputStream in = new FileInputStream(propertiesPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		pro.load(reader);
		
	}

}
