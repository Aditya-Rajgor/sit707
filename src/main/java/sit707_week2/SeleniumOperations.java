package sit707_week2;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// Added
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;


public class SeleniumOperations {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void saveScreenshot(WebDriver driver) {
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File("C:/Users/adity/eclipse-workspace/task2_1P/src/main/java/sit707_week2/download.png"));
			System.out.println("The screenshot has been saved.");
		}
		catch (IOException e){ 
			System.out.println("Screenshot failed to take");
			e.printStackTrace();
		}
	}
	
	
	public static void officeworks_registration_page(String url) {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", "C:/Users/adity/chromedriver-win64/chromedriver.exe");
		
		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Driver info: " + driver);
		
		sleep(2);
	
		// Load a web page in chromium browser.
		driver.get(url);
		
		/*
		 * How to identify a HTML input field -
		 * Step 1: Inspect the web page, 
		 * Step 2: locate the input field, 
		 * Step 3: Find out how to identify it, by id/name/...
		 */
		
		// Find first input field which is first name
		WebElement element = driver.findElement(By.id("firstname"));
		System.out.println("Found first name element: " + element);
		// Send first name
		element.sendKeys("Aditya");
		
		/*
		 * Find following input fields and populate with values
		 */
		// Write code
		WebElement lastname = driver.findElement(By.id("lastname"));
		System.out.println("Found last name element: "+ lastname);
		lastname.sendKeys("Rajgor");
		
		// Phone number
		WebElement phoneNumber = driver.findElement(By.id("phoneNumber"));
		System.out.println("Found phone number element: "+ phoneNumber);
		phoneNumber.sendKeys("041234567");
		
		// Email address
		WebElement emailAdd = driver.findElement(By.id("email"));
		System.out.println("Found phone number element: "+ emailAdd);
		emailAdd.sendKeys("test@test.com");
		
		// Ignoring the password requirement purposely. 
		WebElement password = driver.findElement(By.id("password"));
		System.out.println("Found password element: "+ password);
		password.sendKeys("12345678"); //failing the requirements
		
		WebElement confPassword = driver.findElement(By.id("confirmPassword"));
		System.out.println("Found confirm password element: "+ confPassword);
		confPassword.sendKeys("12345678"); //failing the requirements
		
		/*
		 * Identify button 'Create account' and click to submit using Selenium API.
		 */
		// Write code
		WebElement submitButton = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/form/div[12]/button"));
		System.out.println("Found the submit button element" + submitButton);
		submitButton.click();
		System.out.println("Submit button pressed");

		
		/*
		 * Take screenshot using selenium API.
		 */
		// Write code
		saveScreenshot(driver);



		
		// Sleep a while
		sleep(2);
		
		// close chrome driver
		driver.close();	
	}
	

	
	public static void tenfastfingers_regestration(String url) {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", "C:/Users/adity/chromedriver-win64/chromedriver.exe");
		
		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Driver info: " + driver);
		
		sleep(2);
	
		// Load a web page in chromium browser.
		driver.get(url);
		
		sleep(10);
		// closing add (box one)
		WebElement closeAdd = driver.findElement(By.id("closeIconHit"));
		System.out.println("Closing add at element" + closeAdd);
		closeAdd.click();
		
		// closing add (bottom landscape one)
		WebElement closeAdd2 = driver.findElement(By.xpath("//*[@id=\"fs-slot-footer-wrapper\"]/button"));
		System.out.println("Closing add two at element" + closeAdd2);
		closeAdd2.click();
		
		// clicking cookies 
		WebElement acceptCookie = driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll"));
		System.out.println("Accepting cookies");
		acceptCookie.click();
		
		
		
		// filling the form
		
		// Username
		WebElement tenUser = driver.findElement(By.id("UserUsername"));
		System.out.println("Username element: " + tenUser);
		tenUser.sendKeys("fastAndBlast");
		
		// Username
		WebElement tenPass = driver.findElement(By.id("UserPassword"));
		System.out.println("Password Element: " + tenPass);
		tenPass.sendKeys("Abcd1234");
		
		// Username
		WebElement tenConfPass = driver.findElement(By.id("UserPasswordRepeat"));
		System.out.println("Password Confirmation element: " + tenConfPass);
		tenConfPass.sendKeys("Abcd1234");
		
		// Email
		WebElement tenEmail = driver.findElement(By.id("UserEmail"));
		System.out.println("Email element: " + tenEmail);
		tenEmail.sendKeys("test@xyz.com");
		
		// Email repeat
		WebElement tenConfEmail = driver.findElement(By.id("UserEmailRepeat"));
		System.out.println("Email confirmation element: " + tenConfEmail);
		tenConfEmail.sendKeys("test@xyz.com");
		
		// Clicking create account
		WebElement createAcc = driver.findElement(By.xpath("//*[@id=\"login-form\"]/button"));
		System.out.println("Howering over create button");
		// createAcc.click();
		
		//Creating object of an Actions class
		Actions action = new Actions(driver);

		//Performing the mouse hover action on the target element.
		// This turns createAcc element dark green 
		action.moveToElement(createAcc).perform();
		
		// take screenshot
		saveScreenshot(driver);
		
		sleep(2);
		driver.close();
		System.out.println("The webdriver closed.");
		
	}
	
}
