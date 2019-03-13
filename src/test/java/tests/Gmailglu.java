package tests;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Composepage;
import pages.Homepage;
import pages.Loginpage;

public class Gmailglu
{
public WebDriver driver;
public WebDriverWait wait;
public Homepage hp;
public Loginpage lp;
public Composepage cp;
public Properties p;
public Scenario s;

@Before
public void method1(Scenario s) throws Exception
{
	this.s=s;
	File f=new File("C:\\Users\\Harish\\Desktop\\Selenium\\com.gmail_login.BDD\\src\\test\\resources\\proprtis\\gmail.properties");
	FileReader fr=new FileReader(f);
	p=new Properties();
	p.load(fr);
}
@Given("^launch site$")
public void method2()
{
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Harish\\Downloads\\chromedriver_win32\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.get("https://www.gmail.com");
 hp=new Homepage(driver);
 lp=new Loginpage(driver);
 cp=new Composepage(driver);
 wait=new WebDriverWait(driver,20);
 wait.until(ExpectedConditions.visibilityOf(hp.uid));
 driver.manage().window().maximize();
 }
@Then("^title should be\"(.*)\"$")
public void method3(String et)
{
	String at=driver.getTitle();
	if(at.equals(et))
	{
		s.write("gmail title test passed");
	}
	else
	{
		byte[] b=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		s.embed(b, "gmail title test failed");
		Assert.fail();
	}
}
@When("^close site$")
public void method4()
{
	driver.quit();
}
	
@When("^enter uid as \"(.*)\"$")
public void method5(String x)
{
	hp.filluid(x);
}
@And("^click uid next button$")
public void method6()throws Exception
{
	hp.clickuidnext();
	Thread.sleep(5000);
}
@Then("^check uid outcome with \"(.*)\" criteria$")
public void method7(String c)
{
	try
	{
		if(c.equalsIgnoreCase("uid_blank") && hp.blankuiderr.isDisplayed())
		{
			s.write("blank uid test passed");
		}
		else if(c.equalsIgnoreCase("uid_invalid") && hp.invaliduiderr.isDisplayed())
		{
			s.write("Invalid uid test passed");
		}
		else if(c.equalsIgnoreCase("uid-valid") && lp.pwd.isDisplayed())
		{
			s.write("valid uid test passed");
		}
		else
		{
			byte[] b=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			s.embed(b, "uid test failed");
			Assert.fail();
		}
	}	
	catch(Exception ex)
	{
		s.write(ex.getMessage());
		Assert.fail();
	}
}
@And("^enter pwd as \"(.*)\"$")
public void method8(String x)
{
	wait.until(ExpectedConditions.visibilityOf(lp.pwd));
	lp.fillpwd(x);
}
@And("^click pwd next button$")
public void method9() throws Exception
{
	wait.until(ExpectedConditions.elementToBeClickable(lp.pwdnext));
	lp.clickpwdnext();
	Thread.sleep(5000);
}
@Then("^click pwd outcome with \"(.*)\" criteria$")
public void method10(String c)
{
	try 
	{
		if(c.equalsIgnoreCase("pwd-invalid") && lp.blankpwderr.isDisplayed())
		{
			s.write(" blank pwd test passed");
		}
		else if(c.equalsIgnoreCase("pwd-invalid") && lp.invalidpwderr.isDisplayed())
		{
			s.write("invalid pwd test passed");
		}
		else if(c.equalsIgnoreCase("pwd-valid") && cp.comp.isDisplayed())
		{
			s.write("valid pwd test passed");
			//do logout
			cp.clickprofilepic();
			wait.until(ExpectedConditions.elementToBeClickable(cp.signout));
			cp.clicksignout();
		}
		else
		{
			byte[] b=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			s.embed(b, "pwd test failed");
			Assert.fail();
		}
	}
	catch(Exception ex)
	{
		s.write(ex.getMessage());
		Assert.fail();
	}
}



}
