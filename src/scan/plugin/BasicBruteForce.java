package scan.plugin;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;

import pattern.PartternDTO;
import pattern.PatternServiceImpl;
import pattern.patternService;
import scan.Servlet.BasicBruteForceScan;
import scan.Servlet.BasicSqlScan;

public class BasicBruteForce {
	public static OpenWeb web = new OpenWeb();
	
	public String SQLmessage(){
		return "[����] ����� ���� ����� �߰�\n";
	}
	@SuppressWarnings("static-access")
	public void ScanBasicBruteForce(){
		BasicBruteForceScan sc = new BasicBruteForceScan();
		web.driver.findElement(By.xpath("/html/body/div[1]/div/a[2]")).click();
		patternService service = new PatternServiceImpl();
		String name ="Brute";
		ArrayList<PartternDTO> patternList=service.getPattern(name);
		int count =0; 
		for(PartternDTO p: patternList){
			count++;
			if(count>=5){
				sc.pw.print("[ ���� ��ġ : ]["+web.driver.getTitle()+"]"+"[����]����� ���� �߰�\n");
			}
			try{
			sc.pw.println("[ ���� ��ġ : ]["+web.driver.getTitle()+"]���� �˻���....");
			web.driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input")).sendKeys(
					p.getPattern());
			web.driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input")).sendKeys(
					p.getPattern());
			web.driver.findElement(By.id("submit")).submit();
			web.driver.switchTo().alert().accept();
			}catch(NoAlertPresentException | NoSuchElementException |NullPointerException e){
				sc.pw.println("[ ���� ��ġ : ]["+web.driver.getTitle()+"]"+SQLmessage());
				break;
			}
		}
		web.driver.close();
	}
	//http://211.42.204.62:8088/WebProject/main/Main.html
}
