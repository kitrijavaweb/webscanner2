package scan.plugin;


import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;

import scan.Servlet.BasicXssScan;

public class BasicXSS {
	public static OpenWeb web = new OpenWeb();
	
	public String SQLmessage(){
		return "[����] Xss ����� �߰�\n";
	}
	@SuppressWarnings("static-access")
	public void ScanBasicXss(){
		BasicXssScan xss= new BasicXssScan();
		try{
		web.driver.findElement(By.xpath("/html/body/div[1]/div/a[2]")).click();
			xss.pw.println("[ ���� ��ġ : ]["+web.driver.getTitle()+"]���� �˻���....");
			web.driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input")).sendKeys(
					"admin");
			web.driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input")).sendKeys(
					"admin");
			web.driver.findElement(By.id("submit")).submit();
			xss.pw.println("[ ���� ��ġ : ]["+web.driver.getTitle()+"]���� �˻���....");
			web.driver.findElement(By.xpath("/html/body/table/tbody/tr[14]/td/a[3]")).click();
			xss.pw.println("[ ���� ��ġ : ]["+web.driver.getTitle()+"]���� �˻���....");
			web.driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input")).sendKeys("2018-08-13 XSS �׽�Ʈ");;
			web.driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input")).sendKeys("2018-08-13 XSS �׽�Ʈ");;
			web.driver.findElement(By.xpath("/html/body/form/table/tbody/tr[4]/td[2]/textarea")).sendKeys(
					"<script>alert(\"Xss ����� �׽�Ʈ\")</script>");
			web.driver.findElement(By.xpath("/html/body/form/table/tbody/tr[8]/td/a[1]")).click();
			web.driver.findElement(By.tagName("a[1]")).click();
		}catch(NoAlertPresentException e){
			xss.pw.println("[ ���� ��ġ : ]["+web.driver.getTitle()+"]"+SQLmessage());
		}
			web.driver.close();
	}
	//http://211.42.204.62:8088/WebProject/main/Main.html
}
