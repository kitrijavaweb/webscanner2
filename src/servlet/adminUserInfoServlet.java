package servlet;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import userInfo.UserDTO;
import userInfo.UserService;
import userInfo.UserServiceImpl;

@WebServlet(name = "adminUserInfo", urlPatterns = { "/main/adminUserInfo.do" })
public class adminUserInfoServlet extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,java.io.IOException{
		doPost(req, res);
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,java.io.IOException{
		req.setCharacterEncoding("euc-kr");
		
		UserService service =new UserServiceImpl();
		ArrayList<UserDTO> result=service.userInfo();
		req.setAttribute("userlist", result);
		req.setAttribute("menupath", "/template/adminPage.jsp");
		req.setAttribute("viewpath", "/emp/userInfo.jsp");
			
		RequestDispatcher rd= req.getRequestDispatcher("/template/mainLayout.jsp");
		rd.forward(req,res);
	}

}
