package testdata;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import basetest.BaseTest;
import page.MainPage;
import page.SearchPage;
import utilities.FileReaderUtils;

@RunWith(Parameterized.class)
public class TestParameterizedDataFromFile extends BaseTest {
	private MainPage mainPage = new MainPage(driver);
	private SearchPage searchPage = new SearchPage(driver);
	private String productName;

	public TestParameterizedDataFromFile(String productName) {
		super();
		this.productName = productName;
	}

	@Test
	public void testTxtReader() {

		mainPage.writeInputSearch(productName);
		mainPage.clickButtonSearch();

		String actualResult = searchPage.getTextFromLinkFirstItem();

		assertEquals("Actual result does not match expected. Actual result:  " + actualResult + ", but expected:"
				+ productName, productName, actualResult);

	}

	@Parameters
	public static Collection<String> parameters() throws IOException {
		return FileReaderUtils.getTestData("src/test/resources/TestData_3items.txt");
	}
}