package pe.com.microservice.integration;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//@RunWith(MockitoJUnitRunner.class)
public class Login2 {

	//@Test
	public void loginTest() {
		//System.setProperty("webdriver.chrome.driver","D:\\Tools\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseUrl = "http://www.booxcargo.booxagency.com/clogin.html";

		String username="samuel3283@gmail.com";
		String password="admin";
			
		driver.navigate().to(baseUrl);
		driver.findElements(By.cssSelector("input[type='email']")).get(0).sendKeys(username);
		driver.findElements(By.cssSelector("input[type='password']")).get(0).sendKeys(password);
		driver.findElement(By.id("boton_enviar")).click();
		
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    Boolean response = wait.until(
	           ExpectedConditions.urlContains("clogin.html")
	            );
	    
	    System.out.println("getCurrentUrl:::::::"+driver.getCurrentUrl());		
		assertTrue(response);
		
		driver.quit();		
	}

	
	/*
	@Test
	public void loginTest() {
		System.setProperty("webdriver.chrome.driver","D:\\Tools\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseUrl = "http://localhost:4200";

		String username="snavarro";
		String password="admin";
			
		driver.navigate().to(baseUrl);
		driver.findElement(By.name("usuario")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.id("loginButton")).click();
		
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    Boolean messageElement = wait.until(
	           ExpectedConditions.urlContains("main")
	            );
	    

	    System.out.println("getCurrentUrl:::::::"+driver.getCurrentUrl());
		
		assertTrue(messageElement);
		//Assert.assertEquals (message, successMsg);	    
		
		driver.quit();		
	}
	*/
	
	/*
	@Test
	public void loginTest() {
		System.setProperty("webdriver.chrome.driver","D:\\Tools\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseUrl = "http://localhost:4200";

		String username="snavarro";
		String password="admin";
			
		driver.navigate().to(baseUrl);
		driver.findElement(By.name("usuario")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.id("loginButton")).click();
		
		//System.out.println("getPageSource::::"+driver.getPageSource());
		
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//WebDriverWait wait = new WebDriverWait(driver, 10);
	 
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    WebElement messageElement = wait.until(
	           ExpectedConditions.presenceOfElementLocated(By.id("nameUsuario"))
	            );

	    String message                 = messageElement.getText();
	    String successMsg             = "Welcome";
	    //Assert.assertEquals (message, successMsg);	    

	    //System.out.println("getCurrentUrl:::::::"+driver.getCurrentUrl());
		//http://localhost:4200/login

		assertTrue(message.length() > 0);

		driver.quit();		
	}
	*/

	/*
	@Test
	public void loginErrorTest() {
		System.setProperty("webdriver.chrome.driver","D:\\Tools\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseUrl = "http://localhost:4200";

		String username="snavarro";
		String password="anose";
			
		driver.navigate().to(baseUrl);
		driver.findElement(By.name("usuario")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.id("loginButton")).click();
			 
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    WebElement messageElement = wait.until(
	           ExpectedConditions.presenceOfElementLocated(By.id("message"))
	            );

	    String message                 = messageElement.getText();
	    String successMsg             = "Error Login";
	    //Assert.assertEquals (message, successMsg);	    
		assertTrue(message.length() > 0);

		driver.quit();		
	}
*/
}
