package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

public class setUp

{
	public static WebDriver driver;
	
	
	public static void beforeScenario(){
		//System.setProperty("webdriver.chrome.driver", "//D://My Work//chromedriver.exe");
		String s=System.getProperty("user.dir")+"//WebDriver";
		System.out.println(s);
		System.setProperty("webdriver.chrome.driver", s+"//chromedriver.exe");
	  driver = new ChromeDriver();
	  
	}
	
	
}