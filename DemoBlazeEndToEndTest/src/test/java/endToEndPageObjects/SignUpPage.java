package endToEndPageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
	public WebDriver driver;
     public String uName;
     public String pword;
	public SignUpPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(tagName = "h5")
	WebElement sigUpheading;

	public String getLoginHeading() {
		return sigUpheading.getText();
	}

	@FindBy(xpath = "(//label[contains(text(),'Username')])[1]")
	WebElement userNameText;

	public boolean checkUserNameText() {
		return userNameText.isDisplayed();
	}

	@FindBy(css = "#sign-username")
	WebElement userName;

	public void enterUsername(String uName) {
		userName.sendKeys(uName);
	}

	@FindBy(xpath = "(//label[contains(text(),'Password')])[1]")
	WebElement passwordText;

	public boolean checkPasswordText() {
		return passwordText.isDisplayed();
	}

	@FindBy(id = "sign-password")
	WebElement signUpPassword;

	public void enterPassword(String pword) {
		signUpPassword.sendKeys(pword);
	}

	@FindBy(xpath = "(//button[text()='Close'])[2]")
	WebElement closeBtn;

	public void clickCloseBtn() {
		closeBtn.click();
	}

	@FindBy(xpath = "//button[normalize-space()='Sign up']")
	WebElement signUpBtn;

	public void clickLoginBtn() {
		signUpBtn.click();
	}

}
