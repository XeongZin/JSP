package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login2")
public class LoginServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메서드 호출");
	}

	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//전송된 데이터를 UTF-8로 인코딩
		request.setCharacterEncoding("UTF-8");
		
		//setContentType()을 이용해 응답할 데이터 종류가 HTML임을 설정
		response.setContentType("text/html;charset=utf-8");
		
		//HttpServeltREsponse 객체의 getWriter()를 이용해 출력 스트림 PrintWriter 객체를 받아옴
		PrintWriter out = response.getWriter();
		
		//getParameter()를 이용해 <input> 태그의 name 속성 값으로 전송된 value를 받아옴.
		String id =  request.getParameter("user_id");
		String pw =  request.getParameter("user_pw");
		
		//브라우저로 출력할 데이터를 문자열로 연결해서 HTML태그로 만듦
		String data = "<html>";
		data += "<body>";
		data += "아이디 : " + id;
		data += "<br>";
		data += "비밀번호 : " + pw;
		data += "</body>";
		data += "</html>";
		out.print(data);
	}

}
