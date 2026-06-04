package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.WishListPage;

public class WishListTest extends BaseTest {
	
	@Test(priority = 1)
	public void ValidAddingtoWishList() throws InterruptedException {
		
		WishListPage wishlist = new WishListPage (driver);
		wishlist.giftCardpage();
		Thread.sleep(1000);
		wishlist.InformationGiftcard("Ahmad", "user1780613996804@gmail.com", "AceHaxor", "AutomationTesting988982@gmail.com");
		Thread.sleep(1000);

		wishlist.Addingtowishlist();
		Thread.sleep(1000);

		Assert.assertEquals(wishlist.getMessageText(),"The product has been added to your wishlist");	
		System.out.println(wishlist.getMessageText());
		
	}
	
	@Test(priority = 2)
	public void addinggiftwithoutemailtowishlist() throws InterruptedException {
		
		WishListPage wishlist = new WishListPage (driver);
		wishlist.giftCardpage();
		Thread.sleep(1000);
		wishlist.InformationGiftcard("Ahmad", "", "AceHaxor", "AutomationTesting988982@gmail.com");
		Thread.sleep(1000);

		wishlist.Addingtowishlist();
		Thread.sleep(1000);

		Assert.assertTrue( wishlist.getErrorMessageText() .contains("Enter valid recipient email") );
		System.out.println(wishlist.getErrorMessageText());
		
	}
	
	@Test(priority = 3)
	public void verifyWishlistButtonPresence() {

	    WishListPage wishlist = new WishListPage(driver);

	    wishlist.CheapComputer();

	    if (wishlist.isWishlistButtonPresent()) {
	        System.out.println("Wishlist button exists");
	    } else {
	        System.out.println("Wishlist button is missing → possible bug");
	    }

	    Assert.assertTrue(wishlist.isWishlistButtonPresent());
	}

}
