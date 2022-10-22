package awasthi.Framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import awasthi.utility.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	ReadConfig read = new ReadConfig();
	public static WebDriver driver;

	String url = read.getUrl();
	String Buserid = read.getUserId();
	String Buserpassword = read.getUserPass();
	String Btitle = read.getTitle();
	public static Logger logger;

	@BeforeClass
	@Parameters("browser")
	public void setup(String brows) {

		if (brows.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\vivek\\Eclipse_new_Space\\Framework\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
			getLog();
		} else if (brows.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\vivek\\Eclipse_new_Space\\Framework\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			getLog();
		}

	}

	@AfterClass
	public void getClose() {
		driver.quit();

	}

	public void TakeScreenShot() {
		TakesScreenshot tsc = (TakesScreenshot) driver;
		File srcfile = tsc.getScreenshotAs(OutputType.FILE);
		File desfile = new File("C:\\Users\\vivek\\Eclipse_new_Space\\Framework\\Screenshot\\homepage.png");
		try {
			FileUtils.copyFile(srcfile, desfile);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void getLog() {
		logger = Logger.getLogger("Base");
		PropertyConfigurator.configure("log42j.properties");
	}

}
