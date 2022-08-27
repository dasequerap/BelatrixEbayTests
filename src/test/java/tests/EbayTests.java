package tests;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import pages.EbayHomePage;
import pages.EbayResultsPage;
import models.ProductItemModel;

class EbayTests {
	static EbayHomePage ebayHomePage = null;
	EbayResultsPage ebayResultsPage = null;
	//List<ProductItemModel> results = null;

	@BeforeAll
	static void setUp() throws IOException {
		ebayHomePage = new EbayHomePage();
	}

	@Test
    @DisplayName("1. Ebay Test")
	void automationExamTest() {
		ebayHomePage.get();
		/*ebayResultsPage = ebayHomePage.searchItem("Shoes");
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
		}*/
	}
	
	@AfterAll
	static void tearDown(){
		ebayHomePage.quit();
	}
}
