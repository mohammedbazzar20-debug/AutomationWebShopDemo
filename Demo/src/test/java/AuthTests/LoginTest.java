package AuthTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import AuthPage.LoginPage;
import Base.BaseTest;

public class LoginTest extends BaseTest {
	

        @Test(priority = 1)
        public void validLoginTest1() {
            LoginPage loginPage = new LoginPage(driver);
            waitSeconds(2);
            loginPage.login("AutomationTesting988982@gmail.com", "A123456@a");
            Assert.assertTrue(loginPage.isLogoutDisplayed());
            System.out.println("Login Successful");
        	 loginPage.logout();
        	}
        

        @Test(priority = 2)
        public void invalidPasswordTest() {
            LoginPage loginPage = new LoginPage(driver);
            waitSeconds(2);
            
            loginPage.login("valid@email.com", "WrongPassword");
            waitSeconds(2);          
            Assert.assertTrue( loginPage.getErrorMessage().contains("Login was unsuccessful"));
            System.out.println("Login notSuccessful");
        	}
        

        @Test(priority = 3)
        public void emptyCredentialsTest() {
            LoginPage loginPage = new LoginPage(driver);
            waitSeconds(2);
            loginPage.login("", "");
            waitSeconds(2);
	

	
            Assert.assertTrue(
            	    loginPage.getErrorMessage().contains("Login was unsuccessful"));
            	    System.out.println("Login notSuccessful");
        }
}