package waits;

import org.junit.After;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.MatcherAssert.*;

public class TestEmailAddressWait2 {

	private static WebDriver driver;

	private static String unexpectedText = "Warning: The E-Mail Address was found in our records!";

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.opencart.com/index.php?route=account/forgotten");

	}

	@After
	public void tearDown() {
		driver.close();
	}

	@Test
	public void testEmailAddressText() {
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		assertThat("Error message is not as expected", verifyEmailText());
	}

	private Boolean verifyEmailText() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.textToBePresentInElement(
				driver.findElement(By.cssSelector("#account-forgotten > div.alert.alert-danger.alert-dismissible")),
				unexpectedText));
	}
}
