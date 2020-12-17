package waits;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.MatcherAssert.*;

public class TestEmailAddressWait {

	private static WebDriver driver;

	private static String expectedText = "Warning: The E-Mail Address was not found in our records, please try again!";

	@Test
	public void testEmailAddressText() {
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		assertThat("Error message is not as expected", verifyEmailText());
	}

	private Boolean verifyEmailText() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.textToBePresentInElement(
				driver.findElement(By.cssSelector("#account-forgotten > div.alert.alert-danger.alert-dismissible")),
				expectedText));
	}
}
