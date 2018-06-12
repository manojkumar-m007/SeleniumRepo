package com.practise.selenium.SeleniumPractise;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BasePage 
{
	public static WebDriver driver;
	public static Properties prop;
	public static Logger log;
     public WebDriver initializeDriver() throws IOException
     {
    	 log=LogManager.getLogger("BasePage");
   	     PropertyConfigurator.configure("./src/main/java/resources/log4j.properties");
    	 prop=new Properties();
    	 log.info("Properties Object Is Created");
    	 FileInputStream fis=new FileInputStream("./src/main/java/resources/globalproperty.properties");
    	 log.info("GlobalProperty  File passed to input stream");
    	 prop.load(fis);
    	 log.info("GlobalProperty is loaded");
    	 String browserName=prop.getProperty("browser");
    	 log.info("Getting the Browser");
    	 if(browserName.equalsIgnoreCase("chrome"))
    	 {
    		 log.info("Entered Browser is Chrome");
    		 System.setProperty(prop.getProperty("chrome_key"),prop.getProperty("chrome_executable"));
    		 log.info("Getting key and Executable From Property");
    		 driver=new ChromeDriver();
    		 log.info("Chrome Browser Opened");
    	 }
    	 else if(browserName.equalsIgnoreCase("firefox"))
    	 {
    		 log.info("Entered Browser Is FireFox");
    		 System.setProperty(prop.getProperty("firefox_key"),prop.getProperty("firefox_executable"));
    		 log.info("Getting key and Executable From Property");
    		 driver=new FirefoxDriver();
    		 log.info("FireFox Browser Opened");
    	 }
    	 else if(browserName.equalsIgnoreCase("ie"))
    	 {
    		 log.info("Entered Browser is IE");
    		 System.setProperty(prop.getProperty("ie_key"),prop.getProperty("ie_executable"));
    		 log.info("Getting key and Executable From Property");
    		 driver=new InternetExplorerDriver();
    		 log.info("IE Browser Opened");
    	 }
    	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	 log.info("Implicit wait is Applied");
    	 log.info("Return the Browser Object");
    	 return driver;
    	 
     }
}
