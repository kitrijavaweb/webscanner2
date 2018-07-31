package hhspack;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class snapshot {
	public snapshot() {
		String path = System.getProperty("path", "C:\\logs\\");
		String id = System.getProperty("id", "admin");
		String browser = System.getProperty("browser", "chrome");
		String filename = "screenshot_" + id + "_" + browser + ".png";

		WebDriver driver = new ChromeDriver();

		// 其捞瘤 力格
		System.out.println("Page title is: " + driver.getTitle());
		System.out.println("Filename: " + path + filename);

		// 胶忱鸡 积己
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(path + filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
}
