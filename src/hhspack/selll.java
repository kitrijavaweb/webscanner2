package hhspack;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class selll {
	private static WebDriver driver;
	
	//접속한 URL 헤더 정보
	public static void urlHeader(String inputurl){
		try {
		    URL url = new URL(inputurl);
		 
		    URLConnection urlCon = url.openConnection();
		 
		    // InputStream : 해당 호스트의 페이지 정보를 가져온다.
		    System.out.println("urlCon.getContentType() : " + urlCon.getContentType());
		    System.out.println("urlCon.getContent() : " + urlCon.getContent());
		    System.out.println("urlCon.getContentEncoding() : " + urlCon.getContentEncoding());
		    Map<String, List<String>> map = urlCon.getHeaderFields();
		    Iterator<String> iterator = map.keySet().iterator();
		    while (iterator.hasNext()) {
		        String key = iterator.next();
		        System.out.println("Header Info : " + key + " = " + map.get(key));
		    }
		 
		} catch (MalformedURLException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		} catch (IOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}

	}
	
	//화면캡쳐
	public static void snapshot(String imagename){
		String path = System.getProperty("path", "C:\\logs\\");
		String id = System.getProperty("id", "admin");
		String filename = "screenshot_" + imagename + "_" + id + ".png";
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(path + filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//초기 세팅 
	public static void setup() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");// 크롬 드라이버 경로설정
		String url="http://211.42.204.62:8088/WebProject/main/Main.html";
		driver = new ChromeDriver();
		driver.manage().window().maximize(); // 윈도우창 최대화
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS); // 응답시간 1초설정
		driver.get(url); // 접속할 사이트
		snapshot("Start");
		urlHeader(driver.getCurrentUrl());
//		http://211.42.204.62:8088/WebProject/main/Main.html
	}
	// 상태값 및 에러메세지
	public static void getresponse() throws Exception {
		URL obj = new URL(driver.getCurrentUrl());
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		System.out.println("Post 응답 코드 " + con.getResponseCode());
		System.out.println("에러메세지" + con.getErrorStream());
	}
	//로그인 페이지 접속
	public void loginPage() throws Exception {
		setup();
		driver.findElement(By.xpath("/html/body/div[1]/div/a[2]")).click(); // 메인메뉴 로그인 클릭
		String[] str = { "abcd", "test1", "admin", "admins" };
		String[] str2 = { "abcd", "test1", "admi	s", "admin" };
		for (int i = 0; i < str.length; i++) {
			for (int j = 0; j < str2.length; j++) {
				try {
					driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input")).sendKeys(str[i]);
					driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input")).sendKeys(str2[j]);
					driver.findElement(By.xpath("/html/body/form/table/tbody/tr[4]/td/a[1]")).click(); // 로그인페이지
					urlHeader(driver.getCurrentUrl());
					Alert alert = driver.switchTo().alert();// 팝업창 처리
					alert.accept();
				} catch (org.openqa.selenium.NoAlertPresentException e) {
					snapshot("SQLinJection");
					System.out.println("인젝션 성공");
				} catch (org.openqa.selenium.NoSuchElementException e) {
					break;
				}catch(org.openqa.selenium.UnhandledAlertException e){
					Alert alert = driver.switchTo().alert();// 팝업창 처리
					alert.accept();
				}
			}
		} // for문 끝
	}
	//게시판 점검
	public void board() throws Exception{
		driver.findElement(By.xpath("/html/body/table/tbody/tr[14]/td/a[3]")).click();
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input")).sendKeys("테스트중입니다.");
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[4]/td[2]/textarea")).sendKeys("테스트중입니다.");
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[8]/td/a[1]")).click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//a)[1]")).click();
		snapshot("BoardResult");
	}
	public static void main(String[] args) throws Exception {
		selll start = new selll();
		start.loginPage();
		start.board();
	}
}
