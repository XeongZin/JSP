package sec02.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/member4") // 주석 해제
public class MemberServlet extends HttpServlet {
   
   protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
      response.setContentType("text/html;charset=utf-8");
      
      PrintWriter out = response.getWriter();
      MemberDAO dao = new MemberDAO();
      
      List memberslist = dao.listMembers();
      
      request.setAttribute("membersList", memberslist);
      RequestDispatcher dispatch = request.getRequestDispatcher("viewMembers");
      dispatch.forward(request, response);
   }
}
