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

public class javascriptseleniumTest {
	private static WebDriver driver;
	private static String URL = "http://14.36.28.181/kitri/main/main.web";
	private static String Title = null;
	
	
	//초기 세팅 
	public static void setup() throws Exception {
		String driverpath="src/driver/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverpath);// 크롬 드라이버 경로설정
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--headless");//크롬창 프로세스상태로 유지
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS); // 응답시간 1초설정
		driver.get(URL); // 접속할 사이트
		Title = driver.getTitle();
//		http://211.42.204.62:8088/WebProject/main/Main.html
	}
	
	
	//모든 A태그 가져오기 
	public void javaScriptExcuteTest() throws Exception{
		setup();
		List<WebElement> linkElements=driver.findElements(By.tagName("a"));	
		String[] test = new String[linkElements.size()];
		ArrayList<String> topMnugolist = new ArrayList<String>();
		ArrayList<String> footMnugolist = new ArrayList<String>();
		HashMap<Integer, String> testmap = new HashMap<>();
		int i=0;
		int h=0;
		for (WebElement e : linkElements) {
			if (e.getAttribute("onclick") != null) {
				test[i] = e.getAttribute("onclick");
				System.out.println("스트링 배열에 담겨진 데이터 ===>" + test[i].toString());
				if (test[i].trim().toString().contains("('/")) {
					topMnugolist.add(test[i].trim().toString());
					System.out.println("해쉬맵에 담겨진 데이터(topMnuGo)===>" + testmap.get(h));
					h++;
					System.out.println("topMnuGo를 받아온 해쉬맵 사이즈 =====>"+testmap.size());
				}
			}
			i++;
		}
		System.out.println("TOpMnuGo 사이즈 ****************************>"+topMnugolist.size());
		int count =0;
		for(i=0; i<topMnugolist.size();i++){
			int IndexTop=topMnugolist.get(i).indexOf("('/");
			int IndexTopEnd=topMnugolist.get(i).indexOf("')");
			String topValue = topMnugolist.get(i).substring(IndexTop, IndexTopEnd);
			System.out.println("Topmnu데이터================****>"+topMnugolist.get(i).substring(IndexTop, IndexTopEnd));
		}
//		try{
//			int j=0;
//			System.out.println("모든 데이터를 받아온 해쉬맵 사이즈 =====>"+testmap.size());
//			while((j<=testmap.size())){
//				System.out.println(j+" : "+testmap.size());
//				if(testmap.get(j)!=null){
//				((JavascriptExecutor)driver).executeScript(testmap.get(j));
//				}
//				System.out.println("실행카운트=======================>"+j);
//				j++;
//			}
//		}catch(org.openqa.selenium.UnhandledAlertException e){
//			driver.switchTo().alert().accept();
//		}catch(org.openqa.selenium.ElementNotVisibleException e){
//			driver.navigate().refresh();
//		}finally {
//			System.out.println("검사중");
//		}
	}
	public static void main(String[] args) throws Exception {
		javascriptseleniumTest start = new javascriptseleniumTest();
		start.javaScriptExcuteTest();
	}
}
