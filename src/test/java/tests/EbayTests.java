package tests;

import java.util.List;

import helpers.FirefoxWebdriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.EbayHomePage;
import pages.EbayResultsPage;
import helpers.ProductItem;

public class EbayTests {
	static EbayHomePage ebayHomePage = null;
	EbayResultsPage ebayResultsPage = null;
	List<ProductItem> results = null;

	@BeforeAll
	static void setUp(){
		ebayHomePage = new EbayHomePage();
	}

	@Test
    @DisplayName("1. Ebay Test")
	public void automationExamTest() {
		ebayHomePage.get();
		System.out.println(ebayHomePage.getHomePageTitle());
		ebayResultsPage = ebayHomePage.searchItem("Shoes");
        /*ebayResultsPage.selectPumaBrand();
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
		}*/
	}
	
	@AfterAll
	static void tearDown(){
		ebayHomePage.quit();
	}
}
