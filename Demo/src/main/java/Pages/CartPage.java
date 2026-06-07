package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
	protected WebDriver driver;

	private final By addToCartBtn = By.id("add-to-cart-button-31");
	private final By successMessage = By.cssSelector("p.content");	
	private final By secondAddToCart =By.cssSelector(".product-box-add-to-cart-button");
	private final By shoppingCartBtn = By.xpath("//span[text()='Shopping cart']");
	private final By removeCheckbox = By.name("removefromcart");
	private final By updateCartBtn = By.cssSelector(".update-cart-button");
	private final By productPrice = By.cssSelector(".product-unit-price");
	private final By emptyCartMessage = By.cssSelector(".order-summary-content");

	
	
	
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
		   
		   public void openShoppingCart() {
			    driver.findElement(shoppingCartBtn).click();
			}

			public void removeProduct() {
			    driver.findElement(removeCheckbox).click();
			}

			public void updateCart() {
			    driver.findElement(updateCartBtn).click();
			}

			public String getProductPrice() {
			    return driver.findElement(productPrice).getText();
			}

			public String getEmptyCartMessage() {
			    return driver.findElement(emptyCartMessage).getText();
			}
		
}
