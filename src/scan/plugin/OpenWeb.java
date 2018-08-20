package scan.plugin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import scan.Servlet.BasicSqlScan;

public class OpenWeb {
	public static WebDriver driver;
	public String message(){
		return "ChromeDriver 실행중.....\n";
	}
	
	public void OpenUp(String URL) throws Exception{
		String driverPATH="C:/Users/ghtjd/git/webscanner2/src/driver/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPATH);
		ChromeOptions ChromeOption= new ChromeOptions();
		BasicSqlScan sc = new BasicSqlScan();
		ChromeOption.addArguments("--headless");
		driver =new ChromeDriver(ChromeOption);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		sc.pw.println(driver.getCurrentUrl()+"불러오는중 ...");
		System.out.println("OpenWeb ====>"+URL);
		driver.get(URL);
		sc.pw.println(driver.getCurrentUrl()+"불러오기 완료 ...");
	}
}
