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
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class selll {
	private static WebDriver driver;
	private static String URL = "http://www.douzone.com/";
	private static String Title = null;
	
	
	//초기 세팅 
	public static void setup() throws Exception {
		String driverpath="src/driver/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverpath);// 크롬 드라이버 경로설정
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--headless");//크롬창 프로세스상태로 유지
		driver = new ChromeDriver();
		driver.manage().window().maximize(); // 윈도우창 최대화
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS); // 응답시간 1초설정
		driver.get(URL); // 접속할 사이트
		Title = driver.getTitle();
//		http://211.42.204.62:8088/WebProject/main/Main.html
	}
	//XPATH 주소 생성
	private String generateXPATH(WebElement childElement, String current) {
		String childTag = childElement.getTagName();
		if (childTag.equals("html")) {
			return "/html[1]" + current;
		}	
		WebElement parentElement = childElement.findElement(By.xpath(".."));
		List<WebElement> childrenElements = parentElement.findElements(By.xpath("*"));
		int count = 0;
		for (int i = 0; i < childrenElements.size(); i++) {
			WebElement childrenElement = childrenElements.get(i);
			String childrenElementTag = childrenElement.getTagName();
			if (childTag.equals(childrenElementTag)) {
				count++;
			}
			if (childElement.equals(childrenElement)) {
				return generateXPATH(parentElement, "/" + childTag + "[" + count + "]" + current);
			}
		}
		return null;
	}
	
	
	//모든 A태그 가져오기 
	public String[] getATage() throws Exception{
		setup();
		List<WebElement> linkElements = driver.findElements(By.tagName("a"));
		String[] linkTexts = new String[linkElements.size()];
		int i = 0;
		for (WebElement e : linkElements) { //linkElements 의  a태그 값을 WebElemnet e의 값이 된다.
			if(!e.getText().trim().equals("")&e.getText()!=null){
				linkTexts[i] = e.getText(); // linkElements a태그 값의 Text 값을 linkTexts에 넣는다.
				System.out.println(linkTexts[i].toString());
				i++;
			}
		}
		return linkTexts;
	}
	//input="Text" 삽입공격
	public void inputText() throws Exception{
		WebElement inputText =driver.findElement(By.xpath("//input[@type='text']"));
			inputText.sendKeys("테스트");
	}
	//A태그 SCAN
	public void AtagScan(String[] linkTexts) throws Exception{
		ArrayList<List<WebElement>> linkList = new ArrayList<List<WebElement>>();
		for (String t : linkTexts) { 
				try{
					driver.findElement(By.linkText(t)).click();
					linkList.add(driver.findElements(By.tagName("a")));
				}catch(org.openqa.selenium.UnhandledAlertException|
						org.openqa.selenium.NoSuchElementException |org.openqa.selenium.NoAlertPresentException e){
					driver.switchTo().alert().accept();
					System.out.println("알림창 확인완료");
				}catch(org.openqa.selenium.ElementNotVisibleException e){
					driver.navigate().refresh();
				}catch(IllegalArgumentException	 e){
					HashSet<List<WebElement>> hs = new HashSet<List<WebElement>>(linkList);
					linkList =new ArrayList<List<WebElement>>(hs);
					System.out.println("사이즈"+linkList.size());
				}
		}
	}
	public static void main(String[] args) throws Exception {
		selll start = new selll();
		String[] linkTexts=start.getATage();
		start.AtagScan(linkTexts);
	}
}
