package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/member2")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//전송된 데이터를 UTF-8로 인코딩
		request.setCharacterEncoding("UTF-8");
		
		//setContentType()을 이용해 응답할 데이터 종류가 HTML임을 설정
		response.setContentType("text/html;charset=utf-8");
		
		//HttpServeltREsponse 객체의 getWriter()를 이용해 출력 스트림 PrintWriter 객체를 받아옴
		PrintWriter out = response.getWriter();
		
		//SQL문으로 조회할 MemberDAO 객체 생성
		MemberDAO dao = new MemberDAO();
		
		//command 값을 받아옴
		String command = request.getParameter("command");
		
		//회원가입창에서 전송된 command가 addMember이면 전송된 값들을 받아옴
		if(command != null && command.equals("addMember")) {
			//회원가입창에서 전송된 값들을 얻어와 MemberVo 객체에 저장한 후 SQL문을 이용해 전달
			String _id = request.getParameter("id");
			String _pwd = request.getParameter("pwd");
			String _name = request.getParameter("name");
			String _email = request.getParameter("email");
			
			MemberVO vo = new MemberVO();
			vo.setId(_id);
			vo.setPwd(_pwd);
			vo.setName(_name);
			vo.setEmail(_email);
			
			dao.addMember(vo);
		}
		
		//listMembers() 메서드로 회원 정보 조회
		List<MemberVO> list = dao.listMembers();
		
		out.print("<html><body>");
		out.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
		out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td></tr>");
		
		for(int i=0; i<list.size(); i++) {
			//조회한 회원 정보를 for문과 <tr> 태그를 이용해 리스트로 출력
			MemberVO memberVO = list.get(i);
			String id = memberVO.getId();
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			Date joinDate = memberVO.getJoinDate();
			out.print("<tr><td>" + id + "</td><td>" + pwd + "</td><td>" + name + "</td><td>" + email + "</td><td>" + joinDate + "</td></tr>");
		}
		out.print("</table></body></html>");
		
		//클릭하면 다시 회원 가입창으로 이동
		out.print("<a href='/Chapter07/memberForm.html'>새 회원 등록하기</a>");
	}

}
