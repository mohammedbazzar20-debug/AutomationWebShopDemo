package Tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.LoginPage;

public class LoginTest extends BaseTest {
	private LoginPage loginpath;
	

        @Test
        public void validLoginTest1() throws InterruptedException {
            LoginPage loginPage = new LoginPage(driver);
            Thread.sleep(1000);
            loginPage.login("AutomationTesting988982@gmail.com", "A123456@a");
            Assert.assertTrue(driver.findElement(By.cssSelector(".ico-logout")).isDisplayed());	
        	System.out.println("Login Successful");
        	}
        

        @Test
        public void invalidPasswordTest() throws InterruptedException {
            LoginPage loginPage = new LoginPage(driver);
            Thread.sleep(1000);

            loginPage.login("valid@email.com", "WrongPassword");
            Thread.sleep(1000);
            Assert.assertTrue(
            	    loginPage.getErrorMessage().contains("Login was unsuccessful"));
            System.out.println("Login notSuccessful");
        	}
        

        @Test
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