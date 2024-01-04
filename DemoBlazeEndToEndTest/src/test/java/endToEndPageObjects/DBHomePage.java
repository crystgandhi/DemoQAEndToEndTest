package endToEndPageObjects;


import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DBHomePage {

	public WebDriver driver;
	public WebDriverWait wait;

	public DBHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Click HomePage
	@FindBy(xpath = "//a[contains(text(),'Home')]")
	WebElement homeLink;

	public void clickHomeLink() {
		homeLink.click();
	}

	// Click about link
	@FindBy(xpath = "//a[text()='About us']")
	WebElement aboutUsLink;

	public void clickAboutUsLink() {
		aboutUsLink.click();
	}
	
	// Click contact link
		@FindBy(xpath = "//a[text()='Contact']")
		WebElement contactLink;

		public void clickContactLink() {
			contactLink.click();
		}

	// Click cartLink
	@FindBy(xpath = "// a[text()='Cart']")
	WebElement cartLink;

	public void clickCartLink() {
		cartLink.click();
	}

	// Click LoginLink
	@FindBy(xpath = "// a[text()='Log in']")
	WebElement loginLink;

	public void clickLoginLink() {
		loginLink.click();
	}

	// Click Sign up link
	@FindBy(xpath = "// a[text()='Sign up']")
	WebElement signupLink;

	public void clickSignUpLink() {
		signupLink.click();
	}

	// Get carouselImages
	@FindBy(xpath = "//div[@class='carousel-inner']/div/img[@class='d-block img-fluid']")
	List<WebElement> carouselImages;

	public void getCarouselImages() {
		carouselImages.stream().map(n -> n.getAttribute("src")).forEach(System.out::println);
	}

	// Get Products
	@FindBy(xpath = "//div[@class='col-lg-9']/div/div/div/div/h4")
	List<WebElement> productsInPage1;

	@FindBy(xpath = "//*[@id='frm']/ul/li")
	List<WebElement> pagination;
	@FindBy(xpath = "//*[@id='frm']/ul/li[2]")
	WebElement nextBtn;

	@FindBy(xpath = "//*[@id='frm']/ul/li[1]")
	WebElement prevBtn;

	@FindBy(xpath = "//h4/a")
	List<WebElement> ele;

	@SuppressWarnings("unlikely-arg-type")
	public void getProductsPage1() {

		int numberofPages = pagination.size();
		List<String> nameArray = new ArrayList<String>();
		for (int i = 1; i <= numberofPages; i++) {

			String word = "//*[@id='frm']/ul/li[" + i + "]";
			driver.findElement(By.xpath(word)).click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// wait.until(ExpectedConditions.visibilityOfAllElements(productsInPage1));
			for (WebElement t : ele) {
				nameArray.add(t.getText());
			}
		}
		System.out.println(nameArray);
		System.out.println(nameArray.get(13));
		System.out.println(nameArray.size());
		for (int i = 1; i < nameArray.size(); i++) {
			if (nameArray.get(i).contains("32gb")) {
				System.out.println(i);
				String link = "//*[@id='tbodyid']/div[" + i + "]/div/div/h4/a";
				driver.findElement(By.xpath(link)).click();

			}
		}
				
	}

	@FindBy(xpath = "//*[@id='cat']")
	WebElement category;

	public void checkCategory() {

	}

	// click phones link
	@FindBy(xpath = "//*[contains(text(), 'Phones')]")
	WebElement phones;
	@FindBy(xpath = "//h4/a")
	List<WebElement> phonesList;

	public void clickPhones() {
		System.out.println("-------Phones-----------");
		phones.click();
		phonesList.stream().map(n -> n.getText()).forEach(System.out::println);
		driver.navigate().refresh();
	}

	@FindBy(xpath = "//*[contains(text(), 'Laptops')]")
	WebElement laptops;

	@FindBy(xpath = "//h4/a")
	List<WebElement> typesOfLaptops;

	public void clickLaptops() {
		System.out.println("-----Laptops------");
		laptops.click();
		typesOfLaptops.stream().map(n -> n.getText()).forEach(System.out::println);
		driver.navigate().refresh();
	}

	

	@FindBy(xpath = "//*[contains(text(), 'Monitors')]")
	WebElement monitors;
	@FindBy(xpath = "//*[@id='tbodyid']/div/div/div/h4/a")
	List<WebElement> monitorsList;

	public void clickMonitors() {
		System.out.println("----Monitors-------");
		monitors.click();
		monitorsList.stream().map(x -> x.getText()).forEach(System.out::println);
		
	}
	
	@FindBy(xpath = "//*[@id='logout2']")
	WebElement logout;
	public void clickLogout() {
		logout.click();
	}


}
