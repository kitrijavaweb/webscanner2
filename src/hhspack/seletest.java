
package hhspack;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.jws.WebMethod;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javafx.scene.control.Alert;

public class seletest {
	private static WebDriver driver;
	private static String Title = null;
	private static String URL = "http://14.36.28.181/kitri/main/main.web";
	String alertText = "";

	public void beforeurl() throws Exception {
		URL obj = new URL(driver.getCurrentUrl());
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		System.out.println("Post 응답 코드 " + con.getResponseCode());
		System.out.println("에러메세지" + con.getErrorStream());
	}
	@WebMethod
	public static void crawl(String url,String urltitle) throws IOException{
		Document doc = Jsoup.connect(url).get();
		System.out.println("--------------------------------------------");
		System.out.println(urltitle);
		System.out.println(doc);
		System.out.println("--------------------------------------------");
	}
	@BeforeClass
	public static void setup() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");// 크롬
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS); // 응답시간
		driver.get(URL); // 접속할
		Title = driver.getTitle();
		System.out.println("시작도메인"+Title);
	}

	@Test
	//동적 크롤링 테스트
	public void login_test() throws Exception {
		List<WebElement> linkElements = driver.findElements(By.tagName("a"));
		String[] linkTexts = new String[linkElements.size()];
		int i = 0;
		
		for (WebElement e : linkElements) { //linkElements 의  a태그 값을 WebElemnet e의 값이 된다.
			if(!e.getText().equals("")){
			linkTexts[i] = e.getText(); // linkElements a태그 값의 Text 값을 linkTexts에 넣는다.
			System.out.println(linkTexts[i].toString());
			i++;
			}
		}
		
		for (String t : linkTexts) { 
			if(driver.getCurrentUrl().equals("data:,")){
				driver.get(URL);
			}else{
				try{
				if(driver.switchTo().alert()!=null){
					Thread.sleep(1000);
					driver.switchTo().alert().accept();
				}
				}catch(NoAlertPresentException | IllegalArgumentException e){
				}catch(org.openqa.selenium.UnhandledAlertException e){
					driver.switchTo().alert().accept();
				}finally{
					Thread.sleep(1000);
					driver.switchTo().alert().accept();
					driver.findElement(By.linkText(t)).click();
					if(!driver.getTitle().equals(Title)){crawl(driver.getCurrentUrl(),driver.getTitle());}
					driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
				}
			}
		}
	}
}

