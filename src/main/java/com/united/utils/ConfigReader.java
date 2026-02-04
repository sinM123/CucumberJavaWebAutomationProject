package com.united.utils;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class ConfigReader {
	
	static Properties prop = new Properties();
	static Logger log = LogManager.getLogger(ConfigReader.class);
		
	public static void readConfigFile() throws IOException {
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//config//config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			log.error("Cannot load file." + "Error: " + e.getMessage());
		}

		
	}
	
	public static String getProperty(String key) {
		String value = prop.getProperty(key);
		return value;
	}

}
