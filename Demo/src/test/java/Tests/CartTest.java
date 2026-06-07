package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.CartPage;
import Pages.SearchPage;

public class CartTest extends BaseTest {
	@Test(priority = 1)
	public void addProductToCartFrompageproduct() throws InterruptedException {

	    SearchPage search = new SearchPage(driver);
	    CartPage cart = new CartPage(driver);

	    search.Search("laptop");

	    search.productdetailpage();

	    cart.addtocartProductPage();
	    System.out.println("Add to cart clicked");

	    Thread.sleep(1000);

	    Assert.assertEquals(
	        cart.getSuccessMessage(),
	        "The product has been added to your shopping cart"
	    );

	    System.out.println(cart.getSuccessMessage());
	}
	

	@Test(priority = 2)
	public void addProductToCartnextSearch() throws InterruptedException {

	    SearchPage search = new SearchPage(driver);
	    CartPage cart = new CartPage(driver);

	    search.Search("book");

	    cart.addFirstProductToCart();

	    Thread.sleep(1000);

	    Assert.assertEquals(
	        cart.getSuccessMessage(),
	        "The product has been added to your shopping cart"
	    );

	    System.out.println(cart.getSuccessMessage());
	}
	@Test(priority = 3)
	public void addProductToCartFromHomePage()
	        throws InterruptedException {

	    CartPage cart = new CartPage(driver);

	    cart.addsecondProductToCart();

	    Thread.sleep(1000);

	    Assert.assertEquals(
	        cart.getSuccessMessage(),
	        "The product has been added to your shopping cart"
	    );

	    System.out.println(cart.getSuccessMessage());
	}
	
	@Test(priority = 4)
	public void removeProductFromCart() throws InterruptedException {

	    SearchPage search = new SearchPage(driver);
	    CartPage cart = new CartPage(driver);

	    search.Search("laptop");
	    search.productdetailpage();

	    cart.addtocartProductPage();

	    Thread.sleep(1000);

	    cart.openShoppingCart();

	    cart.removeProduct();

	    cart.updateCart();

	    Assert.assertTrue(
	            cart.getEmptyCartMessage()
	                    .contains("Your Shopping Cart is empty!")
	    );

	    System.out.println("Product removed successfully.");
	}
	
	@Test(priority = 5)
	public void verifyProductPriceInCart() throws InterruptedException {

	    SearchPage search = new SearchPage(driver);
	    CartPage cart = new CartPage(driver);

	    search.Search("laptop");

	    search.productdetailpage();

	    cart.addtocartProductPage();

	    Thread.sleep(1000);

	    cart.openShoppingCart();

	    Assert.assertEquals(
	            cart.getProductPrice(),
	            "1590.00"
	    );

	    System.out.println("Price verified successfully.");
	}
	
	}
