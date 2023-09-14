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

public class BaseClassForActiTimeWithPropertyFile {
static ChromeDriver driver;
static FileInputStream fis;
static Properties p;
@BeforeClass
public void OpenBrowser()throws IOException
{
Reporter.log("Open the chrome Browser",true);
fis=new FileInputStream("./DataFiles/commondata.txt");
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
driver.findElement(By.id("username")).sendKeys(validUserName);
Thread.sleep(2000);
driver.findElement(By.name("pwd")).sendKeys(validPassword);
Thread.sleep(2000);
driver.findElement(By.xpath("//div[.='Login ']")).click();
Thread.sleep(2000);
}
@AfterMethod
public void Logout()
{
Reporter.log("Logout for the application",true);
driver.findElement(By.id("logoutLink")).click();
}
@AfterClass
public void closeBrowser()
{
Reporter.log("Close the Browser",true);
driver.close();
}
}
