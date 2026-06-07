package Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    private final String baseUrl = "https://demowebshop.tricentis.com/";

    protected static WebDriver driver;
    protected void waitSeconds(int seconds) {
        new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(d -> ((org.openqa.selenium.JavascriptExecutor) d)
                        .executeScript("return document.readyState")
                        .equals("complete"));
    }

    @BeforeSuite
    public void setup() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void openHomePage() {

        driver.get(baseUrl);

    }

    @AfterSuite
    public void tearDown() {

        if (driver != null) {

            driver.quit();

        }

    }
}
