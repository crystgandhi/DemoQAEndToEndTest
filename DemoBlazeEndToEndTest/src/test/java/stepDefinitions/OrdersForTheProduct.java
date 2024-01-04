package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OrdersForTheProduct {
	public WebDriver driver;
	
	@Given("User login to the website")
	public void User_login_to_the_website() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.demoblaze.com/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	@When("User added product to the cart")
	public void user_added_product_to_the_cart() {
	    driver.findElement(By.xpath("//*[@id='tbodyid']/div[1]/div/div/h4/a")).click();
	    driver.findElement(By.xpath("//*[@id='tbodyid']/div[2]/div/a")).click();
	    try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    driver.switchTo().alert().accept();
	}

	@Then("User place order")
	public void user_place_order() {
	    driver.findElement(By.xpath("//*[@id='navbarExample']/ul/li[4]/a")).click();
	    driver.findElement(By.xpath("//*[@id='page-wrapper']/div/div[2]/button")).click();
	}

		
	@Given("User is in place order Page")
	public void user_is_in_place_order_page() {
	   String title= driver.findElement(By.xpath("//*[@id='orderModalLabel']")).getText();
	   System.out.println(title);
	}

	@When("User enter personal titles")
	public void user_enter_personal_titles() {
		driver.findElement(By.xpath("//*[@id='name']")).sendKeys("John");
		driver.findElement(By.xpath("//*[@id='country']")).sendKeys("Smith");
		driver.findElement(By.xpath("//*[@id='city']")).sendKeys("Ellicott");
		driver.findElement(By.xpath("//*[@id='card']")).sendKeys("3232323232323232");
		driver.findElement(By.xpath("//*[@id='month']")).sendKeys("09");
		driver.findElement(By.xpath("//*[@id='year']")).sendKeys("2025");	   
	}

	@When("User clicks purchase")
	public void user_clicks_purchase() {
		driver.findElement(By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]")).click();
	}

	@Then("User should see the Thank you for your purchase!")
	public void user_should_see_the_thank_you_for_your_purchase() {
		String orderMessage=driver.findElement(By.xpath("/html/body/div[10]/h2")).getText();
		System.out.println(orderMessage);
		driver.findElement(By.xpath("/html/body/div[10]/div[7]/div/button")).click();
	}
}
