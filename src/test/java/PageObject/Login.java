package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import context.Setup;
import cucumber.api.Scenario;

public class Login extends Setup
{
	Scenario scn;
	private WebDriver driver;
	public Login(WebDriver driver,Scenario s) {
		//setDriver(driver);
		this.scn = s;
	}
	
	public WebElement password() 
	{
		return getDriver().findElement(By.xpath("//form/div/input[@type='password']"));
		
	}
}
