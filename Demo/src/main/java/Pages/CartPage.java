package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
	protected WebDriver driver;

	private final By addToCartBtn = By.id("add-to-cart-button-31");
	private final By successMessage = By.cssSelector("p.content");	
	private final By firstAddToCart =By.cssSelector(".product-box-add-to-cart-button");
	private final By secondAddToCart =By.cssSelector(".product-box-add-to-cart-button");

	
	
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}
		   public void addtocartProductPage() {
		        driver.findElement(addToCartBtn).click();
		    }

		   public String getSuccessMessage() {
			    return driver.findElement(successMessage).getText();
			}
		    
		   public void addFirstProductToCart() {
			    driver.findElements(secondAddToCart)
			          .get(0)
			          .click();
			}
		   public void addsecondProductToCart() {
			    driver.findElements(secondAddToCart)
			          .get(1)
			          .click();
			}
		   
		    


}
