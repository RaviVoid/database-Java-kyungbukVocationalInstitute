package dao;

import java.sql.*;
import java.util.List;

import domain.ExamVO;

public class ExamDAO {

	/**
	 * C:create() 등록하는 메소드
	 * 접근지정자 : public
	 * param : 등록될 값
	 * return : 없음. 
	 */
	public void create(ExamVO vo) {
		//코드작성
		String url = "jdbc:mysql://localhost:3306/smart?characterEncoding=UTF-8&serverTimezone=Asia/Seoul";
		String user = "root";
		String password = "smart";
		StringBuffer sql = new StringBuffer();
		sql.append("\n INSERT INTO exam "); 
		sql.append("\n (varcharTest, charTest, doubleTest, dateTest, dateTimeTest) ");  
		sql.append("\n VALUES (?, ?, ?, ?, ?) "); 
		
		Connection conn = null;
		PreparedStatement stmt = null;
		int idx = 1;
		try {
			//드라이버로드
			Class.forName("com.mysql.cj.jdbc.Driver");
			//DB연결
			conn = DriverManager.getConnection(url, user, password);
			//prepareStatement(SQL작성 실행)
			stmt = conn.prepareStatement(sql.toString());
			
			//?에 값설정
			stmt.setString(idx++, vo.getVarcharTest());
			stmt.setString(idx++, vo.getCharTest());
			stmt.setDouble(idx++, vo.getDoubleTest());
			stmt.setDate(idx++, new Date(vo.getDateTest().getTime()));
			stmt.setTimestamp(idx++, vo.getDateTimeTest());
			
			int res = stmt.executeUpdate();
			//결과처리(Select문만 ResultSet 객체 리턴)
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		//닫기		
	}

	/**
	 * R:read() 조회하는 메소드
	 * 접근지정자 : public
	 * param : 조회할 값
	 * return : List 
	 */
	public List read() {
		String url = "jdbc:mysql://localhost:3306/smart?characterEncoding=UTF-8&serverTimezone=Asia/Seoul";
		String user = "root";
		String password = "smart";
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT * FROM exam ");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		//코드작성
		try {
			//드라이버로드
			Class.forName("com.mysql.cj.jdbc.Driver");
			//DB연결
			conn = DriverManager.getConnection(url, user, password);
			//prepareStatement(SQL작성 실행)
			stmt = conn.prepareStatement(sql.toString());
			rs = stmt.executeQuery();
			//결과처리(Select문만 ResultSet 객체 리턴)
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//닫기
		return null;
	}

	/**
	 * U:update() 수정하는 메소드
	 * 접근지정자 : public
	 * param : 수정될 값
	 * return : 없음. 
	 */
	public void update() {
		//코드작성
		String url = "jdbc:mysql://localhost:3306/smart?characterEncoding=UTF-8&serverTimezone=Asia/Seoul";
		String user = "root";
		String password = "smart";
		StringBuffer sql = new StringBuffer();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			//드라이버로드
			Class.forName("com.mysql.cj.jdbc.Driver");
			//DB연결
			conn = DriverManager.getConnection(url, user, password);
			//prepareStatement(SQL작성 실행)
			stmt = conn.prepareStatement(sql.toString());
			int res = stmt.executeUpdate();
			//결과처리(Select문만 ResultSet 객체 리턴)
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//닫기
		
	}

	/**
	 * D:delete() 삭제하는 메소드
	 * 접근지정자 : public
	 * param : 삭제될 키값
	 * return : 없음. 
	 */
	public void delete() {
		String url = "jdbc:mysql://localhost:3306/smart?characterEncoding=UTF-8&serverTimezone=Asia/Seoul";
		String user = "root";
		String password = "smart";
		StringBuffer sql = new StringBuffer();
		sql.append("\n DELETE FROM exam "); 
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			//드라이버로드
			Class.forName("com.mysql.cj.jdbc.Driver");
			//DB연결
			conn = DriverManager.getConnection(url, user, password);
			//prepareStatement(SQL작성 실행)
			stmt = conn.prepareStatement(sql.toString());
			int res = stmt.executeUpdate();
			//결과처리(Select문만 ResultSet 객체 리턴)
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}





