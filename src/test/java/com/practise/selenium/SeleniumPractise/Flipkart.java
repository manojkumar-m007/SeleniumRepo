package com.practise.selenium.SeleniumPractise;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Flipkart 
{
	public WebDriver driver;
	public Properties p;
	public WebDriverWait w;
	@BeforeMethod
	public void openBrowser() throws IOException
	{
		FileInputStream fir=new FileInputStream("Global property.properties");
		p=new Properties();
		p.load(fir);
		System.setProperty(p.getProperty("key"), p.getProperty("value"));
		driver =new FirefoxDriver();		
	}
  @Test
  public void testLogin() 
  {
	driver.get(p.getProperty("URL"));
	driver.findElement(By.xpath(p.getProperty("expath"))).sendKeys(p.getProperty("email"));
	driver.findElement(By.xpath(p.getProperty("pxpath"))).sendKeys(p.getProperty("password"));
	driver.findElement(By.xpath(p.getProperty("lxpath"))).click();
  }
  @AfterMethod
  public void afterMethod() throws InterruptedException 
  {
	  w=new WebDriverWait(driver, 20);
	  w.until(ExpectedConditions.elementToBeClickable(By.xpath(p.getProperty("loxpath")))).click();
	  w.until(ExpectedConditions.elementToBeClickable(By.xpath(p.getProperty("lgoxpath")))).click();
	  driver.close();
  }

}
