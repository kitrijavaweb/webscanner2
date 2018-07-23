package emp.controller;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.service.empService;
import emp.service.empServiceImpl;

public class registerServlet extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,java.io.IOException{
		req.setCharacterEncoding("euc-kr");
		res.setContentType("text/html;charset=euc-kr");
		
		String name=req.getParameter("Name");
		String id=req.getParameter("Id");
		String pass=req.getParameter("Password");
		empService service = new empServiceImpl();
		service.insert(name, id, pass);
		
	}
}
