package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
	
	protected WebDriver driver;
	
	private final By searchbox= By.id("small-searchterms");
	private final By searchbtn=By.cssSelector(".search-box-button");
	private final By laptopImage = By.cssSelector("img[alt='Picture of 14.1-inch Laptop']");
	private final By productTitle = By.cssSelector(".product-name h1");
	private final By Productnotfound = By.className("result");
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
	}
	public void navigate() {
		driver.get("baseUrl");
	}
	
	public void Selectsearchbox(String productname) {
        driver.findElement(searchbox).sendKeys(productname);
	}
	
	public void pressSearchbtn() {
        driver.findElement(searchbtn).click();
	}
	public void productdetailpage() {
		driver.findElement(laptopImage).click();
	}
	
	public void Search(String productname) {
		Selectsearchbox(productname);
		pressSearchbtn();
	}
	
	public String getProductTitle() {
	    return driver.findElement(productTitle).getText();
	}
	
	public String getResultMessage() {
	    return driver.findElement(Productnotfound).getText();
	}
	
}
