package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;




public class LoginPage {
	protected WebDriver driver;
	private final String loginPath = "login";
	
	private final By loginselect = By.cssSelector(".ico-login");
	private final By loginBy = By.id("Email");
	private final By passwordBy = By.id("Password");
	private final By clicklogin = By.cssSelector(".button-1.login-button");
	private final By errorAlertBy = By.cssSelector(".validation-summary-errors");
	private final By logoutBtn = By.cssSelector(".ico-logout");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	public void navigate() {
		driver.get("baseUrl" + loginPath);
		
	}
	
	public void enterloginpage() {
        driver.findElement(loginselect).click();
	}

	public void enterEmail(String Email) {
        driver.findElement(loginBy).sendKeys(Email);
	}

	public void enterpassword(String Password) {
        driver.findElement(passwordBy).sendKeys(Password);
	}

	public void loginpress() {
        driver.findElement(clicklogin).click();
	}
	
	public void logout() {
		driver.findElement(logoutBtn).click();
	}
	
	   public void login(String email, String password) {
		   enterloginpage();
	        enterEmail(email);
	        enterpassword(password);
	        loginpress();
	    }
	   By errorMessage = By.cssSelector(".validation-summary-errors");

	   public String getErrorMessage() {
	       return driver.findElement(errorMessage).getText();
	   }
	   public boolean isLogoutDisplayed() {
		    return driver.findElement(logoutBtn).isDisplayed();
		}
}
