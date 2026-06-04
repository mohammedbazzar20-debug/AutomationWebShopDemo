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
	}
