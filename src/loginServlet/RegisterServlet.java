package loginServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.LoginDAO;
import login.LoginDAOImpl;
import login.LoginService;
import login.LoginServiceImpl;
import util.PassSecurityMd;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Register.do")
public class RegisterServlet extends HttpServlet {
	@SuppressWarnings("static-access")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PassSecurityMd md5 = new PassSecurityMd();
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset:euc-kr");
		String id= request.getParameter("userId");
		String pass1= md5.MD5(request.getParameter("userpassword1"));
		System.out.println("��й�ȣ �Է� : "+pass1);
		String pass2= md5.MD5(request.getParameter("userpassword2"));
		System.out.println("��й�ȣ �� �Է� : "+pass2);
		String name= request.getParameter("userName");
		String Sort= request.getParameter("usersort");
		String email= request.getParameter("useremail");
		
		LoginService service = new LoginServiceImpl();
		if(id==null||id.equals("")||pass1==null||pass1.equals("")||
				pass2==null||pass2.equals("")||name==null||name.equals("")||
						Sort==null||Sort.equals("")||email==null||email.equals("")){
			request.getSession().setAttribute("messageType", "�����޼���");
			request.getSession().setAttribute("messageContent", "�Է����� ���� ������ �ֽ��ϴ�.");
			response.sendRedirect("template/register.jsp");
			return;
		}
		if(!pass1.equals(pass2)){
			request.getSession().setAttribute("messageType", "�����޼���");
			request.getSession().setAttribute("messageContent", "��й�ȣ�� ���� ��ġ���� �ʽ��ϴ�.");
			response.sendRedirect("template/register.jsp");
			return;
		}
		int result = service.insert(id, pass1, name, Sort, email);
		System.out.println(result);
		if(result==1){
			request.getSession().setAttribute("messageType", "�����޼���");
			request.getSession().setAttribute("messageContent", "ȸ�����Կ� �����߽��ϴ�.");
			response.sendRedirect("/webscanner/template/login.jsp");
			return;
		}else{
			request.getSession().setAttribute("messageType", "�����޼���");
			request.getSession().setAttribute("messageContent", "�̹� �����ϴ� ȸ���Դϴ�.");
			response.sendRedirect("template/register.jsp");
		}
	}
}
