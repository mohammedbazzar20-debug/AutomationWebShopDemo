package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.LoginPage;

public class LoginTest extends BaseTest {
	private LoginPage loginpath;
	

        @Test(priority = 1)
        public void validLoginTest1() throws InterruptedException {
            LoginPage loginPage = new LoginPage(driver);
            Thread.sleep(1000);
            loginPage.login("AutomationTesting988982@gmail.com", "A123456@a");
            Assert.assertTrue(loginPage.isLogoutDisplayed());
            System.out.println("Login Successful");
        	 loginPage.logout();
        	}
        

        @Test(priority = 2)
        public void invalidPasswordTest() throws InterruptedException {
            LoginPage loginPage = new LoginPage(driver);
            Thread.sleep(1000);

            loginPage.login("valid@email.com", "WrongPassword");
            Thread.sleep(1000);
            Assert.assertTrue( loginPage.getErrorMessage().contains("Login was unsuccessful"));
            System.out.println("Login notSuccessful");
        	}
        

        @Test(priority = 3)
        public void emptyCredentialsTest() throws InterruptedException {
            LoginPage loginPage = new LoginPage(driver);
            Thread.sleep(1000);
            loginPage.login("", "");
            Thread.sleep(1000);
	

	
            Assert.assertTrue(
            	    loginPage.getErrorMessage().contains("Login was unsuccessful"));
            	    System.out.println("Login notSuccessful");
        }
}