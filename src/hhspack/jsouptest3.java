
package hhspack;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class jsouptest3 {
	private static WebDriver driver;
	private static String URL = "http://14.36.28.181/kitri/participation/qna_list.web?";
	String Title = null;
	String alertText = "";
	
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
	public void login_test0() throws Exception {
		if(driver.switchTo().alert()!=null){
			System.out.println("팝업창 발생");
		}else{
			System.out.println("뀨잉");
		}
	}
}
