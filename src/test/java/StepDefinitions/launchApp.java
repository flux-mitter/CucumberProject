package StepDefinitions;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObject.login;
import io.cucumber.java.After;
//import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


//public class launchApp extends SetupClass
public class launchApp extends setUp {

	// @Given("^Launch application with url \\\"([^\\\"]*)\\\"$")
	// super Setup();
	/*
	 * public static WebDriver driver;
	 * 
	 * @Before public void beforeScenario(){
	 * System.setProperty("webdriver.chrome.driver",
	 * "//D://My Work//chromedriver.exe"); driver = new ChromeDriver();
	 * 
	 * }
	 */

	
	  @Before public void initialize() { setUp.beforeScenario(); }
	 

	@Given("^Launch application with url \"([^\"]*)\"$")
	public void launchingWeb(String url) throws InterruptedException {
		// System.setProperty("webdriver.chrome.driver","//D://My
		// Work//chromedriver.exe");
		// WebDriver driver = new ChromeDriver();
		// System.setProperty("webdriver.chrome.driver","//D://My
		// Work//chromedriver.exe");
		// System.setProperty("webdriver.chrome.driver", "//D://My
		// Work//chromedriver.exe");
		// WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.get(url);
		// System.out.println("preetam hello world");
		// Select s=new Select(driver.findElement(By.className("a")));
		// driver.findElement(by.sel)
		// s.se

		// driver.quit();

		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form/div/input[@type='text']")));
		//WebElement username = wait.until(ExpectedConditions.)));
		
		username.sendKeys("preetamofficial@gmail.com");
		//driver.findElement(By.xpath("//form/div/input[@type='password']")).sendKeys("Preetam12$");
		login.password().sendKeys("Preetam12$");
		driver.findElement(By.xpath("//button/span[contains(text(),'Login')]")).click();
		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button/span[contains(text(),'Login')]")));

	}

	@When("^Take Screenshot$")
	public void takescreenshot() {
		// TakesScreenshot scrShot =((TakesScreenshot)driver);
		System.out.println(123);
		// D:\My Work\Workspaces\restAssured_Learning\LearnCucumber\screenshot
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(System.getProperty("user.dir") + "//screenshot//homePageScreenshot.png");

		// Copy file at destination

		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
