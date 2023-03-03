package com.FitpeoTask;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

public class AppTest {
    
  @Test
  public void flipkartTask() throws AWTException {
   
	     WebDriverManager.chromedriver().setup();
	     WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get("https://www.flipkart.com/");
	  Robot r = new Robot();
	  r.keyPress(KeyEvent.VK_ESCAPE);
	  r.keyRelease(KeyEvent.VK_ESCAPE);
	  driver.findElement((By.xpath("//input[@type='text']"))).sendKeys("ipad"+Keys.ENTER);
	  driver.findElements(By.xpath("//div[contains(text(),'APPLE')]")).get(0).click();
	  Set<String> windowHandles = driver.getWindowHandles();
	  for (String string : windowHandles) {
		  if(!string.equals("CDwindow-74921DDFA1A5420A1EA0C1ECE3A68862"))
		   driver.switchTo().window(string);
	} 
	  driver.findElement(By.xpath("//button[@type='button']")).click();
	  
	  Faker f = new Faker();
	 String cellPhone = f.phoneNumber().cellPhone().substring(2);
	  
	  driver.findElement(By.xpath("//input[@type='text']")).sendKeys(cellPhone+Keys.ENTER);
	  
	  
	  
  }
}
