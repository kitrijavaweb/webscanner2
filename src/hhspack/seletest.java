package hhspack;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class seletest { 
	private static WebDriver driver;
	String Title=null;
	String URL=null;
	String alertText="";
	int responseCode=0;
	@Before
	public void beforeurl()throws Exception{
		URI uri = new URI(driver.getCurrentUrl());
		URL obj = new URL(driver.getCurrentUrl());
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		
		con.setRequestMethod("POST");
		responseCode = con.getResponseCode();
		System.out.println("응답 코드 "+responseCode);
		String domain =uri.getAuthority()+uri.getPath();
		System.out.println("Before"+domain);
		
	}
	
	@BeforeClass
	public static void setup() throws Exception{
		System.setProperty("webdrivet.chrome.driver", "C:\\chromedriver.exe");//크롬 드라이버 파일 경로설정
	 driver =new ChromeDriver();
	 driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS); // 응답시간 1초설정
	 driver.get("http://211.42.204.5:8088/WebProject/main/Main.html"); //접속할 사이트
	}
	@Test
	public void login_test() throws Exception{
		System.out.println("로그인");
		driver.findElement(By.xpath("/html/body/div[1]/div/a[2]")).click(); //메인메뉴 로그인 버튼
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input")).sendKeys("admin");
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input")).sendKeys("tes");
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[4]/td/a[1]")).click(); //로그인페이지 로그인 버튼
		Alert alert = driver.switchTo().alert();// 팝업창 처리
		alert.accept();
	}
	/*@Test
	public void write_borard_test() throws Exception{
		System.out.println("게시판");
		driver.findElement(By.xpath("/html/body/table/tbody/tr[14]/td/a[3]")).click();//게시판 글쓰기 버튼 
	}
	
	@Test
	public void write_board_test() throws Exception{
		driver.findElement(By.name("BOARD_SUBJECT")).sendKeys("셀레니움 테스트");
		driver.findElement(By.name("BOARD_CONTENT")).sendKeys("<script>\n");
		driver.findElement(By.name("BOARD_CONTENT")).sendKeys("alert(\"셀레니움테스트!\")");
		driver.findElement(By.name("BOARD_CONTENT")).sendKeys("</script>");
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[8]/td/a[1]")).click();//게시판 등록
	}
	@Test
	public void board_out()throws Exception{
		
	}*/
} 
