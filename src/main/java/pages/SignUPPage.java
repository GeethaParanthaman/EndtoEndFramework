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

public class SignUPPage extends CommonMethods {
	WebDriverWait wait;
	
	public SignUPPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
	//Home page elements
	@FindBy (linkText = "Sign up")
	WebElement SignUpButtonElement;
	
	//Signup dialog
	@FindBy(id = "sign-username")
	WebElement userNameElement;
	//Password
	@FindBy(id="sign-password")
	WebElement signUpPasswordElement;
	
	//signup button click in signup dialog
	@FindBy(xpath = "//button[text()='Sign up']")
	WebElement SignUpButtonindialogElement;
	//Close button
	@FindBy(xpath="(//button[text()='Close'])[2]")
	WebElement closeButton;		
	
	public void signUpClick()
	{
		SignUpButtonElement.click();
	}
	public void signupDiaglog()
	{
		
		wait.until(ExpectedConditions.visibilityOf(userNameElement)).sendKeys("GeeSaran16");
		wait.until(ExpectedConditions.visibilityOf(signUpPasswordElement)).sendKeys("Test@123");
		wait.until(ExpectedConditions.visibilityOf(SignUpButtonindialogElement)).click();
		wait.until(ExpectedConditions.visibilityOf(closeButton)).click();
		
	}
	
	
	

}
