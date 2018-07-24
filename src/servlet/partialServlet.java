package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "partial", urlPatterns = { "/partial.do" })
public class partialServlet extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,java.io.IOException{
		doPost(req, res);
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,java.io.IOException{
		req.setCharacterEncoding("euc-kr");
		
			req.setAttribute("menupath", "/template/userPage.jsp");
			req.setAttribute("viewpath", "/emp/partialTest.jsp");
			HttpSession ses= req.getSession();
		//res.sendRedirect(view);
		RequestDispatcher rd= req.getRequestDispatcher("/template/mainLayout.jsp");
		rd.forward(req,res);
	}

}
