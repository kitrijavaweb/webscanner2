
package hhspack;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class seletest2 {
	private static WebDriver driver;
	private static String URL = "http://14.36.28.181/kitri/main/main.web";
	String Title = null;
	String alertText = "";
	
	@SuppressWarnings("unused")
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
		List<WebElement> linkElements=driver.findElements(By.tagName("a"));	
		System.out.println(linkElements.size());
		for(WebElement e:linkElements){
			if(e.getAttribute("href").equals("#")|e.getAttribute("href").equals("#none")|
					e.getAttribute("href").equals("#btn")){
			System.out.println(e.getAttribute("onclick"));
			}
//			((JavascriptExecutor)driver).executeScript(e.getAttribute("onclick"));
		}
	}
}
