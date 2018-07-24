package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "logout", urlPatterns = { "/webout.do" })
public class logoutServlet extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,java.io.IOException{
		doPost(req, res);
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,java.io.IOException{
		req.setCharacterEncoding("euc-kr");
		
		//res.sendRedirect(view);
		RequestDispatcher rd= req.getRequestDispatcher("/template/login.jsp");
		rd.forward(req,res);
	}

}
