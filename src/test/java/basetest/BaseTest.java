package basetest;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTest {
	protected static WebDriver driver;

	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@Before
	public void openHomepage() {
		driver.get("https://demo.opencart.com");

	}

	@AfterClass
	public static void tearDown() {
		driver.manage().deleteAllCookies();
		driver.close();
	}
}
