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

import login.LoginDTO;
import login.LoginService;
import login.LoginServiceImpl;
import util.PassSecurityMd;

@WebServlet(name = "weblogin", urlPatterns = { "/webmain.do" })
public class loginServlet extends HttpServlet {
	@SuppressWarnings("static-access")
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PassSecurityMd md5 =new PassSecurityMd();
		req.setCharacterEncoding("euc-kr");
		String id = req.getParameter("userID");
		String pass = md5.MD5(req.getParameter("userPassword"));
		String check = req.getParameter("id_remeber");
		LoginService service =new LoginServiceImpl();
		LoginDTO loginUser = service.loginCheck(id, pass);
		
		// ���̵� ��Ű�� �����ϱ�
		if (check != null) {
			if (check.equals("T") & loginUser != null) {
				Cookie cookie = new Cookie("id", loginUser.getUserID());
				cookie.setMaxAge(60 * 60 * 24);
				res.addCookie(cookie);
			}
		}
		// �α��� �����ϸ� ������ �����ϰ� ���ǿ� �α��� ������ ������ �߰��Ѵ�.
		// 4. ��û������
		String menupath = "";
		String viewpath = "";
		String connectUrl="";
		HttpSession ses = req.getSession();
		if (loginUser!=null) {// �α��� ����
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
