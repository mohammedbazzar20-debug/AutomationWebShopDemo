package Tests;

import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.LoginPage;

public class LoginTest extends BaseTest {
	private LoginPage loginpath;
	
	@Test
	public void validLoginTest() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        
		loginPage.enterloginpage();
		Thread.sleep(2000);

        loginPage.login("test@test.com", "123456");
    	Thread.sleep(2000);

        loginPage.loginpress();
	
}}
