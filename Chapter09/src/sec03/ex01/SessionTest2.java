package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session2")
public class SessionTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out=response.getWriter();
		
		//getSession()을 호출하여 최초 요청시 세션 객체를 새로 생성하거나 기존 세션을 반환.
		HttpSession session = request.getSession();
		
									//생성된 세션 객체의 id 가져오기.
		out.println("세션 아이디 : " + session.getId() + "<br>");
											//최초 세션 객체 생성 시간 가져오기.
		out.println("최초 세션 생성 시각 : " + new Date(session.getCreationTime()) + "<br>");
											//세션 객체에 가장 최근에 접근한 시간 가져오기.
		out.println("최근 세션 접근 시각 : " + new Date(session.getLastAccessedTime()) + "<br>");
										//세션 객체의 유효 시간 가져오기.
										//톰캣의 기본 세션 유효 시간을 출력.
		out.println("기본 세션 유효 시각 : " + session.getMaxInactiveInterval() + "<br>");
		//세션의 유효 시간을 5초로 설정
		session.setMaxInactiveInterval(5);
									//유효 시간을 재 설정한 후 세션 유효 시간을 출력.
		out.println("세션 유효 시각 : " + session.getMaxInactiveInterval() + "<br>");
		
		//최초 생성된 세션인지 판별
		if(session.isNew()) {
			out.print("새 세션이 만들어졌습니다.");
		}
		
		
	}

}
