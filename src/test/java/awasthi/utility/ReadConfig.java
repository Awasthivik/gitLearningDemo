package awasthi.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import awasthi.Framework.Base;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadConfig {
	
	
	Properties prop;
	String url;
	
	public Properties readProperties() {
	Properties prop=new Properties();
	try {
		FileInputStream file=new FileInputStream(System.getProperty("user.dir") + "\\configuration//Config.properties");
		try {
			prop.load(file);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	}
	return prop;
	
}
	public String getUrl() {
		 url=readProperties().getProperty("url");
		return url;
	}
	public String getUserId() {
		String userid=readProperties().getProperty("userid");
		return userid;
	}public String getUserPass() {
		String upassword=readProperties().getProperty("password");
		return upassword;
	}
	public String getTitle() {
		String title=readProperties().getProperty("title");
		return title;
	}
	
	}
