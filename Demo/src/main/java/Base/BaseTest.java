package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private final String baseUrl = "https://demowebshop.tricentis.com/";

	protected WebDriver driver;

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");

	}
	
	@BeforeMethod
	public void navigateToPage() {
		driver.get(baseUrl);
	}
	

	@AfterTest
	public void tearDown() {
		if (driver != null) {
			 driver.quit();
		}
	}


}
