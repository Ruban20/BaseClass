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

public class OrangeHRM {
	public static ChromeDriver driver;
	public static FileInputStream fis;
	public static Properties p;
	@BeforeClass
	public void OpenBrowser()throws IOException
	{
	Reporter.log("Open the chrome Browser",true);
	fis=new FileInputStream("./DataFiles/orangeHRM.txt");
	p=new Properties();
	p.load(fis);
	String Link=p.getProperty("URL");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	driver.get(Link);
	}
	@BeforeMethod
	public void Login()throws InterruptedException
	{
	Reporter.log("Given the username and password",true);
	String validUserName=p.getProperty("UN");
	String validPassword=p.getProperty("PW");
	driver.findElement(By.name("username")).sendKeys(validUserName);
	Thread.sleep(2000);
	driver.findElement(By.name("password")).sendKeys(validPassword);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@type='submit']")).click();

	}

	 @AfterMethod
	  public void Logout() {
	    Reporter.log("Logout the OrgangeHRM Application", true);
	    driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
	    driver.findElement(By.linkText("Logout")).click();

	  }

	  @AfterClass
	  public void CloseBrowser() {
	    Reporter.log("Close the Chrome Browser", true);
	    driver.close();
	
}
}
