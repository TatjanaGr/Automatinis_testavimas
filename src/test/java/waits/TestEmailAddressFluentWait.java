package waits;

import org.junit.After;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import static org.hamcrest.MatcherAssert.*;

import java.time.Duration;

import java.util.function.Function;

public class TestEmailAddressFluentWait {

	private static WebDriver driver;
	private static String expectedText = "Warning: The E-Mail Address was not found in our records, please try again!";

	// private static String expectedText = "Warning: The E-Mail Address was found
	// in our records!";
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.opencart.com/index.php?route=account/forgotten");

	}

	@After
	public void tearDown() {
		// driver.close();
	}

	@Test
	public void testEmailAddressText() {
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		assertThat("Error message is not as expected", verifyEmailText());
	}

	private Boolean verifyEmailText() {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofMillis(50)).ignoring(NoSuchElementException.class);

		WebElement alertElement = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//div[contains(@class='alert']")); //
			}

		});
		return alertElement.getText().contains(expectedText);
	}
}
