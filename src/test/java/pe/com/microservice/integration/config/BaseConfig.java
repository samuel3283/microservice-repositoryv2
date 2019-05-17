package pe.com.microservice.integration.config;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseConfig {

  public WebDriver driver;

  @BeforeMethod()
  public void getDriver() {
    System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
    driver = new ChromeDriver();

    driver.manage().deleteAllCookies();
	String baseUrl = "http://www.booxcargo.booxagency.com/clogin.html";
	baseUrl = "https://www.sodimac.cl/sodimac-cl/";
    driver.navigate().to(baseUrl);

    //System.out.println("Successfully opened the website "+baseUrl);
    driver.manage().window().maximize();
    driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @AfterMethod()
  public void teardownTest() {
    driver.quit();
  }
}
