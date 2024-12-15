package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonMethods {

	public static WebDriver driver;
	
	public static void browserInitialization()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.demoblaze.com");
	}
	public static void switchAlert()
	{
		driver.switchTo().alert();
		String dialogTextActual=driver.switchTo().alert().getText();
		String dialogTextExpected="Sign up successful.";
		Assert.assertEquals(dialogTextActual, dialogTextExpected,"Succesfully completed Signup process");
	}
	
	public static void browserBack()
	{
		System.out.println("The current url:"+driver.getCurrentUrl());
		driver.navigate().back();
	}
	
	public static void alertAccept()
	{
		driver.switchTo().alert().accept();
	}
	public static void browserRefresh()
	{
		driver.navigate().refresh();
	}
	public static void browserClose()
	{
		driver.quit();
	}

}
