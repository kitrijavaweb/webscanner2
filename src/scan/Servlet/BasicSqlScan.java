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

import scan.plugin.BasicSQLinjection;
import scan.plugin.OpenWeb;

@WebServlet(name = "basicSqlScan2", urlPatterns = {"/main/scan/basicSqlScan.do"})
public class BasicSqlScan extends HttpServlet {
	public static PrintWriter pw;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=euc-kr");
		String URL=request.getParameter("url");
		System.out.println(URL);
		OpenWeb web =new OpenWeb();
		pw= response.getWriter();
		BasicSQLinjection sql = new BasicSQLinjection();
		String msg="";
		msg = "SQL Injecction �˻� ����\n";
		pw.print(msg);
		
		try {
			pw.print(web.message());
			web.OpenUp(URL);
			sql.ScanBasicSQLinjection();
		} catch (Exception e) {
		}
	}


}
