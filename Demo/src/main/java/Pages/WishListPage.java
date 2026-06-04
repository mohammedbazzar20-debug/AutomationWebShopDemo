package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishListPage {
	protected WebDriver driver;
	private final By wishlistBtn = By.xpath("//span[text()='Wishlist']");
	private final By errorNotification = By.id("bar-notification");
	private final By addtowishlistBtn = By.id("add-to-wishlist-button-2");
	private final By giftCardImage =By.xpath("//img[@alt='Picture of $25 Virtual Gift Card']");
	private final By nameofgift = By.id("giftcard_2_RecipientName");
	private final By emailofgift = By.id("giftcard_2_RecipientEmail");
	private final By Myname = By.id("giftcard_2_SenderName");
	private final By Myemail = By.id("giftcard_2_SenderEmail");
	private final By cheapComputerImage =By.xpath("//img[@alt='Picture of Build your own cheap computer']");
	private final By messageText = By.className("content");
	




	
	public WishListPage(WebDriver driver) {
		this.driver = driver;
	}

	public void Oopenwishlist() {
        driver.findElement(wishlistBtn).click();
	}
	
	public void ErrorMessage() {
        driver.findElement(errorNotification).getText();
	}
	
	public void Addingtowishlist() {
        driver.findElement(addtowishlistBtn).click();
	}
	
	public void giftCardpage() {
        driver.findElement(giftCardImage).click();
	}
	

	public void CheapComputer() {
    driver.findElement(cheapComputerImage).click();
}
	
	
	public void namewhotakegift(String Nameone) {
        driver.findElement(nameofgift).sendKeys(Nameone);
	}
	
	public void emailwhotakegift(String email) {
        driver.findElement(emailofgift).sendKeys(email);
	}
	
	public void myname(String Nametwo) {
        driver.findElement(Myname).sendKeys(Nametwo);
	}
	
	public void myemail(String Email) {
        driver.findElement(Myemail).sendKeys(Email);
	}
	
	 public void InformationGiftcard(String Nameone, String email, String Nametwo, String Email) {
		 namewhotakegift(Nameone);
		 emailwhotakegift(email);
		 myname(Nametwo);
		 myemail(Email);
	 }
	 
	 public String getMessageText() {
		    return driver.findElement(messageText).getText();
		}
	 
	 public String getErrorMessageText() {
		    return driver.findElement(errorNotification).getText();
		}
	 
	 public boolean isWishlistButtonPresent() {
		 return driver.findElements( By.id("add-to-wishlist-button-2") ).size() > 0; 
		
	 }

}
