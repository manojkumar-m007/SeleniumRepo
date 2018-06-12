package com.practise.selenium.SeleniumPractise;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class Parivahan 
{
	public WebDriver driver;
	public JavascriptExecutor j;
	public WebElement e;
	public WebDriverWait w;
	public Properties p;
  @Test
  public void testApplicationStatus()
  {
	  driver.get(p.getProperty("URL"));
	  driver.manage().window().maximize();
	  w=new WebDriverWait(driver,20);
	  e=driver.findElement(By.id(p.getProperty("STATE")));
	         Select s=new Select(e);
	         s.selectByValue(p.getProperty("STATE-NAME"));
	  w.until(ExpectedConditions.elementToBeClickable(By.xpath(p.getProperty("APPLY-ONLINE")))).click();
	      j=(JavascriptExecutor)driver;
	      j.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	  driver.findElement(By.xpath(p.getProperty("APPLICATION-STATUS"))).click();
	  driver.findElement(By.name(p.getProperty("APPLICATION-NUMBER"))).sendKeys(p.getProperty("NUMBER"));
	  driver.findElement(By.name(p.getProperty("DOB"))).sendKeys(p.getProperty("DATE-OF-BIRTH"));
	  driver.findElement(By.id(p.getProperty("SUBMIT"))).click();
	  driver.findElement(By.xpath(p.getProperty("PHOTO-SIGN"))).click();
		  j.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	  w.until(ExpectedConditions.elementToBeClickable(By.id(p.getProperty("VIEW-MORE")))).click();
	     j.executeScript("window.scrollBy(0,-document.body.scrollHeight/2)");
	  driver.findElement(By.id(p.getProperty("CANCEL"))).click();
  }
  @BeforeMethod
  public void openBrowser() throws IOException
  {
	  FileReader fr=new FileReader("Parivahan.properties");
	  p=new Properties();
	  p.load(fr);
	  
	  System.setProperty(p.getProperty("KEY"), p.getProperty("VALUE"));
	  driver=new ChromeDriver();
  }

  @AfterMethod
  public void closeBrowser() 
  {
	  //driver.close();
  }

}
