package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObject.login;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;

public class herokuapp_StepDefinations extends setUp

{
	@Before public void initialize() { setUp.beforeScenario(); }


	@Given("^Launch application with url \"([^\"]*)\"$")
	public void launchingWeb(String url) throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.get(url);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form/div/input[@type='text']")));
		username.sendKeys("preetamofficial@gmail.com");
		login.password().sendKeys("Preetam12$");
		driver.findElement(By.xpath("//button/span[contains(text(),'Login')]")).click();
		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button/span[contains(text(),'Login')]")));

	}

}
