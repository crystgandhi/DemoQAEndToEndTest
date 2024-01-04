package endToEndTest;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import utilities.ReadConfig;

public class BaseClass {

	public WebDriver driver;
	ReadConfig readconfig;
	@BeforeTest
	public void setUp() throws IOException {
		driver = new ChromeDriver();
		readconfig = new ReadConfig();
		driver.get(readconfig.getURL());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
	}
	
	@AfterTest
	public void tearDown() {
		//driver.close();
	}

}
