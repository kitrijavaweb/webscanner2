
package hhspack;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Iterator;

public class seletest3 {
	private static String URL = "http://14.36.28.181/kitri/main/main.web";
	private static WebDriver driver;
	@BeforeClass
	public static void setup() throws Exception {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--headless");
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");// 크롬
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS); // 응답시간
		driver.get(URL); // 접속할
		
		
		//http://211.42.204.62:8088/WebProject/main/Main.html
		//http://www.kitri.re.kr/kitri/news/01edu_it_list.web
		//http://14.36.28.181/kitri/main/main.web
	}
	@Test
	// 동적 크롤링 테스트
	public void login_test() throws Exception {
		try {
			String url = "";
			HashMap<String, String> hash_LinkList = new HashMap<>();
			url = URL;
			Document doc = Jsoup.connect(url).get();

			String title = doc.title();
			
			Elements links = doc.select("a[href]").not("a[href='#']").not("a[href='#none']").not("http://www.facebook.com/kr.kitri?fref=ts");
			List<String> url_array = new ArrayList<String>();
			int i = 0;
			url_array.add(url);
			hash_LinkList.put(url, title);
//			Iterator<String> keySetIterator = h.keySet().iterator();
			while ((i <= hash_LinkList.size())) {
				try {
					url = url_array.get(i).toString();
						doc = Jsoup.connect(url).get();
					title = doc.title();
					links = doc.select("a[href]").not("a[href='#']").not("a[href='#none']");
					//.not("a[href='http://www.facebook.com/kr.kitri?fref=ts']")
					for (Element link : links) {

						String res = hash_LinkList.putIfAbsent(link.attr("href"), link.text());
						if (res == null) {
							url_array.add(link.attr("href"));
							System.out.println("URL: " + link.attr("href"));
							System.out.println("TITLE: " + link.text());
						}
					}
				} catch (Exception e) {
//					System.out.println("\n" + e);
				}

				i++;

			}
		} catch (Exception e) {
//			e.printStackTrace();
		}
	}
}