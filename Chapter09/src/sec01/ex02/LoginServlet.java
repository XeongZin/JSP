package sec01.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login2")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메서드 호출");
	}

	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		//getParameter() 메서드를 이요하여 전송된 회원 정보를 가져온다.
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		 // hidden 태그로 전송된 값을 가져온다.
		String user_address = request.getParameter("user_address");
		String user_email = request.getParameter("user_email");
		String user_hp = request.getParameter("user_hp");
		
		//브라우저로 결과 출력
		String data = "안녕하세요!<br> 로그인 하셨습니다.<br><br>";
		data += "<html><body>";
		data += "아이디 : " + user_id;
		data += "<br>";
		data += "패스워드 : " + user_pw;
		data += "<br>";
		data += "주소 : " + user_address;
		data += "<br>";
		data += "email : " + user_email;
		data += "<br>";
		data += "휴대전화 : " + user_hp;
		data +="</body></html>";
		out.print(data);
		
		//Get방식으로 한글 전송하기 위해 인코딩
		user_address = URLEncoder.encode(user_address, "UTF-8");
		
		//아이디, 비밀번호, 주소 정보를 가지고 두번째 서블릿으로 이동
		out.print("<a href='/Chapter09/second?user_id=" + user_id + 
				"&user_pw=" + user_pw + 
				"&user_address=" + user_address + 
				"'><br><br>두번째 서블릿으로 보내기<br></a>");
		data += "</body></html>";
		out.print(data);
	}
}
