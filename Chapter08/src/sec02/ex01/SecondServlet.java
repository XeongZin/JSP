package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second7")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");  
		response.setContentType("text/html;charset=utf-8");
	    PrintWriter out = response.getWriter();
	    String address = (String)request.getAttribute("address");
	    out.println("<html><body>");
	    out.println("이름 : " + address + "<br>");
	    out.println("dispatch을 이용한 forward 실습입니다.");
	    out.println("</body></html>");
	}
}
