package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObject.herokuappPage;
import context.Setup;
import cucumber.api.Scenario;
import cucumber.api.java.Before;

public class Function
{
	Setup setup;
	WebDriver driver;
	herokuappPage herokuapp;
	Scenario scn;

	
	  public Function(Setup setup) 
	  { 
		  this.setup = setup; 
		  driver=setup.getDriver();
	}
	 
	
	
	 
	@org.junit.Before
	public void initialize()
	{
		driver=setup.getDriver();
	}
//	@Before 
//	public void initialize() { //setUp.beforeScenario(); 
//		String s=System.getProperty("user.dir")+"//WebDriver";
//		//test ul = "http://the-internet.herokuapp.com/iframe"
//		System.out.println(s);
//		//System.setProperty("webdriver.chrome.driver", s+"//chromedriver.exe");
//		if (System.getProperty("os.name").contains("Mac OS")) {
//			System.setProperty("webdriver.chrome.driver", s+"//chromedriver");
//		}
//
//		else { System.setProperty("webdriver.chrome.driver", s+"//chromedriver.exe");
//		}
//
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
//		setup.initializePageObjectClasses(driver, scn);
//		setup.setDriver(driver);
//		// function=new Function(driver);
//		 
//	
//	
//	}
	public void click(WebElement element)
	{
		//WebElement emailTxt = driver.findElement(By.id("email"));  
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;  
		jsExecutor.executeScript("arguments[0].style.border='2px solid red'", element);
		element.click();
	}
	
}
