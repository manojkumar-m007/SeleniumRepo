package com.practise.selenium.SeleniumPractise;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePage extends BasePage
{
	public Logger log2;
  @Test
  public void testOpen() throws IOException 
  { 
	  log2=LogManager.getLogger("HomePage");
	  driver=initializeDriver();
	  log.info("Application Opened");
	  driver.get(prop.getProperty("URL"));
	  log.info("Home page loaded Successfully");
  } 

}
