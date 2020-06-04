package AppliToll_01.App_01;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.applitools.eyes.selenium.Eyes;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class ThirdTaskForV1 {

	WebDriver driver;
	JavascriptExecutor js ;
	
	
	@Test
	@Parameters("browser")
	public void ProductDetail(String browserName) throws InterruptedException, IOException
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
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		driver.get("https://demo.applitools.com/gridHackathonV1.html");
		Thread.sleep(3000);
		Eyes eyes = new Eyes();
		eyes.setApiKey("put your apikey");
		eyes.open(driver, "Applitool","ProductDeatailTest");
		driver.get("https://demo.applitools.com/gridHackathonV1.html");
		eyes.checkWindow("Browser");
		
		
		
		System.out.println(driver.manage().window().getSize());
		Dimension d = new Dimension(992, 500);
		driver.manage().window().setSize(d);
		System.out.println(driver.manage().window().getSize());
		driver.manage().window().maximize();
		
		//clicking on black color
		driver.findElement(By.xpath("//span[@id='SPAN__checkmark__107']")).click();
		//clicking on filter button
		driver.findElement(By.xpath("//button[@id='filterBtn']")).click();
		Thread.sleep(5000);
		
		//scrolling
		 js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(5000);
		
		//selecting first shoes
		driver.findElement(By.xpath("(//img[contains(@class,'img-fluid ')])[1]")).click();
		String ShoesName = driver.findElement(By.xpath("//h1[text()='Appli Air x Night']")).getText();
		if(ShoesName.equals("Appli Air x Night"))
		{
			System.out.println("Product Detail opend");
		}
		else
		{
			System.out.println("Product Deatail not Opend");
		}
	    Thread.sleep(2000);
		
		
	    eyes.close();
		
		driver.close();
	
	}
	
}
