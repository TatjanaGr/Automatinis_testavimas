package waits;

import static org.junit.Assert.*;

import org.junit.Test;

import basetest.BaseTest;
import page.MainPage;

public class TestCart extends BaseTest {

	private MainPage mainPage = new MainPage(driver);

	@Test
	public void test() {
		String text = "%s item(s)";
		mainPage.clickLinkDesktops();
		mainPage.clickAllLinkDesktops();

//		mainPage.clickAddToCart("iPhone");
//		mainPage.clickAddToCart("MacBook");
//		mainPage.clickAddToCart("Sony VAIO");

		addToCart("iPhone", "MacBook", "Sony VAIO");
		String actualCartText = mainPage.buttonCart.getText();
		// String expectedCartText = "3 item(s)";
		String expectedCartText = String.format(text, 3);
		assertTrue("Cart does not contain expected text", actualCartText.contains(expectedCartText));

//		mainPage.removeItemFromCart();
//		mainPage.removeItemFromCart();
//		mainPage.removeItemFromCart();
		
		mainPage.getButtonsRemoveItem().forEach(button -> mainPage.removeItemFromCart());

		actualCartText = mainPage.buttonCart.getText();
	//	expectedCartText = "0 item(s)";
		expectedCartText = String.format(text, 0);
		assertTrue("Cart does not contain expected text", actualCartText.contains(expectedCartText));
	}

	private void addToCart(String... productNames) {
		for (String name : productNames) {
			mainPage.clickAddToCart(name);
		}

	}
}
