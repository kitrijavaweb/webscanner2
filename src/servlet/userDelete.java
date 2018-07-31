package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import userInfo.UserService;
import userInfo.UserServiceImpl;

@WebServlet("/userdelete.do")
public class userDelete extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("euc-kr");
		res.setContentType("text/html;charset=euc-kr");
		System.out.println("서블릿요청성공");

		String id = req.getParameter("userId");
		System.out.println(id);

		UserService service = new UserServiceImpl();
		res.getWriter().write(service.delete(id) + "");
	}
}
