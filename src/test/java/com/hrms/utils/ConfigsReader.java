package com.hrms.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigsReader {
	public static Properties prop;
	
	public static void readProperties(String file) {
		try{
			FileInputStream fis=new FileInputStream(file);
			prop=new Properties();
			prop.load(fis);
			fis.close();
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
		public static String getPropery(String key) {
			return prop.getProperty(key);
			
					
		}
	}


