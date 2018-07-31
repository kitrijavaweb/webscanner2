package loginServlet;

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
import login.LoginDTO;
import login.LoginService;
import login.LoginServiceImpl;

@WebServlet(name = "weblogin", urlPatterns = { "/webmain.do" })
public class loginServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("euc-kr");
		String id = req.getParameter("userID");
		String pass = req.getParameter("userPassword");
		String check = req.getParameter("id_remeber");
		LoginService service =new LoginServiceImpl();
		LoginDTO loginUser = service.loginCheck(id, pass);
		
		// 아이디를 쿠키에 저장하기
		if (check != null) {
			if (check.equals("T") & loginUser != null) {
				Cookie cookie = new Cookie("id", loginUser.getUserID());
				cookie.setMaxAge(60 * 60 * 24);
				res.addCookie(cookie);
			}
		}
		// 로그인 성공하면 세션을 생성하고 세션에 로그인 유저의 정보를 추가한다.
		// 4. 요청재지정
		String menupath = "";
		String viewpath = "";
		String connectUrl="";
		HttpSession ses = req.getSession();
		if (loginUser!=null) {// 로그인 성공
			if(loginUser.getUserID().equals("admin")){
				req.setAttribute("menupath", "/template/adminPage.jsp");
				req.setAttribute("viewpath", "/template/adminMainPage.jsp");
				ses.setAttribute("loginUser", loginUser);
			}else{
				req.setAttribute("menupath", "/template/userPage.jsp");
				req.setAttribute("viewpath", "/emp/fullTest.jsp");	
				ses.setAttribute("loginUser", loginUser);
			}
				connectUrl="/template/mainLayout.jsp";
		} else {
			connectUrl="/template/login.jsp";
		}
		RequestDispatcher rd = req.getRequestDispatcher(connectUrl);
		rd.forward(req, res);
	}
}
