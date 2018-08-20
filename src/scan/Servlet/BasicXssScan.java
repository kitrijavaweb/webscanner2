package scan.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thoughtworks.selenium.webdriven.commands.OpenWindow;

import scan.plugin.BasicBruteForce;
import scan.plugin.BasicSQLinjection;
import scan.plugin.BasicXSS;
import scan.plugin.OpenWeb;

@WebServlet(name = "basicXss", urlPatterns = {"/main/scan/basicXssScan.do"})
public class BasicXssScan extends HttpServlet {
	public static PrintWriter pw;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=euc-kr");
		String URL=request.getParameter("url");
		System.out.println("XSS===>"+URL);
		OpenWeb web =new OpenWeb();
		BasicXSS xs = new BasicXSS();
		pw= response.getWriter();
		String msg="";
		msg = "XSS[크로스 사이트 스크립트] 검사 시작\n";
		pw.print(msg);
		
		try {
			pw.print(web.message());
			web.OpenUp(URL);
			xs.ScanBasicXss();
		} catch (Exception e) {
		}
	}


}
