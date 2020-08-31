package TestAssignment.M_QA;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class m_executableTestClass 
{
	WebDriver driver;
	
	@BeforeTest
	public void SetUp_Browser() throws InterruptedException
	{
		//Browser set up
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\java\\TestAssignment\\M_QA\\TestDataFolder\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(12,TimeUnit.SECONDS);
		
		//http://blazedemo.com/
		driver.get("http://blazedemo.com/");
	}
	
	@Test
	public void blazedemo_FlightBookings() throws InterruptedException
	{
		m_Blazedemo_Homepage mbh = PageFactory.initElements(driver, m_Blazedemo_Homepage.class);
		mbh.m_SelectPorts();
		
		m_Blazedemo_SelectFlight mbs = PageFactory.initElements(driver, m_Blazedemo_SelectFlight.class);
		mbs.m_Blazedemo_ChooseFlights();
		
		m_Blazedemo_FlightBookingDetails mbf = PageFactory.initElements(driver, m_Blazedemo_FlightBookingDetails.class);
		mbf.m_Blazedemo_FlightTicketsDetails();
		
		m_Blazedemo_FlightConfirmationPage mbfc = PageFactory.initElements(driver, m_Blazedemo_FlightConfirmationPage.class);
		mbfc.m_Blazedemo_FlightTicketConfirmation();
				
	}
	
	@AfterTest
	public void Close_Browser() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}
	
}
