package sec01.ex06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second6")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      response.setContentType("text/html;charset=utf-8");
	      PrintWriter out = response.getWriter();
	      String name = request.getParameter("name");
	      out.println("<html><body>");
	      out.println("이름 : " + name + "<br>");
	      out.println("dispatch을 이용한 forward 실습입니다.");
	      out.println("</body></html>");
	}
}
