
package hhspack;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class seletest {
	private static WebDriver driver;
	String Title = null;
	String URL = null;
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
																				// 드라이버
																				// 파일
																				// 경로설정
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS); // 응답시간
																		// 1초설정
		driver.get("http://14.36.28.181/kitri/main/main.web"); // 접속할
																			// 사이트
	}

	@Test
	//동적 크롤링 테스트
	public void login_test() throws Exception {
		List<WebElement> linkElements = driver.findElements(By.tagName("a"));
		String[] linkTexts = new String[linkElements.size()];
		int i = 0;
		
		for (WebElement e : linkElements) { //linkElements 의  a태그 값을 WebElemnet e의 값이 된다.
			linkTexts[i] = e.getText(); // linkElements a태그 값의 Text 값을 linkTexts에 넣는다.
			System.out.println(linkTexts[i].toString());
			i++;
		}

		for (String t : linkTexts) { 
			driver.findElement(By.linkText(t)).click();
			crawl(driver.getCurrentUrl(),driver.getTitle());
			driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
			driver.navigate().back();
		}
	}
}
