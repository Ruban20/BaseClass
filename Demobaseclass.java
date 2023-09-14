package baseClass;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class Demobaseclass {
@BeforeClass
public void OpenBrowser()
{
	Reporter.log("Open the browser",true);
}
@BeforeMethod
public void Login()
{
Reporter.log("Login",true);
}
@AfterMethod
public void Logout()
{
Reporter.log("Logout",true);
}
@AfterClass
public void Close()
{
Reporter.log("Close",true);
}
}
