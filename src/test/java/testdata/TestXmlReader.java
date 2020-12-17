package testdata;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import basetest.BaseTest;
import models.ShopItem;
import page.MainPage;
import page.SearchPage;
import utilities.FileReaderUtils;

public class TestXmlReader extends BaseTest {
	private MainPage mainPage = new MainPage(driver);
	private SearchPage searchPage = new SearchPage(driver);

	@Test
	public void testXmlReader() throws IOException {

		ShopItem item = new ShopItem();
		item.setName("iPhone");
		item.setBrand("Apple");
		item.setPrice("$123.20");

		String fileName = "phone";

		FileReaderUtils.writeShopItemToFile(item, fileName);

		ShopItem iPhone = FileReaderUtils.readFileToShopItem(fileName);
		String expectedName = iPhone.getName();

		mainPage.writeInputSearch(expectedName);
		mainPage.clickButtonSearch();

		String actualResult = searchPage.getTextFromLinkFirstItem();

		assertEquals("Actual result does not match expected. Actual result:  " + actualResult + ", but expected:"
				+ expectedName, expectedName, actualResult);

	}
}
