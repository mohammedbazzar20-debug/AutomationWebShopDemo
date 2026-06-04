package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.SearchPage;

public class SearchTest extends BaseTest {
	
	@Test(priority = 1)
	public void ValidSearchproduct() throws InterruptedException {
		SearchPage searching = new SearchPage(driver);
        Thread.sleep(1000);
		searching.Search("laptop");
        Thread.sleep(1000);
        searching.productdetailpage();
        Assert.assertEquals(searching.getProductTitle(),"14.1-inch Laptop");
        System.out.println(searching.getProductTitle());

	}
	@Test(priority = 2)
	public void SearchingunfoundProduct() throws InterruptedException {
		SearchPage searching = new SearchPage(driver);
		Thread.sleep(1000);
		searching.Search("Apple");
		Thread.sleep(1000);
		Thread.sleep(1000);
		Assert.assertEquals( searching.getResultMessage(), "No products were found that matched your criteria." );	
		System.out.println(searching.getResultMessage());
	}
	
}

