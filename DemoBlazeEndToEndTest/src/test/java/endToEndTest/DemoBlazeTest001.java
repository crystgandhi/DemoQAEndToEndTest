package endToEndTest;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import demoBlazePageObjects.ContactPage;
import demoBlazePageObjects.DBHomePage;
import demoBlazePageObjects.FooterSection;
import demoBlazePageObjects.LoginPage;
import demoBlazePageObjects.SignUpPage;

public class DemoBlazeTest001 extends BaseClass{
	String uName=RandomStringUtils.randomAlphabetic(9).toLowerCase();
	String pword=RandomStringUtils.randomAlphanumeric(10);
	
	SignUpPage sp;
	DBHomePage hp;
	LoginPage lp;
	
	@Test
	public void demoBlazeTest001() {
		System.out.println("Application Launched");
		hp=new DBHomePage(driver);
		 hp.clickSignUpLink();
		sp=new SignUpPage(driver);
		sp.getLoginHeading();
		sp.checkUserNameText();
		sp.enterUsername(uName);
		sp.checkPasswordText();
		sp.enterPassword(pword);
		sp.clickLoginBtn();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		hp.clickLoginLink();
		lp=new LoginPage(driver);
		cp=new ContactPage(driver);
		lp.checkUserNameText();
		lp.enterUsername(uName);
		lp.enterPassword(pword);
		lp.clickLoginBtn();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(lp.getLoginMsg());
				
		hp.getCarouselImages();
		hp.getProductsPage1();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		hp.clickLogout();
		
		
	}

}
