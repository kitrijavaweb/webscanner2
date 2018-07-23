package emp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import emp.dto.empDTO;
import emp.service.empService;
import emp.service.empServiceImpl;

@WebServlet(name = "login", urlPatterns = { "/login.do" })
public class loginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String check = request.getParameter("member_id_save");
		
		System.out.println(id);
		System.out.println(pass);
		
		empService service = new empServiceImpl();
		empDTO result=service.login(id, pass);
		request.setAttribute("loginUser", result);
		
		if(check!=null){
			if(check.equals("T")&&result!=null){
				Cookie cookie =new Cookie("setid", result.getId());
				cookie.setMaxAge(60*60*24);
				response.addCookie(cookie);
			}
		}
		
		if(result!=null){
			request.setAttribute("menupath", result.getUrlpath());
			request.setAttribute("viewpath", "#");
			HttpSession ses= request.getSession();
			ses.setAttribute("loginuser", result);
		}else{
			request.setAttribute("menupath", "/template/pub_menu.jsp");
			request.setAttribute("viewpath", "/template/login.jsp");
		}
		//res.sendRedirect(view);
		RequestDispatcher rd= request.getRequestDispatcher("/template/mainLayout.jsp");
		rd.forward(request,response);
	
	}

}
