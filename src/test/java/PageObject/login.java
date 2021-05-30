package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import StepDefinitions.setUp;

public class login extends setUp
{
	
	public static WebElement password() 
	{
		return driver.findElement(By.xpath("//form/div/input[@type='password']"));
		
	}
}
