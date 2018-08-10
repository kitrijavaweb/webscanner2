package servlet;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pattern.PartternDTO;
import pattern.PatternServiceImpl;
import pattern.patternService;

@WebServlet(name = "adminPageInfo", urlPatterns = { "/main/adminPageInfo.do" })
public class adminPageInfoServlet extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,java.io.IOException{
		doPost(req, res);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,java.io.IOException{
		req.setCharacterEncoding("euc-kr");
		patternService service = new PatternServiceImpl();
		ArrayList<PartternDTO> patternList = service.getPattern();
			req.setAttribute("patternList", patternList);
			req.setAttribute("menupath", "/template/adminPage.jsp");
			req.setAttribute("viewpath", "/emp/toolInfo.jsp");
		RequestDispatcher rd= req.getRequestDispatcher("/template/mainLayout.jsp");
		rd.forward(req,res);
	}

}
