package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class UdemyLogin {

	WebDriver driver =null;
	
	@Given("browser is open")
	public void browser_is_open() {
	    System.setProperty("webdriver.chrome.driver", "D:/eclipse_workspace/CucumberJava/src/test/resources/drivers/chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	}

	@And("User is on udemy page")
	public void user_is_on_udemy_page() throws InterruptedException{
	    driver.navigate().to("https://www.udemy.com/");
	    Thread.sleep(1000);
	}

	@When("clicks on login button")
	public void clicks_on_login_button() {
		driver.findElement(By.linkText("Log in")).click();    
	}

	@When("user enter username and password")
	public void user_enter_username_and_password() throws InterruptedException {
		driver.findElement(By.name("email")).sendKeys("sonali12negi@gmail.com");
		driver.findElement(By.name("password")).sendKeys("_back_/upto_WT06");
		Thread.sleep(1000);
	}

	@And("user clicks on submit button")
	public void user_clicks_on_submit_button() {
		driver.findElement(By.name("submit")).click();
	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() throws InterruptedException {
		driver.findElement(By.linkText("My learning")).isDisplayed();
		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}
	
}
