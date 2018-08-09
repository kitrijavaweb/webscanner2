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
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
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

public class javascriptseleniumTest2 {
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
		Title = driver.getTitle();
		// http://211.42.204.62:8088/WebProject/main/Main.html
	}

	// 모든 A태그 가져오기
	public void javaScriptExcuteTest() throws Exception {
		setup();
		try {
			String url = "";
			HashMap<String, String> hash_LinkList = new HashMap<>();
			Document doc = Jsoup.connect(url).get();

			String title = doc.title();
			// 첫 페이지 A태그 관련 href 가져오기
			Elements links = doc.select("a[href]");
			List<String> url_array = new ArrayList<String>();
			int i = 0;
			url_array.add(url);
			hash_LinkList.put(url, title);
			// Iterator<String> keySetIterator = h.keySet().iterator();
			// A태그의 링크가 없을까지 반복작업
			while ((i <= hash_LinkList.size())) {
				try {
					// facebook 이라는 단어가 포함되면 삭제
					driver.navigate().to(url_array.get(i).toString());
					System.out.println("실행?");
					title = doc.title();
					links = doc.select("a[onclick]").not("a[href='#']").not("a[href='#none']").not("a[href='#btn']")
							.not("a[href='#container']");
					for (int j = 0; j < links.size(); j++) {
						if (links.get(j).toString().contains("facebook")) {
							links.get(j).clearAttributes();
						} else if (!links.get(j).toString().contains("http")) {
							String getUrl = "http://14.36.28.181" + links.get(j).attr("href");
							System.out.println(getUrl);
						}
					}
					// .not("a[href='http://www.facebook.com/kr.kitri?fref=ts']")
					for (Element link : links) {
						String res = hash_LinkList.putIfAbsent(link.attr("href"), link.text());
						if (res == null) {
							url_array.add(link.attr("href"));
							System.out.println("URL: " + link.attr("href"));
							System.out.println("TITLE: " + link.text());
						}
					}
				} catch (Exception e) {
					// System.out.println("\n" + e);
				}

				i++;

			}
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		javascriptseleniumTest2 start = new javascriptseleniumTest2();
		start.javaScriptExcuteTest();
	}
}
