package pattern.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pattern.PatternServiceImpl;
import pattern.patternService;
import userInfo.UserService;
import userInfo.UserServiceImpl;

@WebServlet("/main/admin/patterndelete.do")
public class patternDelete extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("euc-kr");
		res.setContentType("text/html;charset=euc-kr");
		System.out.println("서블릿요청성공");

		String pattern = req.getParameter("pattern");
		System.out.println(pattern);
		patternService service= new PatternServiceImpl();

		res.getWriter().write(service.delete(pattern) + "");
	}
}
