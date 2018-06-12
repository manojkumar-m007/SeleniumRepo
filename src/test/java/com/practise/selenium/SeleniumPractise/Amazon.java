package com.practise.selenium.SeleniumPractise;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class Amazon 
{
	public WebDriver driver;
	public Properties p;
	public String s;
	public Set<String> s1;
	public Actions a;
	public WebElement e,e2,e3,e4;
	public WebDriverWait w;
	public FileInputStream f;
  @Test
  public void testEndToEnd() 
  {
	  w=new WebDriverWait(driver, 5);
	  driver.get(p.getProperty("URL"));
	  e=driver.findElement(By.xpath(p.getProperty("sign")));
	  a=new Actions(driver);
	  a.moveToElement(e).build().perform();
	  w.until(ExpectedConditions.elementToBeClickable(By.xpath(p.getProperty("sign-in")))).click();
	  driver.findElement(By.id(p.getProperty("email"))).sendKeys(p.getProperty("email-id"));
	  driver.findElement(By.id(p.getProperty("conti"))).submit();
	  w.until(ExpectedConditions.presenceOfElementLocated(By.id(p.getProperty("password")))).sendKeys(p.getProperty("pass"));
	  driver.findElement(By.id(p.getProperty("login"))).submit();
	  e2=w.until(ExpectedConditions.presenceOfElementLocated(By.xpath(p.getProperty("shopall"))));
	  a.moveToElement(e2).build().perform();
	  e3=w.until(ExpectedConditions.presenceOfElementLocated(By.xpath(p.getProperty("mobile"))));
	  a.moveToElement(e3).build().perform();
	  e4=w.until(ExpectedConditions.presenceOfElementLocated(By.xpath(p.getProperty("almobile"))));
	  a.moveToElement(e4).click().build().perform();
	  driver.findElement(By.linkText(p.getProperty("one"))).click();
	  s1=driver.getWindowHandles();
	  for(String a:s1)
	  {
		  driver.switchTo().window(a);
		  s=driver.getTitle();
		  if(s.equalsIgnoreCase(p.getProperty("title")))
		  {
			  w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(p.getProperty("cart")))).click(); 
		  }
	  }
	  
  }
  @BeforeTest
  public void openBrowser() throws IOException 
  {
	  f=new FileInputStream("AmazonProperty.properties");
	  p=new Properties();
	  p.load(f);
	  System.setProperty(p.getProperty("ckey"),p.getProperty("cpath"));
	  driver=new ChromeDriver();
  }

  @AfterTest
  public void closeBrowser() 
  {
	  //driver.close();
  }

}
