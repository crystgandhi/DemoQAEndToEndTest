package endToEndPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(tagName = "h5")
	WebElement loginheading;

	public String getLoginHeading() {
		return loginheading.getText();
	}

	@FindBy(xpath = "(//label[contains(text(),'Username')])[2]")
	WebElement userNameText;

	public boolean checkUserNameText() {
		return userNameText.isDisplayed();
	}

	@FindBy(css = "#loginusername")
	WebElement userName;

	public void enterUsername(String uName) {
		userName.sendKeys(uName);
	}

	@FindBy(xpath = "(//label[contains(text(),'Password')])[2]")
	WebElement password;

	public boolean checkPasswordText() {
		return password.isDisplayed();
	}

	@FindBy(id = "loginpassword")
	WebElement loginPassword;

	public void enterPassword(String pword) {
		loginPassword.sendKeys(pword);
	}

	@FindBy(xpath = "(//button[text()='Close'])[4]")
	WebElement closeBtn;

	public void clickCloseBtn() {
		closeBtn.click();
	}

	@FindBy(xpath = "//button[normalize-space()='Log in']")
	WebElement logInBtn;

	public void clickLoginBtn() {
		logInBtn.click();
	}
	
	@FindBy(xpath ="//li[@class='nav-item']/a[@id='nameofuser']")
	WebElement loginMsg;
	public String getLoginMsg() {
		return loginMsg.getText();
		
	}

}
