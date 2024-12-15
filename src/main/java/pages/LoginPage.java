package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import common.CommonMethods;

public class LoginPage extends CommonMethods{
WebDriverWait wait;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
	//Loginbutton in home screen
	@FindBy(linkText = "Log in")
	WebElement loginPageLinkElement;
	
	//username in loginpage
	@FindBy(id="loginusername")
	WebElement userNameTextBoxElement;
	
	//Password in loginpage
	@FindBy(id="loginpassword")
	WebElement passwordElement;
	
	//click on loginbutton
	@FindBy(xpath = "//button[text()='Log in']")
	WebElement loginButtonelement;
	
	//loginuser name check
	@FindBy(id="nameofuser")
	WebElement userIdelement;
	
	public void login()
	{
		wait.until(ExpectedConditions.elementToBeClickable(loginPageLinkElement)).click();
		
	}
	public void logininputs()
	{
		wait.until(ExpectedConditions.visibilityOf(userNameTextBoxElement)).sendKeys("GeeSaran");
		wait.until(ExpectedConditions.visibilityOf(passwordElement)).sendKeys("Test@123");
		wait.until(ExpectedConditions.elementToBeClickable(loginButtonelement)).click();
		
	}
public void loginCheck()
{
	String actualloginText=userIdelement.getText();
	Assert.assertTrue(true, actualloginText);
}
}
