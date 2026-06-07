package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.WishListPage;

public class WishListTest extends BaseTest {
	
	@Test(priority = 1)
	public void ValidAddingtoWishList() {
		
		WishListPage wishlist = new WishListPage (driver);
		wishlist.giftCardpage();
		waitSeconds(2);
		wishlist.InformationGiftcard("Ahmad", "user1780613996804@gmail.com", "AceHaxor", "AutomationTesting988982@gmail.com");
		waitSeconds(2);

		wishlist.Addingtowishlist();
		waitSeconds(2);

		Assert.assertEquals(wishlist.getMessageText(),"The product has been added to your wishlist");	
		System.out.println(wishlist.getMessageText());
		
	}
	
	@Test(priority = 2)
	public void addinggiftwithoutemailtowishlist() {
		
		WishListPage wishlist = new WishListPage (driver);
		wishlist.giftCardpage();
		waitSeconds(2);
		wishlist.InformationGiftcard("Ahmad", "", "AceHaxor", "AutomationTesting988982@gmail.com");
		waitSeconds(2);

		wishlist.Addingtowishlist();
		waitSeconds(2);

		Assert.assertTrue( wishlist.getErrorMessageText() .contains("Enter valid recipient email") );
		System.out.println(wishlist.getErrorMessageText());
		
	}
	
	@Test(priority = 3)
	public void verifyWishlistButtonPresence() {

	    WishListPage wishlist = new WishListPage(driver);
	    waitSeconds(2);
	    wishlist.CheapComputer();
	    waitSeconds(2);
	    
	    if (wishlist.isWishlistButtonPresent()) {
	        System.out.println("Wishlist button exists");
	    } else {
	        System.out.println("Wishlist button is missing → possible bug");
	    }
	    waitSeconds(2);

	    Assert.assertTrue(wishlist.isWishlistButtonPresent());
	}
	
	@Test(priority = 4)
	public void removeProductFromWishlist() {

	    WishListPage wishlist = new WishListPage(driver);
	    waitSeconds(2);
	    
	    wishlist.giftCardpage();
	    waitSeconds(2);
	    
	    wishlist.InformationGiftcard(
	            "Ahmad",
	            "user@gmail.com",
	            "Ace",
	            "sender@gmail.com"
	    );

	    wishlist.Addingtowishlist();

	    waitSeconds(2);

	    wishlist.Oopenwishlist();

	    wishlist.removeProduct();

	    wishlist.updateWishlist();

	    Assert.assertEquals(
	            wishlist.getEmptyWishlistMessage(),
	            "The wishlist is empty!"
	    );

	    System.out.println("Wishlist is empty.");
	}
}
