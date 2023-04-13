package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShowMember
 */
@WebServlet("/show")
public class ShowMember extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String id = "", pw = "";
		Boolean isLogon = false;
		//이미 세션이 존재하면 세션을 반환하고, 없으면 null을 반환
		HttpSession session = request.getSession(false);
		
		//세션이 생성되어 있는지 확인
		if(session != null) {
			//getAttribute의 isLogon속성을 가져와 로그인 상태를 확인
			isLogon =  (Boolean) session.getAttribute("isLogOn");
			//isLogon이 true면 로그인 상태이므로 회원 정보를 브라우저에 표시한다
			if(isLogon == true) {
				//로그인 아이디와 비밀번호를 가지고 옴.
				id = (String)session.getAttribute("login.id");
				pw = (String)session.getAttribute("login.pw");
				//로그인 정보를 화면에 보여줌.
				out.print("<html><body>");
				out.print("아이디 : " + id + "<br>");
				out.print("비밀번호 : " + pw + "<br>");
				out.print("</body></html>");
			} else {
				//로그인 상태가 아니면 로그인 창으로 이동
				response.sendRedirect("login4.html");
			}
		} else {
			//세션이 생성되지 않았으므로 로그인 창으로 이동
			response.sendRedirect("login4.html");
		}
		
	}

}
