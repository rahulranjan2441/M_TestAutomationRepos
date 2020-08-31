package TestAssignment.M_QA;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class m_Blazedemo_FlightBookingDetails 
{
	WebDriver driver;
	
	public m_Blazedemo_FlightBookingDetails(WebDriver localdriver)
	{
		this.driver = localdriver;
	}
	
	@FindBy(how=How.XPATH,using="/html[1]/body[1]/div[2]/h2[1]") WebElement VerifyHomePageTitle;
	@FindBy(how=How.XPATH,using="/html[1]/body[1]/div[2]/p") List<WebElement> getflightNumbers;
	@FindBy(how=How.ID,using="inputName") WebElement FirstlastName;
	@FindBy(how=How.ID,using="address") WebElement Address;
	@FindBy(how=How.ID,using="city") WebElement City;
	@FindBy(how=How.ID,using="state") WebElement State;
	@FindBy(how=How.ID,using="zipCode") WebElement ZipCode;
	@FindBy(how=How.XPATH,using="//select[@id='cardType']") WebElement CardType;
	@FindBy(how=How.ID,using="creditCardNumber") WebElement CreditCardNumber;
	@FindBy(how=How.ID,using="nameOnCard") WebElement NameonCard;
	@FindBy(how=How.ID,using="rememberMe") WebElement RememberMe;
	@FindBy(how=How.XPATH,using="//input[@class='btn btn-primary']") WebElement PurchaseFlight;
	
	public void m_Blazedemo_FlightTicketsDetails()
	{
		// enter all details to book the flight:
		String VerifyFlightBookingDetailsPageTitle = VerifyHomePageTitle.getText();
		Assert.assertTrue(VerifyFlightBookingDetailsPageTitle.contains("Your flight from TLV to SFO has been reserved."));
		
		List<WebElement> getSelectedFlilghtDetails = getflightNumbers;
		for(int i = 1;i<getSelectedFlilghtDetails.size();i++)
		{
			String getDetails02 = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/p["+i+"]")).getText();
			System.out.println("Ticket details (0"+i+"): "+getDetails02);
		}
		
		FirstlastName.sendKeys("TestName");
		Address.sendKeys("Test Address 123");
		City.sendKeys("TestCity");
		State.sendKeys("TestState");
		ZipCode.sendKeys("12345");
		WebElement Cardtype = CardType;
		Select sel2 = new Select(Cardtype);
		sel2.selectByValue("amex");
		CreditCardNumber.sendKeys("987654321");
		
		NameonCard.sendKeys("testName CardHolder");
		boolean RememberMe_CB = RememberMe.isSelected();
		Assert.assertFalse(RememberMe_CB, "Remember me - checkbox is not selected");
		
		PurchaseFlight.click();
	}
}
