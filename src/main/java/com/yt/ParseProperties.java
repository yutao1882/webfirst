package com.yt;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class ParseProperties {

	private Properties pro = new Properties();
	String value = null;

	public ParseProperties(String propertiesPath) {
		this.loadProperties(propertiesPath);
	}

	private void loadProperties(String propertiesPath) {

		try {
			InputStream in = new FileInputStream(propertiesPath);
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(isr);
			pro.load(br);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getValue(String keyword) {

		value = pro.getProperty(keyword);

		try {
			value = new String(value.getBytes("UTF-8"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return value;

	}

}
