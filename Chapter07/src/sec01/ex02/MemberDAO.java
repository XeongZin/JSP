package sec01.ex02;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String user = "scott";
	private static final String pwd = "tiger";
	private Connection con;
	private PreparedStatement pstmt;
	
	public List<MemberVO> listMembers() {
		List<MemberVO> list = new ArrayList<MemberVO>() ;
		
		try {
			//네가지 정보로 데이터베이스를 연결
			connDB();
			String query = "select * from t_member";
			System.out.println(query);
			
			//prepareStatement() 메서드에 SQL문을 전달해서 PreparedStatement 객체를 생성
			pstmt = con.prepareStatement(query);
			//executeQuery() 메서들르 호출해 미리 설정한 SQL문을 실행
			ResultSet rs = pstmt.executeQuery(query);
			
			while(rs.next()) {
				//조회한 레크도의 각 컬럼 값을 받아옴
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				
				//각 컬럼 값을 다시 MemberVO객체의 속성에 설정
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				
				//설정된 MemberVO 객체를 다시 ArrayList에 저장
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	private void connDB() {
		try {
			Class.forName(driver);
			System.out.println("Oracle 드라이버 로딩 성공");
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("Connection 생성 성공");
/*			stmt = con.createStatement();
			System.out.println("Statement 생성 성공");*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
