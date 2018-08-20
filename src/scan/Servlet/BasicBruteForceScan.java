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
import scan.plugin.OpenWeb;

@WebServlet(name = "basicBruteForce", urlPatterns = {"/main/scan/basicBruteForceScan.do"})
public class BasicBruteForceScan extends HttpServlet {
	public static PrintWriter pw;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=euc-kr");
		String URL=request.getParameter("url");
		System.out.println("bruteForce===>"+URL);
		OpenWeb web =new OpenWeb();
		pw= response.getWriter();
		BasicBruteForce bf = new BasicBruteForce();
		String msg="";
		msg = "취약한인증[Brute Force] 검사 시작\n";
		pw.print(msg);
		
		try {
			pw.print(web.message());
			web.OpenUp(URL);
			bf.ScanBasicBruteForce();
		} catch (Exception e) {
		}
	}


}
