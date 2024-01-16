package chapter15.sec04.exam03;

import java.util.Properties;

public class PropertiesExample {

	public static void main(String[] args) throws Exception {
		//create Properties collection
		Properties properties = new Properties();
		
		//file load
		properties.load(PropertiesExample.class.getResourceAsStream("database.properties"));
		
		//read value based key
		String driver = properties.getProperty("driver");
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		String admin = properties.getProperty("admin");
		
		//print value
		System.out.println("driver : " + driver);
		System.out.println("url : " + url);
		System.out.println("username : " + username);
		System.out.println("password : " + password);
		System.out.println("admin : " + admin);
	}

}
