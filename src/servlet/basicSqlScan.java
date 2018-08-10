package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "basicSqlScan", urlPatterns = {"/main/scan/basicSqlScan.do"})
public class basicSqlScan extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Ajax===>서블릿 요청");
		response.setContentType("text/plain;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.println("성공");
	}

}
