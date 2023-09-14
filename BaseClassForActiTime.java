package baseClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClassForActiTime {
static ChromeDriver driver;
@BeforeClass
public void OpenBrowser()
{
Reporter.log("Open the chrome Browser",true);
driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
driver.get("https://demo.actitime.com/login.do");
}
@BeforeMethod
public void Login()
{
Reporter.log("Login to the ActiTime Application",true);	
driver.findElement(By.id("username")).sendKeys("admin");
driver.findElement(By.name("pwd")).sendKeys("manager");
driver.findElement(By.xpath("//div[.='Login ']")).click();
}
@AfterMethod
public void Logout()
{
Reporter.log("Logout from ActiTime Application",true);
driver.findElement(By.id("logoutLink")).click();
}
@AfterClass
public void closebrowser()
{
Reporter.log("Close the Browser",true);
driver.close();
}
}
