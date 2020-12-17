package asserts;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestHamcrest {

	private WebDriver driver;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.opencart.com/");

	}

	@After
	public void tearDown() {
		// driver.close();
	}

	@Test
	public void test() {
		driver.findElement(By.id("wishlist-total")).click();
		// TODO: (1) Change it to compare size(Hamcrest)
		assertThat("Number of Search Box/es is/are not 1:", driver.findElements(By.id("search")).size(), is(1));

		String listElement = driver.findElement(By.id("wishlist-total")).getText();
		String expectedString = "Wish List (0)";
		// TODO: (2) Change it to compare text (Hamcrest)
		assertThat("Element name is not: ", listElement, is(expectedString));

		WebElement emailElement = driver.findElement(By.id("input-email"));
		String email = "testing123";
		emailElement.sendKeys(email);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		emailElement = driver.findElement(By.id("input-email"));
		// TODO: (3) Change it to use allOf( is(equalTo()) and containsString() )
		// (Hamcrest)
		assertThat(emailElement.getAttribute("value"), allOf(is(equalTo(email)), containsString("123")));

		boolean cartElement = driver.findElement(By.id("cart")).isDisplayed();
		// TODO: (4) Change it to compare bollean value (Hamcrest)
		// assertThat("Cart button is not displayed: ", cartElement, is(true));
		assertThat(cartElement, is(true));

		driver.findElement(By.linkText("Register")).click();
		boolean agreeElement = driver.findElement(By.name("agree")).isSelected();
		// TODO: (5) Change it to is(not()) (Hamcrest)
		assertThat("Is Agree checkbox not selected: ", agreeElement, is(false));
	}

}
