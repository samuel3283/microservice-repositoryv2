package pe.com.microservice.integration.test;

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
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pe.com.microservice.integration.config.BaseConfig;

public class TestLogin /*/extends BaseConfig*/ {

	public WebDriver driver;

	@Test
	public void loginTest() {
	    System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
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

	
}
