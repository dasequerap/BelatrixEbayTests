package tests;

import java.io.IOException;

import helpers.FirefoxWebDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import models.ProductItemModel;
import pages.EbayHomePage;
import pages.EbayResultsPage;

class EbayTests {
	static EbayHomePage ebayHomePage = null;
	EbayResultsPage ebayResultsPage = null;
	//List<ProductItemModel> results = null;
	ProductItemModel productItem;
	static FirefoxWebDriver driver;

	@BeforeAll
	static void setUp() throws IOException {
		driver = new FirefoxWebDriver();
		driver.initDriver();
	}

	@Test
    @DisplayName("1. Ebay Test")
	void automationExamTest() throws IOException {
		ebayHomePage = new EbayHomePage(this.driver);
		productItem = new ProductItemModel.ProductItemBuilder()
				.name("puma")
				.price("20000")
				.build();

		ebayHomePage.get();
		ebayResultsPage = ebayHomePage.search("Shoes");
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
