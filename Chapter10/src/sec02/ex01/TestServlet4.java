package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet1
 */
//@WebServlet("/*")
/*@WebServlet("/first/*")*/
public class TestServlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String context = request.getContextPath(); //context 이름 가져옴.
		String url = request.getRequestURL().toString(); //전체 URL 가져옴.
		String mapping = request.getServletPath(); //매핑 이름 가져옴.
		String uri = request.getRequestURI(); //URI 가져옴.
		
		out.println("<html><head>");
		out.println("<title>Test Servlet4</title>");
		out.println("</head>");
		out.println("<body bgcolor='pink'>");
		out.println("<b>TestServlet4입니다.</b><br>");
		out.println("<b>컨텍스트명 : " + context + "</b><br>");
		out.println("<b>전체 경로 : " + url + "</b><br>");
		out.println("<b>매핑 명 : " + mapping + "</b><br>");
		out.println("<b>URI : " + uri + "</b><br>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
