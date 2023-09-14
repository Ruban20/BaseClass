package baseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClassTripit {
	public static ChromeDriver driver;
	public static FileInputStream fis;
	public static Properties p;

	@BeforeClass
	public void OpenBrowser() throws IOException {
		Reporter.log("Open the chrome Browser", true);
		fis = new FileInputStream("./DataFiles/triplit.txt");
		p = new Properties();
		p.load(fis);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.get("https://www.tripit.com/web");
		
	}

	@BeforeMethod
	public void Login() throws InterruptedException {
		Reporter.log("Given the username and password", true);
		String validUserName = p.getProperty("UN");
		String validPassword = p.getProperty("PW");
		driver.findElement(By.xpath("//a[.='Sign In']")).click();
		driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys(validUserName);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys(validPassword);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//*[@id='new_webapp_onboarding_modal_close']")).click();

	}

	@AfterMethod
	public void Logout() throws InterruptedException {
		Reporter.log("Logout the Application", true);
		driver.findElement(By.xpath("//*[@id='account-name']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='sign-out-link']")).click();

	}

	@AfterClass
	public void CloseBrowser() {
		Reporter.log("Close the Chrome Browser", true);
		driver.close();

	}
}
