package TestAssignment.M_QA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class m_Blazedemo_Homepage 
{
	WebDriver driver;
	
	public m_Blazedemo_Homepage(WebDriver localdriver)
	{
		this.driver=localdriver;
	}
	
	@FindBy(how=How.XPATH,using="/html[1]/body[1]/div[3]/form[1]/select[1]") WebElement fromPort_text;
	@FindBy(how=How.XPATH,using="/html[1]/body[1]/div[3]/form[1]/select[2]") WebElement toPort;
	@FindBy(how=How.XPATH,using="//input[@class='btn btn-primary']") WebElement findFlights;
	
	public void m_SelectPorts()
	{
		String PageTitle = driver.getTitle();
		Assert.assertTrue(PageTitle.equals("BlazeDemo"));
		
		//select ports
		Select select_fromPort = new Select(fromPort_text);
		select_fromPort.selectByValue("Portland");
		
		Select select_toPort = new Select(toPort);
		select_toPort.selectByValue("London");
		
		findFlights.click();
	}
}
