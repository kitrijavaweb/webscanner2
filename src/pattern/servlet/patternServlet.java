package pattern.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pattern.PatternServiceImpl;
import pattern.patternService;

@WebServlet("/main/admin/pattern.do")
public class patternServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");

		System.out.println("패턴등록 호출");
		
		String name = request.getParameter("attackweb");
		String pattern = request.getParameter("pattern");
		
		System.out.println("이름 명  : "+ name);
		System.out.println("패턴 명  : "+ pattern);
		
		patternService service = new PatternServiceImpl();
		
		service.insert(name, pattern);
		
		response.sendRedirect("/webscanner/main/adminPageInfo.do");
		
	}

}
