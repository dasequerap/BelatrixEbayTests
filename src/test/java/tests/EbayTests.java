package tests;

import java.util.List;

import org.hamcrest.MatcherAssert;
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
		results = ebayResultsPage.getTopResults();

		for (ProductItem result : results) {
			MatcherAssert.assertThat(result.getItemName().toLowerCase()
					, containsString("puma"));
			System.out.println(result.getItemName());
			System.out.println(result.getItemPrice());
		}
		ebayResultsPage.orderByPriceDescendant();
		results = ebayResultsPage.getTopResults();

		for (ProductItem result : results) {
			System.out.println(result.getItemName());
			System.out.println(result.getItemPrice());
		}
		
	}
	
	@AfterEach
	public void closeBrowser(){
		ebayHomePage.quitPage();
	}
}
