package com.practice.genericPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MasterPage {
	
	public static WebDriver driver;
	public Properties prop;
	public Properties or;
	public Properties td;
	//Constructor Implementation
	public MasterPage() throws IOException {
		
	    FileInputStream ip = new FileInputStream("/com.practice.env/src/test/resources/com/practice/resources/configuration.properties");
	    prop= new Properties();
	    prop.load(ip);
	    
	    FileInputStream fs= new FileInputStream("/com.practice.env/src/test/resources/com/practice/resources/Locators.properties");
	    or=new Properties();
	    or.load(fs);
	    
	    FileInputStream ts= new FileInputStream("/com.practice.env/src/test/resources/com/practice/resources/testdata.properties");
	    td=new Properties();
	    td.load(ts);
	    
	    //Added latest webdriver manager dependency into pom.xml
	    if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
	    	WebDriverManager.chromedriver().setup();
	    	 driver= new ChromeDriver();
	    } else if(prop.getProperty("browser").equalsIgnoreCase("firefox")) {
	    	WebDriverManager.firefoxdriver().setup();
	    	driver=new FirefoxDriver();
	    } else if(prop.getProperty("browser").equalsIgnoreCase("edge")) {
	    	WebDriverManager.edgedriver().setup();
	    	driver=new EdgeDriver();
	    } else if(prop.getProperty("browser").equalsIgnoreCase("chrome2")) {
	    	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") +"/com.practice.env/src/test/resources/com/practice/driver/chromedriver.exe");
	        driver= new ChromeDriver();
	    } else {
	    	System.out.println("No Browsr Details Found");
	    }
	    
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get(prop.getProperty("url"));
	
	}

}
