package tests;

import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.EbayHomePage;
import pages.EbayResultsPage;
import helpers.ProductItem;
import static org.hamcrest.CoreMatchers.containsString;

public class EbayTests {
	EbayHomePage ebayHomePage = null;
	EbayResultsPage ebayResultsPage = null;
	List<ProductItem> results = null;
		
	@Test
    @DisplayName("1. Ebay Test")
	public void automationExamTest() {
		ebayHomePage = new EbayHomePage();
		System.out.println(ebayHomePage.getHomePageTitle());
		ebayResultsPage = ebayHomePage.searchItem("Shoes");
        ebayResultsPage.selectPumaBrand();
		ebayResultsPage.selectShoesSizeTen();
		System.out.println(ebayResultsPage.getNumberOfResults());
		ebayResultsPage.orderByPriceAscendant();
		results = ebayResultsPage.getTopResults(5);
		
		for(int index = 0; index < results.size(); index++) {
			Assert.assertThat(results.get(index).getItemName().toLowerCase()
				, containsString("puma"));
			System.out.println(results.get(index).getItemName());
			System.out.println(results.get(index).getItemPrice());
		}
		ebayResultsPage.orderByPriceDescendant();
		results = ebayResultsPage.getTopResults(5);
		
		for(int index = 0; index < results.size(); index++) {
			System.out.println(results.get(index).getItemName());
			System.out.println(results.get(index).getItemPrice());
		}
		
	}
	
	@AfterEach
	public void closeBrowser(){
		ebayHomePage.quitPage();
	}
}
