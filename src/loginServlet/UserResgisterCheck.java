package loginServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.LoginService;
import login.LoginServiceImpl;

/**
 * Servlet implementation class UserResgisterCheck
 */
@WebServlet("/UserResgisterCheck")
public class UserResgisterCheck extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset:euc-kr");
		LoginService service = new LoginServiceImpl();
		String id= request.getParameter("userId");
		response.getWriter().write(service.resgisterCheck(id)+"");
	}
}

