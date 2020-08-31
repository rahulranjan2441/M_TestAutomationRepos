package TestAssignment.M_QA;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class m_Blazedemo_FlightConfirmationPage 
{
	WebDriver driver;
	
	public m_Blazedemo_FlightConfirmationPage(WebDriver localdriver)
	{
		this.driver=localdriver;
	}
	
	@FindBy(how=How.XPATH,using="/html/body/div[2]/div/h1") WebElement Confirmation_Message;
	@FindBy(how=How.XPATH,using="/html/body/div[2]/div/table/tbody/tr") List<WebElement> FlightBookingConfirmation_Details;
	@FindBy(how=How.XPATH,using="/html/body/div[2]/div/table/tbody/tr[1]/td[2]") WebElement Flight_BookingID;
	
	public void m_Blazedemo_FlightTicketConfirmation()
	{
		//Confirmation Page:
		String ConfirmationMessage = Confirmation_Message.getText();
		Assert.assertTrue(ConfirmationMessage.contains("Thank you for your purchase today!"));
		
		List<WebElement> FlightBookingConfirmationDetails = FlightBookingConfirmation_Details;
		for(int k=1;k<= FlightBookingConfirmationDetails.size();k++)
		{
			String ConfirmationFlightDetails = driver.findElement(By.xpath("/html/body/div[2]/div/table/tbody/tr["+k+"]")).getText();
			System.out.println("Flight Booking Confirmation details (0"+k+"): "+ConfirmationFlightDetails);
		}
		String BookingID = Flight_BookingID.getText();
		System.out.println("Flight Booking ID: "+ BookingID);
	}
}
