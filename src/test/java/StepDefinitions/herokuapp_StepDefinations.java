package StepDefinitions;



import java.io.IOException;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObject.herokuappPage;
import context.Setup;
import cucumber.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import junit.framework.Assert;

public class herokuapp_StepDefinations

{
	Setup setup;
	Scenario scn;
	WebDriver driver;
	Function function;

	public herokuapp_StepDefinations(Setup setup) {
		this.setup = setup;
	}
	@Before 
	public void initialize() { //setUp.beforeScenario(); 
		String s=System.getProperty("user.dir")+"//WebDriver";
		//test ul = "http://the-internet.herokuapp.com/iframe"
		System.out.println(s);
		//System.setProperty("webdriver.chrome.driver", s+"//chromedriver.exe");
		if (System.getProperty("os.name").contains("Mac OS")) {
			System.setProperty("webdriver.chrome.driver", s+"//chromedriver");
		}

		else { System.setProperty("webdriver.chrome.driver", s+"//chromedriver.exe");
		}

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		setup.setDriver(driver);
		setup.initializePageObjectClasses(driver, scn);
		 function=new Function(setup);
		 
	
	
	}


	@Given("^Launch herokuapp with url \"([^\"]*)\"$")
	public void launchingHerouappWeb(String url) throws InterruptedException {
		driver.get(url);
		driver.manage().window().maximize();
		setup.setDriver(driver);
		setup.initializePageObjectClasses(driver, scn);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='example']/p")));
		//String welcomemsg= herokuappPage.welcomeStatement().getText();
		String welcomemsg= setup.getHerokuapp().welcomeStatement().getText();
		Assert.assertEquals(true, welcomemsg.contains("Congratulations! You must have the proper credentials."));
}
	

	@Given("^Launch herokuapp \"([^\"]*)\"$")
	public void launchingHerouapp(String url) throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.get(url);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='example']/p")));
		//String welcomemsg= herokuappPage.welcomeStatement().getText();
		//Assert.assertEquals(true, welcomemsg.contains("Congratulations! You must have the proper credentials."));
}
	
	@Given("^click on link from main page \"([^\"]*)\"$")
	public void openMainPageLink(String link) throws InterruptedException {

		function.click(setup.getHerokuapp().welcomePageLink(link));
		Thread.sleep(10000);
		//herokuappPage.welcomePageLink(link).click();
		//Assert.assertEquals(true, welcomemsg.contains("Congratulations! You must have the proper credentials."));
}
	
	@Then("^Find Broken images in the page$")
	public void validate_broken_images() throws InterruptedException {
		//herokuappPage.welcomePageLink(url)
		 int iBrokenImageCount = 0;
		 String status="passed";
		try
        {
          
            List<WebElement> image_list = driver.findElements(By.tagName("img"));
            /* Print the total number of images on the page */
            System.out.println("The page under test has " + image_list.size() + " images");
            for (WebElement img : image_list)
            {
                if (img != null)
                {
                    HttpClient client = HttpClientBuilder.create().build();
                    HttpGet request = new HttpGet(img.getAttribute("src"));
                    HttpResponse response = client.execute(request);
                    /* For valid images, the HttpStatus will be 200 */
                    if (response.getStatusLine().getStatusCode() != 200)
                    {
                        System.out.println(img.getAttribute("outerHTML") + " is broken.");
                        iBrokenImageCount++;
                    }
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            status = "failed";
            System.out.println(e.getMessage());
        }
        status = "passed";
       // System.out.println("The page " + URL + " has " + iBrokenImageCount + " broken images");
	
}
	
	
	
	
	
	@After
	public void tearDown() {
		driver.quit();
	}

}
