package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Member5")
public class MemberServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request,HttpServletResponse response)  throws ServletException, IOException {
		// 추가
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		MemberDAO dao = new MemberDAO();
		String command=request.getParameter("command");
		if(command!= null && command.equals("addMember")){
			 String _id = request.getParameter("id");
			 String _pwd = request.getParameter("pwd");
			 String _name = request.getParameter("name");
			 String _email = request.getParameter("email");
			 
			 MemberVO vo=new MemberVO();
			 vo.setId(_id);
			 vo.setPwd(_pwd);
			 vo.setName(_name);
			 vo.setEmail(_email);
		     dao.addMember(vo);
		}  // 추가
		else if(command!= null && command.equals("delMember")) {
			  String id = request.getParameter("id");
			  dao.delMember(id);
		}
		List memberList = dao.listMembers();
		
		request.setAttribute("memberList", memberList);
		RequestDispatcher dispatch = request.getRequestDispatcher("viewMembers");
		dispatch.forward(request, response);
	}
	




	
}