package TestAssignment.M_QA;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class m_Blazedemo_SelectFlight 
{
	WebDriver driver;
	
	public m_Blazedemo_SelectFlight(WebDriver localdriver)
	{
		this.driver = localdriver;
	}
	
	@FindBy(how=How.XPATH,using="/html[1]/body[1]/div[2]/h3[1]") WebElement flightDetails_Title;
	@FindBy(how=How.XPATH,using="//body//tbody//tr") List<WebElement> FlightsNumber_available;
	@FindBy(how=How.XPATH,using="//tr[1]//td[1]//input[1]") WebElement ChooseFlight;
	
	
	public void m_Blazedemo_ChooseFlights()
	{
		// select flight
		String VerifyFlightDetailsPageTitle = flightDetails_Title.getText();
		Assert.assertTrue(VerifyFlightDetailsPageTitle.contains("Flights from Portland to London"), "loaded page is not correct");
		
		List<WebElement> NumberOfFlightsAvailable = FlightsNumber_available;
		if(NumberOfFlightsAvailable.size()!=0)
		{
			System.out.println("Number of flights available: "+NumberOfFlightsAvailable);
			for(int j=2;j<=NumberOfFlightsAvailable.size();j++)
			{
				String flightDetails = driver.findElement(By.xpath("//tr[1]//td["+j+"]")).getText();
				System.out.println("Flight details (0"+j+"): " + flightDetails);
			}
			ChooseFlight.click();
				
		}else
		{
			System.out.println("No flights are available");
		}			
	}
}
