package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtil2 {

	/**
	 * DB연결
	 * @return
	 */
	public Connection getConn() {
		
		String url = "jdbc:mysql://localhost:3306/smart?characterEncoding=UTF-8&serverTimezone=Asia/Seoul";
		String user = "root";
		String password = "smart";
		Connection conn = null;
		
		try {
			//드라이버로드
			Class.forName("com.mysql.cj.jdbc.Driver");
			//DB연결
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;		
	}
	
	/**
	 * DB닫기
	 * @param conn
	 * @param stmt
	 * @param rs
	 */
	public void dbClose(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}







