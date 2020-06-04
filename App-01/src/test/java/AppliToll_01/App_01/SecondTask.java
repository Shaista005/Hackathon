package AppliToll_01.App_01;

import java.io.File;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.applitools.eyes.selenium.Eyes;

import org.openqa.selenium.JavascriptExecutor;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import org.openqa.selenium.WebElement;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class SecondTask {

	WebDriver driver;
	JavascriptExecutor js ;
	
	
	@Test
	@Parameters("browser")
	public void Shopping(String browserName) throws InterruptedException, IOException
	{
		if(browserName.equalsIgnoreCase("firefox"))
		{
			//WebDriverManager.firefoxdriver().setup();
			System.setProperty("webdriver.gecko.driver","E:\\eclipseEE\\seleniumTesting\\App-01\\Geckodriver\\geckodriver.exe");
            driver = new FirefoxDriver();
			 
		}
		
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			    //WebDriverManager.firefoxdriver().setup();
			System.setProperty("webdriver.chrome.driver","E:\\eclipseEE\\seleniumTesting\\App-01\\Chrome81\\chromedriver.exe");
			 driver = new ChromeDriver();

		}
		
		else if(browserName.equalsIgnoreCase("ie"))
		{
			    //WebDriverManager.firefoxdriver().setup();
			System.setProperty("webdriver.ie.driver","E:\\eclipseEE\\seleniumTesting\\App-01\\InternetExplorerDriver\\IEDriverServer.exe");
			 driver = new InternetExplorerDriver();
			
		}		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		System.out.println(driver.manage().window().getSize());
		Dimension d = new Dimension(992, 500);
		driver.manage().window().setSize(d);
		System.out.println(driver.manage().window().getSize());
		driver.manage().window().maximize();
		
		Eyes eyes = new Eyes();
		eyes.setApiKey("put your api key");
		eyes.open(driver, "Applitool","ShoppingTest");
		driver.get("https://demo.applitools.com/gridHackathonV1.html");
		eyes.checkWindow("Browser");
		
		
		//clicking on black color
		driver.findElement(By.xpath("//span[@id='SPAN__checkmark__107']")).click();
		//clicking on filter button
		driver.findElement(By.xpath("//button[@id='filterBtn']")).click();
		Thread.sleep(2000);
		
		 js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,150)");
		Thread.sleep(2000);
		
		WebElement webElement = driver.findElement(By.xpath("(//div[contains(@class,'row small-gutters')])[3]"));
		Screenshot screenshot = new AShot().takeScreenshot(driver,webElement);
	    ImageIO.write(screenshot.getImage(),"PNG",new File("E:\\eclipseEE\\seleniumTesting\\App-01\\Screenshot\\ElementScreenshotV1.png"));
	    Thread.sleep(2000);
		
		
		eyes.close();
		driver.close();
	}

}
	
	
