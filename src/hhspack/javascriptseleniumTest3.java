package hhspack;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class javascriptseleniumTest3 {
	private static WebDriver driver;
	private static String URL = "http://14.36.28.181/kitri/main/main.web";
	private static String Title = null;

	// 초기 세팅
	public static void setup() throws Exception {
		String driverpath = "src/driver/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverpath);// 크롬 드라이버
																	// 경로설정
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--headless");// 크롬창 프로세스상태로 유지
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS); // 응답시간
																		// 1초설정
		driver.get(URL); // 접속할 사이트
		Title = driver.getTitle();
		// http://211.42.204.62:8088/WebProject/main/Main.html
	}

	// 모든 A태그 가져오기
	public void getAllAtag() throws Exception {
		ArrayList<String> AtagList= new ArrayList<String>();
		List<WebElement> e =driver.findElements(By.tagName("a"));
		int i=0;
		for(WebElement Atag :e){
			AtagList.add(Atag.getAttribute("href"));
		}
		for(String d:AtagList){
			//A태그의 href중 # / null 인 데이터는 삭제 
			try{
			if(!AtagList.get(i).contains("#")|AtagList.get(i)!=null){
				AtagList.remove(i);
			}
			d=AtagList.get(i);
			System.out.println("href가 포함된 A태그 데이터 : "+d);
			i++;
			}catch(NullPointerException n){
				AtagList.remove(i);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		setup();
		javascriptseleniumTest3 java = new javascriptseleniumTest3();
		java.getAllAtag();
	}
}