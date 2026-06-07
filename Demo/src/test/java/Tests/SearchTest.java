package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.SearchPage;

public class SearchTest extends BaseTest {
	
	@Test(priority = 1)
	public void ValidSearchproduct() {
		SearchPage searching = new SearchPage(driver);
		waitSeconds(2);
		searching.Search("laptop");
		waitSeconds(2);
        searching.productdetailpage();
        Assert.assertEquals(searching.getProductTitle(),"14.1-inch Laptop");
        System.out.println(searching.getProductTitle());

	}
	@Test(priority = 2)
	public void SearchingunfoundProduct() {
		SearchPage searching = new SearchPage(driver);
		waitSeconds(2);
		searching.Search("Apple");
		waitSeconds(2);
		Assert.assertEquals( searching.getResultMessage(), "No products were found that matched your criteria." );	
		System.out.println(searching.getResultMessage());
	}
	
}

