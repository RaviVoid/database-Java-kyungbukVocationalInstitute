package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import domain.MemberVO;

public class MemberDAO {
	
	//전역변수로 모든 메소드에서 사용 가능 앞에 private 추가해줌
	private String url = "jdbc:mysql://localhost:3306/kbLab?characterEncoding=UTF-8&serverTimezone=Asia/Seoul";
	private String user = "root";
	private String password = "smart";

	/**
	 * 트랜잭션 처리
	 * @param mvo
	 */
	public void create (MemberVO mvo) {

		Connection conn = null;
		PreparedStatement stmt = null;
		PreparedStatement stmt2 = null;
		String sql = " INSERT INTO member "
				+ "(id, pw, uname, regdate) "
				+ "VALUES (?, ?, ?, now())";
		String sql2 = " INSERT INTO login "
				+ "(id, pw) "
				+ "VALUES (?, ?) ";
		
		try {
			//드라이버 로드
			Class.forName("com.mysql.cj.jdbc.Driver");

			//연결
			conn = DriverManager.getConnection(url, user, password);
			
			//SQL실행
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement(sql);
			int idx = 1;
			stmt.setString(idx++, mvo.getId());
			stmt.setString(idx++, mvo.getPw());
			stmt.setString(idx++, mvo.getUname());
			
			stmt.executeUpdate();
			
			//SQL2실행
			stmt2 = conn.prepareStatement(sql2);
			int idx2 = 1;
			stmt2.setString(idx2++, mvo.getId());
			stmt2.setString(idx2++, mvo.getPw());
			
			stmt2.executeUpdate();
			
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				if(stmt != null) stmt.close();
				if(stmt2 != null) stmt2.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//닫기
		
		
		
	}
	
}
