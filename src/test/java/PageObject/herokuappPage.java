package PageObject;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import StepDefinitions.Function;
import context.Setup;

import cucumber.api.Scenario;

public class herokuappPage
{
	/*
	 * Scenario scn; private WebDriver driver; public herokuappPage(WebDriver
	 * driver) { //setDriver(driver);
	 * 
	 * this.driver=driver; }
	 */
	//Setup setup;
	WebDriver driver;
	

	public herokuappPage(WebDriver driver) {
		this.driver = driver;
		
	}
	public WebElement welcomeStatement() {
		return driver.findElement(By.xpath("//div[@class='example']/p"));
	}
	
	public WebElement welcomePageLink(String link) {
		return driver.findElement(By.xpath("//ul/li/a[contains(text(),'"+link+"')]"));
	}
	public WebElement block1left() {
		return driver.findElement(By.xpath("//div[@id='column-a']"));
	}
	public WebElement block2right() {
		return driver.findElement(By.xpath("//div[@id='column-b']"));
	}
}
