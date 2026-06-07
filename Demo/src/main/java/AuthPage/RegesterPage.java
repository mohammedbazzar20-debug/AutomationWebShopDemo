package AuthPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegesterPage {

	protected WebDriver driver;
	private final String RegesterPath = "register";
	
	private final By Regesterselect = By.cssSelector(".ico-register");
	private final By First = By.id("FirstName");
	private final By Last = By.id("LastName");
	private final By EmailBy = By.id("Email");
	private final By PasswordRegester = By.id("Password");
	private final By RePassword = By.id("ConfirmPassword");
	private final By RegesterBtn = By.id("register-button");
	private final By successMessage =By.cssSelector(".result");
	private final By firstNameError = By.id("FirstName-error");
	private final By lastNameError = By.id("LastName-error");
	private final By emailError = By.xpath("//span[@for='Email']");
	private final By passwordError = By.xpath("//span[@for='Password']");
	private final By confirmPasswordError = By.xpath("//span[@for='ConfirmPassword']");
	private final By presscontuineBtn = By.cssSelector(".register-continue-button");
	private final By logoutBtn = By.cssSelector(".ico-logout");




	public RegesterPage(WebDriver driver) {
		this.driver = driver;
	}
	public void navigate() {
		driver.get("baseUrl" + RegesterPath);
		
	}
	
	public void selectregesterpage() {
        driver.findElement(Regesterselect).click();
	}
	
	public void enterfirstname(String FirstName) {
        driver.findElement(First).sendKeys(FirstName);
	}

	public void enterlastname(String LastName) {
        driver.findElement(Last).sendKeys(LastName);
	}

	public void enterEmail(String Email) {
        driver.findElement(EmailBy).sendKeys(Email);
	}

	public void enterpassword(String Password) {
        driver.findElement(PasswordRegester).sendKeys(Password);
	}

	public void ConfirmPass(String ConfirmPassword) {
        driver.findElement(RePassword).sendKeys(ConfirmPassword);
	}

	public void enterregesterpage() {
        driver.findElement(RegesterBtn).click();
       
	}
	
	public void pressContuine() {
        driver.findElement(presscontuineBtn).click();
       
	}
	
	public void Presslogout() {
        driver.findElement(logoutBtn).click();
	}
	 public void regester(String FirstName, String LastName, String Email, String Password, String ConfirmPassword) {
		 selectregesterpage();
		 enterfirstname(FirstName);
		 enterlastname(LastName);
		 enterEmail(Email);  
		 enterpassword(Password);
		 ConfirmPass(ConfirmPassword);
		 enterregesterpage();
	    }
	 public String getSuccessMessage() {
		    return driver.findElement(successMessage).getText();
		}
	 public String getFirstNameError() {
		    return driver.findElement(firstNameError).getText();
		}

		public String getLastNameError() {
		    return driver.findElement(lastNameError).getText();
		}

		public String getEmailError() {
		    return driver.findElement(emailError).getText();
		}

		public String getPasswordError() {
		    return driver.findElement(passwordError).getText();
		}

		public String getConfirmPasswordError() {
		    return driver.findElement(confirmPasswordError).getText();
		}
		
		public boolean isRegistrationSuccessful() {
		    return driver.getPageSource().contains("Your registration completed");
		}
		
		public boolean isEmailErrorDisplayed() {
		    return driver.findElements(emailError).size() > 0;
		}
		
		public String getEmailErrorText() {
		    return isEmailErrorDisplayed()
		        ? driver.findElement(emailError).getText()
		        : "";
		}
		
		public boolean isErrorPresent() {
		    return driver.findElements(By.cssSelector(".field-validation-error")).size() > 0;
		}
		
		public boolean isRegistrationFailed() {
		    return isErrorPresent();
		}
}
