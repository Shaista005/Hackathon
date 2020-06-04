package AppliToll_01.App_01;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.applitools.eyes.selenium.Eyes;

public class FirstTask {

		WebDriver driver;
		
		
		@Test
		@Parameters("browser")
		public void Check(String browserName)
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
			
			Eyes eyes = new Eyes();
			eyes.setApiKey("put your api key");
			eyes.open(driver, "Applitool","CrossBrowser");
			driver.get("https://demo.applitools.com/gridHackathonV1.html");
			eyes.checkWindow("Browser");
			
			System.out.println(driver.manage().window().getSize());
			Dimension d = new Dimension(992, 500);
			driver.manage().window().setSize(d);
			System.out.println(driver.manage().window().getSize());
			
			eyes.close();
			
			driver.close();
		}

	}

	
	
	
	
	

