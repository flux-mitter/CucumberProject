package context;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import PageObject.Login;
import PageObject.herokuappPage;
import cucumber.api.Scenario;



public class Setup 
{
	private static final Logger logger = LogManager.getLogger(Setup.class);
	protected WebDriver driver;
	//private WebDriver driver;
	private herokuappPage herokuapp;
	//private Login
	private Login login;
	
	public WebDriver getDriver() {
		return driver;
	}
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	public herokuappPage getHerokuapp() {
		return herokuapp;
	}
	
	public Login getLogin() {
		return login;
	}
	
	  public void initializePageObjectClasses(WebDriver driver,Scenario scn) {
	  login = new Login(driver,scn); //Login = new Login(driver,scn); herokuapp =
	
	  herokuapp=new herokuappPage(driver, scn);
	  
	  
	  }
	 
	
	
}
